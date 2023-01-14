/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import Clases.Seccion;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author HOME
 */
public class CrearSeccion {
    
    private String msm;
    private ArrayList<Seccion> secciones;
    
    public CrearSeccion(String seccion) throws SQLException{
        Conexion cn = new Conexion();
        cn.conectar();
        CallableStatement myStmt=null;
        ResultSet myRs=null;
        myStmt=cn.getCn().prepareCall("{call CrearSeccion(?,?)}");
        myStmt.setString(1, seccion);
        myStmt.registerOutParameter(2, Types.VARCHAR);
        myStmt.execute();
        myRs=myStmt.getResultSet();
        
        msm=myStmt.getString(2);
        secciones=display(myRs);
        
        cn.desconectar();
    }
    
    private ArrayList<Seccion> display(ResultSet myRs) throws SQLException{
        ArrayList<Seccion> seccionesRegistradas= new ArrayList<>();
        while(myRs.next()){
            int idseccion = myRs.getInt("idSeccion");
            String seccion = myRs.getString("seccion");
            Seccion s= new Seccion(idseccion,seccion);
            seccionesRegistradas.add(s);
        }
        return seccionesRegistradas;
    }

    public String getMsm() {
        return msm;
    }

    public ArrayList<Seccion> getSecciones() {
        return secciones;
    }  
}
