/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author spala
 */


public class Validaciones {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static boolean esFechaValida(String fecha) {
        try {
            DATE_FORMAT.setLenient(false);
            DATE_FORMAT.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean esCadenaNoVacia(String cadena) {
        return cadena != null && !cadena.trim().isEmpty();
    }

    public static boolean esNumeroPositivo(double numero) {
        return numero > 0;
    }
}