/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectoeditorialsbd;


import Clases.Periodista;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author gabri
 */
public class ActualizarPeriodistaController implements Initializable {


    @FXML
    private AnchorPane apEditarPeriodista;
    @FXML
    private GridPane rootGP;
    @FXML
    private Label labelCedula;
    @FXML
    private TextField lblCedula;
    @FXML
    private TextField lblNombre;
    @FXML
    private TextField lblApellido;
    @FXML
    private TextField lblDireccion;
    @FXML
    private TextField lblSalario;
    @FXML
    private TextField lblContrato;
    @FXML
    private TextField lblCargo;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField lblEdad;
    @FXML
    private Button btnConsultarEmpleado;
    @FXML
    private Label lblAdvertencia;
    @FXML
    private Label lblAdvertencia2;
    @FXML
    private TextField lblidPeriodista;
    @FXML
    private TextField lblEspecialidad;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 

    public void actualizarValores(ActionEvent event) {
         if(lblCedula.getText().equals("")){
            lblAdvertencia2.setText("Ingrese una cedula");
        }
         else{
            Periodista periodista = new Periodista(Integer.valueOf(lblidPeriodista.getText()),lblCedula.getText(),lblNombre.getText(),lblApellido.getText(),
        lblCargo.getText(),lblDireccion.getText(),lblContrato.getText(),
        String.valueOf(datePicker.getValue()),Integer.valueOf(lblEdad.getText()),
        Double.valueOf(lblSalario.getText()),lblEspecialidad.getText());
             System.out.println(periodista);
            lblAdvertencia2.setText("Se han realizado los cambios.");
            OperacionesPeriodista op = new OperacionesPeriodista(periodista);
            op.Modificar();
         }
        
    }

    public void cerrar(ActionEvent event) {
         Stage s = (Stage)btnCancelar.getScene().getWindow();
        s.close();
    }
    
    public void consultarUnPeriodista(ActionEvent e){
        if(lblCedula.getText().equals("")){
            lblAdvertencia.setText("Ingrese una cedula");
        }
        else{
            OperacionesPeriodista op = new OperacionesPeriodista();
            Periodista periodistaSeleccionado = op.ConsultarUno(lblCedula.getText());
            lblidPeriodista.setText(String.valueOf(periodistaSeleccionado.getIdPeriodista()));
            lblNombre.setText(periodistaSeleccionado.getNombre());
            lblApellido.setText(periodistaSeleccionado.getApellido());
            lblCargo.setText(periodistaSeleccionado.getCargo());
            lblDireccion.setText(periodistaSeleccionado.getDireccion());
            lblContrato.setText(periodistaSeleccionado.getContrato());
            datePicker.getEditor().setText(periodistaSeleccionado.getFechaNacimiento());
            lblEdad.setText(String.valueOf(periodistaSeleccionado.getEdad()));
            lblSalario.setText(String.valueOf(periodistaSeleccionado.getSalario()));
            lblEspecialidad.setText(periodistaSeleccionado.getEspecialidad());
        }
    }
   
    
}
