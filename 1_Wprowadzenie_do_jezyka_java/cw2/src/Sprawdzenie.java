public class Sprawdzenie {
    public static boolean sprawdzenieliczby(int liczba) {
        if (liczba < 2)
            return false;
        for (int a = 2; a*a<=liczba; a++){
            if (liczba % a == 0)
                return false;
        }
        return true;
    }
}

