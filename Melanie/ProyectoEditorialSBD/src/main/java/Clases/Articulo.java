/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Dell
 */
public class Articulo {
    
    private int idArticulo;
    private int idPeriodista;

    public Articulo(int idArticulo, int idPeriodista) {
        this.idArticulo = idArticulo;
        this.idPeriodista = idPeriodista;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getIdPeriodista() {
        return idPeriodista;
    }

    public void setIdPeriodista(int idPeriodista) {
        this.idPeriodista = idPeriodista;
    }

    @Override
    public String toString() {
        return "Articulo{" + "idArticulo=" + idArticulo + ", idPeriodista=" + idPeriodista + '}';
    }
    
    
}
