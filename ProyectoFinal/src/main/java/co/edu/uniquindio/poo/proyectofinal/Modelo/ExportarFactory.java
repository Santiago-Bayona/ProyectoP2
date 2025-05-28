package co.edu.uniquindio.poo.proyectofinal.Modelo;

import java.io.File;
import co.edu.uniquindio.poo.proyectofinal.Modelo.Reporte;
import java.io.IOException;

public class ExportarFactory {

    /**
     * Método que obtiene el exportador adecuado según el tipo de archivo especificado.
     *
     * @param archivo El tipo de archivo que se va a exportar (PDF o CSV).
     * @return Una instancia de ReporteExportador correspondiente al tipo de archivo.
     */
    public static ReporteExportador getExportador(Reporte.Archivo archivo) {
        return switch (archivo) {
            case PDF -> new PDFexportador();
            case CSV -> new CSVReporte();
        };
    }

    /**
     * Método que exporta un reporte a un archivo específico.
     *
     * @param reporte El reporte que se va a exportar.
     * @param archivo El archivo donde se almacenará el reporte exportado.
     * @throws IOException Si ocurre un error de entrada/salida durante la exportación.
     */
    public static void exportarReporte(Reporte reporte, File archivo) throws IOException {
        ReporteExportador exportador = getExportador(reporte.getArchivo());
        exportador.exportarReporte(reporte, archivo);
    }
}

