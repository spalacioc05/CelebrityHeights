/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Multa;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author spala
 */

public class GestionarMulta {
    private static final String RUTA_ARCHIVO_MULTAS = "data/multas.json";
    private static final String RUTA_ARCHIVO_MULTAS_PENDIENTES = "data/multasPendientes.json";
    private ObjectMapper mapeador = new ObjectMapper();
    private GestionarPropietario gestionarPropietario = new GestionarPropietario();
    private GestionarPropiedad gestionarPropiedad = new GestionarPropiedad();

    public boolean registrarMulta(Multa multa) {
        try {
            if (!gestionarPropietario.existePropietario(multa.getIdPropietario())) {
                System.out.println("El propietario no existe.");
                return false;
            }

            if (!gestionarPropiedad.propiedadPerteneceAPropietario(multa.getIdPropiedad(), multa.getIdPropietario())) {
                System.out.println("La propiedad no pertenece al propietario.");
                return false;
            }

            List<Multa> listaMultas = leerMultas(RUTA_ARCHIVO_MULTAS);
            List<Multa> listaMultasPendientes = leerMultas(RUTA_ARCHIVO_MULTAS_PENDIENTES);

            for (Multa m : listaMultas) {
                if (m.getIdMulta() == multa.getIdMulta()) {
                    System.out.println("El ID de la multa no es único.");
                    return false;
                }
            }

            for (Multa m : listaMultasPendientes) {
                if (m.getIdMulta() == multa.getIdMulta()) {
                    System.out.println("El ID de la multa no es único.");
                    return false;
                }
            }

            listaMultasPendientes.add(multa);
            escribirMultas(listaMultasPendientes, RUTA_ARCHIVO_MULTAS_PENDIENTES);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private List<Multa> leerMultas(String rutaArchivo) {
        List<Multa> listaMultas = new ArrayList<>();
        try {
            listaMultas = mapeador.readValue(new File(rutaArchivo), mapeador.getTypeFactory().constructCollectionType(List.class, Multa.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaMultas;
    }

    private void escribirMultas(List<Multa> listaMultas, String rutaArchivo) {
        try {
            mapeador.writeValue(new File(rutaArchivo), listaMultas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Multa buscarMultaPorId(String idMulta) {
        List<Multa> listaMultasPendientes = leerMultas(RUTA_ARCHIVO_MULTAS_PENDIENTES);
        for (Multa multa : listaMultasPendientes) {
            if (multa.getIdMulta() == Integer.parseInt(idMulta)) {
                return multa;
            }
        }
        return null;
    }

    public boolean eliminarMultaPendiente(String idMulta) {
        List<Multa> listaMultasPendientes = leerMultas(RUTA_ARCHIVO_MULTAS_PENDIENTES);
        Multa multaAEliminar = null;
        for (Multa multa : listaMultasPendientes) {
            if (multa.getIdMulta() == Integer.parseInt(idMulta)) {
                multaAEliminar = multa;
                break;
            }
        }
        if (multaAEliminar != null) {
            listaMultasPendientes.remove(multaAEliminar);
            escribirMultas(listaMultasPendientes, RUTA_ARCHIVO_MULTAS_PENDIENTES);
            return true;
        }
        return false;
    }

    public boolean reescribirMultas(String idMulta) {
        Multa multa = buscarMultaPorId(idMulta);
        if (multa != null) {
            List<Multa> listaMultas = leerMultas(RUTA_ARCHIVO_MULTAS);
            listaMultas.add(multa);
            escribirMultas(listaMultas, RUTA_ARCHIVO_MULTAS);
            return eliminarMultaPendiente(idMulta);
        }
        return false;
    }

    public int generarIdUnico() {
        Random random = new Random();
        List<Multa> listaMultas = leerMultas(RUTA_ARCHIVO_MULTAS);
        List<Multa> listaMultasPendientes = leerMultas(RUTA_ARCHIVO_MULTAS_PENDIENTES);
        int id;
        boolean idUnico;

        do {
            id = 10000 + random.nextInt(90000);
            idUnico = true;

            for (Multa m : listaMultas) {
                if (m.getIdMulta() == id) {
                    idUnico = false;
                    break;
                }
            }

            if (idUnico) {
                for (Multa m : listaMultasPendientes) {
                    if (m.getIdMulta() == id) {
                        idUnico = false;
                        break;
                    }
                }
            }
        } while (!idUnico);

        return id;
    }

}