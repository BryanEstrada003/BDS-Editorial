/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoeditorialsbd;

import Clases.Ejemplar;
import SQL.OperacionesEjemplar;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class EditarEjemplarController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
        @FXML
    private Button btnCancelar;

    @FXML
    private Button btnGuardar;
    
    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField lblNumeroRegistroEjemplar;

    @FXML
    private TextField lblNumeroRegistroRevista;

    @FXML
    private TextField lblNumeroPaginas;

    @FXML
    private TextField lblNumeroVendidos;

    @FXML
    private AnchorPane root;

    @FXML
    private Label lblAdvertencia;
    
    @FXML
    private Label lblAdvertencia2;
    
    @FXML
    private GridPane rootGP;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void insertarValores(ActionEvent event) {
        Ejemplar ejemplar = new Ejemplar(Integer.valueOf(lblNumeroRegistroEjemplar.getText()),Integer.valueOf(lblNumeroRegistroRevista.getText()),lblNumeroPaginas.getText(),
        lblNumeroVendidos.getText(), String.valueOf(datePicker.getValue()));
        OperacionesEjemplar op = new OperacionesEjemplar(ejemplar);
        op.InsertarEjemplar();
        
    }
    
    @FXML
    public void cerrar(ActionEvent evento){
        Stage s = (Stage)btnCancelar.getScene().getWindow();
        s.close();
    }

    
}
