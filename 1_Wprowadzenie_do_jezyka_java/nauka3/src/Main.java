import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);       //utworzenie nowej zmiennej
        String imie;

        System.out.println("Jak masz na imie?");
        imie = scanner.nextLine();                      //program pobiera tu dane

        System.out.println("Ile masz lat?");
        int wiek = scanner.nextInt();                   // program pobiera tu dane
        System.out.println("Witam, nazywam się " + imie + " i mam " + wiek + " lat.");
    }
}


