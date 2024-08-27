package exceptions;

public class NonWorkingHoursException extends Exception {


    public NonWorkingHoursException(String message) {
        super(message);
        System.out.println(message);
    }
}
