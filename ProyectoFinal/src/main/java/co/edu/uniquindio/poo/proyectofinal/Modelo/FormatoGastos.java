package co.edu.uniquindio.poo.proyectofinal.Modelo;

public class FormatoGastos extends FormatoReporte {
    /**
     * Genera el encabezado del reporte de gastos.
     * Este método construye una cadena que representa el encabezado del reporte,
     * incluyendo un título general y el nombre del usuario asociado al reporte.
     *
     * @param reporte El objeto Reporte que contiene la información para generar el encabezado.
     * @return Una cadena con el encabezado formateado del reporte.
     */
    @Override
    public String encabezado(Reporte reporte) {
        return "==== Reporte de Gastos ====\nUsuario: " + reporte.getUsuario().getNombre() + "\n\n";
    }

    /**
     * Genera el pie de página del reporte de gastos.
     * Este método construye una cadena que representa el pie de página del reporte,
     * incluyendo el rango de fechas cubierto por el reporte.
     *
     * @param reporte El objeto Reporte que contiene la información para generar el pie de página.
     * @return Una cadena con el pie de página formateado del reporte.
     */
    @Override
    public String pie(Reporte reporte) {
        return "\nRango: " + reporte.getFechaInicio() + " a " + reporte.getFechaFinal() + "\n===========================\n";
    }

    /**
     * Genera el cuerpo principal del reporte de gastos.
     * Este método itera sobre las transacciones del reporte y filtra aquellas que
     * califican como gastos (retiros o transferencias salientes de las cuentas del usuario).
     * Para cada gasto, se formatea una línea que incluye la fecha, descripción, monto y
     * la cuenta involucrada.
     *
     * @param reporte El objeto Reporte que contiene las transacciones a procesar.
     * @return Una cadena con el contenido formateado del cuerpo del reporte, listando los gastos.
     */
    @Override
    public String cuerpo(Reporte reporte) {
        StringBuilder contenido = new StringBuilder();

        for (Transaccion t : reporte.getTransacciones()) {

            boolean esGasto = false;
            switch (t.getTipoTransaccion()) {
                case RETIRO:
                    // Si es un retiro y la cuenta 1 pertenece al usuario del reporte, es un gasto.
                    if (t.getCuenta1() != null && t.getCuenta1().getUsuario().equals(reporte.getUsuario())) {
                        esGasto = true;
                    }
                    break;
                case TRANSFERENCIA:
                    // Si es una transferencia y la cuenta 1 (origen) pertenece al usuario del reporte, es un gasto.
                    if (t.getCuenta1() != null && t.getCuenta1().getUsuario().equals(reporte.getUsuario())) {
                        esGasto = true;
                    }
                    break;
                case DEPOSITO:
                    // Los depósitos no son considerados gastos.
                    esGasto = false;
                    break;
            }

            if (esGasto) {
                String cuentaInvolucrada = "";
                // Determina la cuenta involucrada para retiros y transferencias.
                if (t.getTipoTransaccion() == TipoTransaccion.RETIRO && t.getCuenta1() != null) {
                    cuentaInvolucrada = String.valueOf(t.getCuenta1().getNumeroCuenta());
                } else if (t.getTipoTransaccion() == TipoTransaccion.TRANSFERENCIA && t.getCuenta1() != null) {
                    cuentaInvolucrada = String.valueOf(t.getCuenta1().getNumeroCuenta());
                } else {
                    cuentaInvolucrada = "N/A"; // En caso de que la cuenta no esté disponible o el tipo no aplique.
                }
                // Añade la línea del gasto al contenido.
                contenido.append("Fecha: ").append(t.getFechaTransaccion())
                        .append(", Descripción: ").append(t.getDescripcion())
                        .append(", Monto: ").append(t.getMonto())
                        .append(", Cuenta: ").append(cuentaInvolucrada)
                        .append("\n");
            }
        }
        return contenido.toString();
    }
}
