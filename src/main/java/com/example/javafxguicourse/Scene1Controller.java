package com.example.javafxguicourse;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Scene1Controller {

    @FXML
    private AnchorPane myAnchorPane;
    @FXML
    private ColorPicker myColorPicker;

    public void changeColor(ActionEvent event){
        try {
            Color myColor = myColorPicker.getValue();
            myAnchorPane.setBackground(new Background(new BackgroundFill(myColor, null,null)));
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
