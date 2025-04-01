public class Temperature {
    private double celsius;

    private Temperature (double celsius) {  //prywatny konstruktor (ststyczne motody)
        this.celsius = celsius;
    }
    public static Temperature fromCelsius(double value){    //metoda statyczna (tworzy obiekt na podstawie Celsjusza)
        return new Temperature(value);
    }
    public static Temperature fromFahrenheit(double value){
        return new Temperature((value - 32) / 1.8);
    }
    public static Temperature fromKelvin (double value){
        return new Temperature(value - 273.15);
    }

    public double getCelsius(){
        return celsius;
    }
    public double getFahrenheit(){
        return (celsius *1.8 + 32);
    }
    public double getKelvin(){
        return (celsius + 273.15);
    }


}
