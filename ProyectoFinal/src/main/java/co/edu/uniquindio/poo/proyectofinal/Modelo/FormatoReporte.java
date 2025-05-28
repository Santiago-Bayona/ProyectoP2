package co.edu.uniquindio.poo.proyectofinal.Modelo;

public abstract class FormatoReporte {
    /**
     * Genera el reporte completo combinando el encabezado, el cuerpo y el pie.
     *
     * @param reporte El objeto Reporte que contiene la información del reporte a generar.
     * @return Una cadena con el contenido completo del reporte formateado.
     */
    public final String generar(Reporte reporte) {
        return encabezado(reporte) + cuerpo(reporte) + pie(reporte);
    }

    /**
     * Genera el encabezado del reporte.
     *
     * @param reporte El objeto Reporte que contiene la información necesaria para el encabezado.
     * @return Una cadena que representa el encabezado del reporte.
     */
    public abstract String encabezado(Reporte reporte);

    /**
     * Genera el cuerpo del reporte.
     *
     * @param reporte El objeto Reporte que contiene la información necesaria para el cuerpo.
     * @return Una cadena que representa el cuerpo del reporte.
     */
    public abstract String cuerpo(Reporte reporte);

    /**
     * Genera el pie del reporte.
     *
     * @param reporte El objeto Reporte que contiene la información necesaria para el pie.
     * @return Una cadena que representa el pie del reporte.
     */
    public abstract String pie(Reporte reporte);
}
