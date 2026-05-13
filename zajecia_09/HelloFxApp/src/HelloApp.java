import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class HelloApp extends Application {


    public void start(Stage stage) throws Exception {

        stage.setTitle("Hello World");
        Label label = new Label("Witaj JavaFX");
        label.setAlignment(Pos.CENTER);
        Scene scene = new Scene(label, 400, 200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
