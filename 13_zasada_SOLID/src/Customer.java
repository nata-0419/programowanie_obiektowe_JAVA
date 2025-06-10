public class Customer {
    private String name;
    private boolean isLoyalCustomer;

    public Customer(String name, boolean isLoyalCustomer) {
        this.name = name;
        this.isLoyalCustomer = isLoyalCustomer;
    }

    public boolean isLoyalCustomer() {
        return isLoyalCustomer;
    }

    public String getName() {
        return name;
    }
}
