package threads.producerconsumer;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{

    private Store store;

    private Semaphore producerSemaphore, consumerSemaphore;

    public Consumer(Store store, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while(true) {

            try {
                System.out.println("Consumer consumed");
                consumerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(store.getItems().size()>0) {

                // only if we have a cloth, consumer can consume
                store.getItems().remove(store.getItems().size() - 1);
            }
            producerSemaphore.release();
        }
    }
}
