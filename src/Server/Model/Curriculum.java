package Server.Model;

import java.util.ArrayList;

public class Curriculum{
    private static int numberOfCurricilum = 0;
    private int curricilumID;
    private Course course;
    private Teacher teacher;
    private ArrayList<Student> students;

    public Curriculum(Course course, Teacher teacher, ArrayList<Student> student){
        this.course = course;
        this.teacher = teacher;
        this.students = student;
        this.curricilumID = this.numberOfCurricilum;
        this.numberOfCurricilum++;
    }

    public Curriculum(Course course, Teacher teacher){
        this.course = course;
        this.teacher = teacher;
        students = new ArrayList<>();
        this.curricilumID = this.numberOfCurricilum;
        this.numberOfCurricilum++;

    }

    public Curriculum(Course course){
        this.course = course;
        students = new ArrayList<>();
        this.curricilumID = this.numberOfCurricilum;
        this.numberOfCurricilum++;

    }

    public boolean addTeacher(Teacher newTeacher){
        if(teacher != null){
            this.teacher = newTeacher;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean removeTeacher(Teacher teacherToRemove){
        if(teacher != null && teacher.getEmployeeid() == teacherToRemove.getEmployeeid()){
            this.teacher = null;
            return true;
        }else{
            return false;
        }
    }

    public boolean addStudent(Student studentToAdd){
        if(!(students.size()>this.course.getNumberOfStudents())){
            students.add(studentToAdd);
            return true;
        }else{
            return false;
        }
    }

    public void passStudent(Student studentToPass){
        //studentToPass.completeCourse(this.course, true);
    }

    public void failStudent(Student studentToPass){
        //studentToPass.completeCourse(this.course, false);
    }

    public Course getCourse() {
        return course;
    }

    public static int getNumberOfCurricilum() {
        return numberOfCurricilum;
    }

    public int getCurricilumID() {
        return curricilumID;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}