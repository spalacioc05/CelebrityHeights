/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author spala
 */

public class Visitante {
    private String idVisitante;
    private String nombreVisitante;
    private String idPropiedad;
    private String fechaEntrada;
    private String horaEntrada;
    private String motivo;

    public Visitante() {
    }

    public Visitante(String idVisitante, String nombreVisitante, String idPropiedad, String fechaEntrada, String horaEntrada, String motivo) {
        this.idVisitante = idVisitante;
        this.nombreVisitante = nombreVisitante;
        this.idPropiedad = idPropiedad;
        this.fechaEntrada = fechaEntrada;
        this.horaEntrada = horaEntrada;
        this.motivo = motivo;
    }

    public String getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(String idVisitante) {
        this.idVisitante = idVisitante;
    }

    public String getNombreVisitante() {
        return nombreVisitante;
    }

    public void setNombreVisitante(String nombreVisitante) {
        this.nombreVisitante = nombreVisitante;
    }

    public String getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(String idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "Visitante{" + "idVisitante=" + idVisitante + ", nombreVisitante=" + nombreVisitante + ", idPropiedad=" + idPropiedad + ", fechaEntrada=" + fechaEntrada + ", horaEntrada=" + horaEntrada + ", motivo=" + motivo + '}';
    }
    
    
    

}
