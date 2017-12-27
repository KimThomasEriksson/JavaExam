package Server.model;

import java.util.ArrayList;

public class Teacher extends User {

    private static int idCounter = 0;
    private int numberOfTeachers=0;
    private final int employeeid;
    private ArrayList<String> knownSubjects;
    private int salary;


    public Teacher(String firstName, String lastName, String email, String password, int birthyear,int salary, ArrayList<String> knownSubjects) {
        super(firstName, lastName, email, password, birthyear);
        this.knownSubjects = knownSubjects;
        raiseSalary(salary);
        this.employeeid = idCounter;
        idCounter++;
        numberOfTeachers++;
    }

    public Teacher(String firstName, String lastName, String email, String password, int birthyear, int numberOfTeachers, int employeeid,String knownSubject, int salary) {
        super(firstName, lastName, email, password, birthyear);
        this.employeeid = employeeid;
        this.knownSubjects = new ArrayList<String>();
        this.salary = salary;
    }

    public void raiseSalary(int increment) {
        if (this.salary+increment>0){
           this.salary += increment;
        }
    }
    public void decreaseSalary(int decrement){
        if(this.salary-decrement>0){
            this.salary-=decrement;
        }
    }
/*
    public void addSubject(String Subject){
        for(int i=0,)
    }
    */
}
