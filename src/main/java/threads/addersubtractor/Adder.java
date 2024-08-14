package threads.addersubtractor;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void> {

    Value value;
    Lock lock;

    public Adder(Value value, Lock lock) {
        this.value = value;
        this.lock = lock;
    }


    public Void call(){
        for(int i=1; i<=100; i++){
            lock.lock();
            System.out.println("Request lock for adding "+i);
            // entering critical section.
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            value.value += i;
            // coming out of critical section.
            System.out.println("Added "+i);
            lock.unlock();
        }
        return null;
    }
}
