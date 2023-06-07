package com.example.javafxguicourse;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class Scene1Controller implements Initializable {

    @FXML
    private WebView webView;
    @FXML
    private Button loadBtn, refreshBtn;

    @FXML
    private TextField textField;

    private WebEngine webEngine;
    private String homePage;

    private double zoomWeb = 1;
    private WebHistory webHistory;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
             webEngine = webView.getEngine();
             homePage = "https://www.google.com";
             webEngine.load(homePage);
             loadPage();
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public void loadPage(){
        try {
            String urlInput = textField.getText().trim();
            if(!urlInput.isEmpty()){ // isEmpty returns false if string only has whitespace while isBlank returns true
                webEngine.load("https://"+urlInput);
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void refreshPage(){
        try {
            webEngine.reload();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void zoomIn(){
        zoomWeb += 0.25;
        webView.setZoom(zoomWeb);
    }

    public void zoomOut(){
        zoomWeb -= 0.25;
        webView.setZoom(zoomWeb);
    }

    public void displayHistory(){
        webHistory = webEngine.getHistory();
        ObservableList<WebHistory.Entry> entries = webHistory.getEntries();

        for(WebHistory.Entry entry : entries){
            // System.out.println(entry);
            System.out.println("URL: "+entry.getUrl() + " Last Visited: " + entry.getLastVisitedDate());
        }
    }


    public void goBack(){
        try {
            webHistory = webEngine.getHistory();
            ObservableList<WebHistory.Entry> entries = webHistory.getEntries();
            webHistory.go(-1);
            textField.setText(entries.get(webHistory.getCurrentIndex()).getUrl());
        }catch (IndexOutOfBoundsException e){
            System.out.println("Error: "+ e);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void goForward(){
        try {
            webHistory = webEngine.getHistory();
            ObservableList<WebHistory.Entry> entries = webHistory.getEntries();
            webHistory.go(1);
            textField.setText(entries.get(webHistory.getCurrentIndex()).getUrl());
        }catch (IndexOutOfBoundsException e){
            System.out.println("Error: "+ e);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void executeJS(){
        try {
            String urlInput = "https://www.youtube.com";
            webEngine.executeScript("window.location=\""+urlInput+"\"");
            webHistory = webEngine.getHistory();
            ObservableList<WebHistory.Entry> entries = webHistory.getEntries();
            textField.setText(urlInput);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}