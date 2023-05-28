package com.example.javafxguicourse;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Scene1Controller {

    @FXML
    private DatePicker myDatePicker;

    @FXML
    private Label myLabel;
    public void getDate(ActionEvent event){
        try {
            LocalDate myDate = myDatePicker.getValue();
            //myLabel.setText(myDate.toString()); // output => 2023-05-28 (usually default format)

            // formatting date
            // String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
            // myLabel.setText(myFormattedDate); // output => 05-28-2023

            String myFormattedDate2 = myDate.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy"));
            myLabel.setText(myFormattedDate2); // output => May-28-2023

        }catch (Exception e){
            System.out.println(e);
        }
    }

}
