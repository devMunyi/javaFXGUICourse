module com.example.javafxguicourse {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.web;

    opens com.example.javafxguicourse to javafx.fxml;
    exports com.example.javafxguicourse;
}