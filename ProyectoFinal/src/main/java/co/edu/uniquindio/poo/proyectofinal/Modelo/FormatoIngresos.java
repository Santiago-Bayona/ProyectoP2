package co.edu.uniquindio.poo.proyectofinal.Modelo;

public class FormatoIngresos extends FormatoReporte {

    /**
     * Método que genera el encabezado del reporte de ingresos.
     *
     * @param reporte Reporte al cual se le generará el encabezado.
     * @return String con el encabezado del reporte.
     */
    @Override
    public String encabezado(Reporte reporte) {
        return "==== Reporte de Ingresos ====\nUsuario: " + reporte.getUsuario().getNombre() + "\n\n";
    }

    /**
     * Método que genera el pie del reporte de ingresos.
     *
     * @param reporte Reporte al cual se le generará el pie.
     * @return String con el pie del reporte.
     */
    @Override
    public String pie(Reporte reporte) {
        return "\nRango: " + reporte.getFechaInicio() + " a " + reporte.getFechaFinal() + "\n===========================\n";
    }

    /**
     * Método que genera el cuerpo del reporte de ingresos.
     *
     * @param reporte Reporte al cual se le generará el cuerpo.
     * @return String con el cuerpo del reporte.
     */
    @Override
    public String cuerpo(Reporte reporte) {
        StringBuilder contenido = new StringBuilder();

        for (Transaccion t : reporte.getTransacciones()) {

            boolean esIngreso = false;
            switch (t.getTipoTransaccion()) {
                case DEPOSITO:
                    if (t.getCuenta1() != null && t.getCuenta1().getUsuario().equals(reporte.getUsuario())) {
                        esIngreso = true;
                    }
                    break;
                case TRANSFERENCIA:
                    if (t.getCuenta2() != null && t.getCuenta2().getUsuario().equals(reporte.getUsuario())) {
                        esIngreso = true;
                    }
                    break;
                case RETIRO:
                    esIngreso = false;
                    break;
            }

            if (esIngreso) {
                String cuentaInvolucrada = "";
                if (t.getTipoTransaccion() == TipoTransaccion.DEPOSITO && t.getCuenta1() != null) {
                    cuentaInvolucrada = String.valueOf(t.getCuenta1().getNumeroCuenta());
                } else if (t.getTipoTransaccion() == TipoTransaccion.TRANSFERENCIA && t.getCuenta2() != null) {
                    cuentaInvolucrada = String.valueOf(t.getCuenta2().getNumeroCuenta());
                } else {
                    cuentaInvolucrada = "N/A";
                }

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


