package singleton;

/*

Whole method is synchronised, double check
 */
public class DatabaseConnectionV3 {

    private static DatabaseConnectionV3 dbc = null;

    private String url;
    private int portNo;
    private String username;
    private String password;

    private DatabaseConnectionV3() {
    }

    // Not very optimal
//    public static synchronized DatabaseConnectionV3 getInstance(){
//        if(dbc==null){
//            dbc = new DatabaseConnectionV3();
//        }
//        return dbc;
//    }


    // Double check locking
    // This won't work, The null check must be done twice
//    public static DatabaseConnectionV3 getInstance(){
//        if(dbc==null){
//            synchronized (DatabaseConnectionV3.class) {
//                dbc = new DatabaseConnectionV3();
//            }
//        }
//        return dbc;
//    }


    // Double check locking
    // Final solution
    public static DatabaseConnectionV3 getInstance(){
        if(dbc==null){
            synchronized (DatabaseConnectionV3.class) {
                if(dbc==null) {
                    dbc = new DatabaseConnectionV3();
                }
            }
        }
        return dbc;
    }

}
