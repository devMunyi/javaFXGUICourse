package com.example.javafxguicourse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        try {
            // Parent root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
            FXMLLoader loader = new FXMLLoader(App.class.getResource("scene1.fxml"));
            // Parent root = loader.load();
            Scene scene = new Scene(loader.load());

            stage.setTitle("Music Player");
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
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit App");
        alert.setHeaderText("Your About to Close App");
        alert.setContentText("Do You Want to Save Changes Before Exiting?");

        if(alert.showAndWait().get() == ButtonType.OK){
            stage.close();
        }
    }
}
