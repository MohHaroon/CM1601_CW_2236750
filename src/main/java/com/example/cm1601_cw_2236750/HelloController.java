package com.example.cm1601_cw_2236750;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController{
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void mainScene(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("racing.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addDriver(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("addDriver.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}