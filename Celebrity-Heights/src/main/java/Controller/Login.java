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
public class Login {

    public boolean login(String id, String clave, String rol) {
        String filePath = rol.equals("propietario") ? "propietariosPropiedades.json" : "empleados.json";
        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode rootNode = mapper.readTree(new File(filePath));
            for (JsonNode node : rootNode) {
                String jsonId = node.get("id").asText();
                String jsonClave = node.get("clave").asText();
                String jsonRol = node.get("rol").asText();

                if (id.equals(jsonId) && clave.equals(jsonClave) && rol.equals(jsonRol)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
