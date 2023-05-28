package com.example.javafxguicourse;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
            Scene scene = new Scene(root);

            String css = this.getClass().getResource("application.css").toExternalForm();
            scene.getStylesheets().add(css);

            stage.setTitle("Validating user Text field inputs");
            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(event -> {
                event.consume();
                closeApp(stage);
            });
        }catch (Exception e){
            System.out.println(e);
        }
    }


    public void closeApp(Stage stage){
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Close App");
            alert.setHeaderText("You Are About to Close Exit App");
            alert.setContentText("Do you really want to save your changes before exiting");

            if(alert.showAndWait().get() == ButtonType.OK){
                stage.close();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
