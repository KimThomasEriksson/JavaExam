package Server.model;

public class User {
    private String firstName;
    private String lastName;
    private final String email;
    private String password;
    private int birthyear;

    public User(String firstName, String lastName, String email, String password, int birthyear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthyear = birthyear;
    }

    public void changePassword(String password) {
        this.password = password;
    }
}
