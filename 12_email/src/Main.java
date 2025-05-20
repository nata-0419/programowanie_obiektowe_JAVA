public class Main {
    public static void main(String[] args) {
        EmailFactory factory = new EmailFactory();

        Email email = factory.create("welcome");

        Email decorated = new UnsubscribeDecorator(new FooterDecorator(email));

        EmailSender sender = new EmailSender();
        sender.setEmail(decorated);

        sender.setSendStrategy(new TestSend());
        sender.send();

        sender.setSendStrategy(new ImmediateSend());
        sender.send();

        sender.setSendStrategy(new DelayedSend(10));
        sender.send();
    }
}
