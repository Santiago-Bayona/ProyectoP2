package co.edu.uniquindio.poo.proyectofinal.Modelo;

import org.apache.commons.math3.geometry.spherical.oned.Arc;

import java.time.LocalDate;

public class ReporteBuilder {
    private String titulo, id;
    private Usuario usuario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Reporte.Archivo archivo;
    private Reporte.Tipo tipo;

    /**
     * Establece el título del reporte.
     *
     * @param titulo Título del reporte.
     * @return La instancia del ReporteBuilder para encadenar métodos.
     */
    public ReporteBuilder setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    /**
     * Establece el usuario asociado al reporte.
     *
     * @param usuario Usuario del reporte.
     * @return La instancia del ReporteBuilder para encadenar métodos.
     */
    public ReporteBuilder setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    /**
     * Establece las fechas de inicio y final del reporte.
     *
     * @param inicio Fecha de inicio.
     * @param fin    Fecha final.
     * @return La instancia del ReporteBuilder para encadenar métodos.
     */
    public ReporteBuilder setFechas(LocalDate inicio, LocalDate fin) {
        this.fechaInicio = inicio;
        this.fechaFin = fin;
        return this;
    }

    /**
     * Establece el tipo de transacción del reporte.
     *
     * @param tipo Tipo de transacción (Ingreso/Gasto).
     * @return La instancia del ReporteBuilder para encadenar métodos.
     */
    public ReporteBuilder setTipo(Reporte.Tipo tipo) {
        this.tipo = tipo;
        return this;
    }

    /**
     * Construye una instancia de la clase Reporte con los datos proporcionados.
     *
     * @return Una nueva instancia de Reporte.
     */
    public Reporte build() {
        return new Reporte(titulo, id, fechaInicio, fechaFin, usuario, tipo, archivo);
    }
}
