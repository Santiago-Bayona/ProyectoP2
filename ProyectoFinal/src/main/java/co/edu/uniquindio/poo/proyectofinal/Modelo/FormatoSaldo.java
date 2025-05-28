package co.edu.uniquindio.poo.proyectofinal.Modelo;

public class FormatoSaldo extends FormatoReporte{

    /**
     * Genera el encabezado del reporte de saldo.
     *
     * @param reporte El objeto Reporte que contiene la información necesaria para el encabezado.
     * @return Una cadena que representa el encabezado del reporte.
     */
    @Override
    public String encabezado(Reporte reporte) {
        return "==== Reporte de Saldo ====\nUsuario: " + reporte.getUsuario().getNombre() + "\n\n";
    }

    /**
     * Genera el cuerpo del reporte de saldo.
     *
     * @param reporte El objeto Reporte que contiene la información necesaria para el cuerpo.
     * @return Una cadena que representa el cuerpo del reporte.
     */
    @Override
    public String cuerpo(Reporte reporte) {
        return "reporte";
    }

    /**
     * Genera el pie del reporte de saldo.
     *
     * @param reporte El objeto Reporte que contiene la información necesaria para el pie.
     * @return Una cadena que representa el pie del reporte.
     */
    @Override
    public String pie(Reporte reporte) {
        return "Rango: " + reporte.getFechaInicio() + " a " + reporte.getFechaFinal() + "\n===========================\n";
    }
}
