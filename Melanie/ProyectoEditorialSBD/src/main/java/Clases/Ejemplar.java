/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Dell
 */
public class Ejemplar {
    
    private int numeroRegistroEjemplar;
    private int numeroRegistroRevista;
    private String numeroPaginas;
    private String numeroVendidos;
    private String Fecha;

    public Ejemplar(){
        
    }
    
    
    public Ejemplar(int numeroRegistroEjemplar, int numeroRegistroRevista, String numeroPaginas, String numeroVendidos, String Fecha) {
        this.numeroRegistroEjemplar = numeroRegistroEjemplar;
        this.numeroRegistroRevista = numeroRegistroRevista;
        this.numeroPaginas = numeroPaginas;
        this.numeroVendidos = numeroVendidos;
        this.Fecha = Fecha;
    }

    public int getNumeroRegistroEjemplar() {
        return numeroRegistroEjemplar;
    }

    public void setNumeroRegistroEjemplar(int numeroRegistroEjemplar) {
        this.numeroRegistroEjemplar = numeroRegistroEjemplar;
    }

    public int getNumeroRegistroRevista() {
        return numeroRegistroRevista;
    }

    public void setNumeroRegistroRevista(int numeroRegistroRevista) {
        this.numeroRegistroRevista = numeroRegistroRevista;
    }

    public String getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(String numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getNumeroVendidos() {
        return numeroVendidos;
    }

    public void setNumeroVendidos(String numeroVendidos) {
        this.numeroVendidos = numeroVendidos;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    @Override
    public String toString() {
        return "Ejemplar{" + "numeroRegistroEjemplar=" + numeroRegistroEjemplar + ", numeroRegistroRevista=" + numeroRegistroRevista + ", numeroPaginas=" + numeroPaginas + ", numeroVendidos=" + numeroVendidos + ", Fecha=" + Fecha + '}';
    }
    
    
}
