/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoeditorialsbd;

import Clases.Ejemplar;
import SQL.Operaciones;
import SQL.OperacionesEjemplar;
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
public class ActualizarEjemplarController implements Initializable {

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
    private TextField lblNumeroRegistroEjemplar;

    @FXML
    private TextField lblNumeroRegistroRevista;

    @FXML
    private TextField lblNumeroPaginas;

    @FXML
    private TextField lblNumeroVendidos;

    @FXML
    private AnchorPane root;

    @FXML
    private Label lblAdvertencia;
    
    @FXML
    private Label lblAdvertencia2;
    
    @FXML
    private GridPane rootGP;


    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 
    @FXML
    void actualizarValores(ActionEvent event) {
         if(lblNumeroRegistroEjemplar.getText().equals("")){
            lblAdvertencia2.setText("Ingrese un número de registro");
        }
         else{
            Ejemplar ejemplar = new Ejemplar(Integer.valueOf(lblNumeroRegistroEjemplar.getText()),Integer.valueOf(lblNumeroRegistroRevista.getText()),lblNumeroPaginas.getText(),
        lblNumeroVendidos.getText(),String.valueOf(datePicker.getValue()));
             System.out.println(ejemplar);
            lblAdvertencia2.setText("Se han realizado los cambios.");
            OperacionesEjemplar op = new OperacionesEjemplar(ejemplar);
            op.ModificarEjemplar();
         }
        
    }

    @FXML
    void cerrar(ActionEvent event) {
         Stage s = (Stage)btnCancelar.getScene().getWindow();
        s.close();
    }
    
    @FXML
    public void consultarUnEjemplar(ActionEvent e){
        if(lblNumeroRegistroEjemplar.getText().equals("")){
            lblAdvertencia.setText("Ingrese un número de registro");
        }
        else{
            OperacionesEjemplar op = new OperacionesEjemplar();
            Ejemplar ejemplarSeleccionado = op.ConsultarUno(lblNumeroRegistroEjemplar.getText());
            lblNumeroRegistroRevista.setText(String.valueOf(ejemplarSeleccionado.getNumeroRegistroRevista()));
            lblNumeroPaginas.setText(ejemplarSeleccionado.getNumeroPaginas());
            lblNumeroVendidos.setText(ejemplarSeleccionado.getNumeroVendidos());
            datePicker.getEditor().setText(ejemplarSeleccionado.getFecha());
        }

    
}
}
