/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;


import Clases.Periodista;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class OperacionesPeriodista {
    private Periodista periodista;

    public OperacionesPeriodista (){
    }

    public OperacionesPeriodista(Periodista periodista) {
        this.periodista = periodista;
    }

    public Periodista getPeriodista() {
        return periodista;
    }

    public void setPeriodista(Periodista periodista) {
        this.periodista = periodista;
    }
    
    public boolean Insertar()
    {
        boolean resultado=true;
        Conexion cn=new Conexion();
        cn.conectar();
        String sentencia="Insert into Periodista (idPeriodistaExterno,cedula,nombre,apellido,cargo,direccion,contrato,fechaNacimiento,Edad,Salario,Especialidad) values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps=cn.getCn().prepareStatement(sentencia);
            ps.setInt(1, periodista.getIdPeriodista());
            ps.setString(2, periodista.getCedula());
            ps.setString(3, periodista.getNombre());
            ps.setString(4, periodista.getApellido());
            ps.setString(5, periodista.getCargo());
            ps.setString(6, periodista.getDireccion());
            ps.setString(7, periodista.getContrato());
            ps.setString(8, periodista.getFechaNacimiento());
            ps.setString(9, String.valueOf(periodista.getEdad()));
            ps.setString(10, String.valueOf(periodista.getSalario()));
            ps.setString(11, periodista.getEspecialidad());
            
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
        String sentencia="Update Periodista set cedula=?,nombre=?,apellido=?,cargo=?,direccion=?"
                + ",contrato=?,fechaNacimiento=?,Edad=?,Salario=?,Especialidad=? where idPeriodistaExterno=?";
        try {
            PreparedStatement ps=cn.getCn().prepareStatement(sentencia);
             ps.setInt(11, periodista.getIdPeriodista());
            ps.setString(1, periodista.getCedula());
            ps.setString(2, periodista.getNombre());
            ps.setString(3, periodista.getApellido());
            ps.setString(4, periodista.getCargo());
            ps.setString(5, periodista.getDireccion());
            ps.setString(6, periodista.getContrato());
            ps.setString(7, periodista.getFechaNacimiento());
            ps.setString(8, String.valueOf(periodista.getEdad()));
            ps.setString(9, String.valueOf(periodista.getSalario()));
            ps.setString(10, periodista.getEspecialidad());
            
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
        String sentencia="Delete from Periodista where cedula="+cedula;
        try {
            PreparedStatement ps=cn.getCn().prepareStatement(sentencia);
            
            ps.executeUpdate();
            cn.desconectar();
        } catch (SQLException ex) {
           resultado=false;         
        }    
        return resultado;
    }
    
    public static ArrayList<Periodista> ConsultarTodo()
    {
        ArrayList<Periodista> listado=new ArrayList<Periodista>();
        Conexion cn=new Conexion();
        cn.conectar();
        String sentencia="Select * from Periodista";
        try {
            PreparedStatement ps=cn.getCn().prepareStatement(sentencia);
            ResultSet rs=ps.executeQuery();
            while (rs.next())
            {   Periodista p = new Periodista(rs.getInt("idPeriodistaExterno"),rs.getString("cedula"),rs.getString("nombre")
                    ,rs.getString("apellido"),rs.getString("cargo"),rs.getString("direccion"),rs.getString("contrato")
                    ,rs.getString("fechaNacimiento"),rs.getInt("Edad"),rs.getDouble("Salario"),rs.getString("Especialidad"));
                listado.add(p);
                
            }
            cn.desconectar();
        } catch (SQLException ex) {
                 
        } 
        return listado;
    }
    
    public Periodista ConsultarUno(String cedula)
    {
        Periodista p=new Periodista();
        Conexion cn=new Conexion();
        cn.conectar();
        String sentencia="Select * from Periodista where cedula=?";
        try {
            PreparedStatement ps=cn.getCn().prepareStatement(sentencia);
            ps.setString(1, cedula);
            ResultSet rs=ps.executeQuery();
            while (rs.next())
            {
                p.setIdPeriodista(rs.getInt("idPeriodistaExterno"));
                p.setCedula(rs.getString("cedula"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setCargo(rs.getString("cargo"));
                p.setDireccion(rs.getString("direccion"));
                p.setContrato(rs.getString("contrato"));
                p.setFechaNacimiento(rs.getString("fechaNacimiento"));
                p.setEdad(rs.getInt("edad"));
                p.setSalario(rs.getDouble("salario"));
                p.setEspecialidad(rs.getString("Especialidad"));
            }
            cn.desconectar();
        } catch (SQLException ex) {
                 
        }    
        return p;
    }
}
