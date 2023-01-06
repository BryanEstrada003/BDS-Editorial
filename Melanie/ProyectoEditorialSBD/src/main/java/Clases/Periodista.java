/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Dell
 */
public class Periodista {
    
    private int idPeriodista;
    private String cedula;
    private String nombre;
    private String apellido;
    private String cargo;
    private String direccion;
    private String contrato;
    private String fechaNacimiento;
    private int edad;
    private double salario;
    private String especialidad;
    
    public Periodista(){
        
    }
    
    public Periodista(int idPeriodista, String cedula, String nombre, String apellido, String cargo, String direccion, String contrato, String fechaNacimiento, int edad, double salario, String especialidad) {
        this.idPeriodista = idPeriodista;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.direccion = direccion;
        this.contrato = contrato;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.salario = salario;
        this.especialidad = especialidad;
    }

    public int getIdPeriodista() {
        return idPeriodista;
    }

    public void setIdPeriodista(int idPeriodista) {
        this.idPeriodista = idPeriodista;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
}