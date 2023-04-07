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

public class UDD_Function {

    // Defining GUI elements from the java FXMl file
    @FXML
    private TextField newData;
    @FXML
    private TextField driverToUpdate;
    @FXML
    private Label promptUpdate;

    AlertErrors errorAlert = new AlertErrors();

    // Called when the update driver name is clicked
    public void updateDriverName() throws IOException {

        // prompt is set
        promptUpdate.setText("                        ");

        // Variables initialised
        String driverNameUpdate = "";
        String newDriverName = "";

        // Validating that the fields are not empty, if empty, an error message is alerted
        try{
            if (newData.getText().isEmpty() || driverToUpdate.getText().isEmpty()){
                throw new Exception();
            }
        }catch (Exception e){
            errorAlert.errorAlert("Error","Error in Data Entry"
                    ,"Make sure all fields have been filled!");
        }

        // Validating the driver name, if there is an error, an error message is alerted and the field is cleared
        try{
            driverNameUpdate = String.format("%-20s",driverToUpdate.getText());
            if (driverNameUpdate.length() >20){
                throw new  Exception();}
            Driver driverUpdate = new Driver("Racing.txt",driverNameUpdate);
            if(!driverUpdate.driverExists()){
                throw new NullPointerException();
            }

        } catch(NullPointerException e){
            errorAlert.errorAlert("Error","Error in Driver name"
                    ,"Driver doesn't exist!");
            driverToUpdate.clear();
        }
        catch (Exception e){
            errorAlert.errorAlert("Error","Error in Driver name"
                    ,"Make sure the driver's name length is within 20 letters!");
            driverToUpdate.clear();
        }

        // Validating the new name, if there is an error, an error message is alerted and the field is cleared
        try{
            newDriverName = String.format("%-20s",newData.getText());
            if (newDriverName.length() >20){
                throw new  Exception();}
            Driver driverUpdate = new Driver("Racing.txt",newDriverName);
            if(driverUpdate.driverExists()){
                throw new NullPointerException();
            }

        } catch(NullPointerException e){
            errorAlert.errorAlert("Error","Error in Driver name"
                    ,"Driver already exists!");
            newData.clear();
        }
        catch (Exception e){
            errorAlert.errorAlert("Error","Error in Driver name"
                    ,"Make sure the driver's name length is within 20 letters!");
            newData.clear();
        }

        // if fields are not empty, driver name is updated.
        if (!newData.getText().isEmpty() && !driverToUpdate.getText().isEmpty()){
            Driver driverUpdate = new Driver("Racing.txt",newDriverName);
            driverUpdate.updateDriverData("driverNameUpdate",newDriverName,driverNameUpdate);
            promptUpdate.setText("Driver updated Successfully!");
            newData.clear();
            driverToUpdate.clear();
            updateDriverTable();
        }
    }

    // Called when driver age needs to be updated
    public void updateDriverAge() throws IOException {

        // prompt is set
        promptUpdate.setText("                        ");

        // variables initialised
        String driverNameUpdate = "";
        String newDriverAge = "";

        // Validating that the fields are not empty, if empty, an error message is alerted
        try{
            if (newData.getText().isEmpty() || driverToUpdate.getText().isEmpty()){
                throw new Exception();
            }
        }catch (Exception e){
            errorAlert.errorAlert("Error","Error in Data Entry"
                    ,"Make sure all fields have been filled!");
        }

        // Validating the driver name, if there is an error, an error message is alerted and the field is cleared
        try{
            driverNameUpdate = String.format("%-20s",driverToUpdate.getText());
            if (driverNameUpdate.length() >20){
                throw new  Exception();}
            Driver driverUpdate = new Driver("Racing.txt",driverNameUpdate);
            if(!driverUpdate.driverExists()){
                throw new NullPointerException();
            }

        } catch(NullPointerException e){
            errorAlert.errorAlert("Error","Error in Driver name"
                    ,"Driver doesn't exist!");
            driverToUpdate.clear();
        }
        catch (Exception e){
            errorAlert.errorAlert("Error","Error in Driver name"
                    ,"Make sure the driver's name length is within 20 letters!");
            driverToUpdate.clear();
        }

        // Validating the driver age, if there is an error, an error message is alerted and the field is cleared
        try{
            newDriverAge = String.format("%-4s", Integer.parseInt(newData.getText()));
            if (newDriverAge.length() >4){
                throw new  Exception();
            }
            if ((Integer.parseInt(newDriverAge.trim()) < 18) || (Integer.parseInt(newDriverAge.trim()) > 55)){
                throw new  Exception();
            }

        } catch (Exception e){
            errorAlert.errorAlert("Error","Error in Driver age"
                    ,"Make sure the age is a number, and is between 18-55!");
            newData.clear();

        }

        // if fields are not empty, data is updated and the fields are cleared.
        if (!newData.getText().isEmpty() && !driverToUpdate.getText().isEmpty()){
            Driver driverUpdate = new Driver("Racing.txt",newDriverAge);
            driverUpdate.updateDriverData("driverAgeUpdate",newDriverAge,driverNameUpdate);
            promptUpdate.setText("Driver updated Successfully!");
            newData.clear();
            driverToUpdate.clear();
            updateDriverTable();
        }
    }

    // Called when driver age needs to be updated
    public void updateTeamName() throws IOException {

        // prompt is set
        promptUpdate.setText("                        ");

        // variables initialised
        String driverNameUpdate = "";
        String newDriverTeamName = "";

        // Validating that the fields are not empty, if empty, an error message is alerted
        try{
            if (newData.getText().isEmpty() || driverToUpdate.getText().isEmpty()){
                throw new Exception();
            }
        }catch (Exception e){
            errorAlert.errorAlert("Error","Error in Data Entry"
                    ,"Make sure all fields have been filled!");
        }

        // Validating the driver name, if there is an error, an error message is alerted and the field is cleared
        try{
            driverNameUpdate = String.format("%-20s",driverToUpdate.getText());
            if (driverNameUpdate.length() >20){
                throw new  Exception();}
            Driver driverUpdate = new Driver("Racing.txt",driverNameUpdate);
            if(!driverUpdate.driverExists()){
                throw new NullPointerException();
            }

        } catch(NullPointerException e){
            errorAlert.errorAlert("Error","Error in Driver name"
                    ,"Driver doesn't exist!");
            driverToUpdate.clear();
        }
        catch (Exception e){
            errorAlert.errorAlert("Error","Error in Driver name"
                    ,"Make sure the driver's name length is within 20 letters!");
            driverToUpdate.clear();
        }

        // Validating the new team name, if there is an error, an error message is alerted and the field is cleared
        try{
            newDriverTeamName = String.format("%-20s",newData.getText());
            if (newDriverTeamName.length() >20){
                throw new  Exception();}

        } catch (Exception e){
            errorAlert.errorAlert("Error","Error in Driver's team name"
                    ,"Make sure the team name length is within 20 letters!");
            newData.clear();

        }

        // if fields are not empty, data is updated and the fields are cleared.
        if (!newData.getText().isEmpty() && !driverToUpdate.getText().isEmpty()){
            Driver driverUpdate = new Driver("Racing.txt",newDriverTeamName);
            driverUpdate.updateDriverData("driverTeamNameUpdate",newDriverTeamName,driverNameUpdate);
            promptUpdate.setText("Driver updated Successfully!");
            newData.clear();
            driverToUpdate.clear();
            updateDriverTable();
        }

    }
    public void updateCarType() throws IOException {

        // prompt is set
        promptUpdate.setText("                        ");

        // variables initialised
        String driverNameUpdate = "";
        String newCarType = "";

        // Validating that the fields are not empty, if empty, an error message is alerted
        try{
            if (newData.getText().isEmpty() || driverToUpdate.getText().isEmpty()){
                throw new Exception();
            }
        }catch (Exception e){
            errorAlert.errorAlert("Error","Error in Data Entry"
                    ,"Make sure all fields have been filled!");
        }

        // Validating the driver name, if there is an error, an error message is alerted and the field is cleared
        try{
            driverNameUpdate = String.format("%-20s",driverToUpdate.getText());
            if (driverNameUpdate.length() >20){
                throw new  Exception();}
            Driver driverUpdate = new Driver("Racing.txt",driverNameUpdate);
            if(!driverUpdate.driverExists()){
                throw new NullPointerException();
            }

        } catch(NullPointerException e){
            errorAlert.errorAlert("Error","Error in Driver name"
                    ,"Driver doesn't exist!");
            driverToUpdate.clear();
        }
        catch (Exception e){
            errorAlert.errorAlert("Error","Error in Driver name"
                    ,"Make sure the driver's name length is within 20 letters!");
            driverToUpdate.clear();
        }

        // Validating the new car type, if there is an error, an error message is alerted and the field is cleared
        try{
            newCarType = String.format("%-20s",newData.getText());
            if (newCarType.length() >20){
                throw new  Exception();}

        } catch (Exception e){
            errorAlert.errorAlert("Error","Error in Driver's Car type"
                    ,"Make sure the car type length is within 20 letters!");
            newData.clear();

        }

        // if fields are not empty, data is updated and the fields are cleared.
        if (!newData.getText().isEmpty() && !driverToUpdate.getText().isEmpty()){
            Driver driverUpdate = new Driver("Racing.txt",newCarType);
            driverUpdate.updateDriverData("driverCarTypeUpdate",newCarType,driverNameUpdate);
            promptUpdate.setText("Driver updated Successfully!");
            newData.clear();
            driverToUpdate.clear();
            updateDriverTable();
        }
    }
    public void updateCurrentPoints() throws IOException {

        // prompt is set
        promptUpdate.setText("                        ");

        // variables initialised
        String driverNameUpdate = "";
        String newCurrentPoints = "";

        // Validating that the fields are not empty, if empty, an error message is alerted
        try{
            if (newData.getText().isEmpty() || driverToUpdate.getText().isEmpty()){
                throw new Exception();
            }
        }catch (Exception e){
            errorAlert.errorAlert("Error","Error in Data Entry"
                    ,"Make sure all fields have been filled!");
        }

        // Validating the driver name, if there is an error, an error message is alerted and the field is cleared
        try{
            driverNameUpdate = String.format("%-20s",driverToUpdate.getText());
            if (driverNameUpdate.length() >20){
                throw new  Exception();}
            Driver driverUpdate = new Driver("Racing.txt",driverNameUpdate);
            if(!driverUpdate.driverExists()){
                throw new NullPointerException();
            }

        } catch(NullPointerException e){
            errorAlert.errorAlert("Error","Error in Driver name"
                    ,"Driver doesn't exist!");
            driverToUpdate.clear();
        }
        catch (Exception e){
            errorAlert.errorAlert("Error","Error in Driver name"
                    ,"Make sure the driver's name length is within 20 letters!");
            driverToUpdate.clear();
        }

        // Validating the new driver points, if there is an error, an error message is alerted and the field is cleared
        try{
            newCurrentPoints = String.format("%-15s",Integer.parseInt(newData.getText()));
            if (newCurrentPoints.length() >15){
                throw new  Exception();}

        } catch (Exception e){
            errorAlert.errorAlert("Error","Error in Driver's current points"
                    ,"Make sure entered current points is a number!");
            newData.clear();
        }

        // if fields are not empty, data is updated and the fields are cleared.
        if (!newData.getText().isEmpty() && !driverToUpdate.getText().isEmpty()){
            Driver driverUpdate = new Driver("Racing.txt",newCurrentPoints);
            driverUpdate.updateDriverData("driverCurrentPointsUpdate",newCurrentPoints,driverNameUpdate);
            promptUpdate.setText("Driver updated Successfully!");
            newData.clear();
            driverToUpdate.clear();
            updateDriverTable();
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

    @FXML
    private TableColumn<DriverTable, String > driverUpdateAge;

    @FXML
    private TableColumn<DriverTable, String> driverUpdateCar;

    @FXML
    private TableColumn<DriverTable, String> driverUpdateName;

    @FXML
    private TableColumn<DriverTable, String> driverUpdatePoints;

    @FXML
    private TableView<DriverTable> driverUpdateTable;

    @FXML
    private TableColumn<DriverTable, String> driverUpdateTeam;

    @FXML
    private Button updateTableButton;

    // Used to display driver details, in update driver scene
    public void updateDriverTable() throws IOException {

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
        driverUpdateName.setCellValueFactory(new PropertyValueFactory<DriverTable,String>("driverName"));
        driverUpdateAge.setCellValueFactory(new PropertyValueFactory<DriverTable,String>("driverAge"));
        driverUpdateTeam.setCellValueFactory(new PropertyValueFactory<DriverTable,String>("driverTeam"));
        driverUpdateCar.setCellValueFactory(new PropertyValueFactory<DriverTable,String>("driverCar"));
        driverUpdatePoints.setCellValueFactory(new PropertyValueFactory<DriverTable,String>("driverPoints"));

        driverUpdateTable.setItems(list);
        updateTableButton.setDisable(true);

    }

    // Closing Program
    public void closeProgram(ActionEvent event) {
        System.exit(0);
    }
}
