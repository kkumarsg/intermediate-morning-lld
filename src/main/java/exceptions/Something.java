package exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Something {


    public void doSomething(int a, int b) throws DivisionByZeroException {


        if(b==0){
            throw new DivisionByZeroException();
        }
        System.out.println(a/b);
    }

    public static void main(String[] args) throws DivisionByZeroException {

        Something something = new Something();
        something.doSomething(10, 2);
        something.doSomething(10, 0);
    }
}
