public class Main {
    public static void main(String[] args) {

        Car car = new Car("Toyota", 100, 5);
        Motorcycle motorcycle = new Motorcycle("Yamaha", 80, 600);
        Bicycle bicycle = new Bicycle("Giant", 30);
        ElectricCar electricCar = new ElectricCar("Tesla", 100, 4, 30);
        ElectricBicycle electricBicycle = new ElectricBicycle("BMX", 40, 60);

        RentalService rentalService = new RentalService();
        rentalService.addVerhicle(electricCar);
        rentalService.addVerhicle(electricBicycle);
        rentalService.showAllVehicles();
        double totalCost = rentalService.calculateTotalCost(6);
        System.out.println("Calkowoity koszt wynajmu: " + totalCost);
        rentalService.chargeAllElectricVehicles(30);

        System.out.println();
        car.showInfo();
        System.out.println("Koszt wynajmu auta " + car.calculateRentalCost(10));

        System.out.println();
        motorcycle.showInfo();
        System.out.println("Koszt wynajmu motocykla " + motorcycle.calculateRentalCost(5));

        System.out.println();
        bicycle.showInfo();
        System.out.println("Koszt wynajmu roweru " + bicycle.calculateRentalCost(3));

        System.out.println();
        electricCar.showInfo();
        electricCar.showBatteryCar();
        electricCar.chargeBattery(20);
        System.out.println("Koszt wynajmu samochodu elektrycznego  " + electricCar.calculateRentalCost(10));

        System.out.println();
        electricBicycle.showInfo();
        electricBicycle.showBatteryBicycle();
        electricBicycle.chargeBattery(20);
        System.out.println("Koszt wynajmu roweru elektrycznego " + electricCar.calculateRentalCost(3));

    }
}
