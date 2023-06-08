package com.example.javafxguicourse;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
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
import java.util.Timer;
import java.util.TimerTask;

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
    private Timer timer;
    private TimerTask task;
    private boolean running = false;

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

        // set onAction Event method to ComboBox to handle selected music speed
        speedComboBox.setOnAction(this::changeSpeed);

        // add listener to volume increase or decrease
        volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
            }
        });
        musicProgressBar.setStyle("-fx-accent: #00FF00");
    }

    public void playMedia(){
        try {
            beginTimer();
            mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
            mediaPlayer.play();
            changeSpeed(null);
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public void pauseMedia(){
        try {
            cancelTimer();
            mediaPlayer.pause();
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void resetMedia(){
        try {
            mediaPlayer.seek(Duration.seconds(0.0));
            musicProgressBar.setProgress(0);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void nextMedia(){

        try {
            if(songNumber < songs.size() - 1){
                songNumber++;
            }else {
                songNumber = 0;
            }

            if(running){
                cancelTimer();
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

            if(running){
                cancelTimer();
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
        try {
            String comboBoxValue = speedComboBox.getValue();
            if(comboBoxValue == null){
                // set default
                mediaPlayer.setRate(1);
            }else{
                // set value selected from ComboBox
                mediaPlayer.setRate(Integer.parseInt(comboBoxValue.substring(0, comboBoxValue.length() - 1)) * 0.01);
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void beginTimer(){
        timer = new Timer();
        task = new TimerTask() {
            public void run(){
                running = true;
                double currentPlayTimeSec = mediaPlayer.getCurrentTime().toSeconds();
                double endOfPlayTimeSec = media.getDuration().toSeconds();
                System.out.println(currentPlayTimeSec/endOfPlayTimeSec);
                musicProgressBar.setProgress(currentPlayTimeSec/endOfPlayTimeSec);

                if(currentPlayTimeSec/endOfPlayTimeSec == 1){
                    // song has reached the end of play duration
                    cancelTimer();
                    playMedia();
                }
            }
        };

        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    public void cancelTimer(){
        running = false;
        timer.cancel();
    }
}