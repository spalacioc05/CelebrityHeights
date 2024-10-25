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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author spala
 */


public class ListarIndicacion {

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