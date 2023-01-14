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
    private String seccion;

    public Seccion(int idSeccion, String seccion) {
        this.idSeccion = idSeccion;
        this.seccion = seccion;
    }

    public int getIdSeccion() {
        return idSeccion;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }  
}
