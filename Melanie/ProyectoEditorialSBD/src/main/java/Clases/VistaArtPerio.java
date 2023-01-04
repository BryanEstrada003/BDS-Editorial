/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Dell
 */
public class VistaArtPerio {
    private int idPeriodistaExterno;
    private String especialidad;
    private int idArticulo;
    private String nombre;

    public VistaArtPerio(int idPeriodistaExterno, String nombre, String especialidad, int idArticulo) {
        this.idPeriodistaExterno = idPeriodistaExterno;
        this.especialidad = especialidad;
        this.idArticulo = idArticulo;
        this.nombre = nombre;
    }

    public int getIdPeriodistaExterno() {
        return idPeriodistaExterno;
    }

    public void setIdPeriodistaExterno(int idPeriodistaExterno) {
        this.idPeriodistaExterno = idPeriodistaExterno;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    

    @Override
    public String toString() {
        return "VistaArtPerio{" + "idPeriodistaExterno=" + idPeriodistaExterno + ", especialidad=" + especialidad + ", idArticulo=" + idArticulo + ", nombre=" + nombre + '}';
    }
    
    
}
