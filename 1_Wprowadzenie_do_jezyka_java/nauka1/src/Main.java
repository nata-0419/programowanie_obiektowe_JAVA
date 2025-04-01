public class Main {
    public static void main(String[] args) {
        Punkt punkt = new Punkt();
        punkt.ustawX(5);
        punkt.ustawY(10);

        System.out.println("Nasze wspólrzędne to: x=" + punkt.dajX() + " y=" + punkt.dajY());
    }
}