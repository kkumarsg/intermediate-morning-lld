package exceptions;

public class LunchTimeException extends Exception {
    public LunchTimeException(String unavailable_message) {
        super();
        System.out.println(unavailable_message);
    }
}
