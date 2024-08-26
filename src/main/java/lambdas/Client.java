package lambdas;

import java.util.function.Predicate;

public class Client {


    public static void main(String[] args) {

        // can I create an instance of interface ? No
//        DemoInterface way1 = new DemoInterface()

        // can I create an instance of its implementation
        DemoClass demoClass = new DemoClass();
        demoClass.fun();

        // What if I can provide the implementation to make it complete.
        DemoInterface way1 = new DemoInterface(){
            @Override
            public void fun() {
                System.out.println("Something from the interface itself");
            }
        };

        way1.fun();

        DemoInterface way2 = ()->{
            System.out.println("Something from the interface itself 2");
        };

        way2.fun();


        // Predicate takes a parameter
        Predicate<String> isStringLong = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length()>10;
            }
        };

        Predicate<String> isStringLongWay2 = (str) -> {
            return str.length()>10;
        };

        Predicate<String> isStringLongWay3 = (str) -> str.length()>10;

        System.out.println("isStringLong.test(\"Scaler school\") = " + isStringLong.test("Scaler school"));
        System.out.println("isStringLongWay2.test(\"Scaler school\") = " + isStringLongWay2.test("Scaler school"));
        System.out.println("isStringLongWay3.test(\"Scaler school\") = " + isStringLongWay3.test("Scaler school"));


    }
}
