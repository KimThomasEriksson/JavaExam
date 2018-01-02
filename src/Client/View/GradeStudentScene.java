package Client.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GradeStudentScene {

    public static void createScene(String courseName, ArrayList<String[]> studentList) {
        Stage window = new Stage();
        GridPane gridPane = new GridPane();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Grade Student");
        window.setOnCloseRequest(event -> window.close());
        window.setMinHeight(250);

        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);
        Label gradeHeader = new Label(courseName);
        gridPane.add(gradeHeader, 0, 0, 3, 1);
        gradeHeader.setId("gradeHeader");

        ListView<String> studentListGrade = new ListView<>();
        for(int i =0; i < studentList.size();i++){
            studentListGrade.getItems().add(studentList.get(i)[0] + " " + studentList.get(i)[1]);
        }
        gridPane.add(studentListGrade, 0,1,3,1);

        Button passButton = new Button("Pass student");

        Button failButton = new Button("Fail student");

        Button closeButton = new Button("Close");
        closeButton.setOnAction(event -> window.close());



        passButton.setMinWidth(100);
        failButton.setMinWidth(100);
        closeButton.setMinWidth(100);
        gridPane.add(passButton, 0,2,1,1);
        gridPane.add(failButton, 1,2,1,1);
        gridPane.add(closeButton, 2,2,1,1);



        gridPane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(gridPane);
        scene.getStylesheets().add("Client/View/GradeStudentCSS.css");
        window.setScene(scene);
        window.showAndWait();
    }
}
