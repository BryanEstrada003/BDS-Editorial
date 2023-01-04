/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import Clases.VistaEjemplarxRevista;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class OperacionVistaEjempxRevis {
    private VistaEjemplarxRevista vistaExR;
    
    public OperacionVistaEjempxRevis(){
        
    }
    
    public OperacionVistaEjempxRevis(VistaEjemplarxRevista vistaExR){
        this.vistaExR = vistaExR;
    }

    public VistaEjemplarxRevista getVistaExR() {
        return vistaExR;
    }

    public void setVistaExR(VistaEjemplarxRevista vistaExR) {
        this.vistaExR = vistaExR;
    }

    


    
    public static ArrayList<VistaEjemplarxRevista> MostrarVista(){
        ArrayList<VistaEjemplarxRevista> listado = new ArrayList<>();
        Conexion cn = new Conexion();
        cn.conectar();
        String sentencia="Select * from ejempxrevist";
        try {
            PreparedStatement ps=cn.getCn().prepareStatement(sentencia);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
            VistaEjemplarxRevista v = new VistaEjemplarxRevista(rs.getString("Titulo"),rs.getInt("NumeroVenta"));
            listado.add(v);
            }
            cn.desconectar();
        } catch (SQLException ex) {
                 
        } 
        return listado;
    }
}
