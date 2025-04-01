package exceptions;

public class TripNotFoundException extends Exception {
    public TripNotFoundException(String message) {
        super(message);
    }
}
