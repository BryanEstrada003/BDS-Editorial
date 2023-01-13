/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author USER
 */
public class HistorialArticulo {

    private int idArticulo;
    private String Comentario;
    private String Estado;

    public HistorialArticulo(int idArticulo, String Comentario, String Estado) {
        this.idArticulo = idArticulo;
        this.Comentario = Comentario;
        this.Estado = Estado;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public String getComentario() {
        return Comentario;
    }

    public String getEstado() {
        return Estado;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return "HistorialArticulo{" + "idArticulo=" + idArticulo + ", Comentario=" + Comentario + ", Estado=" + Estado + '}';
    }

}
