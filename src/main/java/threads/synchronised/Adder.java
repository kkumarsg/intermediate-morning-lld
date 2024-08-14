package threads.synchronised;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void> {

    Value value;

    public Adder(Value value) {
        this.value = value;
    }


    public Void call() throws InterruptedException {
        for(int i=1; i<=100; i++){

//            System.out.println("Request lock for adding "+i);
//            synchronized (value) {
                Thread.sleep(10);
                value.incrementer(i);
                // value = value + i;
                // coming out of critical section.
//            }
//            System.out.println("Added "+i);
        }
        return null;
    }
}
