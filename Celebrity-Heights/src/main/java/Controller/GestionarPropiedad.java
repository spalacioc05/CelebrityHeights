/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Propiedad;
import Model.Propietario;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author spala
 */


public class GestionarPropiedad {

    private static final String RUTA_ARCHIVO = "data/propietariosPropiedades.json";
    private ObjectMapper mapeador = new ObjectMapper();
    private GestionarPropietario gestionarPropietario = new GestionarPropietario();

    public boolean registrarPropiedad(String idPropietario, Propiedad propiedad) {
        try {
            if (!gestionarPropietario.existePropietario(idPropietario)) {
                System.out.println("El propietario no existe.");
                return false;
            }

            if (!gestionarPropietario.esIdPropiedadUnico(propiedad.getIdPropiedad())) {
                System.out.println("El ID de la propiedad no es único.");
                return false;
            }

            List<Propietario> listaPropietarios = mapeador.readValue(new File(RUTA_ARCHIVO), mapeador.getTypeFactory().constructCollectionType(List.class, Propietario.class));
            for (Propietario propietario : listaPropietarios) {
                if (propietario.getId().equals(idPropietario)) {
                    if (propietario.getPropiedades() == null) {
                        propietario.setPropiedades(new ArrayList<>());
                    }
                    propietario.getPropiedades().add(propiedad);
                    mapeador.writeValue(new File(RUTA_ARCHIVO), listaPropietarios);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean propiedadPerteneceAPropietario(String idPropiedad, String idPropietario) {
        try {
            List<Propietario> listaPropietarios = mapeador.readValue(new File(RUTA_ARCHIVO), mapeador.getTypeFactory().constructCollectionType(List.class, Propietario.class));
            for (Propietario propietario : listaPropietarios) {
                if (propietario.getId().equals(idPropietario)) {
                    if (propietario.getPropiedades() != null) {
                        for (Propiedad propiedad : propietario.getPropiedades()) {
                            if (propiedad.getIdPropiedad().equals(idPropiedad)) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean existePropiedad(String idPropiedad) {
        try {
            List<Propietario> listaPropietarios = mapeador.readValue(new File(RUTA_ARCHIVO), mapeador.getTypeFactory().constructCollectionType(List.class, Propietario.class));
            for (Propietario propietario : listaPropietarios) {
                if (propietario.getPropiedades() != null) {
                    for (Propiedad propiedad : propietario.getPropiedades()) {
                        if (propiedad.getIdPropiedad().equals(idPropiedad)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}