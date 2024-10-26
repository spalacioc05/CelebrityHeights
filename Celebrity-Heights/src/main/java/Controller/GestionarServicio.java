/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Indicacion;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author spala
 */

public class GestionarServicio {
    private static final String RUTA_ARCHIVO = "data/servicio.csv";

    public Indicacion buscarIndicacion(int idIndicacion) {
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
            // Omitir la primera línea (encabezados)
            br.readLine();
            
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                System.out.println("Leyendo línea: " + linea);
                System.out.println("Comparando ID: " + datos[0] + " con " + idIndicacion);
                if (Integer.parseInt(datos[0]) == idIndicacion) {
                    System.out.println("ID encontrado: " + idIndicacion);
                    return new Indicacion(idIndicacion, datos[1], Boolean.parseBoolean(datos[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("ID no encontrado: " + idIndicacion);
        return null;
    }

    public boolean cambiarEstadoIndicacion(int idIndicacion) {
        String linea;
        List<String> lineas = new ArrayList<>();
        boolean encontrado = false;
    
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
            // Omitir la primera línea (encabezados)
            lineas.add(br.readLine());
    
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (Integer.parseInt(datos[0]) == idIndicacion) {
                    datos[2] = "true";
                    encontrado = true;
                }
                lineas.add(String.join(",", datos));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    
        if (encontrado) {
            try (FileWriter fw = new FileWriter(RUTA_ARCHIVO)) {
                for (String l : lineas) {
                    fw.write(l + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    
        return encontrado;
    }
}