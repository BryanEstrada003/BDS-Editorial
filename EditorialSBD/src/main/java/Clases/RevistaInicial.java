/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author USER
 */
public class RevistaInicial {
    private String idRevistaInicial;
    private String titulo;

    public RevistaInicial(String idRevistaInicial, String titulo) {
        this.idRevistaInicial = idRevistaInicial;
        this.titulo = titulo;
    }

    public String getIdRevistaInicial() {
        return idRevistaInicial;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setIdRevistaInicial(String idRevistaInicial) {
        this.idRevistaInicial = idRevistaInicial;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "RevistaInicial{" + "idRevistaInicial=" + idRevistaInicial + ", titulo=" + titulo + '}';
    }
    
    
}
