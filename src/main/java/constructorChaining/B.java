package constructorChaining;

public class B extends A {

    public B() {
        super();
        System.out.println("construcotr of B");
    }

    public B(String name){
        super(name);
        System.out.println("Constructor of B with name : "+name);

    }
}
