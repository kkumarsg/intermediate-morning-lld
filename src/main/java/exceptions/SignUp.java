package exceptions;

public class SignUp {

    static boolean emailExists(String email)  {

        if(!email.contains("@")){
            throw new EmailInvalidRuntime();
        }
        // we should hit the DB and check email is present or not.
        return true;
    }

    public static void main(String[] args){
        if(emailExists("keerthi")){
            // Don't sign up user.
        }
    }
}
