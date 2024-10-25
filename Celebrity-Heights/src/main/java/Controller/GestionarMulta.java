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

/**
 *
 * @author spala
 */

public class GestionarMulta {
    private static final String FILE_PATH_MULTAS = "data/multas.json";
    private static final String FILE_PATH_MULTAS_PENDIENTES = "data/multasPendientes.json";
    private ObjectMapper mapper = new ObjectMapper();
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

            List<Multa> multas = leerMultas(FILE_PATH_MULTAS);
            List<Multa> multasPendientes = leerMultas(FILE_PATH_MULTAS_PENDIENTES);

            for (Multa m : multas) {
                if (m.getIdMulta().equals(multa.getIdMulta())) {
                    System.out.println("El ID de la multa no es único.");
                    return false;
                }
            }

            for (Multa m : multasPendientes) {
                if (m.getIdMulta().equals(multa.getIdMulta())) {
                    System.out.println("El ID de la multa no es único.");
                    return false;
                }
            }

            multasPendientes.add(multa);
            escribirMultas(multasPendientes, FILE_PATH_MULTAS_PENDIENTES);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private List<Multa> leerMultas(String filePath) {
        List<Multa> multas = new ArrayList<>();
        try {
            multas = mapper.readValue(new File(filePath), mapper.getTypeFactory().constructCollectionType(List.class, Multa.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return multas;
    }

    private void escribirMultas(List<Multa> multas, String filePath) {
        try {
            mapper.writeValue(new File(filePath), multas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Multa buscarMultaPorId(String idMulta) {
        List<Multa> multasPendientes = leerMultas(FILE_PATH_MULTAS_PENDIENTES);
        for (Multa multa : multasPendientes) {
            if (multa.getIdMulta().equals(idMulta)) {
                return multa;
            }
        }
        return null;
    }

    public boolean eliminarMultaPendiente(String idMulta) {
        List<Multa> multasPendientes = leerMultas(FILE_PATH_MULTAS_PENDIENTES);
        Multa multaAEliminar = null;
        for (Multa multa : multasPendientes) {
            if (multa.getIdMulta().equals(idMulta)) {
                multaAEliminar = multa;
                break;
            }
        }
        if (multaAEliminar != null) {
            multasPendientes.remove(multaAEliminar);
            escribirMultas(multasPendientes, FILE_PATH_MULTAS_PENDIENTES);
            return true;
        }
        return false;
    }

    public boolean reescribirMultas(String idMulta) {
        Multa multa = buscarMultaPorId(idMulta);
        if (multa != null) {
            List<Multa> multas = leerMultas(FILE_PATH_MULTAS);
            multas.add(multa);
            escribirMultas(multas, FILE_PATH_MULTAS);
            return eliminarMultaPendiente(idMulta);
        }
        return false;
    }

}