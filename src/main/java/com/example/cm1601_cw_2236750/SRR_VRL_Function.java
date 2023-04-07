package com.example.cm1601_cw_2236750;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SRR_VRL_Function {
    // Defining GUI elements from the java FXMl file
    @FXML
    private TextArea raceSimulated;
    @FXML
    private Label racesPrompt;

    // Called when simulate races button is clicked
    public void simulateRaces(){

        raceSimulated.clear();
        // prompt is set
        racesPrompt.setText("             Race was Simulated!");

        // Creating instance
        Races simulateRaces = new Races();

        // .simulateRace is called and the details of the race simulated is passed to a variable
        String raceData = simulateRaces.simulateRace();

        // Calling function to append data to the text area
        displayRace(raceData);

        // alert box displayed
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("A Race was Simulated!");
        alert.showAndWait();

    }

    // Used to append to the text area after simulating a race
    public void displayRace(String raceData){
        String raceSimulatedData =
                raceData.replaceAll(" {2,}(?!\\n)", "   |   ") + "\n";

        raceSimulated.appendText(raceSimulatedData);
        raceSimulated.setWrapText(true);
    }

    // Defining GUI elements from the java FXMl file
    @FXML
    private TextArea racesSummary;
    @FXML
    private Button racesDisplay;

    // called when display races button is pressed
    public void displayRacesSummary(){
        RacesSummaryDisplay table = new RacesSummaryDisplay("RaceSummary.txt");

        // Data is appended to the text area and, the display button is disabled
        racesSummary.appendText(table.raceSort());
        racesSummary.setWrapText(true);
        racesDisplay.setDisable(true);
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

    public void closeProgram(ActionEvent event) {
        System.exit(0);
    }

}
