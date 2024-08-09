package threads;

public class HelloWorldPrinter implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello, World from "+Thread.currentThread().getName());
    }
}
