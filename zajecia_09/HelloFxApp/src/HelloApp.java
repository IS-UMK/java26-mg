import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class HelloApp extends Application {


    public void start(Stage stage) throws Exception {

        stage.setTitle("Hello World");
        Scene scene = new Scene(new Label("Witaj JavaFX"), 400, 200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
