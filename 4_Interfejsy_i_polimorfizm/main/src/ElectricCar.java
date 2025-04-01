class ElectricCar extends Car implements ElectricRechargeable {
    private double batteryLevel;

    public ElectricCar(String brand, double dailyRate, int seatCount, double batteryLevel) {
        super(brand, dailyRate, seatCount);
        this.batteryLevel = batteryLevel;
    }

    public void chargeBattery(double kWh){
        this.batteryLevel += kWh;
        if (batteryLevel > 100) {
            this.batteryLevel = 100;
        }
        System.out.println("Bateria naladowala sie o " + kWh);
        showBatteryCar();
    }
    public double getBatteryLevel(){
        return this.batteryLevel;
    }
    public void showBatteryCar(){
        System.out.println("Poziom bateri: " + batteryLevel + "%");
    }

    public double calculateRentalCost(int days){
        double cost = super.calculateRentalCost(days);
        if (days > 7){
            cost = (cost * 0.9);
            cost = (cost * 0.9);
        } else {
            cost *= days;
        }
        return cost;
    }
}