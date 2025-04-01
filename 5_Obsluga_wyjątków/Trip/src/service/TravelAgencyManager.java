package service;

import model.Trip;
import exceptions.BookingException;
import exceptions.InvalidRatingException;
import exceptions.InvalidTripDataException;
import exceptions.TripAlreadyExistsException;
import exceptions.TripNotFoundException;
import interfaces.Bookable;
import interfaces.Rateable;

import java.util.ArrayList;
import java.util.List;

public class TravelAgencyManager {
    private List<Trip> trips;

    public TravelAgencyManager() {
        this.trips = new ArrayList<>();
    }

    // addTrip - dodanie wycieczki, sprawdzamy duplikat
    public void addTrip(Trip trip) throws TripAlreadyExistsException {
        for (Trip t : trips) {
            if (t.getTripId().equals(trip.getTripId())) {
                throw new TripAlreadyExistsException("Wycieczka o takim ID już istnieje.");
            }
        }
        trips.add(trip);
    }

    // removeTrip - usunięcie wycieczki
    public void removeTrip(String tripId) throws TripNotFoundException {
        Trip tripToRemove = findTripById(tripId);
        trips.remove(tripToRemove);
    }

    // findTripById - wyszukiwanie po ID
    public Trip findTripById(String tripId) throws TripNotFoundException {
        for (Trip t : trips) {
            if (t.getTripId().equals(tripId)) {
                return t;
            }
        }
        throw new TripNotFoundException("Nie znaleziono wycieczki o podanym ID.");
    }

    // findTripsByTitleFragment - wyszukiwanie po fragmencie tytułu
    public List<Trip> findTripsByTitleFragment(String fragment) {
        List<Trip> result = new ArrayList<>();
        for (Trip t : trips) {
            if (t.getTitle().toLowerCase().contains(fragment.toLowerCase())) {
                result.add(t);
            }
        }
        return result;
    }

    // calculateAverageRatingOfAll - obliczanie średniej ocen wszystkich Rateable wycieczek
    public double calculateAverageRatingOfAll() {
        double sum = 0;
        int count = 0;
        for (Trip t : trips) {
            if (t instanceof Rateable) {
                sum += ((Rateable) t).getAverageRating();
                count++;
            }
        }
        return count > 0 ? sum / count : 0;
    }

    // bookOneTrip - rezerwacja wycieczki
    public void bookOneTrip(String tripId, String customerName) {
        try {
            Trip trip = findTripById(tripId);
            if (trip instanceof Bookable) {
                ((Bookable) trip).book(customerName);
            } else {
                System.out.println("Nie można zarezerwować wycieczki, ponieważ nie implementuje interfejsu Bookable.");
            }
        } catch (TripNotFoundException | BookingException e) {
            e.printStackTrace();
        }
    }

    // 7. displayAllRequirements - wyświetlanie wszystkich wymagań dla wycieczek
    public void displayAllRequirements() {
        for (Trip t : trips) {
            System.out.println(t.getTripId() + "\t" + t.getTitle() + "\t" + t.getTravelRequirements());
        }
    }
}
