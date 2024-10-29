package splitwise.strategies;

import splitwise.dtos.Transaction;
import splitwise.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class HeapSettleUpStrategy implements SettleUpStrategy{

    public List<Transaction> settleUser(Map<User, Integer> map) {

        PriorityQueue<Pair> receivers = new PriorityQueue<>();
        PriorityQueue<Pair> givers = new PriorityQueue<>();

        List<Transaction> transactions = new ArrayList<>();

        for(User user: map.keySet()){
            Integer amount = map.get(user);
            if(amount<0){
                givers.add(new Pair(-1*amount, user));
            }
            else if(amount>0){
                receivers.add(new Pair(amount, user));
            }
        }

        // A : 500, B:500, C:500
        // D : -1500

        // A : 500
        // D : 200, B: 200, C:100



        // putting back D (giver)

        while(receivers.size()>0 && givers.size()>0){
            Pair giver = givers.poll();
            Pair receiver = receivers.poll();

            if(giver.amount > receiver.amount) {
                transactions.add(
                        new Transaction(giver.user.getName(), receiver.user.getName(), receiver.amount));
                givers.add(new Pair(giver.amount - receiver.amount, giver.user));
            }

            else if(giver.amount < receiver.amount){
                transactions.add(
                        new Transaction(giver.user.getName(), receiver.user.getName(), giver.amount));
                receivers.add(new Pair(receiver.amount- giver.amount, receiver.user));
            }
            else {
                transactions.add(
                        new Transaction(giver.user.getName(), receiver.user.getName(), receiver.amount));
            }

        }
        return transactions;
    }

}

class Pair implements Comparable {
    int amount;
    User user;

    public Pair(int amount, User user) {
        this.amount = amount;
        this.user = user;
    }

    @Override
    public int compareTo(Object o) {
        Pair other = (Pair) o;
        if(this.amount <= other.amount){
            return -1;
        }
        return 1;
    }
}

