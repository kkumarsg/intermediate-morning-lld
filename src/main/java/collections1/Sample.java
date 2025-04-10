package collections1;

import java.util.*;

public class Sample {

    public static void main(String[] args) throws InterruptedException {

        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();




        Set<Integer> numbers = new TreeSet<>();

        for(int i=10; i>0; i--){
            hashSet.add("Scaler " +i);
            linkedHashSet.add("Scaler "+i);
            treeSet.add("Scaler "+i);
            numbers.add(i);
        }

//        System.out.println("hashSet = " + hashSet);
//        System.out.println("linkedHashSet = " + linkedHashSet);
//        System.out.println("treeSet = " + treeSet);
//        System.out.println("numbers = " + numbers);
    }
}
