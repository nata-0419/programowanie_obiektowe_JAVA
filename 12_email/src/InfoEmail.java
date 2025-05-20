public class InfoEmail implements Email {
    private final String subject;
    private final String content;

    public InfoEmail() {
        this.subject = "Aktualizacja informacji";
        this.content = "Z przyjemnością informujemy o nowych funkcjonalnościach naszej platformy.";
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
