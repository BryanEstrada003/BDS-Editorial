/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author USER
 */
public class Articulo {
    private String idArticulo;
    private String descripcion;
    
    //CONSTRUCTOR

    public Articulo(String idArticulo, String descripcion) {
        this.idArticulo = idArticulo;
        this.descripcion = descripcion;
    }
    
    //GETTERS

    public String getIdArticulo() {
        return idArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    //SETTERS

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Articulo{" + "idArticulo=" + idArticulo + ", descripcion=" + descripcion + '}';
    }
    
    
    
}
