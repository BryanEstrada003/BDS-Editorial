/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoeditorialsbd;

import Clases.Empleado;
import SQL.OperacionesEmpleado;
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
public class EditarEmpleadoController implements Initializable {
    
    @FXML
    private AnchorPane root;

    @FXML
    private GridPane rootGP;

    
    @FXML
    private Button btnGuardar;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField lblApellido;

    @FXML
    private TextField lblCargo;

    @FXML
    private TextField lblCedula;

    @FXML
    private TextField lblContrato;

    @FXML
    private TextField lblDireccion;

    @FXML
    private TextField lblNombre;

    @FXML
    private TextField lblSalario;
    
    @FXML
    private TextField lblEdad;
    
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
        Empleado empleado = new Empleado(lblCedula.getText(),lblNombre.getText(),lblApellido.getText(),
        lblCargo.getText(),lblDireccion.getText(),lblContrato.getText(),
        String.valueOf(datePicker.getValue()),Integer.valueOf(lblEdad.getText()),
        Double.valueOf(lblSalario.getText()));
        
        OperacionesEmpleado op = new OperacionesEmpleado(empleado);
        op.Insertar();
        
        lblAdvertencia.setText("Se ha guardado correctamente los datos.");
        
    }
    
    @FXML
    public void cerrar(ActionEvent evento){
        Stage s = (Stage)btnCancelar.getScene().getWindow();
        s.close();
    }


    
}
