/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author spala
 */
public class SesionGobal {
    private static boolean estaAutenticado = false;
    private static String id;
    private static String rol;

    public static boolean isLoggedIn() {
        return estaAutenticado;
    }

    public static void login(String id, String role) {
        estaAutenticado = true;
        id = id;
        rol = role;
    }

    public static void logout() {
        estaAutenticado = false;
        id = null;
        rol = null;
    }

    public static String getIdUsuario() {
        return id;
    }

    public static String getRolUsuario() {
        return rol;
    }
}
