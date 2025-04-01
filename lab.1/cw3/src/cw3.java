import java.util.Arrays;

public class cw3 {
    public static void main(String[] args) {
        int[] liczby = {3,1,8,5,9};
        System.out.println("Tablica liczb przed segregowaniem: " + Arrays.toString(liczby));
        SortBooble.sortowanie(liczby);
        System.out.println("Tablica liczb po sortowaniu: " + Arrays.toString(liczby));
    }
}
