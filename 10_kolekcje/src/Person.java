import java.util.Objects;

public class Person {
    private String name;
    private String phoneNumber;
    private String email;

    public Person(String name, String phoneNumber, String email) {
        if (name == null || name.isBlank() || phoneNumber == null || phoneNumber.isBlank() ||
                email == null || email.isBlank() || !email.contains("@") || !phoneNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Niepoprawne dane osoby.");
        }
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Imię nie może być puste.");
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null )
            throw new IllegalArgumentException("Numer telefonu musi zawierać tylko cyfry.");
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        if (email == null || !email.contains("@"))
            throw new IllegalArgumentException("Niepoprawny adres e-mail.");
        this.email = email;
    }


    @Override
    public String toString() {
        return name + " – " + phoneNumber + " – " + email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
