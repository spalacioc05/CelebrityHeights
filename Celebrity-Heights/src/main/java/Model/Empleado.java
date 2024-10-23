/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author spala
 */
public class Empleado extends Persona {
    private String cargo;
    private String fechaContratacion;
    private double salario;

    public Empleado() {
    }

    public Empleado(String cargo, String fechaContratacion, double salario) {
        this.cargo = cargo;
        this.fechaContratacion = fechaContratacion;
        this.salario = salario;
    }

    public Empleado(String cargo, String fechaContratacion, double salario, String id, String clave, String rol, String nombre, String telefono, String correo, String fechaNacimiento) {
        super(id, clave, rol, nombre, telefono, correo, fechaNacimiento);
        this.cargo = cargo;
        this.fechaContratacion = fechaContratacion;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" + "cargo=" + cargo + ", fechaContratacion=" + fechaContratacion + ", salario=" + salario + '}';
    }  
}
