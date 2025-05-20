import java.util.*;

public class Main {
    public static void main(String[] args) {
        DzbanDAO dao = new DzbanDAO();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n Aktualne dzbany:");
        dao.getAll().forEach(System.out::println);

        Dzban dz1 = new Dzban("drugi dzban", "to jest drugi dzban", 22, 22);
        Dzban dz2 = new Dzban("piaty dzban", "to jest piaty dzban", 55, 55);
        dao.add(dz1);
        dao.add(dz2);
        System.out.println("\n Dodano 2 dzbany:");
        dao.getAll().forEach(System.out::println);

        Dzban aktualizowany = dao.getAll().get(7);
        aktualizowany.setOpis("Zmieniono opis dzbana");
        dao.update(aktualizowany);
        System.out.println("\n Zaktualizowano dzban:");
        System.out.println(dao.getById(aktualizowany.getId()));

        Dzban doUsuniecia = dao.getAll().get(1);
        dao.delete(doUsuniecia.getId());
        System.out.println("\n Usunięto dzban o ID: " + doUsuniecia.getId());

        System.out.println("\n Zawartość bazy na końcu:");
        dao.getAll().forEach(System.out::println);
    }
}
