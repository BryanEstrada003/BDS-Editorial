package com.mycompany.proyectoeditorialsbd;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Clases.Empleado;
import SQL.OperacionesEmpleado;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class EmpleadoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField tfEliminar;

    @FXML
    private Label lblEliminar;
    
    
    @FXML
    private TableView<Empleado> tableView;
    
    @FXML
    private TableColumn<Empleado, String> colApellido;
    
    @FXML
    private TableColumn<Empleado, String> colCargo;
    
    @FXML
    private TableColumn<Empleado, String> colCedula;

    @FXML
    private TableColumn<Empleado, String> colContrato;

    @FXML
    private TableColumn<Empleado, String> colDireccion;

    @FXML
    private TableColumn<Empleado, String> colEdad;

    @FXML
    private TableColumn<Empleado, String> colFechaN;

    @FXML
    private TableColumn<Empleado, String> colNombre;

    @FXML
    private TableColumn<Empleado, String> colSalario;
   

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO       
        ArrayList<Empleado> empleados = OperacionesEmpleado.ConsultarTodo();
        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colContrato.setCellValueFactory(new PropertyValueFactory<>("contrato"));
        colFechaN.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        colSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
        tableView.getItems().setAll(empleados);
        
        
        
    }

    public void ingresarEmpleado(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(VentanaPrincipalController.class.getResource("editarEmpleado.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
           
        stage.setScene(scene);
        stage.setTitle("Ingresar datos empleado");
        stage.show();
        
    }
    
    @FXML
    void editarEmpleado(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(VentanaPrincipalController.class.getResource("actualizarEmpleado.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
           
        stage.setScene(scene);
        stage.setTitle("Editar empleado");
        stage.show();
        
    }

    @FXML
    void eliminar(ActionEvent event) {
        OperacionesEmpleado op = new OperacionesEmpleado();
        if(tfEliminar.getText().equals("")){
            lblEliminar.setText("Ingrese una cédula.");
        }
        else{
            op.Eliminar(tfEliminar.getText());
        }
         
    }
    
    @FXML
    void actualizarTabla(ActionEvent event) {
        
        ArrayList<Empleado> empleados = OperacionesEmpleado.ConsultarTodo();
        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colContrato.setCellValueFactory(new PropertyValueFactory<>("contrato"));
        colFechaN.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        colSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
        tableView.getItems().setAll(empleados);
        
    }

   
}
