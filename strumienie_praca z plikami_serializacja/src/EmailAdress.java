import java.io.Serializable;

public class EmailAdress implements Serializable {
    private String email;

    public EmailAdress(String email){
        if (email == null || email.chars().filter(a -> a == '@').count() !=1  ||
        email.chars().filter(a -> a == '.').count() != 1) {
            throw new IllegalArgumentException("Adress email jest nie poprawny, sprawdz czy zawiera '@' oraz 'kropke'");
        } else {
            this.email = email;
        }
    }

    public String toString(){
        return email;
    }
}
