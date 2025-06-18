package model;

public class NiepoprawnyPiorytetException extends Exception {
    public NiepoprawnyPiorytetException() {
        super("Priorytet zadania jest niepoprawny. Powinien być liczbą całkowitą dodatnią.");
    }

    public NiepoprawnyPiorytetException(String message) {
        super(message);
    }
}
