package model;

import exceptions.BookingException;
import exceptions.InvalidRatingException;
import exceptions.InvalidTripDataException;
import interfaces.Bookable;
import interfaces.Rateable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CruiseTrip extends Trip implements Bookable, Rateable {
    private String shipName;
    private boolean passportRequired;
    private boolean booked = false;
    private String bookerName;
    private List<Integer> ratings = new ArrayList<>();

    public CruiseTrip(String tripId, String title, String location, BigDecimal price, String description,
                      String shipName, boolean passportRequired) throws InvalidTripDataException {
        super(tripId, title, location, price, description);
        this.shipName = shipName;
        this.passportRequired = passportRequired;
    }

    @Override
    public String getTravelRequirements() {
        return passportRequired ? "Paszport jest wymagany" : "Brak wymogu paszportu";
    }

    @Override
    public void book(String customerName) throws BookingException {
        if (customerName == null || customerName.isEmpty())
            throw new BookingException("Nieprawidłowe dane klienta.");
        if (booked)
            throw new BookingException("Rejs został już zarezerwowany.");
        this.booked = true;
        this.bookerName = customerName;
    }

    @Override
    public boolean isBooked() {
        return booked;
    }

    @Override
    public String getBookerName() {
        return bookerName;
    }

    @Override
    public void rate(int score) throws InvalidRatingException {
        if (score < 0 || score > 5)
            throw new InvalidRatingException("Ocena musi być w przedziale 0–5.");
        ratings.add(score);
    }

    @Override
    public List<Integer> getAllRatings() {
        return ratings;
    }

    @Override
    public double getAverageRating() {
        return ratings.stream().mapToInt(Integer::intValue).average().orElse(0);
    }
}
