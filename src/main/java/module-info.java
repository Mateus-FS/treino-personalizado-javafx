module org.example.treinoapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.treinoapp to javafx.fxml;
    exports org.example.treinoapp;
}