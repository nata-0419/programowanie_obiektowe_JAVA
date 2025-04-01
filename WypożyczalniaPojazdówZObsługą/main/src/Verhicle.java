abstract class Verhicle {
    protected String brand;
    protected double dailyRate;

    public Verhicle(String brand, double dailyRate){
        this.brand = brand;
        this.dailyRate = dailyRate;
    }

    public abstract double calculateRentalCost(int days);

    public void showInfo(){
        System.out.println("Pojazd " + brand + " stawka dzienna " + dailyRate);
    }

}
