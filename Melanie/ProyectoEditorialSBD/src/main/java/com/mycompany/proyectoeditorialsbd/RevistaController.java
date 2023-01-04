/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoeditorialsbd;

import Clases.Revista;
import SQL.Operaciones;
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
public class RevistaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField tfEliminar;

    @FXML
    private Label lblEliminar;
    
    @FXML
    private Button btningresarRevista;
    
    @FXML
    private TableView<Revista> tableView;
    
     @FXML
    private TableColumn<Revista, Integer> colNumeroRegistroRevista;

    @FXML
    private TableColumn<Revista, Integer> colIdSucursal;

    @FXML
    private TableColumn<Revista, String> colTipo;

    @FXML
    private TableColumn<Revista, Integer> colPeriodicidad;

    @FXML
    private TableColumn<Revista, String> colTítulo;
    
    @FXML
    private AnchorPane root;
    
    @FXML
    private GridPane rootGP;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO       
        ArrayList<Revista> revistas = OperacionesRevista.ConsultarRevistas();
        colNumeroRegistroRevista.setCellValueFactory(new PropertyValueFactory<>("numeroRegistroRevista"));
        colIdSucursal.setCellValueFactory(new PropertyValueFactory<>("idSucursal"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colPeriodicidad.setCellValueFactory(new PropertyValueFactory<>("Periodicidad"));
        colTítulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        tableView.getItems().setAll(revistas);
    }
    
    @FXML
    public void ingresarRevista(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(VentanaPrincipalController.class.getResource("editarRevista.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
           
        stage.setScene(scene);
        stage.setTitle("Ingresar datos revista");
        stage.show();
    }
    
    @FXML
    void editarRevista(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(VentanaPrincipalController.class.getResource("actualizarRevista.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
           
        stage.setScene(scene);
        stage.setTitle("Editar revista");
        stage.show();
        
    }

    @FXML
    void eliminar(ActionEvent event) {
        OperacionesRevista op = new OperacionesRevista();
        if(tfEliminar.getText().equals("")){
            lblEliminar.setText("Ingrese un número de registro.");
        }
        else{
            op.Eliminar(tfEliminar.getText());
        }
         
    }
    
    @FXML
    void actualizarTabla(ActionEvent event) {
        
        ArrayList<Revista> revistas = OperacionesRevista.ConsultarRevistas();
        colNumeroRegistroRevista.setCellValueFactory(new PropertyValueFactory<>("numeroRegistroRevista"));
        colIdSucursal.setCellValueFactory(new PropertyValueFactory<>("idSucursal"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colPeriodicidad.setCellValueFactory(new PropertyValueFactory<>("periodicidad"));
        colTítulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        tableView.getItems().setAll(revistas);
        
    }
    
}
