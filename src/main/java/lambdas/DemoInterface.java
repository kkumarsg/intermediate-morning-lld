package lambdas;


@FunctionalInterface
public interface DemoInterface {

    void fun();


    default void something(){

    }

    static void somethingStatic(){

    }
}
