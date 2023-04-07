package com.example.cm1601_cw_2236750;

import javafx.scene.control.Alert;

public class AlertErrors {

    Alert alertError = new Alert(Alert.AlertType.ERROR);

    // Used to alert error dialog boxes
    public void errorAlert(String errorTitle, String errorHeader, String errorText){
        alertError.setTitle(errorTitle);
        alertError.setHeaderText(errorHeader);
        alertError.setContentText(errorText);
        alertError.showAndWait();
    }

    // Used to alert Information dialog boxes
    Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
    public void infoAlert(String infoTitle, String infoHeader, String infoText){
        alertInfo.setTitle(infoTitle);
        alertInfo.setHeaderText(infoHeader);
        alertInfo.setContentText(infoText);
        alertInfo.showAndWait();
    }
}
