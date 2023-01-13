/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author USER
 */
public class Autor {
    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String correo;
    private String fechaNacimiento;
    private String especialidad;
    private float salario;
    
    //CONSTRUCTOR
    
    public Autor(String cedula, String nombre, String apellido, String telefono, String direccion, String correo, String fechaNacimiento, String especialidad, float salario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.especialidad = especialidad;
        this.salario = salario;
    }
    
    //GETTERS
    
    public String getCedula() {
        return cedula;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public float getSalario() {
        return salario;
    }
    
    //SETTERS
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Autor{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", direccion=" + direccion + ", correo=" + correo + ", fechaNacimiento=" + fechaNacimiento + ", especialidad=" + especialidad + ", salario=" + salario + '}';
    }
    
       
    
}
