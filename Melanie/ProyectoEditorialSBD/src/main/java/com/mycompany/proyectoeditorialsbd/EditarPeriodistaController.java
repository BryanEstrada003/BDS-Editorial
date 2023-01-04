/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectoeditorialsbd;

import Clases.Periodista;
import SQL.Operaciones;
import SQL.OperacionesPeriodista;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author gabri
 */
public class EditarPeriodistaController implements Initializable {


    @FXML
    private TextField lblidPeriodista;
    @FXML
    private TextField lblCedula;
    @FXML
    private TextField lblNombre;
    @FXML
    private TextField lblApellido;
    @FXML
    private TextField lblCargo;
    @FXML
    private TextField lblDireccion;
    @FXML
    private TextField lblContrato;
    @FXML
    private TextField lblEdad;
    @FXML
    private TextField lblSalario;
    @FXML
    private TextField lblEspecialidad;
    @FXML
    private DatePicker lblFechaNacimiento;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Label lblAdvertencia;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    public void insertarValores(ActionEvent event) {
        Periodista periodista = new Periodista(Integer.valueOf(lblidPeriodista.getText()),lblCedula.getText(),lblNombre.getText(),lblApellido.getText(),
        lblCargo.getText(),lblDireccion.getText(),lblContrato.getText(),
        String.valueOf(lblFechaNacimiento.getValue()),Integer.valueOf(lblEdad.getText()),
        Double.valueOf(lblSalario.getText()),lblEspecialidad.getText());
        
        OperacionesPeriodista op = new OperacionesPeriodista(periodista);
        op.Insertar();
        
        lblAdvertencia.setText("Se ha guardado correctamente los datos.");
        
    }
    
    public void cerrar(ActionEvent evento){
        Stage s = (Stage)btnCancelar.getScene().getWindow();
        s.close();
    }
    
}
