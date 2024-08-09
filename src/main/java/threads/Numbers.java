package threads;

public class Numbers {

    // Print numbers from [1-100], each number should be printed from different thread.

    public static void main(String[] args) {

        for(int i=1; i<=100; i++){

            PrintNumber pN = new PrintNumber(i);
            Thread t = new Thread(pN);

            t.start();
        }
    }

    /*

    main -> --------------|----|
                          |    |
                          |    |
                         t1   t2

     These threads when are they going to run depends on CPU executing these threads.
     */


}
