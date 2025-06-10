public interface DiscountStrategy {
    double calculateDiscount(ShoppingCart cart);
    String getDescription();
}
