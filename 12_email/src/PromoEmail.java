import java.time.LocalDate;

public class PromoEmail implements Email {
    private final String promoCode;
    private final LocalDate validUntil;
    private final String subject;
    private final String content;

    public PromoEmail(String promoCode, LocalDate validUntil) {
        this.promoCode = promoCode;
        this.validUntil = validUntil;
        this.subject = "Specjalna oferta tylko dla Ciebie!";
        this.content = "Użyj kodu " + promoCode + " przed " + validUntil + " i skorzystaj z promocji!";
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getSubject() {
        return subject;
    }
}
