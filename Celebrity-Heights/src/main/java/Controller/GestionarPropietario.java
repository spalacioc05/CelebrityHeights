/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Propiedad;
import Model.Propietario;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author spala
 */

public class GestionarPropietario implements Gentionar {

    private static final String FILE_PATH = "data/propietariosPropiedades.json";
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public boolean registrar(Object obj) {
        try {
            Propietario propietario = (Propietario) obj;
            List<Propietario> propietarios = mapper.readValue(new File(FILE_PATH), mapper.getTypeFactory().constructCollectionType(List.class, Propietario.class));
            propietarios.add(propietario);
            mapper.writeValue(new File(FILE_PATH), propietarios);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Propietario leer(String id) {
        try {
            List<Propietario> propietarios = mapper.readValue(new File(FILE_PATH), mapper.getTypeFactory().constructCollectionType(List.class, Propietario.class));
            return propietarios.stream().filter(prop -> prop.getId().equals(id)).findFirst().orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean actualizar(Object obj) {
        try {
            Propietario propietario = (Propietario) obj;
            List<Propietario> propietarios = mapper.readValue(new File(FILE_PATH), mapper.getTypeFactory().constructCollectionType(List.class, Propietario.class));
            for (int i = 0; i < propietarios.size(); i++) {
                if (propietarios.get(i).getId().equals(propietario.getId())) {
                    propietarios.set(i, propietario);
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

    @Override
    public boolean eliminar(String id) {
        try {
            List<Propietario> propietarios = mapper.readValue(new File(FILE_PATH), mapper.getTypeFactory().constructCollectionType(List.class, Propietario.class));
            propietarios.removeIf(prop -> prop.getId().equals(id));
            mapper.writeValue(new File(FILE_PATH), propietarios);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String mostrar() {
        try {
            List<Propietario> propietarios = mapper.readValue(new File(FILE_PATH), mapper.getTypeFactory().constructCollectionType(List.class, Propietario.class));
            StringBuilder sb = new StringBuilder();
            for (Propietario prop : propietarios) {
                sb.append(prop.toString()).append("\n");
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean existePropietario(String id) {
        try {
            List<Propietario> propietarios = mapper.readValue(new File(FILE_PATH), mapper.getTypeFactory().constructCollectionType(List.class, Propietario.class));
            return propietarios.stream().anyMatch(prop -> prop.getId().equals(id));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean esIdPropiedadUnico(String idPropiedad) {
        try {
            List<Propietario> propietarios = mapper.readValue(new File(FILE_PATH), mapper.getTypeFactory().constructCollectionType(List.class, Propietario.class));
            for (Propietario propietario : propietarios) {
                if (propietario.getPropiedades() != null) {
                    for (Propiedad propiedad : propietario.getPropiedades()) {
                        if (propiedad.getIdPropiedad().equals(idPropiedad)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Map<String, String> obtenerProfesionOcupacionVecinos(String idPropiedad) {
        Map<String, String> resultado = new HashMap<>();
        try {
            int idPropiedadInt = Integer.parseInt(idPropiedad);
            String idPropiedadMenosUno = String.valueOf(idPropiedadInt - 1);
            String idPropiedadMasUno = String.valueOf(idPropiedadInt + 1);

            List<Propietario> propietarios = mapper.readValue(new File(FILE_PATH), mapper.getTypeFactory().constructCollectionType(List.class, Propietario.class));

            Optional<Propietario> propietarioMenosUno = propietarios.stream()
                .filter(prop -> prop.getPropiedades() != null)
                .flatMap(prop -> prop.getPropiedades().stream())
                .filter(prop -> prop.getIdPropiedad().equals(idPropiedadMenosUno))
                .map(prop -> propietarios.stream().filter(p -> p.getPropiedades().contains(prop)).findFirst().orElse(null))
                .findFirst();

            Optional<Propietario> propietarioMasUno = propietarios.stream()
                .filter(prop -> prop.getPropiedades() != null)
                .flatMap(prop -> prop.getPropiedades().stream())
                .filter(prop -> prop.getIdPropiedad().equals(idPropiedadMasUno))
                .map(prop -> propietarios.stream().filter(p -> p.getPropiedades().contains(prop)).findFirst().orElse(null))
                .findFirst();

            propietarioMenosUno.ifPresent(prop -> {
                resultado.put("idPropiedadMenosUno", idPropiedadMenosUno);
                resultado.put("profesionMenosUno", prop.getProfesion());
                resultado.put("ocupacionMenosUno", prop.getOcupacion());
            });

            propietarioMasUno.ifPresent(prop -> {
                resultado.put("idPropiedadMasUno", idPropiedadMasUno);
                resultado.put("profesionMasUno", prop.getProfesion());
                resultado.put("ocupacionMasUno", prop.getOcupacion());
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }
}