/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author spala
 */
public class ListarMisPropietario {
    protected static final String PROPIETARIOS_PROPIEDADES = "data/propietariosPropiedades.json";
    protected static final String FACTURAS = "data/facturas.csv";
    protected static final String MULTAS = "data/multas.json";
    protected static final String SEGURIDAD = "data/seguridad.csv";

    public boolean listarMisPropiedadesPDF(String propietarioId) {
        String outputPdfPath = "archivosPDF/propiedades_" + propietarioId + ".pdf";
        try {
            // Read JSON file
            ObjectMapper objectMapper = new ObjectMapper();
            List<Propietario> propietarios = objectMapper.readValue(new File(PROPIETARIOS_PROPIEDADES), new TypeReference<List<Propietario>>() {});

            // Find properties by owner ID
            Propietario propietario = null;
            for (Propietario p : propietarios) {
                if (p.getId().equals(propietarioId)) {
                    propietario = p;
                    break;
                }
            }

            if (propietario == null) {
                System.out.println("Propietario no encontrado.");
                return false;
            }

            // Generate PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(outputPdfPath));
            document.open();

            for (Propiedad propiedad : propietario.getPropiedades()) {
                document.newPage();
                document.add(new Paragraph("ID Propiedad: " + propiedad.getIdPropiedad()));
                document.add(new Paragraph("Direccion: " + propiedad.getDireccionPropiedad()));
                document.add(new Paragraph("Tamaño (m2): " + propiedad.getSizeM2()));
                document.add(new Paragraph("Habitaciones: " + propiedad.getHabitaciones()));
                document.add(new Paragraph("Baños: " + propiedad.getBathrooms()));
                document.add(new Paragraph("Precio por m2: " + propiedad.getPrecioM2()));
                document.add(new Paragraph("Fecha de Adquisicion: " + propiedad.getFechaAdquisicion()));
                document.add(new Paragraph("Valor de Administracion: " + propiedad.getValorAdministracion()));
            }

            document.close();
            System.out.println("PDF generado exitosamente en " + outputPdfPath);

            // Open PDF
            if (Desktop.isDesktopSupported()) {
                File pdfFile = new File(outputPdfPath);
                if (pdfFile.exists()) {
                    Desktop.getDesktop().open(pdfFile);
                }
            }

            return true;

        } catch (IOException | DocumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean listarMisVisitasPDF(String propietarioId) {
        String outputPdfPath = "archivosPDF/visitas_" + propietarioId + ".pdf";
        try {
            // Read JSON file
            ObjectMapper objectMapper = new ObjectMapper();
            List<Propietario> propietarios = objectMapper.readValue(new File(PROPIETARIOS_PROPIEDADES), new TypeReference<List<Propietario>>() {});

            // Find properties by owner ID
            Propietario propietario = null;
            for (Propietario p : propietarios) {
                if (p.getId().equals(propietarioId)) {
                    propietario = p;
                    break;
                }
            }

            if (propietario == null) {
                System.out.println("Propietario no encontrado.");
                return false;
            }

            // Read CSV file
            List<Visitante> visitantes = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(SEGURIDAD))) {
                String line;
                br.readLine(); // Skip header
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    Visitante visitante = new Visitante(values[0], values[1], values[2], values[3], values[4], values[5]);
                    visitantes.add(visitante);
                }
            }

            // Generate PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(outputPdfPath));
            document.open();

            for (Propiedad propiedad : propietario.getPropiedades()) {
                document.add(new Paragraph("ID Propiedad: " + propiedad.getIdPropiedad()));
                document.add(new Paragraph("Direccion: " + propiedad.getDireccionPropiedad()));
                document.add(new Paragraph("Tamaño (m2): " + propiedad.getSizeM2()));
                document.add(new Paragraph("Habitaciones: " + propiedad.getHabitaciones()));
                document.add(new Paragraph("Baños: " + propiedad.getBathrooms()));
                document.add(new Paragraph("Precio por m2: " + propiedad.getPrecioM2()));
                document.add(new Paragraph("Fecha de Adquisicion: " + propiedad.getFechaAdquisicion()));
                document.add(new Paragraph("Valor de Administracion: " + propiedad.getValorAdministracion()));
                document.add(new Paragraph(" ")); // Add a blank line

                PdfPTable table = new PdfPTable(6);
                table.setWidthPercentage(100);
                addTableHeader(table);
                addRows(table, visitantes, propiedad.getIdPropiedad());

                document.add(table);
                document.newPage();
            }

            document.close();
            System.out.println("PDF generado exitosamente en " + outputPdfPath);

            // Open PDF
            if (Desktop.isDesktopSupported()) {
                File pdfFile = new File(outputPdfPath);
                if (pdfFile.exists()) {
                    Desktop.getDesktop().open(pdfFile);
                }
            }

            return true;

        } catch (IOException | DocumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void addTableHeader(PdfPTable table) {
        Stream.of("ID Visitante", "Nombre Visitante", "ID Propiedad", "Fecha Entrada", "Hora Entrada", "Motivo")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setPhrase(new Phrase(columnTitle));
                    header.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(header);
                });
    }

    private void addRows(PdfPTable table, List<Visitante> visitantes, String idPropiedad) {
        for (Visitante visitante : visitantes) {
            if (visitante.getIdPropiedad().equals(idPropiedad)) {
                table.addCell(visitante.getIdVisitante());
                table.addCell(visitante.getNombreVisitante());
                table.addCell(visitante.getIdPropiedad());
                table.addCell(visitante.getFechaEntrada());
                table.addCell(visitante.getHoraEntrada());
                table.addCell(visitante.getMotivo());
            }
        }
    }

    public boolean listarMisFacturasPDF(String propietarioId) {
        String outputPdfPath = "archivosPDF/facturas_" + propietarioId + ".pdf";
        try {
            // Read CSV file
            List<Factura> facturas = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(FACTURAS))) {
                String line;
                br.readLine(); // Skip header
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    Factura factura = new Factura(values[0], values[1], values[2], values[3], values[4], values[5], values[6], Double.parseDouble(values[7]), Double.parseDouble(values[8]), Double.parseDouble(values[9]), Boolean.parseBoolean(values[10]));
                    facturas.add(factura);
                }
            }

            // Find invoices by owner ID
            List<Factura> facturasPropietario = new ArrayList<>();
            for (Factura factura : facturas) {
                if (factura.getIdPropietario().equals(propietarioId)) {
                    facturasPropietario.add(factura);
                }
            }

            if (facturasPropietario.isEmpty()) {
                System.out.println("No se encontraron facturas para el propietario.");
                return false;
            }

            // Generate PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(outputPdfPath));
            document.open();

            for (Factura factura : facturasPropietario) {
                document.newPage();
                document.add(new Paragraph("Celebrity Heights - Factura"));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("Factura N°: " + factura.getIdFactura()));
                document.add(new Paragraph("Propiedad: " + factura.getIdPropiedad()));
                document.add(new Paragraph("Identificación del Propietario: " + factura.getIdPropietario()));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("Fecha de Expedición: " + factura.getFechaExpedicion()));
                document.add(new Paragraph("Fecha de Vencimiento: " + factura.getFechaVencimiento()));
                document.add(new Paragraph("Fecha de Pago: " + (factura.getFechaPago().isEmpty() ? "No Pagado" : factura.getFechaPago())));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("Tipo de Factura: " + factura.getTipoFactura()));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("Monto Base: $" + factura.getMonto()));
                document.add(new Paragraph("IVA (19%): $" + factura.getIva()));
                document.add(new Paragraph("Total a Pagar: $" + factura.getMontoTotal()));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("Estado de Pago: " + (factura.isPagado() ? "Pagado" : "No Pagado")));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("Instrucciones de Pago:"));
                document.add(new Paragraph("Realizar el pago a la cuenta bancaria XXX-XXX-XXXX a más tardar el " + factura.getFechaVencimiento() + "."));
                document.add(new Paragraph("El incumplimiento en el pago de esta factura generará intereses adicionales conforme a las políticas del centro residencial."));
            }

            document.close();
            System.out.println("PDF generado exitosamente en " + outputPdfPath);

            // Open PDF
            if (Desktop.isDesktopSupported()) {
                File pdfFile = new File(outputPdfPath);
                if (pdfFile.exists()) {
                    Desktop.getDesktop().open(pdfFile);
                }
            }

            return true;

        } catch (IOException | DocumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean listarMisMultasPDF(String propietarioId) {
        String outputPdfPath = "archivosPDF/multas_" + propietarioId + ".pdf";
        try {
            // Read JSON file
            ObjectMapper objectMapper = new ObjectMapper();
            List<Multa> multas = objectMapper.readValue(new File(MULTAS), new TypeReference<List<Multa>>() {});

            // Filter multas by owner ID
            List<Multa> multasPropietario = multas.stream()
                    .filter(multa -> multa.getIdPropietario().equals(propietarioId))
                    .collect(Collectors.toList());

            if (multasPropietario.isEmpty()) {
                System.out.println("No se encontraron multas para el propietario.");
                return false;
            }

            // Generate PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(outputPdfPath));
            document.open();

            for (Multa multa : multasPropietario) {
                document.newPage();
                document.add(new Paragraph("Celebrity Heights - Multa"));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("Multa N°: " + multa.getIdMulta()));
                document.add(new Paragraph("Propiedad: " + multa.getIdPropiedad()));
                document.add(new Paragraph("Identificación del Propietario: " + multa.getIdPropietario()));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("Fecha de Expedición: " + multa.getFechaExpedicion()));
                document.add(new Paragraph("Fecha de Vencimiento: " + multa.getFechaVencimiento()));
                document.add(new Paragraph("Fecha de Pago: " + (multa.getFechaPago() == null ? "No Pagado" : multa.getFechaPago())));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("Motivo de la Multa: " + multa.getMotivo()));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("Monto Base: $" + multa.getMonto()));
                document.add(new Paragraph("IVA (19%): $" + multa.getIva()));
                document.add(new Paragraph("Total a Pagar: $" + multa.getMontoTotal()));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("Estado de Pago: " + (multa.isPagado() ? "Pagado" : "No Pagado")));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("Instrucciones de Pago:"));
                document.add(new Paragraph("Realizar el pago a la cuenta bancaria XXX-XXX-XXXX a más tardar el " + multa.getFechaVencimiento() + "."));
                document.add(new Paragraph("El incumplimiento en el pago de esta multa generará intereses adicionales conforme a las políticas del centro residencial."));
            }

            document.close();
            System.out.println("PDF generado exitosamente en " + outputPdfPath);

            // Open PDF
            if (Desktop.isDesktopSupported()) {
                File pdfFile = new File(outputPdfPath);
                if (pdfFile.exists()) {
                    Desktop.getDesktop().open(pdfFile);
                }
            }

            return true;

        } catch (IOException | DocumentException e) {
            e.printStackTrace();
            return false;
        }
    }




    
}
