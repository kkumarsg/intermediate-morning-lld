package threads.producerconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Store store = new Store(5);

        ExecutorService es = Executors.newCachedThreadPool();

        Semaphore producerSemaphore = new Semaphore(5);
        Semaphore consumerSemaphore = new Semaphore(0);

        // 8 producers
        for(int i=1; i<=8; i++){
            Producer producer = new Producer(store, producerSemaphore, consumerSemaphore);
            es.execute(producer);
        }

        // 20 consumers
        for(int i=1; i<=20; i++){
            Consumer consumer = new Consumer(store, producerSemaphore, consumerSemaphore);
            es.execute(consumer);
        }

        es.shutdown();
    }
}
