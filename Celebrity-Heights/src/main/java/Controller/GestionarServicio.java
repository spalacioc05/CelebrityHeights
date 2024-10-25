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
    private static final String csvFile = "data/servicio.csv";

    public Indicacion buscarIndicacion(int idIndicacion) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (Integer.parseInt(data[0]) == idIndicacion) {
                    return new Indicacion(idIndicacion, data[1], Boolean.parseBoolean(data[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean cambiarEstadoIndicacion(int idIndicacion) {
        String line;
        List<String> lines = new ArrayList<>();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (Integer.parseInt(data[0]) == idIndicacion) {
                    data[2] = "true";
                    found = true;
                }
                lines.add(String.join(",", data));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        if (found) {
            try (FileWriter fw = new FileWriter(csvFile)) {
                for (String l : lines) {
                    fw.write(l + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        return found;
    }
}
