package com.example.cm1601_cw_2236750;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class VCT_Function {

    // Defining GUI elements from the java FXMl file
    @FXML
    private TextArea position;
    @FXML
    private Button standingDisplay;
    @FXML
    private Label racesPrompt;

    // Called when displayPositions button is clicked
    public void displayPositions(){

        // Data is appended to the text area and, the display button is disabled
        position.appendText("Driver | Age | Team Name | Car Type | Current Points\n");
        DriverTableDisplay table = new DriverTableDisplay("Racing.txt");
        position.appendText(table.driverSort());
        position.setWrapText(true);
        standingDisplay.setDisable(true);
    }

    public void navigateFunction(ActionEvent actionEvent, String fileFXML) throws IOException {
        // Identifying and closing the previous stage
        Stage previousStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        previousStage.close();

        // Opening a new stage
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fileFXML)));
        stage.setScene(new Scene(root,620,500));
        stage.setTitle("World rally cross championship management system");
        stage.show();
    }

    // Loading racing.fxml file
    @FXML
    protected void mainScene(ActionEvent actionEvent) throws Exception{
        navigateFunction(actionEvent,"racing.fxml");
    }

    // Loading saveToFile.fxml file
    @FXML
    protected void saveToFile(ActionEvent actionEvent) throws Exception{
        navigateFunction(actionEvent,"saveToFile.fxml");
    }

    // Closing Program
    public void closeProgram(ActionEvent event) {
        System.exit(0);
    }
}
