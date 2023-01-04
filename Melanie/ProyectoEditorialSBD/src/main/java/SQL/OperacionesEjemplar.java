/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import Clases.Ejemplar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class OperacionesEjemplar {
    private Ejemplar ejemplar;
    
    public OperacionesEjemplar() {
        
    }

    public OperacionesEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }
    
    public boolean InsertarEjemplar()
    {
        boolean resultado=true;
        Conexion cn=new Conexion();
        cn.conectar();
        String sentencia="Insert into Ejemplar (numeroRegistroEjemplar,numeroRegistroRevista,numeroPaginas,numeroVendidos,Fecha) values (?,?,?,?,?)";
        try {
            PreparedStatement ps=cn.getCn().prepareStatement(sentencia);
            ps.setString(1, String.valueOf(ejemplar.getNumeroRegistroEjemplar()));
            ps.setString(2, String.valueOf(ejemplar.getNumeroRegistroRevista()));
            ps.setString(3, ejemplar.getNumeroPaginas());
            ps.setString(4, ejemplar.getNumeroVendidos());
            ps.setString(5, ejemplar.getFecha());
            
            ps.executeUpdate();
            cn.desconectar();
        } catch (SQLException ex) {
           resultado=false;         
        }    
        return resultado;
    }
    public boolean ModificarEjemplar()
    {
        boolean resultado=true;
        Conexion cn=new Conexion();
        cn.conectar();
        String sentencia="Update Ejemplar set numeroRegistroRevista=?,numeroPaginas=?,numeroVendidos=?,Fecha=? where numeroRegistroEjemplar=?";
        try {
            PreparedStatement ps=cn.getCn().prepareStatement(sentencia);
            ps.setString(1, String.valueOf(ejemplar.getNumeroRegistroRevista()));
            ps.setString(2, ejemplar.getNumeroPaginas());
            ps.setString(3, ejemplar.getNumeroVendidos());
            ps.setString(4, ejemplar.getFecha());
            ps.setString(5, String.valueOf(ejemplar.getNumeroRegistroEjemplar()));
            
            ps.executeUpdate();
            cn.desconectar();
        } catch (SQLException ex) {
           resultado=false;         
        }    
        return resultado;
    }
    
    public boolean Eliminar(String cedula)
    {
        boolean resultado=true;
        Conexion cn=new Conexion();
        cn.conectar();
        String sentencia="Delete from Ejemplar where numeroRegistroEjemplar="+ejemplar.getNumeroRegistroEjemplar();
        try {
            PreparedStatement ps=cn.getCn().prepareStatement(sentencia);
            
            ps.executeUpdate();
            cn.desconectar();
        } catch (SQLException ex) {
           resultado=false;         
        }    
        return resultado;
    }
    
    public static ArrayList<Ejemplar> ConsultarEjemplares()
    {
        ArrayList<Ejemplar> listado=new ArrayList<Ejemplar>();
        Conexion cn=new Conexion();
        cn.conectar();
        String sentencia="Select * from Ejemplar";
        try {
            PreparedStatement ps=cn.getCn().prepareStatement(sentencia);
            ResultSet rs=ps.executeQuery();
            while (rs.next())
            {   Ejemplar e = new Ejemplar(rs.getInt("numeroRegistroEjemplar"),rs.getInt("numeroRegistroRevista")
                    ,rs.getString("numeroPaginas"),rs.getString("numeroVendidos"),rs.getString("Fecha"));
                listado.add(e);
                
            }
            cn.desconectar();
        } catch (SQLException ex) {
                 
        } 
        return listado;
    }
    
    public Ejemplar ConsultarUno(String cedula)
    {
        Ejemplar e=new Ejemplar();
        Conexion cn=new Conexion();
        cn.conectar();
        String sentencia="Select * from Ejemplar where numeroRegistroEjemplar=?";
        try {
            PreparedStatement ps=cn.getCn().prepareStatement(sentencia);
            ps.setString(1, String.valueOf(cedula));
            ResultSet rs=ps.executeQuery();
            while (rs.next())
            {
                e.setNumeroRegistroEjemplar(rs.getInt("numeroRegistroEjemplar"));
                e.setNumeroRegistroRevista(rs.getInt("numeroRegistroRevista"));
                e.setNumeroPaginas(rs.getString("numeroPaginas"));
                e.setNumeroVendidos(rs.getString("numeroVendidos"));
                e.setFecha(rs.getString("Fecha"));
            }
            cn.desconectar();
        } catch (SQLException ex) {
                 
        }    
        return e;
    } 
    
}
