public class Bicycle extends Verhicle {

    public Bicycle (String brand, double dailyRate){
        super (brand, dailyRate);
    }

    public double calculateRentalCost(int days){
        return dailyRate*days;
    }

}