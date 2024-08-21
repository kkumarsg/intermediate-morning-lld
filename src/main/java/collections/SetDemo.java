package collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {


    public static void main(String[] args) {

        // Under set, Hashset and LinkedHashset

        Set<Integer> numbersHashSet = new TreeSet<>();

        numbersHashSet.add(4);
        numbersHashSet.add(56);
        numbersHashSet.add(12);
        numbersHashSet.add(13);
        numbersHashSet.add(13);

        System.out.println("numbersHashSet = " + numbersHashSet);
    }

}
