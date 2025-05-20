public abstract class EmailDecorator implements Email {
    protected Email innerEmail;

    public EmailDecorator(Email innerEmail) {
        this.innerEmail = innerEmail;
    }

    @Override
    public String getSubject() {
        return innerEmail.getSubject();
    }

    @Override
    public String getContent() {
        return innerEmail.getContent();
    }
}
