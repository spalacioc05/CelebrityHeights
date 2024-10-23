/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;

/**
 *
 * @author spala
 */
public class Propietario extends Persona{
    private String profesion;
    private String ocupacion;
    private List<Propiedad> propiedades;

    public Propietario() {
    }

    public Propietario(String profesion, String ocupacion, List<Propiedad> propiedades) {
        this.profesion = profesion;
        this.ocupacion = ocupacion;
        this.propiedades = propiedades;
    }

    public Propietario(String profesion, String ocupacion, List<Propiedad> propiedades, String id, String clave, String rol, String nombre, String telefono, String correo, String fechaNacimiento) {
        super(id, clave, rol, nombre, telefono, correo, fechaNacimiento);
        this.profesion = profesion;
        this.ocupacion = ocupacion;
        this.propiedades = propiedades;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public List<Propiedad> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<Propiedad> propiedades) {
        this.propiedades = propiedades;
    }

    @Override
    public String toString() {
        return "Propietario{" + "profesion=" + profesion + ", ocupacion=" + ocupacion + ", propiedades=" + propiedades + '}';
    }
    
    
    
}
