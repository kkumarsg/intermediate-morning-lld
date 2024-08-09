package threads;

public class Test {

    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        System.out.println("Hello "+Thread.currentThread().getName());

        HelloWorldPrinter hp = new HelloWorldPrinter();
        Thread t1 = new Thread(hp);

        t1.start();

//        t1.run();

        doSomehting();
    }

    private static void doSomehting() {
        int c = 20;
        int d = 30;
        System.out.println("Hello, From "+Thread.currentThread().getName());
    }
}
