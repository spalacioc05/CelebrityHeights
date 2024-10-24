/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author spala
 */

public class HorarioZonaComun {
    private String zonaComun;
    private String horaApertura;
    private String horaCierre;
    private String diasDisponibles;

    public HorarioZonaComun() {
    }

    public HorarioZonaComun(String zonaComun, String horaApertura, String horaCierre, String diasDisponibles) {
        this.zonaComun = zonaComun;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.diasDisponibles = diasDisponibles;
    }

    public String getZonaComun() {
        return zonaComun;
    }

    public void setZonaComun(String zonaComun) {
        this.zonaComun = zonaComun;
    }

    public String getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(String horaApertura) {
        this.horaApertura = horaApertura;
    }

    public String getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(String horaCierre) {
        this.horaCierre = horaCierre;
    }

    public String getDiasDisponibles() {
        return diasDisponibles;
    }

    public void setDiasDisponibles(String diasDisponibles) {
        this.diasDisponibles = diasDisponibles;
    }

    @Override
    public String toString() {
        return "HorarioZonaComun{" + "zonaComun=" + zonaComun + ", horaApertura=" + horaApertura + ", horaCierre=" + horaCierre + ", diasDisponibles=" + diasDisponibles + '}';
    }
    
    
}
