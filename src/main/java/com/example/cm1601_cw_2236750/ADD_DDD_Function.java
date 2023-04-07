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
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class ADD_DDD_Function {

    // Defining GUI elements from the java FXMl file
    @FXML
    private TextField addDriverName;
    @FXML
    private TextField addDriverAge;
    @FXML
    private TextField addDriverCarType;
    @FXML
    private TextField addDriverTeamName;
    @FXML
    private TextField addDriverCurrentPoints;
    @FXML
    private Label prompt;

    AlertErrors alert = new AlertErrors();

    // Called when the addDriver button is clicked
    public void addDriverData(){

        // prompt message is set
        prompt.setText("                        ");

        // variables initialised
        String driverName = "";
        String driverAge = "" ;
        String driverTeamName = "";
        String driverCarType = "";
        String driverCurrentPoints = "";

        // Validating that the fields are not empty, if empty, an error message is alerted
        try{
            if (addDriverName.getText().isEmpty() || addDriverAge.getText().isEmpty()
                    || addDriverTeamName.getText().isEmpty() || addDriverCarType.getText().isEmpty()
                    || addDriverCurrentPoints.getText().isEmpty()){
                throw new Exception();
            }
        }catch (Exception e){
            alert.errorAlert("Error","Error in Data Entry"
                    ,"Make sure all fields have been filled!");
        }

        // Validating the driver name, if there is an error, an error message is alerted and the field is cleared
        try{
            driverName = String.format("%-20s",addDriverName.getText());
            if (driverName.length() >20){
                throw new  Exception();}
            Driver driver = new Driver("Racing.txt",driverName);
            if(driver.driverExists()){
                throw new NullPointerException();
            }

        } catch(NullPointerException e){
            alert.errorAlert("Error","Error in Driver name"
                    ,"Driver already exists!");
            addDriverName.clear();
        }
        catch (Exception e){
            alert.errorAlert("Error","Error in Driver name"
                    ,"Make sure the driver's name length is within 20 letters!");
            addDriverName.clear();
        }

        // Validating the driver age, if there is an error, an error message is alerted and the field is cleared
        try{
            driverAge = String.format("%-4s", Integer.parseInt(addDriverAge.getText()));
            if (driverAge.length() >4){
                throw new  Exception();
            }
            if ((Integer.parseInt(driverAge.trim()) < 18) || (Integer.parseInt(driverAge.trim()) > 55)){
                throw new  Exception();
            }

        } catch (Exception e){
            alert.errorAlert("Error","Error in Driver age"
                    ,"Make sure the age is a number, and is between 18-55!");
            addDriverAge.clear();
        }

        // Validating the driver Team, if there is an error, an error message is alerted and the field is cleared
        try{
            driverTeamName = String.format("%-20s",addDriverTeamName.getText());
            if (driverTeamName.length() >20){
                throw new  Exception();}

        } catch (Exception e){
            alert.errorAlert("Error","Error in Driver's team name"
                    ,"Make sure the team name length is within 20 letters!");
            addDriverTeamName.clear();
        }

        // Validating the driver Car type, if there is an error, an error message is alerted and the field is cleared
        try{
            driverCarType = String.format("%-20s",addDriverCarType.getText());
            if (driverCarType.length() >20){
                throw new  Exception();}

        } catch (Exception e){
            alert.errorAlert("Error","Error in Driver's Car type"
                    ,"Make sure the car type length is within 20 letters!");
            addDriverCarType.clear();
        }

        // Validating the driver's points, if there is an error, an error message is alerted and the field is cleared
        try{
            driverCurrentPoints = String.format("%-15s",Integer.parseInt(addDriverCurrentPoints.getText()));
            if (driverCurrentPoints.length() >15){
                throw new  Exception();}

        } catch (Exception e){
            alert.errorAlert("Error","Error in Driver's current points"
                    ,"Make sure entered current points is a number!");
            addDriverCurrentPoints.clear();
        }

        // if none of the fields are empty, driver data is added.
        if (!addDriverName.getText().isEmpty() && !addDriverAge.getText().isEmpty()
                && !addDriverTeamName.getText().isEmpty() && !addDriverCarType.getText().isEmpty()
                && !addDriverCurrentPoints.getText().isEmpty()){

            // All the variables are concatenated and passed to a single variable
            // A CreateFile instance is initialised and the file name and data to be added is passed.
            // .createAndWrite() is called.
            String driverData = driverName + driverAge + driverTeamName + driverCarType + driverCurrentPoints;
            CreateFile Racing = new CreateFile("Racing.txt",driverData);
            Racing.createAndWrite();

            // prompt is set in the GUI
            prompt.setText("Driver added Successfully!");
            alert.infoAlert(   "Driver Added","Driver Details"
                    ,"Driver "+driverName.strip()+" aged "+driverAge.strip()+" of team "+driverTeamName.strip()
            +" driving a "+ driverCarType.strip()+ " with " + driverCurrentPoints.strip() +" points was added!");

            // All the text-fields are cleared.
            addDriverName.clear();
            addDriverAge.clear();
            addDriverTeamName.clear();
            addDriverCarType.clear();
            addDriverCurrentPoints.clear();

        }}

    // Defining GUI elements from the java FXMl file
    @FXML
    private Label promptDelete;
    @FXML
    private TextField driverToDelete;

    // called when delete driver button is clicked
    public void deleteADriver() throws IOException {

        // prompt is set
        promptDelete.setText("                        ");

        // variable initialised
        String driverNameDelete = "";

        // Validating that the field is not empty, if empty, an error message is alerted
        try{
            if (driverToDelete.getText().isEmpty()) {
                throw new IOException();
            }
        } catch (IOException e){
            alert.errorAlert("Error","Error in Driver name"
                    ,"Input Driver name!");
        }

        // Validating the driver name, if there is an error, an error message is alerted and the field is cleared
        try {

            driverNameDelete = String.format("%-20s", driverToDelete.getText());
            if (driverNameDelete.length() > 20) {
                throw new Exception();
            }
            Driver driverDelete = new Driver("Racing.txt", driverNameDelete);
            if (!driverDelete.driverExists()) {
                throw new NullPointerException();
            }
        }
        catch(NullPointerException e){
            alert.errorAlert("Error","Error in Driver name"
                    ,"Driver doesn't exist!");
            driverToDelete.clear();
        }
        catch (Exception e){
            alert.errorAlert("Error","Error in Driver name"
                    ,"Make sure the driver's name length is within 20 letters!");
            driverToDelete.clear();
        }

        // if fields are not empty, data is updated and the field is cleared.
        if (!driverToDelete.getText().isEmpty()){
            Driver deleteADriver = new Driver("Racing.txt",driverNameDelete);
            deleteADriver.deleteDriver();
            promptDelete.setText("Driver deleted!");
            driverToDelete.clear();
            deleteTableDisplay();
        }
    }

    @FXML
    protected void mainScene(ActionEvent actionEvent) throws Exception{
//        mainController.navigateFunction(actionEvent, "mainApplication-view.fxml", "World Rally Cross Application");
        navigateFunction(actionEvent);
    }
    public void navigateFunction(ActionEvent actionEvent) throws IOException {
        // Identifying and closing the previous stage
        Stage previousStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        previousStage.close();

        // Opening a new stage
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("racing.fxml")));
        stage.setScene(new Scene(root,620,500));
        stage.setTitle("World rally cross championship management system");
        stage.show();
    }

    // Defining GUI elements from the java FXMl file
    @FXML
    private TableColumn<DriverTable, String> driverAge;
    @FXML
    private TableColumn<DriverTable, String> driverCar;
    @FXML
    private TableView<DriverTable> driverDeleteTable;
    @FXML
    private TableColumn<DriverTable, String> driverName;
    @FXML
    private TableColumn<DriverTable, String> driverPoints;
    @FXML
    private TableColumn<DriverTable, String> driverTeam;
    @FXML
    private Button displayTableDelete;

    // Used to display driver details, in delete driver scene
    public void deleteTableDisplay() throws IOException {

        // Using an observableList to display the data
        ObservableList<DriverTable> list = FXCollections.observableArrayList();

        // Reading a file line by line, adding data to a list and passing to the observableList
        BufferedReader userFile = new BufferedReader(new FileReader("Racing.txt"));
        String line = userFile.readLine();
        while (line != null){
            String [] driverData = {line.substring(0,20),line.substring(20,24),line.substring(24,44),
                    line.substring(44,64),line.substring(64,79)};
            list.add(new DriverTable(driverData[0],driverData[1],driverData[2],driverData[3],driverData[4]));
            line = userFile.readLine();
        }
        userFile.close();

        // columns in table-view
        driverName.setCellValueFactory(new PropertyValueFactory<DriverTable,String>("driverName"));
        driverAge.setCellValueFactory(new PropertyValueFactory<DriverTable,String>("driverAge"));
        driverTeam.setCellValueFactory(new PropertyValueFactory<DriverTable,String>("driverTeam"));
        driverCar.setCellValueFactory(new PropertyValueFactory<DriverTable,String>("driverCar"));
        driverPoints.setCellValueFactory(new PropertyValueFactory<DriverTable,String>("driverPoints"));

        driverDeleteTable.setItems(list);
        displayTableDelete.setDisable(true);

    }

    // Closing Program
    public void closeProgram(ActionEvent event) {
        System.exit(0);
    }
}