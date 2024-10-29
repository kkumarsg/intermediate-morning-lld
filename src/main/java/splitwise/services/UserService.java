package splitwise.services;

import splitwise.dtos.Transaction;
import splitwise.models.*;
import splitwise.repositories.GroupRepository;
import splitwise.repositories.UserExpenseRepository;
import splitwise.strategies.SettleUpStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private GroupRepository groupRepository;
    private UserExpenseRepository userExpenseRepository;
    private SettleUpStrategy settleUpStrategy;

    public UserService(GroupRepository groupRepository, UserExpenseRepository userExpenseRepository, SettleUpStrategy settleUpStrategy) {
        this.groupRepository = groupRepository;
        this.userExpenseRepository = userExpenseRepository;
        this.settleUpStrategy = settleUpStrategy;
    }

    /*
                    GOA TRIP [A, B, C, D]

        (E1)
            Expense 1 : Dinner, 2000, Regular

            whoPaid : [A:1000, B:1000]
            whoHadToPay : [A:500, B:500, C: 500: D: 500]

         UserExpenses
            user expense   amount   type
             A      e1      1000   WhoPaid
             B      e1      1000   WhoPaid

             A      e1      500   WhoHadToPay
             B      e1      500   WhoHadToPay
             C      e1      500   WhoHadToPay
             D      e1      500   WhoHadToPay

         ExtraAmount map
            initial : [A: 0, B:0, C:0, D:0]

            A = 0+1000 = 1000
            B = 0+1000 = 1000
            A = 1000-500 = 500
            B = 1000-500 = 500
            C = 0-500 = -500
            D = 0-500 =-500

            updated : [A: 500, B:500, C:-500, D:-500]

          HeapStrategy -> (updatedMap)

            Givers : [C:-500, D:-500]
            Receivers : [A:500, B: 500]

            Transactions :
                from to amount
                  C  A   500
                  D  B   500

                If you're only trying to settle C
                    C A 500




     */

    /*
        1. Get all expense of the group
        2. For every expense, I'll find the userExpenses
        3. Go through all the user expenses and correspondingly update the extra_amount
            for each user
        4. Pass this extra amount map to a strategy which will return a list<Transaction>

    TO-DO
        5. Filter the transactions that contains this user either in 'from' or in 'to'




     */




    public List<Transaction> settleUser(String userName, String groupName) {

        Map<User, Integer> extraAmountMap = new HashMap<>();
        Group group = groupRepository.findGroupByName(groupName);

        for(Expense expense: group.getExpenses()){

            List<UserExpense> userExpenses =
                    userExpenseRepository.findUserExpenseByExpenseDescription(expense.getDescription());

            for(UserExpense userExpense: userExpenses){

                User user = userExpense.getUser();
                if(!extraAmountMap.containsKey(user)){
                    extraAmountMap.put(user, 0);
                }

                Integer amount = extraAmountMap.get(user);
                if(userExpense.getUserExpenseType().equals(UserExpenseType.PAID_BY)){
                    amount += userExpense.getAmount();
                }
                else{
                    amount -= userExpense.getAmount();
                }
                extraAmountMap.put(user, amount);
            }

        }

        return settleUpStrategy.settleUser(extraAmountMap);
    }










}
