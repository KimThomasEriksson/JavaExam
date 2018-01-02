package Client.Model;

import java.util.ArrayList;

public class Admin extends User {
    private ArrayList<String> listOfAdmins;

    public Admin(String firstName, String lastName, String email, String password, int birthyear) {
        super(firstName, lastName, email, password, birthyear);
        this.listOfAdmins = new ArrayList<>(); //test


    }
}