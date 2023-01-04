/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectoeditorialsbd;

import Clases.Empleado;
import SQL.OperacionVistaArtPerio;
import SQL.OperacionesEmpleado;
import Clases.VistaArtPerio;
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
public class VistaArtPerioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btnCerrar;

    @FXML
    private TableColumn<VistaArtPerio, String> colEspecialidad;

    @FXML
    private TableColumn<VistaArtPerio, Integer> colIdArticulo;

    @FXML
    private TableColumn<VistaArtPerio, Integer> colIdPeriodista;

    @FXML
    private TableColumn<VistaArtPerio, String> colNombre;
    
    @FXML
    private TableView<VistaArtPerio> tableView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<VistaArtPerio> vista = OperacionVistaArtPerio.MostrarVista();
        System.out.println(vista);
        colIdPeriodista.setCellValueFactory(new PropertyValueFactory<>("idPeriodistaExterno"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEspecialidad.setCellValueFactory(new PropertyValueFactory<>("especialidad"));
        colIdArticulo.setCellValueFactory(new PropertyValueFactory<>("idArticulo"));
        
        tableView.getItems().setAll(vista);
    }    
    
    
    
    
    
    @FXML
    void cerrar(ActionEvent event) {
        Stage s = (Stage)btnCerrar.getScene().getWindow();
        s.close();
    }
    
}
