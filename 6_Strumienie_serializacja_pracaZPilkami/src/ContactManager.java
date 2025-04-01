import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void loadContactFromTextFile(String filename) {
        try {
            Contact contact = new Contact("", "", new PhoneNumber("123456789"), new EmailAdress("a@b.c"));
            contact.readFromTextFile(filename);
            contacts.add(contact);
        } catch (Exception e) {
            System.out.println("Bląd przy zapisie: " + e.getMessage());
        }
    }

    public void displayAllContacts() {
for (Contact contact: contacts) {
            System.out.println(contact);
        }
    }

    public void serializeContacts(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(contacts);
            System.out.println("Lista kontaktów pobrana z pliku " + filename);
        } catch (IOException e) {
            System.out.println("Bląd przy serializacji: " + e.getMessage());
        }
    }

    public void deserializeContacts(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            contacts = (List<Contact>) ois.readObject();
            System.out.println("Lisa kontaktów zapisana w pliku " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Bląd przy zapisie deserializacji: " + e.getMessage());
        }
    }
}

