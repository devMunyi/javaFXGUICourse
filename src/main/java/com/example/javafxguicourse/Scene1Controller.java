package com.example.javafxguicourse;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

public class Scene1Controller implements Initializable {
    @FXML
    private Label myLabel;

    @FXML
    private ListView<String> myListView;

    private String[] food = {"Pilau", "Sushi", "Pizza"};


    private String currentFood;

    public void getFood(ActionEvent event){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myListView.getItems().addAll(food);
        // changeSelectedFood();

        // add listener to update label text on selection change
        myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                changeSelectedFood();
            }
        });

    }

    public void changeSelectedFood(){
        currentFood = myListView.getSelectionModel().getSelectedItem();
        myLabel.setText(currentFood);
    }
}
