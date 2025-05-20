import java.time.LocalDate;

public class EmailFactory {
    public Email create(String type) {
        return switch (type.toLowerCase()) {
            case "welcome" -> new WelcomeEmail("Natalia Góras");
            case "promo" -> new PromoEmail("SAVE25", LocalDate.of(2025, 5, 18));
            case "info" -> new InfoEmail();
            default -> throw new IllegalArgumentException("Nieznany typ wiadomości: " + type);
        };
    }
}
