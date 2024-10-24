/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Empleado;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;

/**
 *
 * @author spala
 */

public class GestionarEmpleado implements Gentionar {
    private static final String FILE_PATH = "data/empleados.json";

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public boolean registrar(Object obj) {
        try {
            Empleado empleado = (Empleado) obj;
            List<Empleado> empleados = mapper.readValue(new File(FILE_PATH), mapper.getTypeFactory().constructCollectionType(List.class, Empleado.class));
            empleados.add(empleado);
            mapper.writeValue(new File(FILE_PATH), empleados);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Empleado leer(String id) {
        try {
            List<Empleado> empleados = mapper.readValue(new File(FILE_PATH), mapper.getTypeFactory().constructCollectionType(List.class, Empleado.class));
            return empleados.stream().filter(emp -> emp.getId().equals(id)).findFirst().orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean actualizar(Object obj) {
        try {
            Empleado empleado = (Empleado) obj;
            List<Empleado> empleados = mapper.readValue(new File(FILE_PATH), mapper.getTypeFactory().constructCollectionType(List.class, Empleado.class));
            for (int i = 0; i < empleados.size(); i++) {
                if (empleados.get(i).getId().equals(empleado.getId())) {
                    empleados.set(i, empleado);
                    mapper.writeValue(new File(FILE_PATH), empleados);
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
            List<Empleado> empleados = mapper.readValue(new File(FILE_PATH), mapper.getTypeFactory().constructCollectionType(List.class, Empleado.class));
            empleados.removeIf(emp -> emp.getId().equals(id));
            mapper.writeValue(new File(FILE_PATH), empleados);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String mostrar() {
        try {
            List<Empleado> empleados = mapper.readValue(new File(FILE_PATH), mapper.getTypeFactory().constructCollectionType(List.class, Empleado.class));
            StringBuilder sb = new StringBuilder();
            for (Empleado emp : empleados) {
                sb.append(emp.toString()).append("\n");
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}