import java.io.*;

public class Contact extends Person{
    private PhoneNumber phoneNumber;
    private EmailAdress emailAdress;

    public Contact (String firstName, String lastName, PhoneNumber phoneNumber, EmailAdress emailAdress){
        super(firstName, lastName);
        this.phoneNumber = phoneNumber;
        this.emailAdress = emailAdress;
    }

    public void saveToTextFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(firstName + ";" + lastName + ";" + phoneNumber + ";" + emailAdress);
        }
    }

    public void readFromTextFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            if (line != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    this.firstName = parts[0];
                    this.lastName = parts[1];
                    this.phoneNumber = new PhoneNumber(parts[2]);
                    this.emailAdress = new EmailAdress(parts[3]);
                }
            }
        }
    }

    @Override
    public String toString() {
        return firstName + ";" + lastName + ";" + phoneNumber + ";" + emailAdress;
    }

}
