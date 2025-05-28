package co.edu.uniquindio.poo.proyectofinal.Modelo;

import java.time.LocalDate;

public interface TransaccionFactory {
    public Transaccion crearTransaccion(String idTransaccion, Double monto, LocalDate fechaTransaccion, String descripcion, Categoria categoria, TipoTransaccion tipoTransaccion, CuentaBancaria cuenta1, CuentaBancaria cuenta2);
}
