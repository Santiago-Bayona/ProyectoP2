package co.edu.uniquindio.poo.proyectofinal.Modelo;

import java.io.File;
import java.io.IOException;

public interface ReporteExportador {
    public void exportarReporte(Reporte reporte, File archivo) throws IOException;
}
