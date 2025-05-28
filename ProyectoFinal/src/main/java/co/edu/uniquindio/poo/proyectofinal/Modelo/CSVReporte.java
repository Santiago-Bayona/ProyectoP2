package co.edu.uniquindio.poo.proyectofinal.Modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVReporte implements ReporteExportador{

    @Override
    /**
     *Metodo que permite exportar un resporte a tipo de archivo csv
     */
    public void exportarReporte(Reporte reporte, File archivo) throws IOException {
        FormatoReporte formato = reporte.getTipo() == Reporte.Tipo.Ingreso ? new FormatoIngresos() : new FormatoGastos();
        String contenido = formato.generar(reporte);

        try (FileWriter writer = new FileWriter(archivo)) {
            writer.write(contenido.replace("\n", System.lineSeparator()));
            System.out.println("CSV generado: " + archivo.getAbsolutePath());
        }
    }
}
