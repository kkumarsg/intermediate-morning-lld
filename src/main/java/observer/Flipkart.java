package observer;

import java.util.ArrayList;
import java.util.List;

public class Flipkart {

    List<OrderPlacedSubscriber> subscribers;

    public Flipkart() {
        this.subscribers = new ArrayList<>();
    }

    void registerSubscriber(OrderPlacedSubscriber subscriber){
        subscribers.add(subscriber);
    }

    void unregisterSubscriber(OrderPlacedSubscriber subscriber){
        subscribers.remove(subscriber);
    }

    public void orderPlaced(){

        System.out.println("Order is placed on Flipkart");

        // notify all the subscribers
        for (OrderPlacedSubscriber subscriber : subscribers) {
            subscriber.onOrderPlaced();
        }
    }

}
