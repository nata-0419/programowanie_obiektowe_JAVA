public class Car extends Verhicle {
    int seatCount;

    public Car (String brand, double dailyRate, int seatCount){
    super(brand, dailyRate);
    this.seatCount = seatCount;
    }

    public double calculateRentalCost(int days){
        double cost = dailyRate * days;
        if (days > 7){
            cost = (cost*0.9);
        }
        return cost;
    }

}
