import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Podaj pierwszą liczbę: ");
        int a = scanner.nextInt();
        String nazwa = scanner.nextLine()
        System.out.printf("Podaj drugą liczbę: ");
        int b = scanner.nextInt();

        int c = a + b;
        int d = a - b;
        int e = a * b;
        int f = a / b;

        System.out.println("Wynik dodawania:" + c);
        System.out.println("Wynik odejmowania:" + d);
        System.out.println("Wynik mnożenia:" + e);
        System.out.println("Wynik dzielenia:" + f);

    }
}