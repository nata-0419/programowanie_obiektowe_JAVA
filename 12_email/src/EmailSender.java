public class EmailSender {
    private Email email;
    private SendStrategy strategy;

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setSendStrategy(SendStrategy strategy) {
        this.strategy = strategy;
    }

    public void send() {
        if (email != null && strategy != null) {
            strategy.send(email);
        } else {
            System.out.println("Błąd: nie ustawiono wiadomości lub strategii.");
        }
    }
}
