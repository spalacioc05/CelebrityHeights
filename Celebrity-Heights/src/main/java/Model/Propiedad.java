/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

/**
 *
 * @author spala
 */
public interface Propiedad {
    String getIdPropiedad();
    void setIdPropiedad(String idPropiedad);

    String getDireccionPropiedad();
    void setDireccionPropiedad(String direccionPropiedad);

    int getSizeM2();
    void setSizeM2(int sizeM2);

    int getHabitaciones();
    void setHabitaciones(int habitaciones);

    int getBathrooms();
    void setBathrooms(int bathrooms);

    double getPrecioM2();
    void setPrecioM2(double precioM2);

    String getFechaAdquisicion();
    void setFechaAdquisicion(String fechaAdquisicion);

    double getValorAdministracion();
    void setValorAdministracion(double valorAdministracion);
    
}
