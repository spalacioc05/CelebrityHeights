/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
/**
 *
 * @author spala
 */
public class GestionarLogin {

    public boolean login(String id, String clave, String rol) {
        String rutaArchivo = rol.equals("propietario") ? "data/propietariosPropiedades.json" : "data/empleados.json";
        ObjectMapper mapeador = new ObjectMapper();

        try {
            JsonNode nodoRaiz = mapeador.readTree(new File(rutaArchivo));
            for (JsonNode nodo : nodoRaiz) {
                String idJson = nodo.get("id").asText();
                String claveJson = nodo.get("clave").asText();
                String rolJson = nodo.get("rol").asText();

                if (id.equals(idJson) && clave.equals(claveJson) && rol.equals(rolJson)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
