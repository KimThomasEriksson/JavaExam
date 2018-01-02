package Client.View;

import java.util.ArrayList;

public class StudentSceneFunctions {

    public static String[] changeSelectedCourse(String newValue, ArrayList<String[]> courseList) {
        int index = 0;
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i)[0].equals(newValue)) {
                index = i;
                break;
            }

        }
        return courseList.get(index);
    }

}
