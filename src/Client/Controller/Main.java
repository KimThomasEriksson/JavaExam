package Client.Controller;

import Client.Model.School;
import Client.View.ClientGUI;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        School diceSchool = new School("Dice School", "Kungsgatan 15");

        diceSchool.addCource("Math A", "Mathematics", 100, 25);
        diceSchool.addCource("Math B", "Mathematics", 100, 25);
        diceSchool.addCource("Math C", "Mathematics", 100, 25);
        diceSchool.addCource("Spanish A", "Spanish", 100, 25);
        diceSchool.addCource("French","French", 100, 25);
        diceSchool.addCource("Physics A", "Physics", 100, 25);

        diceSchool.addTeacher("Kim", "Svensson", "kim@diceSchool.se", "1234", 1994, 26000, "Mathematics");
        diceSchool.addTeacher("Peter", "Brymer", "peter@diceSchool.se", "1234", 1994, 26000, "Spanish");
        diceSchool.addTeacher("Dan", "Berg", "dan@diceSchool.se", "1234", 1994, 26000, "French");
        ArrayList<String> teacherList = new ArrayList<>();
        teacherList.add("Mathematics");
        teacherList.add("Physics");
        diceSchool.addTeacher("Johanna", "Olsson", "johanna@diceSchool.se", "1234", 1994, 26000, teacherList);

        diceSchool.addStudent("Sven", "Larsson", "sven@diceSchool.se", "1234", 1994);
        diceSchool.addStudent("Håkan", "Svensson", "hakan@diceSchool.se", "1234", 1994);
        diceSchool.addStudent("Loke", "Svalbardsson", "loke@diceSchool.se", "1234", 1994);
        diceSchool.addStudent("Björn", "Dankelan", "bjorn@diceSchool.se", "1234", 1994);

        diceSchool.addCurriclum(diceSchool.getCourses().get(0), diceSchool.getTeachers().get(0));
        diceSchool.addCurriclum(diceSchool.getCourses().get(1), diceSchool.getTeachers().get(1));
        diceSchool.addCurriclum(diceSchool.getCourses().get(3), diceSchool.getTeachers().get(2));
        diceSchool.addCurriclum(diceSchool.getCourses().get(5), diceSchool.getTeachers().get(3));

        diceSchool.getCurriculum().get(0).addStudent(diceSchool.getStudents().get(0));
        diceSchool.getCurriculum().get(0).addStudent(diceSchool.getStudents().get(1));
        diceSchool.getCurriculum().get(0).addStudent(diceSchool.getStudents().get(2));

        ClientGUI client = new ClientGUI();
        client.main(args, diceSchool);



    }
}
