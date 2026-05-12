package org.example.fxmlhello;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    @FXML
    private TextField loginText;

    @FXML
    protected void onHelloButtonClick() {

        loginText.setText("Hello World");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginText.setPromptText("Login XXX");
        loginText.setStyle("-fx-border-color: red;");
    }
}
