package com.example.javafxguicourse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;

public class Scene1Controller {
    @FXML
    private TextField nameField;
    private Parent root;
    private Stage stage;
    private Scene scene;

    public void login(ActionEvent event) throws IOException {

        String name = nameField.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene2.fxml"));
        root = loader.load();

        Scene2Controller scene2Controller = loader.getController();
        scene2Controller.displayName("Hello "+ name);

        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);

        // System.out.println("Entered Name is: "+name);
    }
}
