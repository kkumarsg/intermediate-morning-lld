package singleton;

public class Client {

    public static void main(String[] args) {
//        DatabaseConnectionV1 db1 = new DatabaseConnectionV1();
//        DatabaseConnectionV1 db2 = new DatabaseConnectionV1();

        DatabaseConnectionV1 db1 = DatabaseConnectionV1.getInstance();
        DatabaseConnectionV1 db2 = DatabaseConnectionV1.getInstance();


        DatabaseConnectionV2 db1Lazy = DatabaseConnectionV2.getInstance();
        DatabaseConnectionV2 db2Lazy = DatabaseConnectionV2.getInstance();

        System.out.println("Hello, World ");
    }
}
