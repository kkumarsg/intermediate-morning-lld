package generics;

import java.security.spec.RSAOtherPrimeInfo;

public class FriendGeneric<T, U> {

    T p1;
    T p2;
    U relation;

    public FriendGeneric(T p1, T p2, U relation) {
        this.p1 = p1;
        this.p2 = p2;
        this.relation = relation;
    }

    public static <E> void something(E e){
        System.out.println("e = " + e);
    }

    public static <E> void somethingElse(E e1, E e2){
        System.out.println("e1 = " + e1+" e2 = "+e2);
    }

    // This is also fine.
    public static <E, V> void somethingElseElse(E e1, V e2){
        System.out.println("e1 = " + e1+" e2 = "+e2);
    }

    public static <E> E somethingWithReturn(String name){
        System.out.println(name);
        return null;
    }

    public static <E, V> V somethingWithReturn(E e1){
        System.out.println("with retunr type e1 = " +e1);
        return null;
    }
}
