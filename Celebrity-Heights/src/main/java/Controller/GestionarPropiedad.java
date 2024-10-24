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

    private static final String FILE_PATH = "data/propietariosPropiedades.json";
    private ObjectMapper mapper = new ObjectMapper();
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

            List<Propietario> propietarios = mapper.readValue(new File(FILE_PATH), mapper.getTypeFactory().constructCollectionType(List.class, Propietario.class));
            for (Propietario propietario : propietarios) {
                if (propietario.getId().equals(idPropietario)) {
                    if (propietario.getPropiedades() == null) {
                        propietario.setPropiedades(new ArrayList<>());
                    }
                    propietario.getPropiedades().add(propiedad);
                    mapper.writeValue(new File(FILE_PATH), propietarios);
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
            List<Propietario> propietarios = mapper.readValue(new File(FILE_PATH), mapper.getTypeFactory().constructCollectionType(List.class, Propietario.class));
            for (Propietario propietario : propietarios) {
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
            List<Propietario> propietarios = mapper.readValue(new File(FILE_PATH), mapper.getTypeFactory().constructCollectionType(List.class, Propietario.class));
            for (Propietario propietario : propietarios) {
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