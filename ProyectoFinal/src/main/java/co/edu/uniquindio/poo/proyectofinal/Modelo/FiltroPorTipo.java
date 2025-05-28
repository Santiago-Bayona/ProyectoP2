package co.edu.uniquindio.poo.proyectofinal.Modelo;

public class FiltroPorTipo implements FiltroStrategy {
    private TipoTransaccion tipo;

    /**
     * Constructor para inicializar el filtro con un tipo de transacción específico.
     *
     * @param tipo El tipo de transacción por el cual se desea filtrar.
     */
    public FiltroPorTipo(TipoTransaccion tipo) {
        this.tipo = tipo;
    }

    /**
     * Método que verifica si una transacción corresponde al tipo especificado.
     *
     * @param trransaccion La transacción a evaluar.
     * @return true si la transacción corresponde al tipo especificado, false en caso contrario.
     */
    public boolean filtrar(Transaccion trransaccion) {
        return trransaccion.getTipoTransaccion() == tipo;
    }
}
