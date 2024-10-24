/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author spala
 */
public class Indicacion {
    private int idIndicacion;
    private String indicacion;
    private boolean estado;

    public Indicacion() {
    }

    public Indicacion(int idIndicacion, String indicacion, boolean estado) {
        this.idIndicacion = idIndicacion;
        this.indicacion = indicacion;
        this.estado = estado;
    }

    public int getIdIndicacion() {
        return idIndicacion;
    }

    public void setIdIndicacion(int idIndicacion) {
        this.idIndicacion = idIndicacion;
    }

    public String getIndicacion() {
        return indicacion;
    }

    public void setIndicacion(String indicacion) {
        this.indicacion = indicacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Indicacion{" + "idIndicacion=" + idIndicacion + ", indicacion=" + indicacion + ", estado=" + estado + '}';
    }
    
    

}
