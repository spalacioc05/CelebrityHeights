/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Empleado;
import Model.Factura;
import Model.HorarioZonaComun;
import Model.Indicacion;
import Model.Multa;
import Model.Propiedad;
import Model.Propietario;
import Model.Visitante;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Desktop;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
/**
 *
 * @author spala
 */

public class Listar {

    protected static final String EMPLEADOS = "data/empleados.json";
    protected static final String PROPIETARIOS_PROPIEDADES = "data/propietariosPropiedades.json";
    protected static final String FACTURAS = "data/facturas.csv";
    protected static final String MULTAS = "data/multas.json";
    protected static final String MULTAS_PENDIENTES = "data/multasPendientes.json";
    protected static final String SEGURIDAD = "data/seguridad.csv";
    protected static final String HORARIO_ZONAS_COMUNES = "data/horarioZonasComunes.csv";
    protected static final String SERVICIO = "data/servicio.csv";

        // Inside the ListarEmpleadosPDF method
    public boolean ListarEmpleadosPDF() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Leer el archivo JSON y mapearlo a una lista de objetos Empleado
            List<Empleado> empleados = objectMapper.readValue(new File(EMPLEADOS), objectMapper.getTypeFactory().constructCollectionType(List.class, Empleado.class));
    
            // Crear un documento PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("archivosPDF/ListarEmpleados.pdf"));
            document.open();
    
            // Crear un título en negrita
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Paragraph title = new Paragraph("Lista de Empleados", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
    
            // Agregar un espacio entre el título y la tabla
            document.add(new Paragraph(" "));
    
            // Crear una tabla con las columnas necesarias
            PdfPTable table = new PdfPTable(9); // 9 columnas
            table.setWidthPercentage(100);
    
            // Agregar encabezados de columna en negrita
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 8);
            String[] headers = {"ID", "Rol", "Nombre", "Cargo", "Telefono", "Correo", "Fecha Nacimiento", "Fecha Contratacion", "Salario"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell();
                cell.setPhrase(new Phrase(header, headerFont));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }
    
            // Agregar datos de los empleados con tamaño de fuente 11
            Font dataFont = FontFactory.getFont(FontFactory.HELVETICA, 8);
            for (Empleado empleado : empleados) {
                table.addCell(new Phrase(empleado.getId(), dataFont));
                table.addCell(new Phrase(empleado.getRol(), dataFont));
                table.addCell(new Phrase(empleado.getNombre(), dataFont));
                table.addCell(new Phrase(empleado.getCargo(), dataFont));
                table.addCell(new Phrase(empleado.getTelefono(), dataFont));
                table.addCell(new Phrase(empleado.getCorreo(), dataFont));
                table.addCell(new Phrase(empleado.getFechaNacimiento(), dataFont));
                table.addCell(new Phrase(empleado.getFechaContratacion(), dataFont));
                table.addCell(new Phrase(String.valueOf(empleado.getSalario()), dataFont));
            }
    
            // Agregar la tabla al documento
            document.add(table);
            document.close();
    
            // Abrir el PDF generado
            File pdfFile = new File("archivosPDF/ListarEmpleados.pdf");
            if (pdfFile.exists()) {
                Desktop.getDesktop().open(pdfFile);
            }
    
            return true; // Proceso exitoso
    
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
            return false; // Ocurrió un error
        }
    }

    public boolean ListarPropietariosPDF() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Propietario> propietarios = objectMapper.readValue(new File(PROPIETARIOS_PROPIEDADES), objectMapper.getTypeFactory().constructCollectionType(List.class, Propietario.class));
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("archivosPDF/ListarPropietarios.pdf"));
            document.open();
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Paragraph title = new Paragraph("Lista de Propietarios", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph(" "));
            PdfPTable table = new PdfPTable(9);
            table.setWidthPercentage(100);
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 8);
            String[] headers = {"ID", "Rol", "Nombre", "Profesion", "Ocupacion", "Telefono", "Correo", "Fecha Nacimiento", "Propiedades"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell();
                cell.setPhrase(new Phrase(header, headerFont));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }
            Font dataFont = FontFactory.getFont(FontFactory.HELVETICA, 8);
            for (Propietario propietario : propietarios) {
                table.addCell(new Phrase(propietario.getId(), dataFont));
                table.addCell(new Phrase(propietario.getRol(), dataFont));
                table.addCell(new Phrase(propietario.getNombre(), dataFont));
                table.addCell(new Phrase(propietario.getProfesion(), dataFont));
                table.addCell(new Phrase(propietario.getOcupacion(), dataFont));
                table.addCell(new Phrase(propietario.getTelefono(), dataFont));
                table.addCell(new Phrase(propietario.getCorreo(), dataFont));
                table.addCell(new Phrase(propietario.getFechaNacimiento(), dataFont));
                table.addCell(new Phrase(propietario.getPropiedades() == null ? "0" : String.valueOf(propietario.getPropiedades().size()), dataFont));
            }
            document.add(table);
            document.close();
            File pdfFile = new File("archivosPDF/ListarPropietarios.pdf");
            if (pdfFile.exists()) {
                Desktop.getDesktop().open(pdfFile);
            }
            return true;
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean ListarPropiedadesPDF() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Propietario> propietarios = objectMapper.readValue(new File(PROPIETARIOS_PROPIEDADES), objectMapper.getTypeFactory().constructCollectionType(List.class, Propietario.class));
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("archivosPDF/ListarPropiedades.pdf"));
            document.open();
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Paragraph title = new Paragraph("Lista de Propiedades", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph(" "));
            PdfPTable table = new PdfPTable(10);
            table.setWidthPercentage(100);
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 8);
            String[] headers = {"ID Propiedad", "Direccion", "Tamaño (m2)", "Habitaciones", "Baños", "Precio (m2)", "Fecha Adquisicion", "Valor Administracion", "ID Propietario", "Nombre Propietario"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell();
                cell.setPhrase(new Phrase(header, headerFont));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }
            Font dataFont = FontFactory.getFont(FontFactory.HELVETICA, 8);
            for (Propietario propietario : propietarios) {
                if (propietario.getPropiedades() == null) {
                    continue; // Skip this propietario if propiedades is null
                }
                for (Propiedad propiedad : propietario.getPropiedades()) {
                    table.addCell(new Phrase(propiedad.getIdPropiedad(), dataFont));
                    table.addCell(new Phrase(propiedad.getDireccionPropiedad(), dataFont));
                    table.addCell(new Phrase(String.valueOf(propiedad.getSizeM2()), dataFont));
                    table.addCell(new Phrase(String.valueOf(propiedad.getHabitaciones()), dataFont));
                    table.addCell(new Phrase(String.valueOf(propiedad.getBathrooms()), dataFont));
                    table.addCell(new Phrase(String.valueOf(propiedad.getPrecioM2()), dataFont));
                    table.addCell(new Phrase(propiedad.getFechaAdquisicion(), dataFont));
                    table.addCell(new Phrase(String.valueOf(propiedad.getValorAdministracion()), dataFont));
                    table.addCell(new Phrase(propietario.getId(), dataFont));
                    table.addCell(new Phrase(propietario.getNombre(), dataFont));
                }
            }
            document.add(table);
            document.close();
            File pdfFile = new File("archivosPDF/ListarPropiedades.pdf");
            if (pdfFile.exists()) {
                Desktop.getDesktop().open(pdfFile);
            }
            return true;
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean ListarFacturasPDF() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Leer el archivo CSV y mapearlo a una lista de objetos Factura
            List<Factura> facturas = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(FACTURAS));
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Factura factura = new Factura(
                        Integer.parseInt(values[0]),
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
            br.close();

            // Leer el archivo JSON y mapearlo a una lista de objetos Propietario
            List<Propietario> propietarios = objectMapper.readValue(new File(PROPIETARIOS_PROPIEDADES), objectMapper.getTypeFactory().constructCollectionType(List.class, Propietario.class));
            Map<Integer, Propietario> propietarioMap = new HashMap<>();
            for (Propietario propietario : propietarios) {
                propietarioMap.put(Integer.parseInt(propietario.getId()), propietario);
            }

            // Crear un documento PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("archivosPDF/ListarFacturas.pdf"));
            document.open();

            // Crear un título en negrita
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Paragraph title = new Paragraph("Lista de Facturas", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Agregar un espacio entre el título y la tabla
            document.add(new Paragraph(" "));

            // Crear una tabla con las columnas necesarias
            PdfPTable table = new PdfPTable(11); // 11 columnas
            table.setWidthPercentage(100);

            // Agregar encabezados de columna en negrita
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 8);
            String[] headers = {"ID Factura", "ID Propiedad", "ID Propietario", "Fecha Expedicion", "Fecha Vencimiento", "Fecha Pago", "Tipo Factura", "Monto", "IVA", "Monto Total", "Pagado"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell();
                cell.setPhrase(new Phrase(header, headerFont));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }

            // Agregar datos de las facturas con tamaño de fuente 8
            Font dataFont = FontFactory.getFont(FontFactory.HELVETICA, 8);
            for (Factura factura : facturas) {
                table.addCell(new Phrase(String.valueOf(factura.getIdFactura()), dataFont));
                table.addCell(new Phrase(String.valueOf(factura.getIdPropiedad()), dataFont));
                table.addCell(new Phrase(String.valueOf(factura.getIdPropietario()), dataFont));
                table.addCell(new Phrase(factura.getFechaExpedicion(), dataFont));
                table.addCell(new Phrase(factura.getFechaVencimiento(), dataFont));
                table.addCell(new Phrase(factura.getFechaPago(), dataFont));
                table.addCell(new Phrase(factura.getTipoFactura(), dataFont));
                table.addCell(new Phrase(String.valueOf(factura.getMonto()), dataFont));
                table.addCell(new Phrase(String.valueOf(factura.getIva()), dataFont));
                table.addCell(new Phrase(String.valueOf(factura.getMontoTotal()), dataFont));
                table.addCell(new Phrase(String.valueOf(factura.isPagado()), dataFont));
            }

            // Agregar la tabla al documento
            document.add(table);
            document.close();

            // Abrir el PDF generado
            File pdfFile = new File("archivosPDF/ListarFacturas.pdf");
            if (pdfFile.exists()) {
                Desktop.getDesktop().open(pdfFile);
            }

            return true; // Proceso exitoso

        } catch (IOException | DocumentException e) {
            e.printStackTrace();
            return false; // Ocurrió un error
        }
    }
    
    public boolean ListarMultasPDF() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Leer el archivo JSON y mapearlo a una lista de objetos Multa
            List<Multa> multas = objectMapper.readValue(new File(MULTAS), objectMapper.getTypeFactory().constructCollectionType(List.class, Multa.class));
    
            // Crear un documento PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("archivosPDF/ListarMultas.pdf"));
            document.open();
    
            // Crear un título en negrita
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Paragraph title = new Paragraph("Lista de Multas", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
    
            // Agregar un espacio entre el título y la tabla
            document.add(new Paragraph(" "));
    
            // Crear una tabla con las columnas necesarias
            PdfPTable table = new PdfPTable(11); // 11 columnas
            table.setWidthPercentage(100);
    
            // Agregar encabezados de columna en negrita
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 8);
            String[] headers = {"ID Multa", "ID Propiedad", "ID Propietario", "Fecha Expedicion", "Fecha Vencimiento", "Fecha Pago", "Motivo", "Monto", "IVA", "Monto Total", "Pagado"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell();
                cell.setPhrase(new Phrase(header, headerFont));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }
    
            // Agregar datos de las multas con tamaño de fuente 8
            Font dataFont = FontFactory.getFont(FontFactory.HELVETICA, 8);
            for (Multa multa : multas) {
                table.addCell(new Phrase(String.valueOf(multa.getIdMulta()), dataFont));
                table.addCell(new Phrase(multa.getIdPropiedad(), dataFont));
                table.addCell(new Phrase(multa.getIdPropietario(), dataFont));
                table.addCell(new Phrase(multa.getFechaExpedicion(), dataFont));
                table.addCell(new Phrase(multa.getFechaVencimiento(), dataFont));
                table.addCell(new Phrase(multa.getFechaPago(), dataFont));
                table.addCell(new Phrase(multa.getMotivo(), dataFont));
                table.addCell(new Phrase(String.valueOf(multa.getMonto()), dataFont));
                table.addCell(new Phrase(String.valueOf(multa.getIva()), dataFont));
                table.addCell(new Phrase(String.valueOf(multa.getMontoTotal()), dataFont));
                table.addCell(new Phrase(String.valueOf(multa.isPagado()), dataFont));
            }
    
            // Agregar la tabla al documento
            document.add(table);
            document.close();
    
            // Abrir el PDF generado
            File pdfFile = new File("archivosPDF/ListarMultas.pdf");
            if (pdfFile.exists()) {
                Desktop.getDesktop().open(pdfFile);
            }
    
            return true; // Proceso exitoso
    
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
            return false; // Ocurrió un error
        }
    }

    public boolean ListarVisitantesPDF() {
        try {
            // Leer el archivo CSV y mapearlo a una lista de objetos Visitante
            List<Visitante> visitantes = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(SEGURIDAD));
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Visitante visitante = new Visitante(
                        values[0],
                        values[1],
                        values[2],
                        values[3],
                        values[4],
                        values[5]
                );
                visitantes.add(visitante);
            }
            br.close();

            // Crear un documento PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("archivosPDF/ListarVisitantes.pdf"));
            document.open();

            // Crear un título en negrita
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Paragraph title = new Paragraph("Lista de Visitantes", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Agregar un espacio entre el título y la tabla
            document.add(new Paragraph(" "));

            // Crear una tabla con las columnas necesarias
            PdfPTable table = new PdfPTable(6); // 6 columnas
            table.setWidthPercentage(100);

            // Agregar encabezados de columna en negrita
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 8);
            String[] headers = {"ID Visitante", "Nombre Visitante", "ID Propiedad", "Fecha Entrada", "Hora Entrada", "Motivo"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell();
                cell.setPhrase(new Phrase(header, headerFont));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }

            // Agregar datos de los visitantes con tamaño de fuente 8
            Font dataFont = FontFactory.getFont(FontFactory.HELVETICA, 8);
            for (Visitante visitante : visitantes) {
                table.addCell(new Phrase(visitante.getIdVisitante(), dataFont));
                table.addCell(new Phrase(visitante.getNombreVisitante(), dataFont));
                table.addCell(new Phrase(visitante.getIdPropiedad(), dataFont));
                table.addCell(new Phrase(visitante.getFechaEntrada(), dataFont));
                table.addCell(new Phrase(visitante.getHoraEntrada(), dataFont));
                table.addCell(new Phrase(visitante.getMotivo(), dataFont));
            }

            // Agregar la tabla al documento
            document.add(table);
            document.close();

            // Abrir el PDF generado
            File pdfFile = new File("archivosPDF/ListarVisitantes.pdf");
            if (pdfFile.exists()) {
                Desktop.getDesktop().open(pdfFile);
            }

            return true; // Proceso exitoso

        } catch (IOException | DocumentException e) {
            e.printStackTrace();
            return false; // Ocurrió un error
        }
    }

    public boolean ListarHorarioZonasComunesPDF() {
        try {
            // Leer el archivo CSV y mapearlo a una lista de objetos HorarioZonaComun
            List<HorarioZonaComun> horarios = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(HORARIO_ZONAS_COMUNES));
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                HorarioZonaComun horario = new HorarioZonaComun(
                        values[0],
                        values[1],
                        values[2],
                        values[3]
                );
                horarios.add(horario);
            }
            br.close();

            // Crear un documento PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("archivosPDF/HorarioZonasComunes.pdf"));
            document.open();

            // Crear un título en negrita
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Paragraph title = new Paragraph("Horario de Zonas Comunes", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Agregar un espacio entre el título y la tabla
            document.add(new Paragraph(" "));

            // Crear una tabla con las columnas necesarias
            PdfPTable table = new PdfPTable(4); // 4 columnas
            table.setWidthPercentage(100);

            // Agregar encabezados de columna en negrita
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 8);
            String[] headers = {"Zona Común", "Hora Apertura", "Hora Cierre", "Días Disponibles"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell();
                cell.setPhrase(new Phrase(header, headerFont));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }

            // Agregar datos de los horarios con tamaño de fuente 8
            Font dataFont = FontFactory.getFont(FontFactory.HELVETICA, 8);
            for (HorarioZonaComun horario : horarios) {
                table.addCell(new Phrase(horario.getZonaComun(), dataFont));
                table.addCell(new Phrase(horario.getHoraApertura(), dataFont));
                table.addCell(new Phrase(horario.getHoraCierre(), dataFont));
                table.addCell(new Phrase(horario.getDiasDisponibles(), dataFont));
            }

            // Agregar la tabla al documento
            document.add(table);
            document.close();

            // Abrir el PDF generado
            File pdfFile = new File("archivosPDF/HorarioZonasComunes.pdf");
            if (pdfFile.exists()) {
                Desktop.getDesktop().open(pdfFile);
            }

            return true; // Proceso exitoso

        } catch (IOException | DocumentException e) {
            e.printStackTrace();
            return false; // Ocurrió un error
        }
    }

    public boolean ListarIndicacionesPDF() {
        try {
            // Leer el archivo CSV y mapearlo a una lista de objetos Indicacion
            List<Indicacion> indicaciones = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(SERVICIO));
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Indicacion indicacion = new Indicacion(
                        Integer.parseInt(values[0]),
                        values[1],
                        Boolean.parseBoolean(values[2])
                );
                indicaciones.add(indicacion);
            }
            br.close();
    
            // Crear un documento PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("archivosPDF/ListarIndicaciones.pdf"));
            document.open();
    
            // Crear un título en negrita
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Paragraph title = new Paragraph("Lista de Indicaciones", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
    
            // Agregar un espacio entre el título y la tabla
            document.add(new Paragraph(" "));
    
            // Crear una tabla con las columnas necesarias
            PdfPTable table = new PdfPTable(3); // 3 columnas
            table.setWidthPercentage(100);
    
            // Agregar encabezados de columna en negrita
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 8);
            String[] headers = {"ID Indicacion", "Indicacion", "Estado"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell();
                cell.setPhrase(new Phrase(header, headerFont));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }
    
            // Agregar datos de las indicaciones con tamaño de fuente 8
            Font dataFont = FontFactory.getFont(FontFactory.HELVETICA, 8);
            for (Indicacion indicacion : indicaciones) {
                table.addCell(new Phrase(String.valueOf(indicacion.getIdIndicacion()), dataFont));
                table.addCell(new Phrase(indicacion.getIndicacion(), dataFont));
                table.addCell(new Phrase(String.valueOf(indicacion.isEstado()), dataFont));
            }
    
            // Agregar la tabla al documento
            document.add(table);
            document.close();
    
            // Abrir el PDF generado
            File pdfFile = new File("archivosPDF/ListarIndicaciones.pdf");
            if (pdfFile.exists()) {
                Desktop.getDesktop().open(pdfFile);
            }
    
            return true; // Proceso exitoso
    
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
            return false; // Ocurrió un error
        }
    }

    public boolean ListarMultasPendientesPDF() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Leer el archivo JSON y mapearlo a una lista de objetos Multa
            List<Multa> multas = objectMapper.readValue(new File(MULTAS_PENDIENTES), objectMapper.getTypeFactory().constructCollectionType(List.class, Multa.class));
    
            // Crear un documento PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("archivosPDF/ListarMultasPendientes.pdf"));
            document.open();
    
            // Crear un título en negrita
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Paragraph title = new Paragraph("Lista de Multas Pendientes", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
    
            // Agregar un espacio entre el título y la tabla
            document.add(new Paragraph(" "));
    
            // Crear una tabla con las columnas necesarias
            PdfPTable table = new PdfPTable(11); // 11 columnas
            table.setWidthPercentage(100);
    
            // Agregar encabezados de columna en negrita
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 8);
            String[] headers = {"ID Multa", "ID Propiedad", "ID Propietario", "Fecha Expedicion", "Fecha Vencimiento", "Fecha Pago", "Motivo", "Monto", "IVA", "Monto Total", "Pagado"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell();
                cell.setPhrase(new Phrase(header, headerFont));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }
    
            // Agregar datos de las multas con tamaño de fuente 8
            Font dataFont = FontFactory.getFont(FontFactory.HELVETICA, 8);
            for (Multa multa : multas) {
                table.addCell(new Phrase(String.valueOf(multa.getIdMulta()), dataFont));
                table.addCell(new Phrase(multa.getIdPropiedad(), dataFont));
                table.addCell(new Phrase(multa.getIdPropietario(), dataFont));
                table.addCell(new Phrase(multa.getFechaExpedicion(), dataFont));
                table.addCell(new Phrase(multa.getFechaVencimiento(), dataFont));
                table.addCell(new Phrase(multa.getFechaPago(), dataFont));
                table.addCell(new Phrase(multa.getMotivo(), dataFont));
                table.addCell(new Phrase(String.valueOf(multa.getMonto()), dataFont));
                table.addCell(new Phrase(String.valueOf(multa.getIva()), dataFont));
                table.addCell(new Phrase(String.valueOf(multa.getMontoTotal()), dataFont));
                table.addCell(new Phrase(String.valueOf(multa.isPagado()), dataFont));
            }
    
            // Agregar la tabla al documento
            document.add(table);
            document.close();
    
            // Abrir el PDF generado
            File pdfFile = new File("archivosPDF/ListarMultasPendientes.pdf");
            if (pdfFile.exists()) {
                Desktop.getDesktop().open(pdfFile);
            }
    
            return true; // Proceso exitoso
    
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
            return false; // Ocurrió un error
        }
    }

    public boolean crearPDFProfesionOcupacionVecinos(Map<String, String> info) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("archivosPDF/ProfesionOcupacionVecinos.pdf"));
            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Font dataFont = FontFactory.getFont(FontFactory.HELVETICA, 12);

            if (info.containsKey("idPropiedadMenosUno")) {
                document.add(new Paragraph("Vecino de la izquierda: " + info.get("idPropiedadMenosUno"), titleFont));
                document.add(new Paragraph("Profesion: " + info.get("profesionMenosUno"), dataFont));
                document.add(new Paragraph("Ocupacion: " + info.get("ocupacionMenosUno"), dataFont));
                document.add(new Paragraph(" "));
            }

            if (info.containsKey("idPropiedadMasUno")) {
                document.add(new Paragraph("Vecino de la derecha: " + info.get("idPropiedadMasUno"), titleFont));
                document.add(new Paragraph("Profesion: " + info.get("profesionMasUno"), dataFont));
                document.add(new Paragraph("Ocupacion: " + info.get("ocupacionMasUno"), dataFont));
                document.add(new Paragraph(" "));
            }

            document.close();

            File pdfFile = new File("archivosPDF/ProfesionOcupacionVecinos.pdf");
            if (pdfFile.exists()) {
                Desktop.getDesktop().open(pdfFile);
            }

            return true;
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void crearYMostrarPDFMulta(Multa multa) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("archivosPDF/Multa_" + multa.getIdMulta() + ".pdf"));
            document.open();
            document.add(new Paragraph("Celebrity Heights - Multa\n\n"));
            document.add(new Paragraph("Multa N°: " + multa.getIdMulta()));
            document.add(new Paragraph("Propiedad: " + multa.getIdPropiedad()));
            document.add(new Paragraph("Identificacion del Propietario: " + multa.getIdPropietario() + "\n"));
            document.add(new Paragraph("Fecha de Expedición: " + multa.getFechaExpedicion()));
            document.add(new Paragraph("Fecha de Vencimiento: " + multa.getFechaVencimiento()));
            document.add(new Paragraph("Fecha de Pago (si aplica): " + multa.getFechaPago() + "\n"));
            document.add(new Paragraph("Motivo de la Multa: " + multa.getMotivo() + "\n"));
            document.add(new Paragraph("Monto Base: $" + multa.getMonto()));
            document.add(new Paragraph("IVA (19%): $" + multa.getIva()));
            document.add(new Paragraph("Total a Pagar: $" + multa.getMontoTotal() + "\n"));
            document.add(new Paragraph("Estado de Pago: " + (multa.isPagado() ? "Pagado" : "No Pagado") + "\n"));
            document.add(new Paragraph("Instrucciones de Pago:\n"));
            document.add(new Paragraph("Realizar el pago a la cuenta bancaria XXX-XXX-XXXX a más tardar el " + multa.getFechaVencimiento() + ".\n"));
            document.add(new Paragraph("El incumplimiento en el pago de esta multa generará intereses adicionales conforme a las políticas del centro residencial.\n"));
            document.add(new Paragraph("Atentamente,\nAdministración de Celebrity Heights"));
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }

        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File("archivosPDF/Multa_" + multa.getIdMulta() + ".pdf"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void generarPDF(Indicacion indicacion) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("archivosPDF/Indicacion_" + indicacion.getIdIndicacion() + ".pdf"));
            document.open();
            document.add(new Paragraph("ID Indicacion: " + indicacion.getIdIndicacion()));
            document.add(new Paragraph("Indicacion: " + indicacion.getIndicacion()));
            document.add(new Paragraph("Estado: " + (indicacion.isEstado() ? "true" : "false")));
            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File("archivosPDF/Indicacion_" + indicacion.getIdIndicacion() + ".pdf"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}