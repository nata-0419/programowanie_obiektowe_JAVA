package interfaces;

import exceptions.InvalidRatingException;
import java.util.List;

public interface Rateable {
    void rate(int score) throws InvalidRatingException;
    List<Integer> getAllRatings();
    double getAverageRating();
}
