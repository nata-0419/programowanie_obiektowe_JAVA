import java.io.Serializable;

public class Person  implements Serializable {
    protected String firstName;
    protected  String lastName;

    public Person ( String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String allName(){
        return firstName + " " + lastName;
    }
}
