public class WelcomeEmail implements Email {
    private final String content;
    private final String subject;
    private final String username;

    public WelcomeEmail(String username) {
        this.username = username;
        this.subject = "Wiadomość 1!";
        this.content = "Witam " + username + ", oto treść wiadomości";
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
