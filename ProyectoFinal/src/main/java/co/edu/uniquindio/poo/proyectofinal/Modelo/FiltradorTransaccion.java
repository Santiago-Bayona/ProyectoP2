package co.edu.uniquindio.poo.proyectofinal.Modelo;

import java.util.ArrayList;
import java.util.List;

public class FiltradorTransaccion {

    public FiltroStrategy filtro;

    /**
     * Constructor de la clase FiltradorTransaccion que permite
     * inicializar la estrategia de filtrado.
     *
     * @param filtroStrategy Estrategia de filtrado a utilizar.
     */
    public FiltradorTransaccion(FiltroStrategy filtroStrategy) {
        this.filtro = filtroStrategy;
    }

    /**
     * Método que permite establecer una nueva estrategia de filtrado.
     *
     * @param filtroStrategy Nueva estrategia de filtrado.
     */
    public void setFiltroStrategy(FiltroStrategy filtroStrategy) {
        this.filtro = filtroStrategy;
    }

    /**
     * Método que filtra una lista de transacciones utilizando la estrategia definida.
     *
     * @param transacciones Lista de transacciones a ser filtradas.
     * @return Lista de transacciones que cumplen con el criterio del filtro.
     */
    public List<Transaccion> filtrar(List<Transaccion> transacciones) {
        List<Transaccion> resultado = new ArrayList<>();
        for (Transaccion transaccion : transacciones) {
            if (filtro.filtrar(transaccion)) {
                resultado.add(transaccion);
            }
        }
        return resultado;
    }
}
