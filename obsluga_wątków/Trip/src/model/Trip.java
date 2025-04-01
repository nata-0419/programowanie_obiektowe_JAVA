package model;

import java.math.BigDecimal;
import exceptions.InvalidTripDataException;

public abstract class Trip {
    protected String tripId;
    protected String title;
    protected String location;
    protected BigDecimal price;
    protected String description;

    public Trip(String tripId, String title, String location, BigDecimal price, String description)
            throws InvalidTripDataException {
        if (tripId == null || tripId.isEmpty())
            throw new InvalidTripDataException("Identyfikator wycieczki nie może być pusty.");
        if (price.compareTo(BigDecimal.ZERO) < 0)
            throw new InvalidTripDataException("Cena nie może być ujemna.");

        this.tripId = tripId;
        this.title = title;
        this.location = location;
        this.price = price;
        this.description = description;
    }

    public String getTripId() {
        return tripId;
    }

    public String getTitle() {
        return title;
    }

    public abstract String getTravelRequirements();
}
