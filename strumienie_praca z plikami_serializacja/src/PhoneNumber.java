import java.io.Serializable;

public class PhoneNumber implements Serializable {
    private String number;

    public PhoneNumber (String number){
        if (number == null || number.length() != 9){
            throw new IllegalArgumentException("Numer nie jest poprawny.");
        } else {
            this.number = number;
        }
    }

    public String toString(){
        return number;
    }

}
