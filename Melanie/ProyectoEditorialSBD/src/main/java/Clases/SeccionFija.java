/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Dell
 */
public class SeccionFija {
    
    private String titulo;
    private int numeroRegistroRevista;
    private int extension;

    public SeccionFija(String titulo, int numeroRegistroRevista, int extension) {
        this.titulo = titulo;
        this.numeroRegistroRevista = numeroRegistroRevista;
        this.extension = extension;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumeroRegistroRevista() {
        return numeroRegistroRevista;
    }

    public void setNumeroRegistroRevista(int numeroRegistroRevista) {
        this.numeroRegistroRevista = numeroRegistroRevista;
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "SeccionFija{" + "titulo=" + titulo + ", numeroRegistroRevista=" + numeroRegistroRevista + ", extension=" + extension + '}';
    }
    
    
}
