import Server.Model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Unittest {

    @Test
    public void testTeacher(){
        Teacher teacher = new Teacher("Kim", "Eriksson", "kim@school.se", "1234", 1996, 26000, "Math");
        assertEquals(teacher.getEmployeeid(), 0);
        assertEquals(teacher.getKnownSubjects().get(0), "Math");
        assertEquals(teacher.getKnownSubjects().size(), 1);
        assertEquals(teacher.getEmail(), "kim@school.se");
        assertEquals(teacher.getNumberOfTeachers(), 1);
        assertEquals(teacher.getSalary(), 26000);
        assertEquals(teacher.getFirstName(), "Kim");
        assertEquals(teacher.getLastName(), "Eriksson");
        assertEquals(teacher.getPassword(), "1234");

        // Test raiseSalary
        teacher.raiseSalary(2000);
        assertEquals(teacher.getSalary(), 28000);

        // Test decreaseSalary
        teacher.decreaseSalary(30000);
        assertEquals(teacher.getSalary(), 28000);

        teacher.decreaseSalary(2000);
        assertEquals(teacher.getSalary(), 26000);


        //Test add Subject
        teacher.addSubject("Spanish");
        assertEquals(teacher.getKnownSubjects().size(), 2);
        assertEquals(teacher.getStringOfSubjects(), "Math,Spanish,");

        //Test remove subject

        teacher.removeSubject("Spanish");
        assertEquals(teacher.getKnownSubjects().size(), 1);
        assertEquals(teacher.getStringOfSubjects(), "Math");


    }

    @Test
    public void testStudent(){
        Student student = new Student("Kim", "Eriksson", "kim@school.se", "1234", 1996);
        assertEquals(student.getFirstName(), "Kim");
        assertEquals(student.getLastName(), "Eriksson");
        assertEquals(student.getEmail(), "kim@school.se");
        assertEquals(student.getBirthyear(), 1996);
        assertEquals(student.getPassword(), "1234");
        assertEquals(student.getTotalPoints(), 0);

        // Test add course
        Course course = new Course("Math A", "Math", 50, 30);
        Course course2 = new Course("Math A", "Math", 50, 30);

        student.addCourse(course);
        assertEquals(student.getTotalPoints(), 0);
        assertEquals(student.getCurrentCourses().size(), 1);

        // Test complete course pass
        student.completeCourse(course, true);
        assertEquals(student.getTotalPoints(), 50);
        assertEquals(student.getCurrentCourses().size(), 0);
        assertEquals(student.getCompletedCourses().size(), 1);
        assertEquals(student.getFailedCourses().size(), 0);

        // Test complete course fail
        student.addCourse(course2);
        assertEquals(student.getCurrentCourses().size(), 1);
        student.completeCourse(course2, false);
        assertEquals(student.getTotalPoints(), 50);
        assertEquals(student.getCurrentCourses().size(), 0);
        assertEquals(student.getCompletedCourses().size(), 1);
        assertEquals(student.getFailedCourses().size(), 1);

    }

    @Test
    public void testAdmin(){
        Admin admin = new Admin("Kim", "Eriksson", "kim@school.se", "1234", 1996);
        assertEquals(admin.getFirstName(), "Kim");
        assertEquals(admin.getLastName(), "Eriksson");
        assertEquals(admin.getEmail(), "kim@school.se");
        assertEquals(admin.getBirthyear(), 1996);
        assertEquals(admin.getPassword(), "1234");
    }

    @Test
    public void testCourse(){
        Course course = new Course("Math A", "Math", 50, 30);
        Course course2 = new Course("Math A", "Math", 50, 30);
        assertEquals(course.getName(), "Math A");
        assertEquals(course.getSubject(), "Math");
        assertEquals(course.getCourseID(), 2);
        assertEquals(course2.getCourseID(), 3);
        assertEquals(course.getNumberOfStudents(), 30);


    }

    @Test
    public void testCurriculum(){
        Course course = new Course("Math A", "Math", 50, 2);
        Course course2 = new Course("Math B", "Math", 50, 2);

        Student student = new Student("Kim", "Eriksson", "kim@school.se", "1234", 1996);
        Student student2 = new Student("Kim", "Eriksson", "kim@school.se", "1234", 1996);
        Student student3 = new Student("Kim", "Eriksson", "kim@school.se", "1234", 1996);
        ArrayList<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student2);
        students.add(student3);

        Teacher teacher = new Teacher("Kim", "Eriksson", "kim@school.se", "1234", 1996, 26000, "Math");
        Teacher teacher2 = new Teacher("Kim", "Eriksson", "kim@school.se", "1234", 1996, 26000, "Math");

        Curriculum curriculum = new Curriculum(course, teacher);
        assertEquals(curriculum.getCourse().getCourseID(), course.getCourseID());
        assertEquals(curriculum.getCurricilumID(), 0);
        assertEquals(curriculum.getStudents().size(), 0);
        assertEquals(curriculum.getTeacher().getEmployeeid(), teacher.getEmployeeid());

        // Test adding another teacher
        assertEquals(curriculum.addTeacher(teacher2), false);

        // Test removing teacker

        assertEquals(curriculum.removeTeacher(teacher), true);
        assertEquals(curriculum.getTeacher(), null);
        assertEquals(curriculum.addTeacher(teacher2), true);
        assertEquals(curriculum.getTeacher().getEmployeeid(), teacher2.getEmployeeid());

        // Test adding students
        assertEquals(curriculum.addStudent(student), true);
        assertEquals(curriculum.addStudent(student), false);
        assertEquals(curriculum.addStudent(student2), true);
        assertEquals(curriculum.addStudent(student3), false);

        // Test pass and fail course;
        curriculum.passStudent(student);
        assertEquals(student.getCompletedCourses().get(0).getCourseID(), course.getCourseID());
        curriculum.failStudent(student2);
        assertEquals(student2.getFailedCourses().get(0).getCourseID(), course.getCourseID());

    }


}
