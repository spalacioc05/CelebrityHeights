/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controller;

/**
 *
 * @author spala
 */

public interface GestionarPersona {
    boolean registrar(Object obj);
    Object leer(String id);
    boolean actualizar(Object obj);
    boolean eliminar(String id);
    String mostrar();
}