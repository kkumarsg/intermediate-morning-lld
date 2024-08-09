package threads;

public class PrintNumber implements Runnable{

    int no;

    public PrintNumber(int no) {
        this.no = no;
    }

    @Override
    public void run() {
        System.out.println(no+", printed by the thread "+Thread.currentThread().getName());
    }
}
