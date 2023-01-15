/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.editorialsbd;

import Clases.*;
import SQL.CrearSeccion;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
/**
 * FXML Controller class
 *
 * @author HOME
 */
public class IngresarSeccionController implements Initializable {


    @FXML
    private TextField txtseccion;
    @FXML
    private VBox contenedor;
    @FXML
    private TableView<Seccion> tablaSeccion;
    @FXML
    private TableColumn<Seccion, Integer> idSeccionColumna;
    @FXML
    private TableColumn<Seccion, String> SeccionColumna;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void registrarSeccion(ActionEvent event) {
        contenedor.getChildren().clear();
        try {
            if(txtseccion.getText().trim().length()!=0){
            contenedor.getChildren().clear();
            CrearSeccion cs= new CrearSeccion(txtseccion.getText().trim());
            Label lblmensaje= new Label(cs.getMsm());
            contenedor.getChildren().add(lblmensaje);
            contenedor.getChildren().add(new Label("SECCIONES REGISTRADAS:"));
            ArrayList<Seccion> secciones = cs.getSecciones();
            ObservableList<Seccion> datosTabla = FXCollections.observableArrayList();
            for (Seccion s:secciones){                            
                datosTabla.add(s);
            }
            tablaSeccion.setItems(datosTabla);
            idSeccionColumna.setCellValueFactory(new PropertyValueFactory<>("idSeccion"));
            SeccionColumna.setCellValueFactory(new PropertyValueFactory<>("seccion"));
            }else{
                contenedor.getChildren().clear();
                contenedor.getChildren().addAll(new Label("Todos los campos deben de ser llenados"));
            }
        } catch (SQLException ex) {
            contenedor.getChildren().clear();
            contenedor.getChildren().addAll(new Label("se cayo :c"));
        }catch (Exception exp) {
            contenedor.getChildren().clear();
            contenedor.getChildren().addAll(new Label("ya está dentro del database"));
        }
    }

}
