package threads.addersubtractor;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable<Void> {


    Value value;
    Lock lock;

    public Subtractor(Value value, Lock lock) {
        this.value = value;
        this.lock = lock;
    }

    @Override
    public Void call() throws Exception {

        for(int i=1; i<=100; i++){
            lock.lock();
            System.out.println("Request lock for subtracting "+i);
            Thread.sleep(1000);
            value.value -= i;
            System.out.println("Subtracted "+i);
            lock.unlock();
        }
        return null;
    }
}
