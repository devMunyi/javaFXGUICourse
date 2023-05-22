module com.example.javafxguicourse {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxguicourse to javafx.fxml;
    exports com.example.javafxguicourse;
}