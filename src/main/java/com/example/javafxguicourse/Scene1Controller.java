package com.example.javafxguicourse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;


public class Scene1Controller {

    @FXML
    private Button submitBtn;

    @FXML
    private Label myLabel;

    @FXML
    private TextField ageTextField;

    private Integer age;

    private Boolean error = false;

    public void submit(ActionEvent event){

        String ageInput = ageTextField.getText().trim();
        if (ageInput.isEmpty()) {
            error = true;
            textFillRed(myLabel);
            myLabel.setText("Please enter your age");
            return;
        }

        try {

            age = Integer.parseInt(ageInput);

            if (age >= 18) {
                myLabel.setText(age + " years old. You're welcome!");
                error = false;
            } else {
                myLabel.setText(age + " years old. You're under age!");
                error = true;
            }

        }catch (NumberFormatException e){
            myLabel.setText("Invalid age input");
            error = true;
            System.out.println("Invalid age input");
        }catch(Exception e){
            myLabel.setText(String.valueOf(e));
            error = true;
            System.out.println(e);
        }finally {
            if(error) {
                textFillRed(myLabel);
            }else {
                textFillGreen(myLabel);
            }
        }
    }

    public void textFillRed(Label label){
        label.setTextFill(Color.RED);
    }

    public void textFillGreen(Label label){
        label.setTextFill(Color.GREEN);
    }
}
