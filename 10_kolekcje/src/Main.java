public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        try {
            Person p1 = new Person("Alicja", "123456789", "alicja@example.com");
            Person p2 = new Person("Bartek", "987654321", "bartek@example.com");
            Person p3 = new Person("Celina", "555666777", "celina@example.com");

            phoneBook.addPerson(p1);
            phoneBook.addPerson(p2);
            phoneBook.addPerson(p3);

            System.out.println("Osoby dodane");
            phoneBook.getSortedPeople().forEach(System.out::println);

            System.out.println("\n Adresy email posortowane");
            phoneBook.getSortedEmails().forEach(System.out::println);

            System.out.println("\n Nadpisywanie osoby z tym samym numerem");
            Person p1Updated = new Person("Ala", "123456789", "ala@example.com");
            phoneBook.addPerson(p1Updated);

            System.out.println("Po nadpisaniu ");
            phoneBook.getSortedPeople().forEach(System.out::println);

            System.out.println("\n Próba dodania osoby z istniejącym e-mailem ");
            try {
                Person p4 = new Person("Dawid", "111222333", "bartek@example.com");
                phoneBook.addPerson(p4);
            } catch (Exception e) {
                System.out.println("Błąd: " + e.getMessage());
            }

            System.out.println("\n Usuwanie osoby ");
            phoneBook.removePerson("987654321");
            phoneBook.getSortedPeople().forEach(System.out::println);

            System.out.println("\n Próba usunięcia nieistniejącej osoby");
            try {
                phoneBook.removePerson("000000000");
            } catch (Exception e) {
                System.out.println("Błąd: " + e.getMessage());
            }

            System.out.println("\n Wyszukiwanie osoby ");
            Person found = phoneBook.searchByPhoneNumber("123456789");
            System.out.println(found != null ? found : "Nie znaleziono osoby.");

            System.out.println("\n Wyszukiwanie nieistniejącej osoby ");
            Person notFound = phoneBook.searchByPhoneNumber("000000000");
            System.out.println(notFound != null ? notFound : "Nie znaleziono osoby.");

            System.out.println("\n Adresy email po aktualizacji ");
            phoneBook.getSortedEmails().forEach(System.out::println);

            System.out.println("\n Próba dodania osoby z błędnymi danymi ");
            try {
                new Person("", "123abc", "invalidemail.com");
            } catch (Exception e) {
                System.out.println("Błąd: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }
}
