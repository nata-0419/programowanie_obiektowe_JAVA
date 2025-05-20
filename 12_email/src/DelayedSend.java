import java.util.concurrent.TimeUnit;

public class DelayedSend implements SendStrategy {
    private final int delayInSeconds;

    public DelayedSend(int delayInSeconds) {
        this.delayInSeconds = delayInSeconds;
    }

    @Override
    public void send(Email email) {
        System.out.println("\n OPÓŹNIONA WYSYŁKA: " + delayInSeconds );
        try {
            TimeUnit.SECONDS.sleep(delayInSeconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Przerwano opóźnienie.");
        }
        System.out.println("Temat: " + email.getSubject());
        System.out.println("Treść: " + email.getContent());
    }
}
