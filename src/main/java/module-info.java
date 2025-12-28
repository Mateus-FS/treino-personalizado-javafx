module org.example.treinoapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires spring.data.commons;
    requires jakarta.persistence;


    opens org.example.treinoapp to javafx.fxml;
    exports org.example.treinoapp;
}