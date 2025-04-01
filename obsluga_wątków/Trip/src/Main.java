import exceptions.*;
import model.*;
import service.TravelAgencyManager;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TravelAgencyManager manager = new TravelAgencyManager();

        try {
            CityBreak cityBreak = new CityBreak("TRIP-001", "City Break: Kraków", "Kraków", new BigDecimal("499.99"), "Weekend w Krakowie", 3);
            CruiseTrip cruise = new CruiseTrip("TRIP-002", "Rejs po Morzu Śródziemnym", "Morze Śródziemne", new BigDecimal("1999.99"), "Luksusowy rejs", "MS Sea Explorer", true);
            AdventureTrip adventure = new AdventureTrip("TRIP-003", "Trekking w Tatrach", "Tatry", new BigDecimal("799.99"), "Górska przygoda", ActivityLevel.MEDIUM);

            manager.addTrip(cityBreak);
            manager.addTrip(cruise);
            manager.addTrip(adventure);

            // Dodanie duplikatu
            try {
                manager.addTrip(cityBreak);
            } catch (TripAlreadyExistsException e) {
                System.out.println("OCZEKIWANY WYJĄTEK: " + e.getMessage());
            }

            // Niepoprawna wycieczka
            try {
                new CityBreak("", "Błąd", "Warszawa", new BigDecimal("-200"), null, 2);
            } catch (InvalidTripDataException e) {
                System.out.println("OCZEKIWANY WYJĄTEK: " + e.getMessage());
            }

            // Wyszukiwanie
            Trip found = manager.findTripById("TRIP-001");
            System.out.println("Znaleziono wycieczkę: " + found.getTitle() + " – wymagania: " + found.getTravelRequirements());

            // Fragment tytułu
            List<Trip> result = manager.findTripsByTitleFragment("break");
            System.out.println("Wycieczki zawierające 'break': " + result.size());

            // Fragment nieistniejący
            System.out.println("Wycieczki zawierające 'nieistnieje': " + manager.findTripsByTitleFragment("nieistnieje").size());

            // Wyświetl wymagania
            System.out.println("\\n=== WYMAGANIA ===");
            manager.displayAllRequirements();

//            // Rezerwacja
//            manager.bookOneTrip("Jan Kowalski");
//
//            // Próba rezerwacji z pustym imieniem
//            manager.bookOneTrip("");

            // Oceny
            cityBreak.rate(4);
            cityBreak.rate(2);
            cruise.rate(5);
            adventure.rate(3);
            System.out.println("Średnia ocen CityBreak: " + cityBreak.getAverageRating());

            // Błędna ocena
            try {
                cruise.rate(10);
            } catch (InvalidRatingException e) {
                System.out.println("OCZEKIWANY WYJĄTEK: " + e.getMessage());
            }

            // Średnia globalna
            System.out.println("Średnia ocen wszystkich wycieczek: " + manager.calculateAverageRatingOfAll());

            // Usunięcie
            manager.removeTrip("TRIP-003");

            // Nieistniejący trip
            try {
                manager.removeTrip("TRIP-999");
            } catch (TripNotFoundException e) {
                System.out.println("OCZEKIWANY WYJĄTEK: " + e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
