package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threadpool {


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int i=1; i<=100; i++){
            if(i==80){
                System.out.println("Somemthing");
            }
            PrintNumber hp = new PrintNumber(i);
            executorService.execute(hp);
        }
    }
}
