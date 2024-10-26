/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Visitante;
import Model.Indicacion;
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
    private static final String RUTA_ARCHIVO_VISITANTES = "data/seguridad.csv";
    private static final String RUTA_ARCHIVO_INDICACIONES = "data/servicio.csv";
    private GestionarPropiedad gestionarPropiedad = new GestionarPropiedad();

    public boolean registrarVisita(Visitante visitante) {
        try {
            if (!gestionarPropiedad.existePropiedad(visitante.getIdPropiedad())) {
                System.out.println("La propiedad no existe.");
                return false;
            }

            List<Visitante> listaVisitantes = leerVisitantes();
            listaVisitantes.add(visitante);
            escribirVisitantes(listaVisitantes);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private List<Visitante> leerVisitantes() {
        List<Visitante> listaVisitantes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_ARCHIVO_VISITANTES))) {
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] valores = linea.split(",");
                Visitante visitante = new Visitante(
                        valores[0],
                        valores[1],
                        valores[2],
                        valores[3],
                        valores[4],
                        valores[5]
                );
                listaVisitantes.add(visitante);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaVisitantes;
    }

    private void escribirVisitantes(List<Visitante> listaVisitantes) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_ARCHIVO_VISITANTES))) {
            bw.write("idVisitante,nombreVisitante,idPropiedad,fechaEntrada,horaEntrada,motivo\n");
            for (Visitante visitante : listaVisitantes) {
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

    public boolean enviarIndicacion(Indicacion indicacion) {
        try {
            List<Indicacion> listaIndicaciones = leerIndicaciones();
            int nuevoId = listaIndicaciones.isEmpty() ? 1 : listaIndicaciones.get(listaIndicaciones.size() - 1).getIdIndicacion() + 1;
            indicacion.setIdIndicacion(nuevoId);
            listaIndicaciones.add(indicacion);
            escribirIndicaciones(listaIndicaciones);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private List<Indicacion> leerIndicaciones() {
        List<Indicacion> listaIndicaciones = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_ARCHIVO_INDICACIONES))) {
            String linea;
            br.readLine(); // Saltar encabezado
            while ((linea = br.readLine()) != null) {
                String[] valores = linea.split(",");
                Indicacion indicacion = new Indicacion(
                        Integer.parseInt(valores[0]),
                        valores[1],
                        Boolean.parseBoolean(valores[2])
                );
                listaIndicaciones.add(indicacion);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaIndicaciones;
    }

    private void escribirIndicaciones(List<Indicacion> listaIndicaciones) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_ARCHIVO_INDICACIONES))) {
            bw.write("idIndicacion,indicacion,estado\n");
            for (Indicacion indicacion : listaIndicaciones) {
                bw.write(String.format("%d,%s,%b\n",
                        indicacion.getIdIndicacion(),
                        indicacion.getIndicacion(),
                        indicacion.isEstado()
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}