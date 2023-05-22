package com.example.javafxguicourse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
public class MainApp extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        Scene scene = new Scene(root);
        // FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("scene1.fxml"));
        // Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Login Screen");
        stage.setScene(scene);
        stage.show();
    }


//    public static void main(String[] args){
//        launch(args);
//    }

    public static void main(String[] args){
        launch(args);
    }
}
