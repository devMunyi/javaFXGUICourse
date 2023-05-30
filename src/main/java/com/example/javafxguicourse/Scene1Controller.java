package com.example.javafxguicourse;

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
    private ProgressBar myProgressBar;

    @FXML
    private Button myBtn;

    // double progress;

    BigDecimal progress = new BigDecimal(String.format("%.2f", 0.0));
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myProgressBar.setStyle("-fx-accent: #00FF00");
    }

    public void increaseProgress(ActionEvent event){

        try {
            if(progress.doubleValue() < 1){
                progress = new BigDecimal(String.format("%.2f", progress.doubleValue() + 0.1));
                myProgressBar.setProgress(progress.doubleValue());
                System.out.println(progress);
                String myProgress = Integer.toString((int)Math.round((progress.doubleValue()) * 100)) + "%";
                myLabel.setText(myProgress);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
