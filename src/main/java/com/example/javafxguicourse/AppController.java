package com.example.javafxguicourse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class AppController {
    @FXML
    private Button logoutButton;

    @FXML
    private AnchorPane scenePane;
    private  Stage stage;

    public void logout(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Do you want to save before exiting?");

        // Accessing stage using event object
//        if(alert.showAndWait().get() == ButtonType.OK) {
//             stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//             stage.close();
//        }


        // Accessing stage using scenePane object
        if(alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scenePane.getScene().getWindow();
            stage.close();
            System.out.println("Logged out successfully!");
        }
    }

}
