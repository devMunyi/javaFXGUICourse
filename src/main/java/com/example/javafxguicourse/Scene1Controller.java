package com.example.javafxguicourse;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
