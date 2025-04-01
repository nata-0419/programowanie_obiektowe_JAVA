class ElectricBicycle extends Bicycle implements ElectricRechargeable {
    public double batteryLevel;

    public ElectricBicycle(String brand, double dailyRate, double batteryLevel) {
        super(brand, dailyRate);
        this.batteryLevel = batteryLevel;
    }

    public void chargeBattery(double kWh){
        this.batteryLevel += kWh;
        if (batteryLevel > 100 ){
            batteryLevel = 100;
        }
        System.out.println("Bateria doladowala sie o " + kWh);
        showBatteryBicycle();
    }
    public double getBatteryLevel(){
        return this.batteryLevel;
    }
    public void showBatteryBicycle(){
        System.out.println("Aktualny poziom baterii to " + batteryLevel + "%");
    }

    public double calculateRentalCost(int days){
        double cost = super.calculateRentalCost(days);
        if (days < 4 ){
            cost = 0;
        } else {
            cost *= days;
        }
        return cost;
    }


}
