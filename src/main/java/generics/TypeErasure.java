package generics;

import java.util.List;

public class TypeErasure {

    public static void main(String[] args) {

        List<String> l1 = List.of("hello", "hi", "there");
        List<Integer> l2 = List.of(1, 2,3 ,4);
        List l3 = List.of("hello", 1, 1.8, "there");

        List<Product> l4 = List.of(new Product(), new Product());

        /*
         l1 is a list of String
         l2 is a list of Integer
         l3 is a list of Object
         l4 is a list of Product
         */

        System.out.println("l1.getClass() = " + l1.getClass());
        System.out.println("l2.getClass() = " + l2.getClass());
        System.out.println("l3.getClass() = " + l3.getClass());
        System.out.println("l4.getClass() = " + l4.getClass());
    }
}


class Product{

}
