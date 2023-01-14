/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.editorialsbd;

import SQL.ObtenerEstadoArticulo;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
/**
 * FXML Controller class
 *
 * @author HOME
 */
public class EstadoArtController implements Initializable {


    @FXML
    private TextField idArt;
    @FXML
    private VBox contenedor;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void consultarEstado(ActionEvent event) {
        int id=0;
        try{
            id=Integer.valueOf(idArt.getText().trim());
            String estado;
            String articulo;
            try {
                contenedor.getChildren().clear();
                ObtenerEstadoArticulo estadoArt= new ObtenerEstadoArticulo(id);
                String e = estadoArt.getEstado();
                articulo = estadoArt.getArticulo();
                if (e.equalsIgnoreCase("true")){
                    estado="Está aprobado";
                }
                else if (e.equalsIgnoreCase("false")){
                    estado="Está desaprobado";
                }
                else{
                    estado=e;
                }
                contenedor.getChildren().addAll(new Label(estado), new Label(articulo));
            } catch (SQLException ex) {
                contenedor.getChildren().clear();
                contenedor.getChildren().addAll(new Label("Hubo un error en el SQL"));
            }
        }catch (NumberFormatException nfe){
            contenedor.getChildren().clear();
            contenedor.getChildren().addAll(new Label("Coloque de manera correcta el id del articulo"));
        }catch (Exception ex){
            contenedor.getChildren().clear();
            contenedor.getChildren().addAll(new Label("Lo sentimos, se cayo esta ventana :c"));
        }
    }

}
