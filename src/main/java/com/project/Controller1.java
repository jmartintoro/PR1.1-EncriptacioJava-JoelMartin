package com.project;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

public class Controller1 implements Initializable {
    private File pubKey, file, destination;

    @FXML
    private Button publicKeyButton, fileButton, destinationButton, encriptButton;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pubKey = null; 
        file = null;
        destination = null;

        FileChooser fileChooser = new FileChooser();
        publicKeyButton.setOnMouseClicked(e -> {
            File selectedFile = fileChooser.showOpenDialog(null);

            if (selectedFile != null) {
                publicKeyButton.setText(selectedFile.getName());
                pubKey = selectedFile;
                // Aquí puedes realizar acciones adicionales con el archivo seleccionado si es necesario
                System.out.println("Archivo seleccionado: " + pubKey.getAbsolutePath());
            }
        });

        fileButton.setOnMouseClicked(e -> {
            File selectedFile = fileChooser.showOpenDialog(null);

            if (selectedFile != null) {
                fileButton.setText(selectedFile.getName());
                file = selectedFile;
                // Aquí puedes realizar acciones adicionales con el archivo seleccionado si es necesario
                System.out.println("Archivo seleccionado: " + file.getAbsolutePath());
            }
        });

        destinationButton.setOnMouseClicked(e -> {
            File selectedFile = fileChooser.showOpenDialog(null);

            if (selectedFile != null) {
                destinationButton.setText(selectedFile.getName());
                destination = selectedFile;
                // Aquí puedes realizar acciones adicionales con el archivo seleccionado si es necesario
                System.out.println("Archivo seleccionado: " + destination.getAbsolutePath());
            }
        });

        encriptButton.setOnMouseClicked(e -> {
            if (pubKey != null && file != null && destination != null) {
                System.out.println("ENCRIPTAR");

                String outputPath = System.getProperty("user.dir")+"/data/"+destination.getName();
                System.out.println(outputPath);
                try {
                    KeyBasedFileProcessor.encryptFile(outputPath, file.getAbsolutePath().toString(), pubKey.getAbsolutePath().toString(), true, true);
                } catch (Exception e1) {
                    Main.status = false;
                    UtilsViews.setViewAnimating("View3");
                    e1.printStackTrace();
                }
                System.out.println("ENCRIPTAT!");
                
                Main.status = true;
                UtilsViews.setViewAnimating("View3");
            } else {
                System.out.println("Faltan arxius per seleccionar");
            }
        });
        
    }

    @FXML
    private void goBack(){
        UtilsViews.setViewAnimating("View0");
    }

    
}