package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {

    private List<Integer> arrayToSort;
    private ExecutorService es;

    public Sorter(List<Integer> arrayToSort, ExecutorService es) {
        this.arrayToSort = arrayToSort;
        this.es = es;
    }

    @Override
    public List<Integer> call() throws Exception {

        if(arrayToSort.size()<=1){
            return arrayToSort;
        }

        List<Integer> leftArrayToSort = new ArrayList<>();
        List<Integer> rightArrayToSort = new ArrayList<>();

        int mid = arrayToSort.size()/2;

        for(int i=0; i<mid; i++){
            leftArrayToSort.add(arrayToSort.get(i));
        }

        for(int i=mid; i<arrayToSort.size(); i++){
            rightArrayToSort.add(arrayToSort.get(i));
        }



        Sorter sorterLeft = new Sorter(leftArrayToSort, es);
        Sorter sorterRight = new Sorter(rightArrayToSort, es);

        Future<List<Integer>> sortedLeftArrayFuture = es.submit(sorterLeft);
        Future<List<Integer>> sortedRightArrayFuture = es.submit(sorterRight);
//        List<Integer> sortedLeftArray = sorterLeft.call();
//        List<Integer> sortedRightArray = sorterRight.call();

        // I want to make sure both left and right are completed.
        List<Integer> sortedLeftArray = sortedLeftArrayFuture.get();
        List<Integer> sortedRightArray = sortedRightArrayFuture.get();

        // focus on merge now
        List<Integer> sortedArray = new ArrayList<>();
        int i=0, j=0;

        while(i<sortedLeftArray.size() && j<sortedRightArray.size()){
            if(sortedLeftArray.get(i) <=sortedRightArray.get(j)){
                sortedArray.add(sortedLeftArray.get(i));
                i++;
            }
            else{
                sortedArray.add(sortedRightArray.get(j));
                j++;
            }
        }

        // check for any elements left in any of the arrays.
        while(i<sortedLeftArray.size()){
            sortedArray.add(sortedLeftArray.get(i));
            i++;
        }
        while(j< sortedRightArray.size()){
            sortedArray.add(sortedRightArray.get(j));
            j++;
        }

        return sortedArray;
    }
}
