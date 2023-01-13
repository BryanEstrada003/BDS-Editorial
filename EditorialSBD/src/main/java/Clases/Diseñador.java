/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author USER
 */
public class Diseñador {
    private String cedula_dis;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String correo;
    private String fecha_nacimiento;
    private float salario;

    public Diseñador(String cedula, String nombre, String apellido, String telefono, String direccion, String correo, String fecha_nacimiento, float salario) {
        this.cedula_dis = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.salario = salario;
    }
    
    //GETTERS
    
    public String getCedula() {
        return cedula_dis;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public float getSalario() {
        return salario;
    }
    
    //SETTERS

    public void setCedula(String cedula) {
        this.cedula_dis = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Disenador{" + "cedula=" + cedula_dis + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", direccion=" + direccion + ", correo=" + correo + ", fecha_nacimiento=" + fecha_nacimiento + ", salario=" + salario + '}';
    }
    
    
    
}
