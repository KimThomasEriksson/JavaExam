package Client.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LogIn{
        Stage mainWindow;
        public static void display(Stage parentStage){
            Stage mainWindow = parentStage;

            Stage window = new Stage();
            GridPane grid = new GridPane();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Log In");
            window.setMinWidth(250);
            window.setOnCloseRequest(e -> closeWindow(window, mainWindow));

            //GridPane with 10px padding around edge
            grid.setPadding(new Insets(10, 10, 10, 10));
            grid.setVgap(8);
            grid.setHgap(10);

            Label topLabel = new Label("DICE School System");
            topLabel.setId("top_label");
            grid.add(topLabel, 0, 0, 3, 1);
            topLabel.setAlignment(Pos.CENTER);

            //Email Input
            TextField emailInput = new TextField();
            emailInput.setPromptText("email");
            grid.add(emailInput, 0, 1, 1,1);

            //Password Input
            TextField passInput = new TextField();
            passInput.setPromptText("password");
            grid.add(passInput, 1, 1, 1,1);

            //Login
            Button loginButton = new Button("Log In");
            grid.add(loginButton, 2, 1, 1,1);
            loginButton.setOnAction(e -> login(emailInput, passInput, window, mainWindow));

            //Text

            Label infoText = new Label();
            infoText.setText("\nWelcome to DICE School system.\nPlease log in\n\nIf you have not recieved a login, please\ncontact your programcoordinator");
            infoText.setId("info_text");
            grid.add(infoText, 0, 2, 3, 1);

            Scene scene = new Scene(grid, 400, 300);
            scene.getStylesheets().add("Client/View/LogInCSS.css");
            window.setScene(scene);
            window.show();
            loginButton.requestFocus();


        }


    private static void login(TextField email, TextField password, Stage logInWindow, Stage mainWindow) {
        if (email.getText().length() != 0 && password.getText().length() != 0) {
            if(email.getText().equals("student")){

                Scene newScene = StudentScene.createScene();
                mainWindow.setScene(newScene);
                logInWindow.close();
            }

        } else {
            AlertBox.alert("Error", "Wrong email or password");
        }

    }

     private static void closeWindow(Stage logInWindow, Stage parentWindow){
         logInWindow.close();
         parentWindow.close();
    }






}
