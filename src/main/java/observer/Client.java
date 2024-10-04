package observer;

public class Client {


    public static void main(String[] args) {

        Flipkart flipkart = new Flipkart();

        flipkart.registerSubscriber(new EmailService());
        InvoiceGenerationService invoiceService = new InvoiceGenerationService();
        flipkart.registerSubscriber(invoiceService);
        flipkart.registerSubscriber(new WarehouseMgtService());

        flipkart.unregisterSubscriber(invoiceService);

        flipkart.orderPlaced();
    }
}
