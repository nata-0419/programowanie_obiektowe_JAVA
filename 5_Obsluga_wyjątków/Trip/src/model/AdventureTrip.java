package model;

import exceptions.InvalidRatingException;
import exceptions.InvalidTripDataException;
import interfaces.Rateable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AdventureTrip extends Trip implements Rateable {
    private ActivityLevel activityLevel;
    private List<Integer> ratings = new ArrayList<>();

    public AdventureTrip(String tripId, String title, String location, BigDecimal price, String description,
                         ActivityLevel activityLevel) throws InvalidTripDataException {
        super(tripId, title, location, price, description);
        this.activityLevel = activityLevel;
    }

    @Override
    public String getTravelRequirements() {
        return switch (activityLevel) {
            case LOW -> "Podstawowe przygotowanie fizyczne";
            case MEDIUM -> "Dobra kondycja fizyczna";
            case HIGH -> "Zaawansowane umiejętności i specjalistyczny sprzęt";
        };
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
