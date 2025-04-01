public class SortBooble {
    public static void sortowanie(int[] arr) {
        int n = arr.length;
        boolean swapped;        // sprawdza czy tablica jest już posortowana, jęsli tak pomija sortowanie
        for (int i=0; i<n-1; i++){
            swapped = false;
            for (int j=0; j<n-1; j++){
                if (arr[j] > arr[j+1]){
                    int zamiana = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = zamiana;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
