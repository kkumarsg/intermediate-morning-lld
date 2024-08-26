package lambdas;

public class ClientThread {

    public static void main(String[] args) {


        Thread t1 = new Thread(new PrinterTask());
        t1.start();



        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, from thread "+
                        Thread.currentThread().getName());
            }
        };
        Thread t2 = new Thread(runnable);
        t2.start();

        Runnable runnable1 = ()-> System.out.println("Hello, from thread "+
                Thread.currentThread().getName());
        Thread t3 = new Thread(runnable1);
        t3.start();

        Thread t4 = new Thread(()-> System.out.println("Hello, form lambda thread"+
                Thread.currentThread().getName()));
        t4.start();
    }
}
