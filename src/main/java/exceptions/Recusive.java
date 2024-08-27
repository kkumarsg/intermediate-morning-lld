package exceptions;

public class Recusive {

    public static void doSomething(int a){
        doSomething(a*a);
    }

    public static void main(String[] args) {
        doSomething(10);
    }
}
