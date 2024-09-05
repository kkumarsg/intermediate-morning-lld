package singleton;

/*
Doesn't work in multithreaded environment
 */
public class DatabaseConnectionV1 {

    private static DatabaseConnectionV1 dbc = null;

    private String url;
    private int portNo;
    private String username;
    private String password;

    private DatabaseConnectionV1() {
    }

    public static DatabaseConnectionV1 getInstance(){
        if(dbc==null){
            dbc = new DatabaseConnectionV1();
        }
        return dbc;
    }
}
