/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import Clases.VistaEjemplarxRevista;
import Clases.VistaSeccionaPublicar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class OperacionVistaSeccionaPublicar {
    private VistaSeccionaPublicar vista;
    
    public OperacionVistaSeccionaPublicar(){
        
    }

    public OperacionVistaSeccionaPublicar(VistaSeccionaPublicar vista) {
        this.vista = vista;
    }

    public VistaSeccionaPublicar getVista() {
        return vista;
    }

    public void setVista(VistaSeccionaPublicar vista) {
        this.vista = vista;
    }
    
    public static ArrayList<VistaSeccionaPublicar> MostrarVista(){
        ArrayList<VistaSeccionaPublicar> listado = new ArrayList<>();
        Conexion cn = new Conexion();
        cn.conectar();
        String sentencia="Select * from nomtitsecc";
        try {
            PreparedStatement ps=cn.getCn().prepareStatement(sentencia);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
            VistaSeccionaPublicar v = new VistaSeccionaPublicar(rs.getString("Nombre"),rs.getString("Titulo")
                    ,rs.getString("SeccionPublicar"));
            listado.add(v);
            }
            cn.desconectar();
        } catch (SQLException ex) {
                 
        } 
        return listado;
    }
    
}
