public class ImmediateSend implements SendStrategy {
    @Override
    public void send(Email email) {
        System.out.println("\n NATYCHMIASTOWA WYSYŁKA");
        System.out.println("Temat: " + email.getSubject());
        System.out.println("Treść: " + email.getContent());
    }
}
