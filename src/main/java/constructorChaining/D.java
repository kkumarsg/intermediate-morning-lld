package constructorChaining;

public class D extends C{

    public D() {

        System.out.println("Constructor of D");
    }

    public D(String name){
        super(name);
        System.out.println("Constructor of D with name : "+name);
    }
}
