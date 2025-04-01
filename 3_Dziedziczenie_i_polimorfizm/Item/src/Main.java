public class Main {
    public static void main(String[] args) {

        Library library = new Library();

        Book book1 = new Book(11, "Odyseja", "Homer", 781, true, 0,357, "historyczna", "polski");
        Book book2 = new Book(12, "Wojna i pokój", "Lew Tołstoj", 1989, false,0,205, "histryczna", "polski");
        Magazine magazyn1 = new Magazine(13, "Odkrywcy skarbów", "Robert Zeko", 2015, true, 0, 5, "wrzesień", "dokumentalny");
        Magazine magazyn2 = new Magazine(14, "National Geographic", "Redakcja NG", 2023, true,0, 150, "Styczeń", "geograficzny");

        User user1 = new User(1, "Natalia", "Goras");
        User user2 = new User(2, "Dorota", "Kopka");

        System.out.println("Oto lista użytkowników: ");
        System.out.println(user1.UserInformation());
        System.out.println(user2.UserInformation());
        System.out.println();

        System.out.println(book1.getInformation());
            book1.getInformation();
        System.out.println(book1.datInformation());
        System.out.println();

        System.out.println(magazyn1.getInformation());
        magazyn1.getInformation();
        System.out.println(magazyn1.magazinInformation());
        System.out.println();

        library.addItem(book1);
        library.addItem(book2);
        library.addItem(magazyn1);
        library.addItem(magazyn2);
        System.out.println();

        library.displayItems();

        book1.borrowItem(1);
        magazyn1.borrowItem(2);

        library.displayItems();
        System.out.println();

        book1.returnItem(1);
        magazyn1.returnItem(2);
        System.out.println();

        library.displayItems();

        // System.out.printf(book1.getInformation()); //wykorzystanie polączenia z super.....






    }
}