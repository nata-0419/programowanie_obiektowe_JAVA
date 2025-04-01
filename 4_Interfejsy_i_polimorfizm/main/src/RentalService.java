import java.util.ArrayList;
import java.util.List;

public class RentalService {
    private List<Verhicle> verhicles;

    public RentalService() {
        verhicles = new ArrayList<>();
    }

    public void addVerhicle(Verhicle verhicle) {
        verhicles.add(verhicle);
    }

    public void showAllVehicles() {
        for (Verhicle v : verhicles) {
            v.showInfo();
        }
    }

    public List<ElectricRechargeable> getAllElectricVehicles() {
        List<ElectricRechargeable> electricVerhicles = new ArrayList<>();
        for (Verhicle v : verhicles) {
            if (v instanceof ElectricRechargeable) {
                electricVerhicles.add((ElectricRechargeable) v);
            }
        }
        return electricVerhicles;
    }

    public double calculateTotalCost(int days) {
        double totalCost = 0;
        for (Verhicle v : verhicles) {
            totalCost += v.calculateRentalCost(days);
        }
        return totalCost;
    }

    public void chargeAllElectricVehicles(double kWh){
        for (Verhicle v : verhicles){
            if (v instanceof ElectricRechargeable){
                ((ElectricRechargeable) v).chargeBattery(kWh);
            }
        }
    }




}
