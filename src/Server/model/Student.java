package Server.Model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Student extends User {

    private int totalPoints;
    private ArrayList<String> currentCourses;
    private ArrayList<String> completedCourses;
    private ArrayList<String> failedCourses;


    public Student(String firstName, String lastName, String email, String password, int birthyear,int totalPoints,ArrayList<String>currentCourses,ArrayList<String>completedCourses,ArrayList<String>failedCourses) {
        super(firstName,lastName,email,password,birthyear);
        this.totalPoints = totalPoints;
        this.currentCourses = currentCourses;
        this.completedCourses = completedCourses;
        this.failedCourses = failedCourses;

    }

    public Student(String firstName, String lastName, String email, String password, int birthyear) {
        super(firstName,lastName,email,password,birthyear);
        this.totalPoints = 0;
        this.currentCourses = new ArrayList<>();
        this.completedCourses = new ArrayList<>();
        this.failedCourses = new ArrayList<>();

    }

    public int getTotalPoints() {
        return totalPoints;
    }

    /* Funktion för att räkna ut totalpoängen
    public void calculateTotalPoints(){
        int result = 0;
        for(Course completed : completedCourses){
            result += completed.getPoints();
        }
    }
    */

//Adds a course to the list if it's not already in the list of courses.
    public void addCourse(String Course) {
        for (int i = 0; i <this.currentCourses.size(); i++) {
            if(this.currentCourses.get(i).equals(Course)){
                return;
            }
        }
        this.currentCourses.add(Course);
    }

    public void completeCourse(String Course,boolean completed){
        for (int i = 0; i <this.currentCourses.size(); i++) {
            if(this.currentCourses.get(i).equals(Course)) {
                if(completed) {
                    this.completedCourses.add(Course);
                    return;
                }
                else {
                    this.failedCourses.add(Course);
                    return;
                }
            }
        }
        this.currentCourses.remove(Course);

    }

    public ArrayList<String> getCurrentCourses() {
        return currentCourses;
    }

    public ArrayList<String> getCompletedCourses() {
        return completedCourses;
    }

    public ArrayList<String> getFailedCourses() {
        return failedCourses;
    }

    // EJ KLAR
/*
    public void saveStudentToFile(String fileName) throws FileNotFoundException {
        FileOutputStream fileOut = new FileOutputStream(fileName);
        try {
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
            for (int i = 0; i <this.students.size(); i++) {
                out.writeObject(User);

            }
        out.close();
        fileOut.close();
        }   catch (IOException i) {

        }

    }
    */
}
