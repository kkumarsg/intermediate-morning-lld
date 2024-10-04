package observer;

public class WarehouseMgtService implements OrderPlacedSubscriber{
    @Override
    public void onOrderPlaced() {
        System.out.println("Warehouse is being informed");
    }
}
