/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author HOME
 */
public class ObtenerEstadoArticulo {
    private String estado;
    private String articulo;
    
    
    public ObtenerEstadoArticulo(int idIngresado) throws SQLException{
        Conexion cn = new Conexion();
        cn.conectar();
        CallableStatement myStmt=null; 
        myStmt=cn.getCn().prepareCall("{call ObtenerEstadoArticulo(?,?,?)}");
        myStmt.setInt(1, idIngresado);
        myStmt.registerOutParameter(2, Types.VARCHAR);
        myStmt.registerOutParameter(3, Types.VARCHAR);
        myStmt.execute();
        estado=myStmt.getString(2);
        articulo=myStmt.getString(3);
        cn.desconectar();
    }

    public String getEstado() {
        return estado;
    }

    public String getArticulo() {
        return articulo;
    }
    
    
    
}
