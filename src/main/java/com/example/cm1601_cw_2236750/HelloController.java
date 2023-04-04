package com.example.cm1601_cw_2236750;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class HelloController{

    // Initialising elements from the GUI
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
    @FXML
    private TextField newData;
    @FXML
    private TextField driverToUpdate;
    @FXML
    private Label promptUpdate;
    @FXML
    private Label promptDelete;
    @FXML
    private TextField driverToDelete;
    @FXML
    private TextArea position;
    @FXML
    private Button standingDisplay;
    @FXML
    private Label racesPrompt;
    @FXML
    private TextField userFileName;
    @FXML
    private Label promptSTF;
    @FXML
    private TextField fileToDisplay;
    @FXML
    private TextArea fileData;
    @FXML
    private Button fileDisplay;
    @FXML
    private TextArea racesSummary;
    @FXML
    private Button racesDisplay;

    private Stage stage;
    private Scene scene;


    // loading the main scene once program starts
    public void mainScene(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("racing.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // loading addDriver scene
    public void addDriver(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("addDriver.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Data Entry");
            alert.setContentText("Make sure all fields have been filled!");
            alert.showAndWait();
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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Driver name");
            alert.setContentText("Driver already exists!");
            alert.showAndWait();
            addDriverName.clear();
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Driver name");
            alert.setContentText("Make sure the driver's name length is within 20 letters!");
            alert.showAndWait();
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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Driver age");
            alert.setContentText("Make sure the age is a number, and is between 18-55!");

            alert.showAndWait();
            addDriverAge.clear();

        }

        // Validating the driver Team, if there is an error, an error message is alerted and the field is cleared
        try{
            driverTeamName = String.format("%-20s",addDriverTeamName.getText());
            if (driverTeamName.length() >20){
                throw new  Exception();}

        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Driver's team name");
            alert.setContentText("Make sure the team name length is within 20 letters!");
            alert.showAndWait();
            addDriverTeamName.clear();

        }

        // Validating the driver Car type, if there is an error, an error message is alerted and the field is cleared
        try{
            driverCarType = String.format("%-20s",addDriverCarType.getText());
            if (driverCarType.length() >20){
                throw new  Exception();}

        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Driver's Car type");
            alert.setContentText("Make sure the car type length is within 20 letters!");
            alert.showAndWait();
            addDriverCarType.clear();

        }

        // Validating the driver's points, if there is an error, an error message is alerted and the field is cleared
        try{
            driverCurrentPoints = String.format("%-15s",Integer.parseInt(addDriverCurrentPoints.getText()));
            if (driverCurrentPoints.length() >15){
                throw new  Exception();}

        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Driver's current points");
            alert.setContentText("Make sure entered current points is a number!");
            alert.showAndWait();
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

            // All the text-fields are cleared.
            addDriverName.clear();
            addDriverAge.clear();
            addDriverTeamName.clear();
            addDriverCarType.clear();
            addDriverCurrentPoints.clear();

        }}


    // Loading updateDriver scene
    public void updateDriver(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("updateDriver.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Called when the update driver name is clicked
    public void updateDriverName(){

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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Data Entry");
            alert.setContentText("Make sure all fields have been filled!");
            alert.showAndWait();
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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Driver name");
            alert.setContentText("Driver doesn't exists!");
            alert.showAndWait();
            driverToUpdate.clear();
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Driver name");
            alert.setContentText("Make sure the driver's name length is within 20 letters!");
            alert.showAndWait();
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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Driver name");
            alert.setContentText("Driver already exists!");
            alert.showAndWait();
            newData.clear();
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Driver name");
            alert.setContentText("Make sure the driver's name length is within 20 letters!");
            alert.showAndWait();
            newData.clear();
        }

        // if fields are not empty, driver name is updated.
        if (!newData.getText().isEmpty() && !driverToUpdate.getText().isEmpty()){
            Driver driverUpdate = new Driver("Racing.txt",newDriverName);
            driverUpdate.updateDriverData("driverNameUpdate",newDriverName,driverNameUpdate);
            promptUpdate.setText("Driver updated Successfully!");
            newData.clear();
            driverToUpdate.clear();
        }

    }

    // Called when driver age needs to be updated
    public void updateDriverAge(){

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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Data Entry");
            alert.setContentText("Make sure all fields have been filled!");
            alert.showAndWait();
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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Driver name");
            alert.setContentText("Driver doesn't exists!");
            alert.showAndWait();
            driverToUpdate.clear();
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Driver name");
            alert.setContentText("Make sure the driver's name length is within 20 letters!");
            alert.showAndWait();
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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Driver age");
            alert.setContentText("Make sure the age is a number, and is between 18-55!");

            alert.showAndWait();
            newData.clear();

        }

        // if fields are not empty, data is updated and the fields are cleared.
        if (!newData.getText().isEmpty() && !driverToUpdate.getText().isEmpty()){
            Driver driverUpdate = new Driver("Racing.txt",newDriverAge);
            driverUpdate.updateDriverData("driverAgeUpdate",newDriverAge,driverNameUpdate);
            promptUpdate.setText("Driver updated Successfully!");
            newData.clear();
            driverToUpdate.clear();
        }


    }

    // Called when driver age needs to be updated
    public void updateTeamName(){

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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Data Entry");
            alert.setContentText("Make sure all fields have been filled!");
            alert.showAndWait();
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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Driver name");
            alert.setContentText("Driver doesn't exists!");
            alert.showAndWait();
            driverToUpdate.clear();
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Driver name");
            alert.setContentText("Make sure the driver's name length is within 20 letters!");
            alert.showAndWait();
            driverToUpdate.clear();
        }

        // Validating the new team name, if there is an error, an error message is alerted and the field is cleared
        try{
            newDriverTeamName = String.format("%-20s",newData.getText());
            if (newDriverTeamName.length() >20){
                throw new  Exception();}

        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Driver's team name");
            alert.setContentText("Make sure the team name length is within 20 letters!");
            alert.showAndWait();
            newData.clear();

        }

        // if fields are not empty, data is updated and the fields are cleared.
        if (!newData.getText().isEmpty() && !driverToUpdate.getText().isEmpty()){
            Driver driverUpdate = new Driver("Racing.txt",newDriverTeamName);
            driverUpdate.updateDriverData("driverTeamNameUpdate",newDriverTeamName,driverNameUpdate);
            promptUpdate.setText("Driver updated Successfully!");
            newData.clear();
            driverToUpdate.clear();
        }

    }
    public void updateCarType(){

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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Data Entry");
            alert.setContentText("Make sure all fields have been filled!");
            alert.showAndWait();
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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Driver name");
            alert.setContentText("Driver doesn't exists!");
            alert.showAndWait();
            driverToUpdate.clear();
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Driver name");
            alert.setContentText("Make sure the driver's name length is within 20 letters!");
            alert.showAndWait();
            driverToUpdate.clear();
        }

        // Validating the new car type, if there is an error, an error message is alerted and the field is cleared
        try{
            newCarType = String.format("%-20s",newData.getText());
            if (newCarType.length() >20){
                throw new  Exception();}

        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Driver's team name");
            alert.setContentText("Make sure the car type length is within 20 letters!");
            alert.showAndWait();
            newData.clear();

        }

        // if fields are not empty, data is updated and the fields are cleared.
        if (!newData.getText().isEmpty() && !driverToUpdate.getText().isEmpty()){
            Driver driverUpdate = new Driver("Racing.txt",newCarType);
            driverUpdate.updateDriverData("driverCarTypeUpdate",newCarType,driverNameUpdate);
            promptUpdate.setText("Driver updated Successfully!");
            newData.clear();
            driverToUpdate.clear();
        }
    }
    public void updateCurrentPoints(){

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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Data Entry");
            alert.setContentText("Make sure all fields have been filled!");
            alert.showAndWait();
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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Driver name");
            alert.setContentText("Driver doesn't exists!");
            alert.showAndWait();
            driverToUpdate.clear();
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Driver name");
            alert.setContentText("Make sure the driver name length is within 20 letters!");
            alert.showAndWait();
            driverToUpdate.clear();
        }

        // Validating the new driver points, if there is an error, an error message is alerted and the field is cleared
        try{
            newCurrentPoints = String.format("%-15s",Integer.parseInt(newData.getText()));
            if (newCurrentPoints.length() >15){
                throw new  Exception();}

        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Current Points");
            alert.setContentText("Make sure the current points length is an integer within 20 letters!");
            alert.showAndWait();
            newData.clear();

        }

        // if fields are not empty, data is updated and the fields are cleared.
        if (!newData.getText().isEmpty() && !driverToUpdate.getText().isEmpty()){
            Driver driverUpdate = new Driver("Racing.txt",newCurrentPoints);
            driverUpdate.updateDriverData("driverCurrentPointsUpdate",newCurrentPoints,driverNameUpdate);
            promptUpdate.setText("Driver updated Successfully!");
            newData.clear();
            driverToUpdate.clear();
        }
    }

    // Loading deleteDriver scene
    public void deleteDriver(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("deleteDriver.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // called when delete driver button is clicked
    public void deleteADriver(){

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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Driver name");
            alert.setContentText("Input Driver name!");
            alert.showAndWait();
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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Driver name");
            alert.setContentText("Driver doesn't exist!");
            alert.showAndWait();
            driverToDelete.clear();
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in Driver name");
            alert.setContentText("Make sure the driver's name length is within 20 letters!");
            alert.showAndWait();
            driverToDelete.clear();
        }

        // if fields are not empty, data is updated and the field is cleared.
        if (!driverToDelete.getText().isEmpty()){
            Driver deleteADriver = new Driver("Racing.txt",driverNameDelete);
            deleteADriver.deleteDriver();
            promptDelete.setText("Driver deleted!");
            driverToDelete.clear();
        }
    }

    // loading displayStandings scene
    public void displayStandings(ActionEvent event) throws  IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("displayStandings.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Called when displayPositions button is clicked
    public void displayPositions(){

        // Data is appended to the text area and, the display button is disabled
        position.appendText("Driver | Age | Team Name | Car Type | Current Points\n");
        DriverTableDisplay table = new DriverTableDisplay("Racing.txt");
        position.appendText(table.driverSort());
        position.setWrapText(true);
        standingDisplay.setDisable(true);
    }

    // Loading simulateRace scene
    public void simulateRace(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("simulateRace.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Called when simulate races button is clicked
    public void simulateRaces(){

        // prompt is set
        racesPrompt.setText("             Race was Simulated!");

        // Creating instance
        Races simulateRaces = new Races();

        // .simulateRace is called
        simulateRaces.simulateRace();

        // alert box displayed
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("A Race was Simulated!");
        alert.showAndWait();

    }

    // loading racesSummary scene
    public void racesSummary(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("racesSummary.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // called when display races button is pressed
    public void displayRacesSummary(){
        RacesSummaryDisplay table = new RacesSummaryDisplay("RaceSummary.txt");

        // Data is appended to the text area and, the display button is disabled
        racesSummary.appendText(table.raceSort());
        racesSummary.setWrapText(true);
        racesDisplay.setDisable(true);
    }

    // Loading saveToFile scene
    public void saveToFile(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("saveToFile.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in File name");
            alert.setContentText("Enter a name!");
            alert.showAndWait();
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

    // called when display file button s clicked
    public void displayFileData(){

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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error in File name");
            alert.setContentText("Enter a name; of a file that exists!");
            alert.showAndWait();
        }

        // if text field is not empty, data is displayed.
        if (!fileToDisplay.getText().isEmpty()) {
            fileData.appendText("Driver | Age | Team Name | Car Type | Current Points\n");
            DriverTableDisplay table = new DriverTableDisplay(fileName);
            fileData.appendText(table.driverSort());
            fileData.setWrapText(true);
            fileDisplay.setDisable(true);
        }
    }

    // Loading display file scene
    public void displayFileScene(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("displayFileScene.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // closes program, when exit button is clicked.
    public void closeProgram(ActionEvent event) throws  IOException{
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
}