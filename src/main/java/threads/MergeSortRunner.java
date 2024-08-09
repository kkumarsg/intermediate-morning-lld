package threads;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MergeSortRunner {


    public static void main(String[] args) throws Exception {

        List<Integer> arrayToSort = List.of(8, 2, 4, 1, 9, 6, 0, 7) ;

        // No of threads created = No of function calls. = NLogN
//        ExecutorService es = Executors.newCachedThreadPool();

        ExecutorService es = Executors.newFixedThreadPool(3);
        // What if I create a fixed threadpool, will it work ?
        // size of threadpool is 4.
        List<Integer> sortedArray = new Sorter(arrayToSort, es).call();

        System.out.println("sortedArray = " + sortedArray);

        es.shutdown();

    }
}
