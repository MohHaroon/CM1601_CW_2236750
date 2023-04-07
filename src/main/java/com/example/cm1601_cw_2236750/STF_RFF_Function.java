package com.example.cm1601_cw_2236750;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class STF_RFF_Function {
    // Defining GUI elements from the java FXMl file
    @FXML
    private TextField userFileName;
    @FXML
    private Label promptSTF;
    @FXML
    private TextField fileToDisplay;

    AlertErrors errorAlert = new AlertErrors();

    // Called when save file button is clicked
    public void saveFile(){

        // variable initialised
        String fileName = "";

        // Validating that the field file name is not empty, if empty, an error message is alerted
        try{
            if (userFileName.getText().isEmpty()) {
                throw new IOException();
            }
            fileName = userFileName.getText() + ".txt";
        } catch (IOException e){
            errorAlert.errorAlert("Error","Error in File name"
                    ,"Enter a name!");
        }

        // if fields is not empty, data is saved to file and text field is cleared
        if (!userFileName.getText().isEmpty()){
            promptSTF.setText("Data saved to File!");
            userFileName.clear();

            // Creating instance
            CreateFile saveFile = new CreateFile(fileName,"");

            // .saveToFile used
            saveFile.saveToFile();
        }

    }

    // Defining GUI elements from the java FXMl file
    @FXML
    private TableColumn<DriverTable, String> dAge;
    @FXML
    private TableColumn<DriverTable, String> dCar;
    @FXML
    private TableColumn<DriverTable, String> dName;
    @FXML
    private TableColumn<DriverTable, String> dPoints;
    @FXML
    private TableColumn<DriverTable, String> dTeam;
    @FXML
    private TableView<DriverTable> fileTable;

    // called when display file button s clicked
    public void displayFileData() throws IOException {

        // variables initialised
        String fileName = "";

        // Validating the file name, if there is an error, an error message is alerted and the field is cleared
        try{
            if (fileToDisplay.getText().isEmpty()) {
                throw new FileNotFoundException();
            }

            fileName = fileToDisplay.getText() + ".txt";
            DriverTableDisplay checkForFile = new DriverTableDisplay(fileName);
            String checkFile = checkForFile.driverSort();

        } catch (Exception e){
            fileToDisplay.clear();
            errorAlert.errorAlert("Error","Error in File name"
                    ,"Enter a name; of a file that exists!");
        }

        // if text field is not empty, data is displayed.
        if (!fileToDisplay.getText().isEmpty()) {

            ObservableList<DriverTable> list = FXCollections.observableArrayList();

            BufferedReader userFile = new BufferedReader(new FileReader(fileName));
            String line = userFile.readLine();
            while (line != null){
                String [] driverData = {line.substring(0,20),line.substring(20,24),line.substring(24,44)
                        ,line.substring(44,64),line.substring(64,79)};
                list.add(new DriverTable(driverData[0],driverData[1],driverData[2],driverData[3],driverData[4]));
                line = userFile.readLine();
            }
            userFile.close();

            dName.setCellValueFactory(new PropertyValueFactory<DriverTable,String>("driverName"));
            dAge.setCellValueFactory(new PropertyValueFactory<DriverTable,String>("driverAge"));
            dTeam.setCellValueFactory(new PropertyValueFactory<DriverTable,String>("driverTeam"));
            dCar.setCellValueFactory(new PropertyValueFactory<DriverTable,String>("driverCar"));
            dPoints.setCellValueFactory(new PropertyValueFactory<DriverTable,String>("driverPoints"));

            fileTable.setItems(list);
        }
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

    public void navigateFunctionFileDisplay(ActionEvent actionEvent, String fileFXML) throws IOException {
        // Identifying and closing the previous stage
        Stage previousStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        previousStage.close();

        // Opening a new stage
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fileFXML)));
        stage.setScene(new Scene(root,620,570));
        stage.setTitle("World rally cross championship management system");
        stage.show();
    }

    // Loading updateDriver.fxml file
    @FXML
    protected void updateDriver(ActionEvent actionEvent) throws Exception{
        navigateFunction(actionEvent,"updateDriver.fxml");
    }

    // Loading racing.fxml file
    @FXML
    protected void mainScene(ActionEvent actionEvent) throws Exception{
        navigateFunction(actionEvent,"racing.fxml");
    }

    // Loading displayFileScene.fxml file
    @FXML
    protected void displayFile(ActionEvent actionEvent) throws Exception{
        navigateFunctionFileDisplay(actionEvent,"displayFileScene.fxml");
    }

    // Closing Program
    public void closeProgram(ActionEvent event) {
        System.exit(0);
    }
}