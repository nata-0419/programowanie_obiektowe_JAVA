public class Main {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1,2);
        Fraction f2 = new Fraction(2,2);
        f1.reduce();
        f2.reduce();
        System.out.println("Wynik dodawania: "+f1.add(f2));
        System.out.println("Wynik odejmowania: "+f1.subtract(f2));
        System.out.println("Wynik mnożenia: "+f1.multiply(f2));
        System.out.println("Wynik dzielenie: "+f1.divide(f2));
    }
}
