/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectoeditorialsbd;

import Clases.VistaEjemplarxRevista;
import Clases.VistaSeccionaPublicar;
import SQL.OperacionVistaEjempxRevis;
import SQL.OperacionVistaSeccionaPublicar;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class VistaSeccionPublicarController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button btnCerrar;

    @FXML
    private TableColumn<VistaSeccionaPublicar, String> colNombre;

    @FXML
    private TableColumn<VistaSeccionaPublicar, String> colSeccion;

    @FXML
    private TableColumn<VistaSeccionaPublicar, String> colTitulo;

    @FXML
    private TableView<VistaSeccionaPublicar> tableView;

    @FXML
    void cerrar(ActionEvent event) {
        Stage s = (Stage)btnCerrar.getScene().getWindow();
        s.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<VistaSeccionaPublicar> vista = OperacionVistaSeccionaPublicar.MostrarVista();
        colNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("Titulo"));
        colSeccion.setCellValueFactory(new PropertyValueFactory<>("SeccionPublicar"));
        tableView.getItems().setAll(vista);
    }    
    
}
