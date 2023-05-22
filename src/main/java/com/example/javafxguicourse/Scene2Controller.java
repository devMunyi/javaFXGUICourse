package com.example.javafxguicourse;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Scene2Controller {

    @FXML
    private Label nameDisplay;

    public void displayName(String name){
        nameDisplay.setText(name);
    }
}
