/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Dell
 */
public class HistorialArticulo {
    
    private int idHistorialArt;
    private int idArticulo;
    private String comentarios;
    private Estado estado;

    public HistorialArticulo(int idHistorialArt, int idArticulo, String comentarios, Estado estado) {
        this.idHistorialArt = idHistorialArt;
        this.idArticulo = idArticulo;
        this.comentarios = comentarios;
        this.estado = estado;
    }

    public int getIdHistorialArt() {
        return idHistorialArt;
    }

    public void setIdHistorialArt(int idHistorialArt) {
        this.idHistorialArt = idHistorialArt;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "HistorialArticulo{" + "idHistorialArt=" + idHistorialArt + ", idArticulo=" + idArticulo + ", comentarios=" + comentarios + ", estado=" + estado + '}';
    }
    
    
    
    
}
