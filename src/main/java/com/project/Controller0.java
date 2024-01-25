package com.project;

import javafx.fxml.FXML;

public class Controller0 {

    @FXML
    private void encriptarArxiu(){
        UtilsViews.setViewAnimating("View1");
    }

    @FXML
    private void desencriptarArxiu(){
        UtilsViews.setViewAnimating("View2");
    }

}