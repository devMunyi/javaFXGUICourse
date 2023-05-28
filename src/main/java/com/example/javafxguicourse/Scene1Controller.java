package com.example.javafxguicourse;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Scene1Controller {
    @FXML
    private Label myLabel;
    @FXML
    private RadioButton rBtn1, rBtn2, rBtn3;

    public void getFood(ActionEvent event){
        try {
            if(rBtn1.isSelected()){
                myLabel.setText(rBtn1.getText());
            }else if(rBtn2.isSelected()){
                myLabel.setText(rBtn2.getText());
            }else if(rBtn3.isSelected()){
                myLabel.setText(rBtn3.getText());
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
