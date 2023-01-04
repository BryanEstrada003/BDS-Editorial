/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoeditorialsbd;

import Clases.Ejemplar;
import SQL.Operaciones;
import SQL.OperacionesEjemplar;
import SQL.OperacionesRevista;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class EjemplarController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private Button btnActualizar;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btningresarRevista;

    @FXML
    private TableColumn<Ejemplar, String> colFecha;

    @FXML
    private TableColumn<Ejemplar, String> colNumeroPaginas;

    @FXML
    private TableColumn<Ejemplar, Integer> colNumeroRegistroRevista;

    @FXML
    private TableColumn<Ejemplar, String> colNumeroVendidos;

    @FXML
    private TableColumn<Ejemplar, Integer> colRegistroEjemplar;
    
    @FXML
    private Label lblEliminar;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<Ejemplar> tableView;

    @FXML
    private TextField tfEliminar;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO       
        ArrayList<Ejemplar> ejemplares = OperacionesEjemplar.ConsultarEjemplares();
        colRegistroEjemplar.setCellValueFactory(new PropertyValueFactory<>("numeroRegistroEjemplar"));
        colNumeroRegistroRevista.setCellValueFactory(new PropertyValueFactory<>("numeroRegistroRevista"));
        colNumeroPaginas.setCellValueFactory(new PropertyValueFactory<>("numeroPaginas"));
        colNumeroVendidos.setCellValueFactory(new PropertyValueFactory<>("numeroVendidos"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        tableView.getItems().setAll(ejemplares);
    }
    
    @FXML
    public void ingresarEjemplar(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(VentanaPrincipalController.class.getResource("EditarEjemplar.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
           
        stage.setScene(scene);
        stage.setTitle("Ingresar datos ejemplar");
        stage.show();
    }
    
    @FXML
    void editarRevista(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(VentanaPrincipalController.class.getResource("ActualizarEjemplar.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
           
        stage.setScene(scene);
        stage.setTitle("Editar ejemplar");
        stage.show();
        
    }

    @FXML
    void eliminar(ActionEvent event) {
        Operaciones op = new Operaciones();
        if(tfEliminar.getText().equals("")){
            lblEliminar.setText("Ingrese un número de registro.");
        }
        else{
            op.Eliminar(tfEliminar.getText());
        }
         
    }
    
    @FXML
    void actualizarTabla(ActionEvent event) {
        
        ArrayList<Ejemplar> ejemplares = OperacionesEjemplar.ConsultarEjemplares();
        colRegistroEjemplar.setCellValueFactory(new PropertyValueFactory<>("numeroRegistroEjemplar"));
        colNumeroRegistroRevista.setCellValueFactory(new PropertyValueFactory<>("numeroRegistroRevista"));
        colNumeroPaginas.setCellValueFactory(new PropertyValueFactory<>("numeroPaginas"));
        colNumeroVendidos.setCellValueFactory(new PropertyValueFactory<>("numeroVendidos"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        tableView.getItems().setAll(ejemplares);
        
    }
    
}
