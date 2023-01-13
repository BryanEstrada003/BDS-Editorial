/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author USER
 */
public class Aprobacion {
    private int idArticulo;
    private int idRevistaInicial;

    public Aprobacion(int idArticulo, int idRevistaInicial) {
        this.idArticulo = idArticulo;
        this.idRevistaInicial = idRevistaInicial;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public int getIdRevistaInicial() {
        return idRevistaInicial;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public void setIdRevistaInicial(int idRevistaInicial) {
        this.idRevistaInicial = idRevistaInicial;
    }

    @Override
    public String toString() {
        return "Aprobacion{" + "idArticulo=" + idArticulo + ", idRevistaInicial=" + idRevistaInicial + '}';
    }
    
    
}
