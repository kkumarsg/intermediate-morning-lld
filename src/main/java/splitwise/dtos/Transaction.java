package splitwise.dtos;

public class Transaction {

    private String from;
    private String to;
    private int amount;

    public Transaction(String from, String to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public String toString() {
        // Keerthi -> Tanay : 500
        return from+" -> "+to+" : "+amount;
    }
}
