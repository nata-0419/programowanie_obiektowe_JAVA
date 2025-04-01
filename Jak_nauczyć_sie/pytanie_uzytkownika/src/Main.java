import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj swoje imie: ");
        String imie = scanner.nextLine();

        System.out.println("Podaj swój wiek: ");
        int wiek = scanner.nextInt();

        System.out.println("Witam, " + imie + ". Masz " + wiek + " lat.");

        /*System.out.println("Masz więcej niż 18 lat?");
        String odp = scanner.nextLine();*/
            if (wiek > 18) {
                System.out.println("Jesteś pelnoletni");

            } else {
                System.out.println("Nie jesteś pelnoletni");
            }

    }
}