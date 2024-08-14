package threads.synchronised;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable<Void> {


    Value value;

    public Subtractor(Value value) {
        this.value = value;
    }

    @Override
    public Void call() throws Exception {

        for(int i=1; i<=100; i++){
//            System.out.println("Request lock for subtracting "+i);
//            synchronized (value) {
                Thread.sleep(10);
                value.decrementer(i);
                // value = value-i;
//            }
//            System.out.println("Subtracted "+i);
        }
        return null;
    }
}
