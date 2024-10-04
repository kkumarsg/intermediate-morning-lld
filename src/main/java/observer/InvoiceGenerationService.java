package observer;

public class InvoiceGenerationService implements OrderPlacedSubscriber{
    @Override
    public void onOrderPlaced() {
        System.out.println("Generating invoice ");
    }
}
