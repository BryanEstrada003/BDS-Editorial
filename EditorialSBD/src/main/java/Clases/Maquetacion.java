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
public class Maquetacion {
    private int idRevistaInicial;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String comentario;

    public Maquetacion(int idRevistaInicial, Date fecha_inicio, Date fecha_fin, String comentario) {
        this.idRevistaInicial = idRevistaInicial;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.comentario = comentario;
    }

    public int getIdRevistaInicial() {
        return idRevistaInicial;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public String getComentario() {
        return comentario;
    }

    public void setIdRevistaInicial(int idRevistaInicial) {
        this.idRevistaInicial = idRevistaInicial;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Maquetacion{" + "idRevistaInicial=" + idRevistaInicial + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", comentario=" + comentario + '}';
    }
    
    
    
}
