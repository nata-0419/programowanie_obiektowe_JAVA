public class BuyOneGetOneFreeDiscount implements DiscountStrategy {
    private String productName;

    public BuyOneGetOneFreeDiscount(String productName) {
        this.productName = productName;
    }

    @Override
    public double calculateDiscount(ShoppingCart cart) {
        for (CartItem item : cart.getItems()) {
            if (item.getProduct().getName().equalsIgnoreCase(productName)) {
                int freeItems = item.getQuantity() / 2;
                return freeItems * item.getProduct().getUnitPrice();
            }
        }
        return 0;
    }

    @Override
    public String getDescription() {
        return "Buy One Get One Free(Kup jeden a drugi za darmo): " + productName;
    }
}
