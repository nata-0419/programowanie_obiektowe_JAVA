import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę: ");
        int liczba = scanner.nextInt();
        scanner.close();

        if (Sprawdzenie.sprawdzenieliczby(liczba)){
            System.out.println(liczba +" jest liczbą pierwszą.");
        } else {
            System.out.println(liczba + " nie jest liczbą pierwszą.");
        }

    }
}