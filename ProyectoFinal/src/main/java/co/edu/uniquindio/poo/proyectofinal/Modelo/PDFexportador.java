package co.edu.uniquindio.poo.proyectofinal.Modelo;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.File;
import java.io.IOException;

public class PDFexportador implements ReporteExportador {

    /**
     * Metodo que permite exportar el resporte a un archivo tipo pdf
     * @param reporte
     * @param archivo
     * @throws IOException
     */
    @Override
    public void exportarReporte(Reporte reporte, File archivo) throws IOException {
        FormatoReporte formato = reporte.getTipo() == Reporte.Tipo.Ingreso ? new FormatoIngresos() : new FormatoGastos();
        String contenido = formato.generar(reporte);

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.beginText();
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12);
            contentStream.setLeading(14.5f);
            contentStream.newLineAtOffset(50, 700);

            for (String line : contenido.split("\n")) {
                contentStream.showText(line);
                contentStream.newLine();
            }

            contentStream.endText();
            contentStream.close();

            document.save(archivo);
            System.out.println("PDF generado: " + archivo.getAbsolutePath());
        }
    }
}
