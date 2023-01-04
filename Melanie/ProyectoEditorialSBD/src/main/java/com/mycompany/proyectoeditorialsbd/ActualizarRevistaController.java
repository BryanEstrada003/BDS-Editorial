package com.mycompany.proyectoeditorialsbd;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Clases.Empleado;
import Clases.Revista;
import SQL.Operaciones;
import SQL.OperacionesRevista;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
public class ActualizarRevistaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private AnchorPane root;

    @FXML
    private GridPane rootGP;

    
    @FXML
    private Button btnGuardar;
    
        @FXML
    private TextField lblNumeroRegistroRevista;

    @FXML
    private TextField lblIdSucursal;

    @FXML
    private TextField lblTipo;

    @FXML
    private TextField lblPeriodicidad;

    @FXML
    private TextField lblTitulo;
    
    @FXML
    private Button btnCancelar;

    @FXML
    private Label lblAdvertencia;
    
    @FXML
    private Label lblAdvertencia2;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
        @FXML
    void actualizarValores(ActionEvent event) {
            Revista revista = new Revista(Integer.valueOf(lblNumeroRegistroRevista.getText()),Integer.valueOf(lblIdSucursal.getText()),lblTipo.getText(),
        Integer.valueOf(lblPeriodicidad.getText()),lblTitulo.getText());
            OperacionesRevista op = new OperacionesRevista(revista);
            op.ModificarRevista();
    }

    @FXML
    void cerrar(ActionEvent event) {
         Stage s = (Stage)btnCancelar.getScene().getWindow();
        s.close();
    }
    
    @FXML
    public void consultarUnaRevista(ActionEvent e){
            OperacionesRevista op = new OperacionesRevista();
            Revista revistaSeleccionada = op.ConsultarUno(lblNumeroRegistroRevista.getText());
            lblIdSucursal.setText(String.valueOf(revistaSeleccionada.getIdSucursal()));
            lblTipo.setText(revistaSeleccionada.getTipo());
            lblPeriodicidad.setText(String.valueOf(revistaSeleccionada.getPeriodicidad()));
            lblTitulo.setText(revistaSeleccionada.getTitulo());
    }
    
}
