package Server.Model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Student extends User {

    private int totalPoints;
    private ArrayList<Course> currentCourses;
    private ArrayList<Course> completedCourses;
    private ArrayList<Course> failedCourses;


    public Student(String firstName, String lastName, String email, String password, int birthyear, ArrayList<Course>currentCourses,ArrayList<Course>completedCourses,ArrayList<Course>failedCourses) {
        super(firstName,lastName,email,password,birthyear);
        this.currentCourses = currentCourses;
        this.completedCourses = completedCourses;
        this.failedCourses = failedCourses;
        calculateTotalPoints();

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


    public void calculateTotalPoints(){
        int result = 0;
        for(Course completed : completedCourses){
            result += completed.getPoints();
        }
        this.totalPoints = result;
    }


//Adds a course to the list if it's not already in the list of courses.
    public boolean addCourse(Course newCourse) {
        for (Course course: currentCourses){
            if(course.getCourseID() == newCourse.getCourseID()){
                return false;
            }
        }
        for (Course course: completedCourses){
            if(course.getCourseID() == newCourse.getCourseID()){
                return false;
            }
        }
        this.currentCourses.add(newCourse);
        return true;
    }

    public boolean completeCourse(Course completedCourse, boolean completed){
        if(currentCourses.contains(completedCourse)){
            if(completed){
                completedCourses.add(completedCourse);
                calculateTotalPoints();
                currentCourses.remove(completedCourse);
                return true;
            }else{
                failedCourses.add(completedCourse);
                currentCourses.remove(completedCourse);
                return true;
            }
        }else{
            return false;
        }

    }

    public ArrayList<Course> getCurrentCourses() {
        return currentCourses;
    }

    public ArrayList<Course> getCompletedCourses() {
        return completedCourses;
    }

    public ArrayList<Course> getFailedCourses() {
        return failedCourses;
    }




}
