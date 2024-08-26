package lambdas;

public class PrinterTask implements Runnable{
    @Override
    public void run() {
        System.out.println("Printing from another thread "
                +Thread.currentThread().getName());
    }
}
