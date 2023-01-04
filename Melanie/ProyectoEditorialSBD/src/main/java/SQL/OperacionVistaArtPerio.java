/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import Clases.Empleado;
import Clases.VistaArtPerio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class OperacionVistaArtPerio {
    private VistaArtPerio vistaArtPerio;
    
    public OperacionVistaArtPerio(){
        
    }
    
    public OperacionVistaArtPerio(VistaArtPerio vista){
        this.vistaArtPerio = vista;
    }

    public VistaArtPerio getVistaArtPerio() {
        return vistaArtPerio;
    }

    public void setVistaArtPerio(VistaArtPerio vistaArtPerio) {
        this.vistaArtPerio = vistaArtPerio;
    }


    
    public static ArrayList<VistaArtPerio> MostrarVista(){
        ArrayList<VistaArtPerio> listado = new ArrayList<>();
        Conexion cn = new Conexion();
        cn.conectar();
        String sentencia="Select * from artsPeridodista";
        try {
            PreparedStatement ps=cn.getCn().prepareStatement(sentencia);
            ResultSet rs=ps.executeQuery();
            while (rs.next())
            {   VistaArtPerio v = new VistaArtPerio(rs.getInt("idPeriodistaExterno"),rs.getString("Nombre"),
            rs.getString("Especialidad"),rs.getInt("idArticulo"));
            listado.add(v);
            }
            cn.desconectar();
        } catch (SQLException ex) {
                 
        } 
        return listado;
    }
    
}
