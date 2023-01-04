/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Dell
 */
public class VistaSeccionaPublicar {
    
    private String nombre;
    private String titulo;
    private String seccionPublicar;

    public VistaSeccionaPublicar(String nombre, String titulo, String seccionPublicar) {
        this.nombre = nombre;
        this.titulo = titulo;
        this.seccionPublicar = seccionPublicar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSeccionPublicar() {
        return seccionPublicar;
    }

    public void setSeccionPublicar(String seccionPublicar) {
        this.seccionPublicar = seccionPublicar;
    }
    
    
}
