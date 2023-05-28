package com.example.javafxguicourse;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Scene1Controller implements Initializable {

   @FXML
    private Label myLabel;

   @FXML
    private ChoiceBox<String> myChoiceBox;

   private String[] food = {"Pizza", "Sushi", "Pilau"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myChoiceBox.getItems().addAll(food);
        myChoiceBox.setOnAction(this::getFood);
    }

    private void getFood(ActionEvent event) {
        try {
            String myFood = String.valueOf(myChoiceBox.getValue());
            myLabel.setText(myFood);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
