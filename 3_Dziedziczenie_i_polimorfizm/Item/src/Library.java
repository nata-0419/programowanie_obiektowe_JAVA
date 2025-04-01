import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Item> items;

    public Library() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
        System.out.println("Dodano nową pozycję w bibliotece: " + item.getInformation());
    }

    public void displayItems() {
        System.out.println("Lista dostępnych pozycji w bibliotece:");
        if (items.isEmpty()) {
            System.out.println("Brak pozycji w bibliotece!");
        } else {
            for (Item item : items) {
                if (item.isAvailable()) {
                    System.out.println(item.getInformation());
                }
            }
        }
    }
}
