/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Date;

/**
 *
 * @author USER
 */
public class Publicacion {
    private int idRevistaInicial;
    private int idSeccion;
    private Date fechaPublicacion;
    private float precio;

    public Publicacion(int idRevistaInicial, int idSeccion, Date fechaPublicacion, float precio) {
        this.idRevistaInicial = idRevistaInicial;
        this.idSeccion = idSeccion;
        this.fechaPublicacion = fechaPublicacion;
        this.precio = precio;
    }

    public int getIdRevistaInicial() {
        return idRevistaInicial;
    }

    public int getIdSeccion() {
        return idSeccion;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setIdRevistaInicial(int idRevistaInicial) {
        this.idRevistaInicial = idRevistaInicial;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Publicacion{" + "idRevistaInicial=" + idRevistaInicial + ", idSeccion=" + idSeccion + ", fechaPublicacion=" + fechaPublicacion + ", precio=" + precio + '}';
    }
    
    
}
