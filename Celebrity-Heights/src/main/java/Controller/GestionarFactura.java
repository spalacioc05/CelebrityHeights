/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Factura;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author spala
 */

public class GestionarFactura {
    private static final String FILE_PATH = "data/facturas.csv";
    private GestionarPropietario gestionarPropietario = new GestionarPropietario();
    private GestionarPropiedad gestionarPropiedad = new GestionarPropiedad();

    public boolean registrarFactura(Factura factura) {
        try {
            if (!gestionarPropietario.existePropietario(factura.getIdPropietario())) {
                System.out.println("El propietario no existe.");
                return false;
            }

            if (!gestionarPropiedad.propiedadPerteneceAPropietario(factura.getIdPropiedad(), factura.getIdPropietario())) {
                System.out.println("La propiedad no pertenece al propietario.");
                return false;
            }

            List<Factura> facturas = leerFacturas();
            for (Factura f : facturas) {
                if (f.getIdFactura().equals(factura.getIdFactura())) {
                    System.out.println("El ID de la factura no es único.");
                    return false;
                }
            }

            facturas.add(factura);
            escribirFacturas(facturas);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private List<Factura> leerFacturas() {
        List<Factura> facturas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Factura factura = new Factura(
                        values[0],
                        values[1],
                        values[2],
                        values[3],
                        values[4],
                        values[5],
                        values[6],
                        Double.parseDouble(values[7]),
                        Double.parseDouble(values[8]),
                        Double.parseDouble(values[9]),
                        Boolean.parseBoolean(values[10])
                );
                facturas.add(factura);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return facturas;
    }

    private void escribirFacturas(List<Factura> facturas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            bw.write("idFactura,idPropiedad,idPropietario,fechaExpedicion,fechaVencimiento,fechaPago,tipoFactura,monto,iva,montoTotal,pagado\n");
            for (Factura factura : facturas) {
                bw.write(String.format("%s,%s,%s,%s,%s,%s,%s,%.2f,%.2f,%.2f,%b\n",
                        factura.getIdFactura(),
                        factura.getIdPropiedad(),
                        factura.getIdPropietario(),
                        factura.getFechaExpedicion(),
                        factura.getFechaVencimiento(),
                        factura.getFechaPago(),
                        factura.getTipoFactura(),
                        factura.getMonto(),
                        factura.getIva(),
                        factura.getMontoTotal(),
                        factura.isPagado()
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}