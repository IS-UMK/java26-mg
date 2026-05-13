module org.example.fxmlhello {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.fxmlhello to javafx.fxml;
    exports org.example.fxmlhello;
}