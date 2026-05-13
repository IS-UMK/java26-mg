import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import  javafx.scene.control.TextField;

import javax.naming.Binding;


public class ShapeApp extends Application {

    public void start(Stage stage) throws Exception {

        StackPane stackPane = new StackPane();

        Ellipse ellipse = new Ellipse(110, 70);
        ellipse.setFill(Color.LIGHTBLUE);

        Text text = new Text("Hello World");
        text.setFont(new Font("Arial Bold", 24));

        Stop[] stops = new Stop[] {
                new Stop(0, Color.DODGERBLUE),
                new Stop(0.5, Color.LIGHTBLUE),
                new Stop(1.0, Color.LIGHTGREEN)  };
        LinearGradient gradient = new LinearGradient(0, 0, 1, 1, true,
                CycleMethod.NO_CYCLE, stops);

        ellipse.setEffect(new DropShadow(30, 10, 10, Color.GRAY));

        ellipse.setFill(gradient);

        Reflection  reflection = new Reflection();
        reflection.setFraction(.8);
        reflection.setTopOffset(1.0);
        text.setEffect(reflection);

        RotateTransition rotate = new RotateTransition(Duration.millis(2500), stackPane);
        rotate.setToAngle(360);
        rotate.setFromAngle(0);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();

        FadeTransition fade = new FadeTransition(Duration.millis(2500), stackPane);
        fade.setToValue(1);
        fade.setFromValue(0);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.play();

        Text text2 = new Text("Status Animacji");

        VBox vbox =  new VBox();
        vbox.setAlignment(Pos.CENTER);

        vbox.setSpacing(10);
        vbox.getChildren().addAll(stackPane, text2);

        stackPane.setOnMouseClicked(mouseEvent -> {
            if (rotate.getStatus().equals(Animation.Status.RUNNING)) {
                rotate.pause();
            } else {
                rotate.play();
            }
        });

        rotate.statusProperty().addListener(observable -> {
            text2.setText("Animation status: " + rotate.getStatus());
        });

        text2.rotateProperty().bind(stackPane.rotateProperty());

        Text text3 = new Text("Rotacja ");
        vbox.getChildren().add(text3);
        text3.textProperty().bind(Bindings.concat("Rotacja ",
                stackPane.rotateProperty().asString("%.1f")));

        TextField textField1 = new TextField();
        textField1.setPromptText("Wpisz tu cokolwiek");
        TextField textField2 = new TextField("");
        textField2.setPromptText("Wpisz tu cokolwiek");

        vbox.getChildren().addAll(textField1, textField2);
        textField1.textProperty().bindBidirectional(textField2.textProperty());

        stackPane.getChildren().addAll(ellipse, text);
        Scene scene = new Scene(vbox, 400, 400, Color.LIGHTYELLOW);
        stage.setScene(scene);
        stage.setTitle("Shape Demo");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
