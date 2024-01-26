package com.project;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class Controller3 implements Initializable {

    @FXML
    private Label label;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        if (Main.status) {
            label.setText("Perfecto");
        } else {
            label.setText("something goes wrong...");
        }

    }


    @FXML
    private void goHome(){
        UtilsViews.setViewAnimating("View0");
    }

}