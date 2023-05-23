package com.example.javafxguicourse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        Scene scene = new Scene(root);

        stage.setTitle("Image View");
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(event -> {
            event.consume();
            closeApp(stage);
        });
    }


    public static void main(String[] args){
        launch(args);
    }

    public void closeApp(Stage stage){
       // confirmation alert
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Close App");
        alert.setHeaderText("You are about to close application!");
        alert.setContentText("Do you want to save your changes before exiting?");

        if(alert.showAndWait().get() == ButtonType.OK){
            stage.close();
        }
    }
}
