package com.example.javafxguicourse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

public class MainAppController {

    @FXML
    private Circle myCircle;
    private double x;
    private double y;

    public void up(ActionEvent event) {
        myCircle.setCenterY(y-=1);
    }

    public void down(ActionEvent event) {
        // System.out.println("CLICKED DOWN BUTTON");
        myCircle.setCenterY(y+=1);
    }

    public void right(ActionEvent event) {
        myCircle.setCenterX(x-=1);
    }

    public void left(ActionEvent event) {
        myCircle.setCenterX(x+=1);
    }

}
