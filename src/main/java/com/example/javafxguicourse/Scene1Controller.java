package com.example.javafxguicourse;

import javafx.scene.media.*;;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Scene1Controller implements Initializable {

    @FXML
    private MediaView mediaView;
    @FXML
    private Button playBtn, pauseBtn, resetBtn;

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // mediaView.setMediaPlayer(new MediaPlayer(new File("video.mp4")));

        try {
            // readlink -f video.mp4 (is the command to get full file pah in linux on cmd)
            file = new File("/home/samuel/Public/Java/JavaFX/javaFXGUICourse/src/main/java/com/example/javafxguicourse/video.mp4");
            media = new Media(file.toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public void playMedia() {
        mediaPlayer.play();
    }

    public void pauseMedia() {
        mediaPlayer.pause();
    }

    public void resetMedia() {
        mediaPlayer.seek(Duration.seconds(0.0));
    }
}