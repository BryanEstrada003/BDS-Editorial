/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author User
 */
public class Revista {

    private int numeroRegistroRevista;
    private int idSucursal;
    private String tipo;
    private int periodicidad;
    private String titulo;

    
    public Revista(int numeroRegistroRevista, int idSucursal, String tipo, int periodicidad, String titulo) {
        this.numeroRegistroRevista = numeroRegistroRevista;
        this.idSucursal = idSucursal;
        this.tipo = tipo;
        this.periodicidad = periodicidad;
        this.titulo = titulo;
    }

    public Revista() {
        
    }

    public int getNumeroRegistroRevista() {
        return numeroRegistroRevista;
    }

    public void setNumeroRegistroRevista(int numeroRegistroRevista) {
        this.numeroRegistroRevista = numeroRegistroRevista;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(int periodicidad) {
        this.periodicidad = periodicidad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Revista{" + "numeroRegistroRevista=" + numeroRegistroRevista + ", idSucursal=" + idSucursal + ", tipo=" + tipo + ", periodicidad=" + periodicidad + ", titulo=" + titulo + '}';
    }

    
    
    
    
}

