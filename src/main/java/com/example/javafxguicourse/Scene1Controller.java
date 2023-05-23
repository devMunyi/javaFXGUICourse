package com.example.javafxguicourse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Scene1Controller {
    @FXML
    ImageView myImageView;
    @FXML
    Button toggleImageBtn;

    Image image1 = new Image(getClass().getResourceAsStream("demo_1.jpg"));
    Image image2 = new Image(getClass().getResourceAsStream("demo_2.jpg"));
    boolean isImage1Visible = true;
    public void toggleImage(){
        if(isImage1Visible){
            myImageView.setImage(image2);
            isImage1Visible = false;
        }else {
            myImageView.setImage(image1);
            isImage1Visible = true;
        }
    }

}
