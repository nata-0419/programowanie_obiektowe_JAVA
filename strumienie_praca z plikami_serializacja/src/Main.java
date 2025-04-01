import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();

        try {
            Contact c1 = new Contact("Anna", "Kowalska",
                    new PhoneNumber("123456789"),
                    new EmailAdress("annakowalska@example.com"));
            Contact c2 = new Contact("Natalia", "Góras",
                    new PhoneNumber("123987546"),
                    new EmailAdress("nataliagoras@gamil.com"));

            c2.saveToTextFile("contact.txt");                   // Zapis do pliku

            manager.addContact(c1);                                     // dodanie c1 do menadżera bezpośrednio
            manager.loadContactFromTextFile("contact.txt");     // dodanie c2 przez odczyt z pliku

            System.out.println("Wyświetlenie listy zapisanych kontaktów: ");
            manager.displayAllContacts();                               // wyświetlenie wszystkich kontaków

            System.out.println();
            manager.serializeContacts("contacts.dat");          // serializacja do pliku binarnego

            ContactManager newManager = new ContactManager();
            newManager.deserializeContacts("contacts.dat");     // Deserializacja z pliku binarnego

            System.out.println();
            System.out.println("Kontakty po deserializacji:");          // wyświetlenie kontaków po deserializacji
            newManager.displayAllContacts();

        } catch (IllegalArgumentException | IOException e) {
            System.out.println("bląd: " + e.getMessage());
        }
    }
}
