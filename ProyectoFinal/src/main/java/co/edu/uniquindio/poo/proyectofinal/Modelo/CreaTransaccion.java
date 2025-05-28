package co.edu.uniquindio.poo.proyectofinal.Modelo;

import java.time.LocalDate;

public class CreaTransaccion implements TransaccionFactory{

    /**
     *
     * @param idTransaccion
     * @param monto
     * @param fechaTransaccion
     * @param descripcion
     * @param categoria
     * @param tipoTransaccion
     * @param cuenta1
     * @param cuenta2
     * @return
     */
    public Transaccion crearTransaccion(String idTransaccion, Double monto, LocalDate fechaTransaccion, String descripcion, Categoria categoria, TipoTransaccion tipoTransaccion, CuentaBancaria cuenta1, CuentaBancaria cuenta2) {

        switch (tipoTransaccion){
            case RETIRO:
                return  new Transaccion(idTransaccion,monto,fechaTransaccion,descripcion,categoria,tipoTransaccion,cuenta1,null);
            case DEPOSITO:
                return  new Transaccion(idTransaccion,monto,fechaTransaccion,descripcion,categoria,tipoTransaccion,cuenta1,null);
            case TRANSFERENCIA:
                return  new Transaccion(idTransaccion,monto,fechaTransaccion,descripcion,categoria,tipoTransaccion,cuenta1,cuenta2);
            default:
                throw new IllegalArgumentException("Tipo de transacción desconocido: " + tipoTransaccion);
        }
    }
}
