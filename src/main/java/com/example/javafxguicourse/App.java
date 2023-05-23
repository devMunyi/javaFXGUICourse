package com.example.javafxguicourse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Close App");
        stage.show();

        stage.setOnCloseRequest(event -> {
            event.consume();
            logout(stage);
        });
    }

    public void logout(Stage stage){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to exit!");
        alert.setContentText("Do you want to save changes before exiting?");

        if(alert.showAndWait().get() == ButtonType.OK) {
            stage.close();
            System.out.println("Logged out successfully!");
        }
    }

}
