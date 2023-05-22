package com.example.javafxguicourse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // add fxml
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // add stylesheet
        // scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        // getting css as a variable for re-usability
        String css = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(css);


        stage.setTitle("Handling Events");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args){
        launch(args);
    }
}
