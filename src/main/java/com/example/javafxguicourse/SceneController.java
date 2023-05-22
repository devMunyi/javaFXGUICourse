package com.example.javafxguicourse;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {

    private Parent root;
    private Stage stage;
    private Scene scene;

    // for switching to scene 1
    public void switchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        String css = String.valueOf(this.getClass().getResource("application.css"));
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Scene 1");
        stage.show();
    }

    // for switching to scene 2
    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene);
        String css = String.valueOf(this.getClass().getResource("application.css"));
        scene.getStylesheets().add(css);
        stage.setTitle("Scene 2");
        stage.show();
    }

}
