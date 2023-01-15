/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.editorialsbd;

import Clases.Autor;
import SQL.InsertarAutor;
import java.net.URL;
import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author HOME
 */
public class IngresarAutorController implements Initializable {
    @FXML
    private VBox contenedor;
    @FXML
    private TextField cedula;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellido;
    @FXML
    private TextField telefono;
    @FXML
    private TextField direccion;
    @FXML
    private TextField email;
    @FXML
    private DatePicker fechaNac;
    @FXML
    private TextField especialidad;
    @FXML
    private TextField salario;
    @FXML
    private TableView<Autor> TablaAutor;
    @FXML
    private TableColumn<Autor, String> CedulaColumn;
    @FXML
    private TableColumn<Autor, String> NombreColumn;
    @FXML
    private TableColumn<Autor, String> ApellidoColumn;
    @FXML
    private TableColumn<Autor, String> TelefonoColumn;
    @FXML
    private TableColumn<Autor, String> DireccionColumn;
    @FXML
    private TableColumn<Autor, String> CorreoColumn;
    @FXML
    private TableColumn<Autor, Date> FNColumn;
    @FXML
    private TableColumn<Autor, String> EspecialidadColumn;
    @FXML
    private TableColumn<Autor, Float> SalarioColumn;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void registrarAutor(ActionEvent event) {
        
        String ced=cedula.getText().trim();
        String nom = nombre.getText().trim();
        String apell = apellido.getText().trim();
        String telf= telefono.getText().trim();
        String dir = direccion.getText().trim();
        String em=email.getText().trim();
        String espec = especialidad.getText().trim();
        String sal=salario.getText().trim();
        
        if(ced.length()!=0 || nom.length()!=0 || apell.length()!=0 || dir.length()!=0 || fechaNac!=null || espec.length()!=0 ||
           sal.length()!=0){
            contenedor.getChildren().clear();
            

            try {
                LocalDate localDate = fechaNac.getValue();
                Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
                Date dateNac = Date.from(instant);
                float saldAutor=Float.parseFloat(sal);
                InsertarAutor instAut = new InsertarAutor(ced, nom, apell, telf, dir, em, (java.sql.Date) dateNac, espec,
                                                            saldAutor);
                Label lblmensaje= new Label(instAut.getMsm());
                contenedor.getChildren().add(lblmensaje);
                contenedor.getChildren().add(new Label("AUTORES REGISTRADOS:"));
                ArrayList<Autor> secciones = instAut.getAutores();
                ObservableList<Autor> datosTabla = FXCollections.observableArrayList();
                for (Autor a:secciones){                            
                    datosTabla.add(a);
                }   
                TablaAutor.setItems(datosTabla);
                CedulaColumn.setCellValueFactory(new PropertyValueFactory<>("cedula"));
                NombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                ApellidoColumn.setCellValueFactory(new PropertyValueFactory<>("apellido"));
                TelefonoColumn.setCellValueFactory(new PropertyValueFactory<>("telefono"));
                DireccionColumn.setCellValueFactory(new PropertyValueFactory<>("direccion"));
                CorreoColumn.setCellValueFactory(new PropertyValueFactory<>("correo"));
                FNColumn.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
                EspecialidadColumn.setCellValueFactory(new PropertyValueFactory<>("especialidad"));
                SalarioColumn.setCellValueFactory(new PropertyValueFactory<>("salario"));
                
            } catch (SQLException ex) {
                contenedor.getChildren().clear();
                contenedor.getChildren().addAll(new Label("se cayo :c"));
            } catch (NumberFormatException nfe){
                contenedor.getChildren().clear();
                contenedor.getChildren().addAll(new Label("Coloque bien el salario"));
            }catch (Exception iex) {
                contenedor.getChildren().clear();
                contenedor.getChildren().addAll(new Label("se cayo :c"));
            }
        }else{
            contenedor.getChildren().clear();
            contenedor.getChildren().addAll(new Label("Todos los campos deben de ser llenados"));
        }
        
    }
    
}
