package com.project;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class Controller2 implements Initializable {
    private File privKey, file, destination;

    @FXML
    private Button privateKeyButton, fileButton, destinationButton, desencriptarButton;

    @FXML
    private TextField psswd;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        privKey = null; 
        file = null;
        destination = null;

        FileChooser fileChooser = new FileChooser();
        privateKeyButton.setOnMouseClicked(e -> {
            File selectedFile = fileChooser.showOpenDialog(null);

            if (selectedFile != null) {
                privateKeyButton.setText(selectedFile.getName());
                privKey = selectedFile;
                // Aquí puedes realizar acciones adicionales con el archivo seleccionado si es necesario
                System.out.println("Archivo seleccionado: " + privKey.getAbsolutePath());
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

        desencriptarButton.setOnMouseClicked(e -> {
            if (privKey != null && file != null && destination != null) {
                System.out.println("ENCRIPTAR");

                String outputPath = System.getProperty("user.dir")+"/data/"+destination.getName();
                System.out.println(outputPath);
                try {
                    KeyBasedFileProcessor.decryptFile(file.getAbsolutePath().toString(), privKey.getAbsolutePath().toString(), psswd.getText().toCharArray(), null);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
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