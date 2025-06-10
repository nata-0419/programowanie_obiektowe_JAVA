import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> items = new ArrayList<>();
    private List<DiscountStrategy> discountStrategies = new ArrayList<>();
    private Customer customer;

    public ShoppingCart(Customer customer) {
        this.customer = customer;
    }

    public void addItem(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
    }

    public double calculateTotalPrice() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public double calculateTotalDiscount() {
        return discountStrategies.stream()
                .mapToDouble(strategy -> strategy.calculateDiscount(this))
                .sum();
    }

    public double calculateFinalPrice() {
        return calculateTotalPrice() - calculateTotalDiscount();
    }

    public List<String> getAppliedDiscountDescriptions() {
        List<String> descriptions = new ArrayList<>();
        for (DiscountStrategy strategy : discountStrategies) {
            double discount = strategy.calculateDiscount(this);
            if (discount > 0) {
                descriptions.add(strategy.getDescription() + " (-" + discount + ")");
            }
        }
        return descriptions;
    }

    public void addDiscountStrategy(DiscountStrategy strategy) {
        discountStrategies.add(strategy);
    }

    public List<CartItem> getItems() {
        return items;
    }

    public Customer getCustomer() {
        return customer;
    }
}
