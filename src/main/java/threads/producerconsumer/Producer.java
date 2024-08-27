package threads.producerconsumer;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable{

    private Store store;
    private Semaphore producerSemaphore, consumerSemaphore;

    public Producer(Store store, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while(true) {

            try {
//                System.out.println("Producer produced");
                producerSemaphore.acquire();
//                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(store.getItems().size()<store.getMaxSize()) {
                // now, one of the store is empty...
                store.getItems().add(new Object());
            }
            consumerSemaphore.release();
        }
    }
}
