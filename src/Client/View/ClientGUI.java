package Client.View;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class ClientGUI extends Application{

    Stage window;
    Button button;
    GridPane grid = new GridPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("DICE School system");

        //GridPane with 10px padding around edge
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Scene scene = new Scene(grid, 800, 600);
        scene.getStylesheets().add("Client/View/LogInCSS.css");
        window.setScene(scene);
        window.show();
        LogIn.display(window);



    }

}
