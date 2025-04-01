public class Motorcycle extends Verhicle {
    double engineCapacity;

    public Motorcycle (String brand, double dailyRate, double engineCapacity){
        super (brand, dailyRate);
        this.engineCapacity = engineCapacity;
    }

    public double calculateRentalCost(int days){
        double cost = dailyRate * days;
        if (engineCapacity > 500){
            cost += 50;
        }
        return cost;
    }

}