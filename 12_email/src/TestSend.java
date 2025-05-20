public class TestSend implements SendStrategy {
    @Override
    public void send(Email email) {
        System.out.println("\n TO JEST TEST");
        System.out.println("Temat: " + email.getSubject());
        System.out.println("Treść: " + email.getContent());
    }
}
