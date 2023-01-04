/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectoeditorialsbd;

import Clases.Empleado;
import Clases.ViewHistorialEmp;
import SQL.Operaciones;
import SQL.OperacionesHEVista;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * FXML Controller class
 *
 * @author gabri
 */
public class ViewHistorialEmpleadoController implements Initializable {


    @FXML
    private TableColumn<?, ?> colidSucursal;
    @FXML
    private TableColumn<?, ?> colfechaInicio;
    @FXML
    private TableColumn<?, ?> colFechafin;
    @FXML
    private TableColumn<?, ?> colNombre;
    @FXML
    private TableColumn<?, ?> colApellido;
    @FXML
    private TableColumn<?, ?> colCedula;
    @FXML
    private Button btnConsultarUno;
    @FXML
    private TextField fldCedula;
    @FXML
    private TableView<ViewHistorialEmp> tableView;
    @FXML
    private Label lblAdvertencia;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<ViewHistorialEmp> hEmpleados = OperacionesHEVista.ConsultarTodo();
        colidSucursal.setCellValueFactory(new PropertyValueFactory<>("idSucursal"));
        colfechaInicio.setCellValueFactory(new PropertyValueFactory<>("fechaInicio"));
        colFechafin.setCellValueFactory(new PropertyValueFactory<>("fechaFin"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        tableView.getItems().setAll(hEmpleados);
        
        
    }

    public void consultarUnEmpleado(ActionEvent e){
        if(fldCedula.getText().equals("")){
            lblAdvertencia.setText("Ingrese una cedula");
        }
        else{
            tableView.getItems().clear();
            OperacionesHEVista op = new OperacionesHEVista();
            ViewHistorialEmp empleadoSeleccionado = op.ConsultarUno(fldCedula.getText());
            colidSucursal.setCellValueFactory(new PropertyValueFactory<>("idSucursal"));
            colfechaInicio.setCellValueFactory(new PropertyValueFactory<>("fechaInicio"));
            colFechafin.setCellValueFactory(new PropertyValueFactory<>("fechaFin"));
            colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
            colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
            tableView.getItems().add(empleadoSeleccionado);
            
        }
    }    
    
}
