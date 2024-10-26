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
import java.util.Random;

/**
 *
 * @author spala
 */

public class GestionarFactura {
    private static final String RUTA_ARCHIVO = "data/facturas.csv";
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

            List<Factura> listaFacturas = leerFacturas();
            for (Factura f : listaFacturas) {
                if (f.getIdFactura() == factura.getIdFactura()) {
                    System.out.println("El ID de la factura no es único.");
                    return false;
                }
            }

            listaFacturas.add(factura);
            escribirFacturas(listaFacturas);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private List<Factura> leerFacturas() {
        List<Factura> listaFacturas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
            String linea;
            br.readLine(); // Saltar encabezado
            while ((linea = br.readLine()) != null) {
                String[] valores = linea.split(",");
                Factura factura = new Factura(
                        Integer.parseInt(valores[0]),
                        valores[1],
                        valores[2],
                        valores[3],
                        valores[4],
                        valores[5],
                        valores[6],
                        Double.parseDouble(valores[7]),
                        Double.parseDouble(valores[8]),
                        Double.parseDouble(valores[9]),
                        Boolean.parseBoolean(valores[10])
                );
                listaFacturas.add(factura);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaFacturas;
    }

    private void escribirFacturas(List<Factura> listaFacturas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_ARCHIVO))) {
            bw.write("idFactura,idPropiedad,idPropietario,fechaExpedicion,fechaVencimiento,fechaPago,tipoFactura,monto,iva,montoTotal,pagado\n");
            for (Factura factura : listaFacturas) {
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

    public int generarIdFacturaUnico() {
        Random random = new Random();
        List<Factura> listaFacturas = leerFacturas();
        int idFactura;
        boolean idUnico;

        do {
            idFactura = 10000 + random.nextInt(90000);
            idUnico = true;
            for (Factura factura : listaFacturas) {
                if (factura.getIdFactura() == idFactura) {
                    idUnico = false;
                    break;
                }
            }
        } while (!idUnico);

        return idFactura;
    }
}