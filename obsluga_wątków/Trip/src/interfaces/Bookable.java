package interfaces;

import exceptions.BookingException;

public interface Bookable {
    void book(String customerName) throws BookingException;
    boolean isBooked();
    String getBookerName();
}
