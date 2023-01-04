/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;
import Clases.Revista;
import java.sql.*;
import java.util.ArrayList;



/**
 *
 * @author User
 */
public class OperacionesRevista {

    private Revista revista;
    public OperacionesRevista() {
    }
    
    public OperacionesRevista(Revista revista) {
        this.revista=revista;
    }
        public boolean InsertarRevista()
    {
        boolean resultado=true;
        Conexion cn=new Conexion();
        cn.conectar();
        String sentencia="Insert into Revista (numeroRegistroRevista,idSucursal,tipo,periodicidad,titulo) values (?,?,?,?,?)";
        try {
            PreparedStatement ps=cn.getCn().prepareStatement(sentencia);
            ps.setString(1, String.valueOf(revista.getNumeroRegistroRevista()));
            ps.setString(2, String.valueOf(revista.getIdSucursal()));
            ps.setString(3, revista.getTipo());
            ps.setString(4, String.valueOf(revista.getPeriodicidad()));
            ps.setString(5, revista.getTitulo());
            ps.executeUpdate();
            cn.desconectar();
        } catch (SQLException ex) {
           resultado=false;         
        }    
        return resultado;
    }
        
    public boolean ModificarRevista()
    {
        boolean resultado=true;
        Conexion cn=new Conexion();
        cn.conectar();
        String sentencia="Update Revista set idSucursal=?,tipo=?,periodicidad=?,titulo=? where numeroRegistroRevista=?";
        try {
            PreparedStatement ps=cn.getCn().prepareStatement(sentencia);
            ps.setString(1, String.valueOf(revista.getIdSucursal()));
            ps.setString(2, revista.getTipo());
            ps.setString(3, String.valueOf(revista.getPeriodicidad()));
            ps.setString(4, String.valueOf(revista.getTitulo()));
            ps.setString(5, String.valueOf(revista.getNumeroRegistroRevista()));
            ps.executeUpdate();
            cn.desconectar();
        } catch (SQLException ex) {
           resultado=false;         
        }    
        return resultado;
    }
    
    public boolean Eliminar(String numeroRegistroRevista)
    {
        boolean resultado=true;
        Conexion cn=new Conexion();
        cn.conectar();
        String sentencia="Delete from Revista where numeroRegistroRevista="+numeroRegistroRevista;
        try {
            PreparedStatement ps=cn.getCn().prepareStatement(sentencia);
     
            ps.executeUpdate();
            cn.desconectar();
        } catch (SQLException ex) {
           resultado=false;         
        }    
        return resultado;
    }
    
    public static ArrayList<Revista> ConsultarRevistas()
    {
        ArrayList<Revista> listado=new ArrayList<Revista>();
        Conexion cn=new Conexion();
        cn.conectar();
        String sentencia="Select * from Revista";
        try {
            PreparedStatement ps=cn.getCn().prepareStatement(sentencia);
            ResultSet rs=ps.executeQuery();
            while (rs.next())
            {   Revista r = new Revista(rs.getInt("numeroRegistroRevista"),rs.getInt("idSucursal")
                    ,rs.getString("tipo"),rs.getInt("periodicidad"),rs.getString("titulo"));
                listado.add(r);
                
            }
            cn.desconectar();
        } catch (SQLException ex) {
                 
        } 
        return listado;
    }
    
    public Revista ConsultarUno(String numeroRegistroRevista)
    {
        Revista r =new Revista();
        Conexion cn=new Conexion();
        cn.conectar();
        String sentencia="Select * from Revista where numeroRegistroRevista=?";
        try {
            PreparedStatement ps=cn.getCn().prepareStatement(sentencia);
            ps.setString(1, String.valueOf(numeroRegistroRevista));
            ResultSet rs=ps.executeQuery();
            while (rs.next())
            {
                r.setNumeroRegistroRevista(rs.getInt("numeroRegistroRevista"));
                r.setIdSucursal(rs.getInt("idSucursal"));
                r.setTipo(rs.getString("tipo"));
                r.setPeriodicidad(rs.getInt("periodicidad"));
                r.setTitulo(rs.getString("titulo"));
            }
            cn.desconectar();
        } catch (SQLException ex) {
                 
        }    
        return r;
    }
    
}
