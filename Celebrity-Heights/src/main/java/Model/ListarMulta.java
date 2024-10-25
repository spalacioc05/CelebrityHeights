/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author spala
 */


public class ListarMulta {

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
}
