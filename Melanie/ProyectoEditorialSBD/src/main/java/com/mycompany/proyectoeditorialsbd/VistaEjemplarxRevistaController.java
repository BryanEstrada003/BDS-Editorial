/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectoeditorialsbd;

import SQL.OperacionVistaArtPerio;
import SQL.OperacionVistaEjempxRevis;
import Clases.VistaArtPerio;
import Clases.VistaEjemplarxRevista;
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
public class VistaEjemplarxRevistaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button btnCerrar;
    
    @FXML
    private TableColumn<VistaEjemplarxRevista, Integer> colVenta;

    @FXML
    private TableColumn<VistaEjemplarxRevista, String> colTitulo;

    @FXML
    private TableView<VistaEjemplarxRevista> tableView;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<VistaEjemplarxRevista> vista = OperacionVistaEjempxRevis.MostrarVista();
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("Titulo"));
        colVenta.setCellValueFactory(new PropertyValueFactory<>("NumeroVenta"));
        tableView.getItems().setAll(vista);
    }    
    @FXML
    void cerrar(ActionEvent event) {
        Stage s = (Stage)btnCerrar.getScene().getWindow();
        s.close();
    }
}
