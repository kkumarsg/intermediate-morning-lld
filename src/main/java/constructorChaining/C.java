package constructorChaining;

public class C extends B {

    public C() {
        super();
        System.out.println("Constructor of C");
    }

    public C(String name){
        super(name);
        System.out.println("Constructor of C with name : "+name);
    }
}
