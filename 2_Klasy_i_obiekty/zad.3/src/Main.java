public class Main {
    public static void main(String[] args) {
        Temperature tem1 = Temperature.fromCelsius(2);
        Temperature tem2 = Temperature.fromFahrenheit(5);
        Temperature tem3 = Temperature.fromKelvin(7);

        System.out.println("Temp1: " + tem1.getCelsius() + "C, " + tem1.getFahrenheit() + "F, " + tem1.getKelvin() + "K");
        System.out.println("Temp2: " + tem2.getCelsius() + "C, " + tem2.getFahrenheit() + "F, " + tem2.getKelvin() + "K");
        System.out.println("Temp3: " + tem3.getCelsius() + "C, " + tem3.getFahrenheit() + "F, " + tem3.getKelvin() + "K");
    }
}