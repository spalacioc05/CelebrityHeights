/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author spala
 */
public class Navegacion {
    private static javax.swing.JFrame ventanaAnterior;

    public static void setVentanaAnterior(javax.swing.JFrame ventana) {
        ventanaAnterior = ventana;
    }

    public static javax.swing.JFrame getVentanaAnterior() {
        return ventanaAnterior;
    }

    public static void navegarVentanaAnterior() {
        if (ventanaAnterior != null) {
            ventanaAnterior.setVisible(true);
        }
    }
}
