/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author USER
 */
public class Seccion {
    private int idSeccion;
    private String Seccion;

    public Seccion(int idSeccion, String Seccion) {
        this.idSeccion = idSeccion;
        this.Seccion = Seccion;
    }

    public int getIdSeccion() {
        return idSeccion;
    }

    public String getSeccion() {
        return Seccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    public void setSeccion(String Seccion) {
        this.Seccion = Seccion;
    }

    @Override
    public String toString() {
        return "Seccion{" + "idSeccion=" + idSeccion + ", Seccion=" + Seccion + '}';
    }
    
    
    
}
