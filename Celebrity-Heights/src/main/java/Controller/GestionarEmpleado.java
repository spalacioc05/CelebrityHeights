/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Empleado;
import Model.Propietario;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;
/**
 *
 * @author spala
 */

public class GestionarEmpleado implements GestionarPersona {
    private static final String RUTA_ARCHIVO = "data/empleados.json";
    private ObjectMapper mapeador = new ObjectMapper();

    @Override
    public boolean registrar(Object obj) {
        try {
            Empleado empleado = (Empleado) obj;
            List<Empleado> listaEmpleados = mapeador.readValue(new File(RUTA_ARCHIVO), mapeador.getTypeFactory().constructCollectionType(List.class, Empleado.class));
            listaEmpleados.add(empleado);
            mapeador.writeValue(new File(RUTA_ARCHIVO), listaEmpleados);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Empleado leer(String id) {
        try {
            List<Empleado> listaEmpleados = mapeador.readValue(new File(RUTA_ARCHIVO), mapeador.getTypeFactory().constructCollectionType(List.class, Empleado.class));
            return listaEmpleados.stream().filter(emp -> emp.getId().equals(id)).findFirst().orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean actualizar(Object obj) {
        try {
            Empleado empleado = (Empleado) obj;
            List<Empleado> listaEmpleados = mapeador.readValue(new File(RUTA_ARCHIVO), mapeador.getTypeFactory().constructCollectionType(List.class, Empleado.class));
            for (int i = 0; i < listaEmpleados.size(); i++) {
                if (listaEmpleados.get(i).getId().equals(empleado.getId())) {
                    listaEmpleados.set(i, empleado);
                    mapeador.writeValue(new File(RUTA_ARCHIVO), listaEmpleados);
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
            List<Empleado> listaEmpleados = mapeador.readValue(new File(RUTA_ARCHIVO), mapeador.getTypeFactory().constructCollectionType(List.class, Empleado.class));
            listaEmpleados.removeIf(emp -> emp.getId().equals(id));
            mapeador.writeValue(new File(RUTA_ARCHIVO), listaEmpleados);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String mostrar() {
        try {
            List<Empleado> listaEmpleados = mapeador.readValue(new File(RUTA_ARCHIVO), mapeador.getTypeFactory().constructCollectionType(List.class, Empleado.class));
            StringBuilder sb = new StringBuilder();
            for (Empleado emp : listaEmpleados) {
                sb.append(emp.toString()).append("\n");
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean existeIdEnArchivos(String id) {
        try {
            List<Propietario> listaPropietarios = mapeador.readValue(new File("data/propietariosPropiedades.json"), mapeador.getTypeFactory().constructCollectionType(List.class, Propietario.class));
            if (listaPropietarios.stream().anyMatch(prop -> prop.getId().equals(id))) {
                return true;
            }

            List<Empleado> listaEmpleados = mapeador.readValue(new File(RUTA_ARCHIVO), mapeador.getTypeFactory().constructCollectionType(List.class, Empleado.class));
            return listaEmpleados.stream().anyMatch(emp -> emp.getId().equals(id));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}