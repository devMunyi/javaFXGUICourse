module com.example.javafxguicourse {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.javafxguicourse to javafx.fxml;
    exports com.example.javafxguicourse;
}