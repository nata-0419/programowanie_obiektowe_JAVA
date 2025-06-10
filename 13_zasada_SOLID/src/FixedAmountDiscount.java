public class FixedAmountDiscount implements DiscountStrategy {
    private double amount;

    public FixedAmountDiscount(double amount) {
        this.amount = amount;
    }

    @Override
    public double calculateDiscount(ShoppingCart cart) {
        return Math.min(amount, cart.calculateTotalPrice());
    }

    @Override
    public String getDescription() {
        return "Fixed discount(rabat kwotowy): " + amount;
    }
}
