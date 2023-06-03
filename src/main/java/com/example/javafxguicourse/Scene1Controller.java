package com.example.javafxguicourse;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Scene1Controller implements Initializable {

    @FXML
    private ImageView imageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //translate
        /*

        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(imageView);
        translateTransition.setDuration(Duration.millis(1000));
        translateTransition.setCycleCount(Animation.INDEFINITE);
        translateTransition.setAutoReverse(true);
        // translateTransition.interpolate(50);
        translateTransition.setByX(250);
        translateTransition.play();

         */

        // rotate
        /*
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setNode(imageView);
        rotateTransition.setCycleCount(Animation.INDEFINITE);
        rotateTransition.setDuration(Duration.millis(1000));
        rotateTransition.setByAngle(360);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.setAxis(Rotate.Y_AXIS); // others: X_AXIS, Z_AXIS(default)
        rotateTransition.play();

        */

        // fade
        /*
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(imageView);
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setCycleCount(Animation.INDEFINITE);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();

         */

        // scale
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setNode(imageView);
        scaleTransition.setDuration(Duration.millis(1000));
        scaleTransition.setCycleCount(Animation.INDEFINITE);
        scaleTransition.setAutoReverse(true);
        scaleTransition.setByX(2.0);
        scaleTransition.setByY(2.0);
//        scaleTransition.setFromX(1);
//        scaleTransition.setToX(2);
//        scaleTransition.setFromY(1);
//        scaleTransition.setToY(2);
//        scaleTransition.setFromZ(1);
//        scaleTransition.setToZ(2);
        scaleTransition.play();
    }
}
