/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.editorialsbd;

import SQL.ObtenerEstadoArticulo;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HOME
 */
public class InicioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void estadoArticulo(ActionEvent event) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EstadoArt.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException ex) {
            VBox root = new VBox(new Label("Lo sentimos, tuvimos problemas con la app :c"));
            root.setAlignment(Pos.CENTER);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.showAndWait();
        }
        
    }

    @FXML
    private void nuevaSeccion(ActionEvent event) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("IngresarSeccion.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException ex) {
            VBox root = new VBox(new Label("Lo sentimos, tuvimos problemas con la app :c"));
            root.setAlignment(Pos.CENTER);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.showAndWait();
        }
    }

    @FXML
    private void nuevoAutor(ActionEvent event) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("IngresarAutor.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException ex) {
            VBox root = new VBox(new Label("Lo sentimos, tuvimos problemas con la app :c"));
            root.setAlignment(Pos.CENTER);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.showAndWait();
        }
    }
    
}
