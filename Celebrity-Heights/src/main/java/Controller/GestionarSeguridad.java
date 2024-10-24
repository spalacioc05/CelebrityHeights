/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Visitante;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author spala
 */


public class GestionarSeguridad {
    private static final String FILE_PATH = "data/seguridad.csv";
    private GestionarPropiedad gestionarPropiedad = new GestionarPropiedad();

    public boolean registrarVisita(Visitante visitante) {
        try {
            if (!gestionarPropiedad.existePropiedad(visitante.getIdPropiedad())) {
                System.out.println("La propiedad no existe.");
                return false;
            }

            List<Visitante> visitantes = leerVisitantes();
            visitantes.add(visitante);
            escribirVisitantes(visitantes);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private List<Visitante> leerVisitantes() {
        List<Visitante> visitantes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Visitante visitante = new Visitante(
                        values[0],
                        values[1],
                        values[2],
                        values[3],
                        values[4],
                        values[5]
                );
                visitantes.add(visitante);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return visitantes;
    }

    private void escribirVisitantes(List<Visitante> visitantes) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            bw.write("idVisitante,nombreVisitante,idPropiedad,fechaEntrada,horaEntrada,motivo\n");
            for (Visitante visitante : visitantes) {
                bw.write(String.format("%s,%s,%s,%s,%s,%s\n",
                        visitante.getIdVisitante(),
                        visitante.getNombreVisitante(),
                        visitante.getIdPropiedad(),
                        visitante.getFechaEntrada(),
                        visitante.getHoraEntrada(),
                        visitante.getMotivo()
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}