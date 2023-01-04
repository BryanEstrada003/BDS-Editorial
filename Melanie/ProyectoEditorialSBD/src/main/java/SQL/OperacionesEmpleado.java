/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;
import Clases.Empleado;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Dell
 */
public class OperacionesEmpleado {
    private Empleado empleado;

    public OperacionesEmpleado() {
    }

    public OperacionesEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    public boolean Insertar()
    {
        boolean resultado=true;
        Conexion cn=new Conexion();
        cn.conectar();
        String sentencia="Insert into Empleado (cedula,nombre,apellido,cargo,direccion,contrato,fechaNacimiento,Edad,Salario) values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps=cn.getCn().prepareStatement(sentencia);
            ps.setString(1, empleado.getCedula());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getApellido());
            ps.setString(4, empleado.getCargo());
            ps.setString(5, empleado.getDireccion());
            ps.setString(6, empleado.getContrato());
            ps.setString(7, empleado.getFechaNacimiento());
            ps.setString(8, String.valueOf(empleado.getEdad()));
            ps.setString(9, String.valueOf(empleado.getSalario()));
            
            ps.executeUpdate();
            cn.desconectar();
        } catch (SQLException ex) {
           resultado=false;         
        }    
        return resultado;
    }
    public boolean Modificar()
    {
        boolean resultado=true;
        Conexion cn=new Conexion();
        cn.conectar();
        String sentencia="Update Empleado set nombre=?,apellido=?,cargo=?,direccion=?,contrato=?,fechaNacimiento=?,edad=?,salario=? where cedula=?";
        try {
            PreparedStatement ps=cn.getCn().prepareStatement(sentencia);
            ps.setString(9, empleado.getCedula());
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setString(3, empleado.getCargo());
            ps.setString(4, empleado.getDireccion());
            ps.setString(5, empleado.getContrato());
            ps.setString(6, empleado.getFechaNacimiento());
            ps.setString(7, String.valueOf(empleado.getEdad()));
            ps.setString(8, String.valueOf(empleado.getSalario()));
            
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
        String sentencia="Delete from Empleado where cedula="+cedula;
        try {
            PreparedStatement ps=cn.getCn().prepareStatement(sentencia);
            
            ps.executeUpdate();
            cn.desconectar();
        } catch (SQLException ex) {
           resultado=false;         
        }    
        return resultado;
    }
    
    public static ArrayList<Empleado> ConsultarTodo()
    {
        ArrayList<Empleado> listado=new ArrayList<Empleado>();
        Conexion cn=new Conexion();
        cn.conectar();
        String sentencia="Select * from Empleado";
        try {
            PreparedStatement ps=cn.getCn().prepareStatement(sentencia);
            ResultSet rs=ps.executeQuery();
            while (rs.next())
            {   Empleado e = new Empleado(rs.getString("cedula"),rs.getString("nombre")
                    ,rs.getString("apellido"),rs.getString("cargo"),rs.getString("direccion"),rs.getString("contrato")
                    ,rs.getString("fechaNacimiento"),rs.getInt("edad"),rs.getDouble("Salario"));
                listado.add(e);
              
            }
            cn.desconectar();
        } catch (SQLException ex) {
                 
        } 
        return listado;
    }
    
    public Empleado ConsultarUno(String cedula)
    {
        Empleado p=new Empleado();
        Conexion cn=new Conexion();
        cn.conectar();
        String sentencia="Select * from Empleado where cedula=?";
        try {
            PreparedStatement ps=cn.getCn().prepareStatement(sentencia);
            ps.setString(1, String.valueOf(cedula));
            ResultSet rs=ps.executeQuery();
            while (rs.next())
            {
                p.setCedula(rs.getString("cedula"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setCargo(rs.getString("cargo"));
                p.setDireccion(rs.getString("direccion"));
                p.setContrato(rs.getString("contrato"));
                p.setFechaNacimiento(rs.getString("fechaNacimiento"));
                p.setEdad(rs.getInt("edad"));
                p.setSalario(rs.getDouble("salario"));
            }
            cn.desconectar();
        } catch (SQLException ex) {
                 
        }    
        return p;
    }
    
}
