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

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Scene1Controller implements Initializable {

    @FXML
    private Label myLabel;

    @FXML
    private Slider mySlider;

    int myTemperature;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myTemperature = (int)(mySlider.getValue());
        myLabel.setText(String.valueOf(myTemperature) + "°C");

        mySlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                myTemperature = (int) mySlider.getValue();
                myLabel.setText(String.valueOf(myTemperature) + "°C");
            }
        });
    }
}
