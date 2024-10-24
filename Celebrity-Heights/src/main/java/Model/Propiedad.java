/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

/**
 *
 * @author spala
 */

public class Propiedad {
    private String idPropiedad;
    private String direccionPropiedad;
    private float sizeM2;
    private int habitaciones;
    private int bathrooms;
    private double precioM2;
    private String fechaAdquisicion;
    private double valorAdministracion;

    // Constructor por defecto
    public Propiedad() {
    }

    // Constructor con parámetros
    public Propiedad(String idPropiedad, String direccionPropiedad, int sizeM2, int habitaciones, int bathrooms, int precioM2, String fechaAdquisicion, int valorAdministracion) {
        this.idPropiedad = idPropiedad;
        this.direccionPropiedad = direccionPropiedad;
        this.sizeM2 = sizeM2;
        this.habitaciones = habitaciones;
        this.bathrooms = bathrooms;
        this.precioM2 = precioM2;
        this.fechaAdquisicion = fechaAdquisicion;
        this.valorAdministracion = valorAdministracion;
    }

    // Getters y setters
    public String getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(String idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public String getDireccionPropiedad() {
        return direccionPropiedad;
    }

    public void setDireccionPropiedad(String direccionPropiedad) {
        this.direccionPropiedad = direccionPropiedad;
    }

    public float getSizeM2() {
        return sizeM2;
    }

    public void setSizeM2(float sizeM2) {
        this.sizeM2 = sizeM2;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public double getPrecioM2() {
        return precioM2;
    }

    public void setPrecioM2(double precioM2) {
        this.precioM2 = precioM2;
    }

    public String getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(String fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public double getValorAdministracion() {
        return valorAdministracion;
    }

    public void setValorAdministracion(double valorAdministracion) {
        this.valorAdministracion = valorAdministracion;
    }
}