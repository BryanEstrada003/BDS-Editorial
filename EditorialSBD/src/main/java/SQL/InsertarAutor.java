/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import Clases.Autor;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author HOME
 */
public class InsertarAutor {
    private String msm;
    private ArrayList<Autor> autores;
    // cedula_Autor, Nombre, Apellido, Telefono, Direccion, Correo, fecha_Nacimiento, Especialidad, Salario

    public InsertarAutor(
            String cedAutor, 
            String nomAutor, 
            String apellAutor, 
            String tlfAutor, 
            String direcAutor, 
            String correoAutor, 
            Date fnAutor, 
            String espAutor, 
            float salarioAutor) throws SQLException{
        Conexion cn = new Conexion();
        cn.conectar();
        CallableStatement myStmt=null;
        ResultSet myRs=null;
        myStmt=cn.getCn().prepareCall("{call InsertarAutor(?,?,?,?,?,?,?,?,?)}");
        myStmt.setString(1, cedAutor);
        myStmt.setString(2, nomAutor);
        myStmt.setString(3, apellAutor);
        myStmt.setString(4, tlfAutor);
        myStmt.setString(5, direcAutor);
        myStmt.setString(6, correoAutor);
        myStmt.setDate(7, fnAutor);
        myStmt.setString(8, espAutor);
        myStmt.setFloat(9, salarioAutor);      
        myStmt.execute();
        myRs=myStmt.getResultSet();
        msm=myStmt.getString(10);
        autores=display(myRs);
        
        cn.desconectar();
    
    }
    private ArrayList<Autor> display(ResultSet myRs) throws SQLException{
        ArrayList<Autor> autoresRegistradas= new ArrayList<>();
        while(myRs.next()){
            String cedulaAutor = myRs.getString("cedula_Autor");
            String nombreAutor = myRs.getString("Nombre");
            String apellidoAutor = myRs.getString("Apellido");
            String telfAutor = myRs.getString("Telefono");
            String dirAutor = myRs.getString("Direccion");
            String corrAutor = myRs.getString("Correo"); 
            Date fechaNacAutor = myRs.getDate("fecha_Nacimiento");
            String especAutor = myRs.getString("Especialidad");
            float salarioAutor = myRs.getFloat("Salario");
            Autor a= new Autor(cedulaAutor,
                                nombreAutor,
                                apellidoAutor,
                                telfAutor,
                                dirAutor,
                                corrAutor,
                                fechaNacAutor,
                                especAutor,
                                salarioAutor);
            autoresRegistradas.add(a);
        }
        return autoresRegistradas;
    }

    public String getMsm() {
        return msm;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }
    
}
