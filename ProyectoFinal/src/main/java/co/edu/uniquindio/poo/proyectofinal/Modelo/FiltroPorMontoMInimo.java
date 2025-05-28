package co.edu.uniquindio.poo.proyectofinal.Modelo;

public class FiltroPorMontoMInimo implements FiltroStrategy{
    private double montoMinimo;

    /**
     * Constructor de la clase FiltroPorMontoMInimo.
     * Inicializa el monto mínimo que se utilizará para filtrar las transacciones.
     *
     * @param montoMinimo el monto mínimo que debe cumplir la transacción.
     */
    public FiltroPorMontoMInimo(double montoMinimo) {
        this.montoMinimo = montoMinimo;
    }

    /**
     * Método que verifica si una transacción cumple con el filtro por monto mínimo.
     *
     * @param transaccion la transacción a evaluar.
     * @return true si el monto de la transacción es mayor o igual al monto mínimo, false en caso contrario.
     */
    @Override
    public boolean filtrar(Transaccion transaccion) {
        return transaccion.getMonto() >= montoMinimo;
    }
}
