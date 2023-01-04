/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class ActualizarEmpleadoController implements Initializable {

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
    private Label labelCedula;

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
    private TextField lblEdad;

    @FXML
    private TextField lblNombre;

    @FXML
    private TextField lblSalario;

    @FXML
    private AnchorPane root;
    
    @FXML
    private Label lblAdvertencia;
    
    @FXML
    private Label lblAdvertencia2;
    
    @FXML
    private GridPane rootGP;

    @FXML
    void actualizarValores(ActionEvent event) {
         if(lblCedula.getText().equals("")){
            lblAdvertencia2.setText("Ingrese una cedula");
        }
         else{
            Empleado empleado = new Empleado(lblCedula.getText(),lblNombre.getText(),lblApellido.getText(),
        lblCargo.getText(),lblDireccion.getText(),lblContrato.getText(),
        String.valueOf(datePicker.getValue()),Integer.valueOf(lblEdad.getText()),
        Double.valueOf(lblSalario.getText()));
             System.out.println(empleado);
            lblAdvertencia2.setText("Se han realizado los cambios.");
            OperacionesEmpleado op = new OperacionesEmpleado(empleado);
            op.Modificar();
         }
        
    }

    @FXML
    void cerrar(ActionEvent event) {
         Stage s = (Stage)btnCancelar.getScene().getWindow();
        s.close();
    }
    
    @FXML
    public void consultarUnEmpleado(ActionEvent e){
        if(lblCedula.getText().equals("")){
            lblAdvertencia.setText("Ingrese una cedula");
        }
        else{
            OperacionesEmpleado op = new OperacionesEmpleado();
            Empleado empleadoSeleccionado = op.ConsultarUno(lblCedula.getText());
            lblNombre.setText(empleadoSeleccionado.getNombre());
            lblApellido.setText(empleadoSeleccionado.getApellido());
            lblCargo.setText(empleadoSeleccionado.getCargo());
            lblDireccion.setText(empleadoSeleccionado.getDireccion());
            lblContrato.setText(empleadoSeleccionado.getContrato());
            datePicker.getEditor().setText(empleadoSeleccionado.getFechaNacimiento());
            lblEdad.setText(String.valueOf(empleadoSeleccionado.getEdad()));
            lblSalario.setText(String.valueOf(empleadoSeleccionado.getSalario()));
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
    }    
    
    
}
