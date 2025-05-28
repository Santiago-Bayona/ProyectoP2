package co.edu.uniquindio.poo.proyectofinal.Modelo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;

public class Reporte {

    private String Titulo, ID;
    private LocalDate FechaInicio, FechaFinal;
    private Usuario Usuario;
    public Collection<Transaccion> transacciones;

    public Tipo tipo;
    public enum Tipo{
        Ingreso, Gasto
    }

    public Archivo archivo;

    public enum Archivo{
        PDF, CSV
    }

    /**
     * Constructor de la clase Reporte.
     *
     * @param titulo      Título del reporte.
     * @param id          Identificador único del reporte.
     * @param fechaInicio Fecha de inicio del reporte.
     * @param fechaFinal  Fecha final del reporte.
     * @param usuario     Usuario asociado al reporte.
     * @param tipo        Tipo de transacciones en el reporte (Ingreso/Gasto).
     * @param archivo     Tipo de archivo en el que se generará el reporte (PDF/CSV).
     */
    public Reporte(String titulo, String id, LocalDate fechaInicio, LocalDate fechaFinal, Usuario usuario, Tipo tipo, Archivo archivo) {
        this.Titulo = titulo;
        this.FechaInicio = fechaInicio;
        this.FechaFinal = fechaFinal;
        this.Usuario = usuario;
        this.transacciones = new LinkedList<>();
        this.tipo = tipo;
        this.archivo = archivo;
        this.ID = id;
    }

    /**
     * Obtiene el título del reporte.
     *
     * @return Título del reporte.
     */
    public String getTitulo() {
        return Titulo;
    }

    /**
     * Establece el título del reporte.
     *
     * @param titulo Título del reporte.
     */
    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    /**
     * Obtiene el usuario asociado al reporte.
     *
     * @return Usuario del reporte.
     */
    public Usuario getUsuario() {
        return Usuario;
    }

    /**
     * Establece el usuario asociado al reporte.
     *
     * @param usuario Usuario del reporte.
     */
    public void setUsuario(Usuario usuario) {
        Usuario = usuario;
    }

    /**
     * Obtiene la fecha de inicio del reporte.
     *
     * @return Fecha de inicio del reporte.
     */
    public LocalDate getFechaInicio() {
        return FechaInicio;
    }

    /**
     * Establece la fecha de inicio del reporte.
     *
     * @param fechaInicio Fecha de inicio del reporte.
     */
    public void setFechaInicio(LocalDate fechaInicio) {
        FechaInicio = fechaInicio;
    }

    /**
     * Obtiene la fecha final del reporte.
     *
     * @return Fecha final del reporte.
     */
    public LocalDate getFechaFinal() {
        return FechaFinal;
    }

    /**
     * Establece la fecha final del reporte.
     *
     * @param fechaFinal Fecha final del reporte.
     */
    public void setFechaFinal(LocalDate fechaFinal) {
        FechaFinal = fechaFinal;
    }

    /**
     * Obtiene las transacciones asociadas al reporte.
     *
     * @return Colección de transacciones del reporte.
     */
    public Collection<Transaccion> getTransacciones() {
        return transacciones;
    }

    /**
     * Configura las transacciones asociadas al reporte.
     *
     * @param transacciones Colección de transacciones del reporte.
     */
    public void setTransacciones(Collection<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    /**
     * Obtiene el tipo de transacción del reporte.
     *
     * @return Tipo de transacción (Ingreso/Gasto).
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de transacción del reporte.
     *
     * @param tipo Tipo de transacción (Ingreso/Gasto).
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el formato del archivo del reporte.
     *
     * @return Formato del archivo (PDF/CSV).
     */
    public Archivo getArchivo() {
        return archivo;
    }

    /**
     * Establece el formato del archivo del reporte.
     *
     * @param archivo Formato del archivo (PDF/CSV).
     */
    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }

    /**
     * Obtiene el identificador del reporte.
     *
     * @return Identificador del reporte.
     */
    public String getID() {
        return ID;
    }

    /**
     * Establece el identificador del reporte.
     *
     * @param ID Identificador único del reporte.
     */
    public void setID(String ID) {
        this.ID = ID;
    }


    @Override
    public String toString() {
        return "Reporte{" +
                "Titulo='" + Titulo + '\'' +
                ", FechaInicio=" + FechaInicio +
                ", FechaFinal=" + FechaFinal +
                ", Usuario=" + Usuario +
                ", transacciones=" + transacciones +
                ", tipo=" + tipo +
                ", archivo=" + archivo +
                '}';
    }
}
