package singleton;

/*

EAGER initialization
 */
public class DatabaseConnectionV2 {

    private static DatabaseConnectionV2 dbc = new DatabaseConnectionV2();

    private String url;
    private int portNo;
    private String username;
    private String password;

    private DatabaseConnectionV2() {
    }

    public static DatabaseConnectionV2 getInstance(){
        return dbc;
    }
}
