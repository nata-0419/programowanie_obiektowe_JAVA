public class LoyaltyDiscount implements DiscountStrategy {
    private double percentage = 5.0;

    @Override
    public double calculateDiscount(ShoppingCart cart) {
        if (cart.getCustomer().isLoyalCustomer()) {
            return cart.calculateTotalPrice() * (percentage / 100);
        }
        return 0;
    }

    @Override
    public String getDescription() {
        return "Loyalty discount(rabat lojalnościowy): " + percentage + "%";
    }
}
