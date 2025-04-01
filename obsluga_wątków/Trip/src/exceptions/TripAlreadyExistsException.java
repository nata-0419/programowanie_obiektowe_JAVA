package exceptions;

public class TripAlreadyExistsException extends Exception {
    public TripAlreadyExistsException(String message) {
        super(message);
    }
}
