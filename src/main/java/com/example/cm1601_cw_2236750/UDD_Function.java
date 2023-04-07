package com.example.cm1601_cw_2236750;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

    @FXML
    protected void mainScene(ActionEvent actionEvent) throws Exception{
        navigateFunction(actionEvent,"racing.fxml");
    }

    @FXML
    protected void saveToFile(ActionEvent actionEvent) throws Exception{
        navigateFunction(actionEvent,"saveToFile.fxml");
    }

    public void closeProgram(ActionEvent event) {
        System.exit(0);
    }
}
