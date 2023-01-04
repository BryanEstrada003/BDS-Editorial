/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;


import Clases.ViewHistorialEmp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class OperacionesHEVista {
    private ViewHistorialEmp ViewHE;
    
    public OperacionesHEVista(){}

    public OperacionesHEVista(ViewHistorialEmp ViewHE) {
        this.ViewHE = ViewHE;
    }

    public ViewHistorialEmp getViewHE() {
        return ViewHE;
    }

    public void setViewHE(ViewHistorialEmp ViewHE) {
        this.ViewHE = ViewHE;
    }
    
        
    public static ArrayList<ViewHistorialEmp> ConsultarTodo()
    {
        ArrayList<ViewHistorialEmp> listado=new ArrayList<>();
        Conexion cn=new Conexion();
        cn.conectar();
        String sentencia="Select * from historialEmp";
        try {
            PreparedStatement ps=cn.getCn().prepareStatement(sentencia);
            ResultSet rs=ps.executeQuery();
            while (rs.next())
            {   ViewHistorialEmp v = new ViewHistorialEmp(rs.getInt("idSucursal"),rs.getString("fechaInicio"),
            rs.getString("fechaFin"),rs.getString("nombre"),rs.getString("apellido"),rs.getString("cedula"));
                listado.add(v);
                
            }
            cn.desconectar();
        } catch (SQLException ex) {
                 
        } 
        return listado;
    }
    
    public ViewHistorialEmp ConsultarUno(String cedula)
    {
        ViewHistorialEmp p=new ViewHistorialEmp();
        Conexion cn=new Conexion();
        cn.conectar();
        String sentencia="Select * from historialEmp where cedula=?";
        try {
            PreparedStatement ps=cn.getCn().prepareStatement(sentencia);
            ps.setString(1, String.valueOf(cedula));
            ResultSet rs=ps.executeQuery();
            while (rs.next())
            {
                p.setIdSucursal(rs.getInt("idSucursal"));
                p.setFechaInicio(rs.getString("fechaInicio"));
                p.setFechaFin(rs.getString("fechaFin"));
                p.setCedula(rs.getString("cedula"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
            }
            cn.desconectar();
        } catch (SQLException ex) {
                 
        }    
        return p;
    }
    
    
}
