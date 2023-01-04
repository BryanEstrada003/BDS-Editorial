/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectoeditorialsbd;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Dell
 */
public class VentanaPrincipalController implements Initializable {


    @FXML
    private Button btnAbrirVentana;

    @FXML
    private ToggleGroup grupoVentanas;

    @FXML
    private RadioButton Empleado;

    @FXML
    private RadioButton HistorialEmpleado;

    @FXML
    private RadioButton Periodista;

    @FXML
    private RadioButton Revista;
    
    @FXML
    private RadioButton Ejemplar;

    @FXML
    private VBox rootVP;
    
    @FXML
    private VBox nodoVentanas;
    
    @FXML
    private VBox nodoVistas;
    
     @FXML
    private Button btnVista;

    @FXML
    private ToggleGroup grupoVistas;
    
    @FXML
    private RadioButton vista1;

    @FXML
    private RadioButton vista2;

    @FXML
    private RadioButton vista3;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    private void AbrirVentana(ActionEvent event) throws IOException {
        String nombreVentana = "";
        Stage stage = new Stage();
        Scene scene;
        RadioButton elegido = (RadioButton)grupoVentanas.getSelectedToggle();
        if(elegido == null){
            Label aviso = new Label("No ha seleccionado una opcion.");
            nodoVentanas.getChildren().add(aviso);
            aviso.setPadding(new Insets(0, 0, 0, 200));
        }
        else if(elegido.getText().equals(Empleado.getText())){
            nombreVentana = "Empleado";
        }
        else if(elegido.getText().equals(Periodista.getText())){
            nombreVentana = "Periodista";
        }
        else if(elegido.getText().equals(HistorialEmpleado.getText())){
            nombreVentana = "ViewHistorialEmpleado";
        }
        else if(elegido.getText().equals(Revista.getText())){
            nombreVentana = "Revista";
        }
        else if(elegido.getText().equals(Ejemplar.getText())){
            nombreVentana = "Ejemplar";
        }
        try{
            FXMLLoader fxmlLoader = 
                    new FXMLLoader(VentanaPrincipalController.class.getResource(nombreVentana+".fxml"));
            Parent root = fxmlLoader.load();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Ventana "+elegido.getText());
            stage.show();
        }catch(IllegalStateException e){
            
        }
        
    }
    
    @FXML
    private void abrirVista(ActionEvent event) throws IOException {
        String nombreVista = "";
        Stage stage = new Stage();
        Scene scene;
        RadioButton elegido = (RadioButton)grupoVistas.getSelectedToggle();
        if(elegido == null){
            Label aviso = new Label("No ha seleccionado una opcion.");
            nodoVistas.getChildren().add(aviso);
            aviso.setPadding(new Insets(0, 0, 0, 200));        
        }
        else if(elegido.getText().equals(vista1.getText())){
            nombreVista = "vistaEjemplarxRevista";
        }
        else if(elegido.getText().equals(vista2.getText())){
            nombreVista = "vistaSeccionPublicar";
        }
        else if(elegido.getText().equals(vista3.getText())){
            nombreVista = "vistaArtPerio";
        }
        try{
            FXMLLoader fxmlLoader = 
                    new FXMLLoader(VentanaPrincipalController.class.getResource(nombreVista+".fxml"));
            Parent root = fxmlLoader.load();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(elegido.getText());
            stage.show();
        }catch(IllegalStateException e){
            
        }
        
    }
}

