package Client.View;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.nio.channels.Pipe;

public class StudentScene extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;

        BorderPane root = new BorderPane();
        window.setMinWidth(800);
        window.setMinHeight(600);

        // Top
        HBox topBox = new HBox();
        topBox.setAlignment(Pos.CENTER);
        topBox.setPadding(new Insets(10, 10, 10, 10));
        topBox.setSpacing(10);
        topBox.setId("topBox");

        Label topLabel = new Label("Student Login");
        topLabel.setId("topLabel");

        Button logOutButton = new Button("Log Out");
        topBox.getChildren().addAll(topLabel, logOutButton);
        root.setTop(topBox);

        //Center Student

        GridPane studentCenter = new GridPane();
        studentCenter.setPadding(new Insets(50, 10, 10, 10));
        studentCenter.setVgap(8);
        studentCenter.setHgap(10);
        studentCenter.setId("studentCenter");

        Label studentLabel = new Label("Student Info");
        studentLabel.setId("studentHeader");
        studentCenter.add(studentLabel, 0, 0, 4, 1);


        Label fNameLabel = new Label("First Name");
        studentCenter.add(fNameLabel, 0, 1, 1, 1);

        Label fName = new Label("Kim");
        studentCenter.add(fName, 1,1,1,1);

        Label lNameLabel = new Label("Last Name");
        studentCenter.add(lNameLabel, 0, 2, 1, 1);

        Label lName = new Label("Eriksson");
        studentCenter.add(lName, 1,2,1,1);

        Label emailLabel = new Label("Email");
        studentCenter.add(emailLabel, 2,1,1,1);

        Label email = new Label("kim@school.se");
        studentCenter.add(email, 3,1,1,1);

        Label totalPointsLabel = new Label("Total points");
        studentCenter.add(totalPointsLabel, 2, 2,1,1);

        Label totalPoints = new Label("100");
        studentCenter.add(totalPoints, 3,2,1,1);

        //Center Current

        GridPane currentCenter = new GridPane();
        currentCenter.setPadding(new Insets(10, 10, 10, 10));
        currentCenter.setVgap(8);
        currentCenter.setHgap(10);
        currentCenter.setId("currentCenter");

        Label currentLabel = new Label("Current courses");

        currentCenter.add(currentLabel, 0, 0, 1, 1);



        //Center Completed

        GridPane completedCenter = new GridPane();
        completedCenter.setPadding(new Insets(10, 10, 10, 10));
        completedCenter.setVgap(8);
        completedCenter.setHgap(10);
        completedCenter.setId("completedCenter");

        Label completedLabel = new Label("Completed courses");

        completedCenter.add(completedLabel, 0, 0, 1, 1);

        //Center Failed

        GridPane failedCenter = new GridPane();
        failedCenter.setPadding(new Insets(10, 10, 10, 10));
        failedCenter.setVgap(8);
        failedCenter.setHgap(10);
        failedCenter.setId("failedCenter");

        Label failedLabel = new Label("Failed Courses");

        failedCenter.add(failedLabel, 0, 0, 1, 1);

        //Center New Course

        GridPane newCourseCenter = new GridPane();
        newCourseCenter.setPadding(new Insets(10, 10, 10, 10));
        newCourseCenter.setVgap(8);
        newCourseCenter.setHgap(10);
        newCourseCenter.setId("newCourseCenter");

        Label newCoursesLabel = new Label("Courses");

        newCourseCenter.add(newCoursesLabel, 0, 0, 1, 1);

        //Left
        VBox leftBox = new VBox();
        leftBox.setPrefWidth(150);
        leftBox.setPadding(new Insets(100, 10, 10, 10));
        leftBox.setSpacing(10);
        leftBox.setId("leftBox");

        Button studentButton = new Button("Student info");
        studentButton.setOnAction(event -> root.setCenter(studentCenter));

        Button currentButton = new Button("Current courses");
        currentButton.setOnAction(event -> root.setCenter(currentCenter));

        Button completedButton = new Button("Finished courses");
        completedButton.setOnAction(event -> root.setCenter(completedCenter));

        Button failedButton = new Button("Failed courses");
        failedButton.setOnAction(event -> root.setCenter(failedCenter));

        Button signUpButton = new Button("Sign up for course");
        signUpButton.setOnAction(event -> root.setCenter(newCourseCenter));

        studentButton.setMinWidth(leftBox.getPrefWidth());
        currentButton.setMinWidth(leftBox.getPrefWidth());
        completedButton.setMinWidth(leftBox.getPrefWidth());
        failedButton.setMinWidth(leftBox.getPrefWidth());
        signUpButton.setMinWidth(leftBox.getPrefWidth());

        leftBox.getChildren().addAll(studentButton, currentButton, completedButton, failedButton, signUpButton);
        root.setLeft(leftBox);

        //Right


        //Bottom




        //Start scene
        root.setCenter(studentCenter);

        Scene newScene = new Scene(root, 800, 600);
        newScene.getStylesheets().add("Client/View/StudentSceneCSS.css");
        window.setScene(newScene);
        window.show();
    }

}
