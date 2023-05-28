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
    private Button exitBtn;

    @FXML
    private Label myLabel;

    @FXML
    private ImageView myImageView;

    @FXML
    private CheckBox myCheckBox;

    Image image1 = new Image(getClass().getResourceAsStream("pic_bulboff.gif"));
    Image image2 = new Image(getClass().getResourceAsStream("pic_bulbon.gif"));
    public void change(ActionEvent event){

        try {
            if(myCheckBox.isSelected()){
                myLabel.setText("ON");
                myImageView.setImage(image2);
            }else{
                myLabel.setText("OFF");
                myImageView.setImage(image1);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void closeApp(ActionEvent event){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit App");
        alert.setHeaderText("You Are About to Close App");
        alert.setContentText("Do you want to save changes before exiting?");

        // Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        // or access stage using exitBtn
        Stage stage = (Stage) exitBtn.getScene().getWindow();

        if(alert.showAndWait().get() == ButtonType.OK){
            stage.close();
        }

    }

}
