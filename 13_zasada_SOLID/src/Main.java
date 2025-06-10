public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Natalia", true);

        Product apple = new Product("Jablko", 4.0);
        Product banana = new Product("Banan", 2.0);

        ShoppingCart cart = new ShoppingCart(customer);
        cart.addItem(apple, 3);   // 6.0
        cart.addItem(banana, 4); // 6.0

        cart.addDiscountStrategy(new PercentageDiscount(10));       // 1.2
        cart.addDiscountStrategy(new LoyaltyDiscount());            // 0.6
        cart.addDiscountStrategy(new FixedAmountDiscount(3));       // 3.0
        cart.addDiscountStrategy(new BuyOneGetOneFreeDiscount("Banan")); // 3.0

        System.out.println("Pelna wartość koszyka: " + cart.calculateTotalPrice());
        System.out.println("Lączna wartość rabatów: " + cart.calculateTotalDiscount());
        System.out.println("Ostateczna kwota do zaplaty: " + cart.calculateFinalPrice());

        for (String desc : cart.getAppliedDiscountDescriptions()) {
            System.out.println(desc);
        }
    }
}
