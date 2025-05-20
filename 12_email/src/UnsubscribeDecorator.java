public class UnsubscribeDecorator extends EmailDecorator {
    public UnsubscribeDecorator(Email wrappee) {
        super(wrappee);
    }

    @Override
    public String getContent() {
        return super.getContent() + "\nAby zrezygnować z subskrypcji, kliknij tutaj.";
    }
}
