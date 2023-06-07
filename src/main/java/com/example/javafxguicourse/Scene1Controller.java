package com.example.javafxguicourse;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Scene1Controller implements Initializable {
    @FXML
    private Label musicLabel;
    @FXML
    private ProgressBar musicProgressBar;
    @FXML
    private Button playBtn, pauseBtn, resetBtn, previousBtn, nextBtn;
    @FXML
    private ComboBox<String> speedComboBox;
    @FXML
    private Slider volumeSlider;

    private Media media;
    private MediaPlayer mediaPlayer;

    private File directory;
    private File[] files;
    private ArrayList<File> songs;

    private int songNumber;
    private int[] speeds = { 25, 50, 75, 100, 125, 150, 175, 200 };

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        songs = new ArrayList<File>();
        directory = new File("/home/samuel/Public/Java/JavaFX/javaFXGUICourse/src/main/resources/com/example/javafxguicourse/music/");
        files = directory.listFiles();

        if(files != null){
            for (File file : files){
                System.out.println(file);
                songs.add(file);
            }
        }

        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        musicLabel.setText(songs.get(songNumber).getName());

        for(int i = 0; i < speeds.length; i++){
            speedComboBox.getItems().add(Integer.toString(speeds[i]) + "%");
        }

        speedComboBox.setOnAction(this::changeSpeed);
        volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
            }
        });
    }

    public void playMedia(){

        mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
        mediaPlayer.play();
    }

    public void pauseMedia(){
        mediaPlayer.pause();
    }

    public void resetMedia(){
        mediaPlayer.seek(Duration.seconds(0.0));
    }

    public void nextMedia(){

        try {
            if(songNumber < songs.size() - 1){
                songNumber++;
            }else {
                songNumber = 0;
            }
            mediaPlayer.stop();
            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            musicLabel.setText(songs.get(songNumber).getName());
            playMedia();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void previousMedia(){
        try {
            if(songNumber > 0){
                songNumber--;
            }else{
                songNumber = songs.size() - 1;
            }

            mediaPlayer.stop();
            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            musicLabel.setText(songs.get(songNumber).getName());
            playMedia();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void changeSpeed(ActionEvent event){
        mediaPlayer.setRate(Integer.parseInt(speedComboBox.getValue().substring(0, speedComboBox.getValue().length() - 1)) * 0.01);
    }

    public void beginTimer(){

    }

    public void cancelTimer(){

    }

    public String musicName(String filePath) {
        try {
            File file = new File(filePath);
            String basename = file.getName();
            return basename;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}