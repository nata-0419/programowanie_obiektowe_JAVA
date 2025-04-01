public class User {
    private int userId;
    private String ferstName;
    private String lastName;

    public User(int userId, String ferstName, String lastName) {
        this.userId = userId;
        this.ferstName = ferstName;
        this.lastName = lastName;
    }

    public String UserInformation() {
        return "ID: " + userId + ". " + ferstName + " " + lastName;
    }
}