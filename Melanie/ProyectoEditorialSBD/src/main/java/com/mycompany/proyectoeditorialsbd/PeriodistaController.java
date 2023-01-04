package com.mycompany.proyectoeditorialsbd;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Clases.Empleado;
import Clases.Periodista;
import SQL.Operaciones;
import SQL.OperacionesPeriodista;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class PeriodistaController implements Initializable {

    @FXML
    private TableView<Periodista> tableView;
    @FXML
    private TableColumn<?, ?> colIdPeriodista;
    @FXML
    private TableColumn<?, ?> colCedula;
    @FXML
    private TableColumn<?, ?> colNombre;
    @FXML
    private TableColumn<?, ?> colApellido;
    @FXML
    private TableColumn<?, ?> colCargo;
    @FXML
    private TableColumn<?, ?> colDireccion;
    @FXML
    private TableColumn<?, ?> colContrato;
    @FXML
    private TableColumn<?, ?> colFechaNacimiento;
    @FXML
    private TableColumn<?, ?> colEdad;
    @FXML
    private TableColumn<?, ?> colSalario;
    @FXML
    private TableColumn<?, ?> colEspecialidad;
    @FXML
    private TextField tfEliminar;
    @FXML
    private Label lblEliminar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO       
        ArrayList<Periodista> periodistas = OperacionesPeriodista.ConsultarTodo();
        colIdPeriodista.setCellValueFactory(new PropertyValueFactory<>("idPeriodista"));
        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colContrato.setCellValueFactory(new PropertyValueFactory<>("contrato"));
        colFechaNacimiento.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        colSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
        colEspecialidad.setCellValueFactory(new PropertyValueFactory<>("especialidad"));
        tableView.getItems().setAll(periodistas);
        
        
        
    }

    @FXML
    public void ingresarPeriodista(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(VentanaPrincipalController.class.getResource("editarPeriodista.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
           
        stage.setScene(scene);
        stage.setTitle("Ingresar datos periodista");
        stage.show();
        
    }
    
    @FXML
    void editarPeriodista(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(VentanaPrincipalController.class.getResource("actualizarPeriodista.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
           
        stage.setScene(scene);
        stage.setTitle("Editar Periodista");
        stage.show();
        
    }

    @FXML
    void eliminar(ActionEvent event) {
        OperacionesPeriodista op = new OperacionesPeriodista();
        if(tfEliminar.getText().equals("")){
            lblEliminar.setText("Ingrese una cédula.");
        }
        else{
            op.Eliminar(tfEliminar.getText());
        }
         
    }
    
    @FXML
    void actualizarTabla(ActionEvent event) {
        ArrayList<Periodista> periodistas = OperacionesPeriodista.ConsultarTodo();
        colIdPeriodista.setCellValueFactory(new PropertyValueFactory<>("idPeriodista"));
        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colContrato.setCellValueFactory(new PropertyValueFactory<>("contrato"));
        colFechaNacimiento.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        colSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
        colEspecialidad.setCellValueFactory(new PropertyValueFactory<>("especialidad"));
        tableView.getItems().setAll(periodistas);
    }
    
}
