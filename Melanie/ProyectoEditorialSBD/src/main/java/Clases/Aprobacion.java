/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Dell
 */
public class Aprobacion {
    
    private int idAprobacion;
    private String cedula;
    private int idArticulo;
    private int numeroRegistroRevista;
    private String seccionPublicar;
    private Estado estado;

    public Aprobacion(int idAprobacion, String cedula, int idArticulo, int numeroRegistroRevista, String seccionPublicar, Estado estado) {
        this.idAprobacion = idAprobacion;
        this.cedula = cedula;
        this.idArticulo = idArticulo;
        this.numeroRegistroRevista = numeroRegistroRevista;
        this.seccionPublicar = seccionPublicar;
        this.estado = estado;
    }

    public int getIdAprobacion() {
        return idAprobacion;
    }

    public void setIdAprobacion(int idAprobacion) {
        this.idAprobacion = idAprobacion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getNumeroRegistroRevista() {
        return numeroRegistroRevista;
    }

    public void setNumeroRegistroRevista(int numeroRegistroRevista) {
        this.numeroRegistroRevista = numeroRegistroRevista;
    }

    public String getSeccionPublicar() {
        return seccionPublicar;
    }

    public void setSeccionPublicar(String seccionPublicar) {
        this.seccionPublicar = seccionPublicar;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Aprobacion{" + "idAprobacion=" + idAprobacion + ", cedula=" + cedula + ", idArticulo=" + idArticulo + ", numeroRegistroRevista=" + numeroRegistroRevista + ", seccionPublicar=" + seccionPublicar + ", estado=" + estado + '}';
    }
    
    
}
