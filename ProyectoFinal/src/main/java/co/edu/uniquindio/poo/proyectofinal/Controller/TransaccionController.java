package co.edu.uniquindio.poo.proyectofinal.Controller;

import co.edu.uniquindio.poo.proyectofinal.Modelo.*;

import java.util.Collection;

public class TransaccionController {

    private BilleteraVirtual virtual;

    public TransaccionController(BilleteraVirtual virtual){
        this.virtual = virtual;
    }

    public boolean AgregarTransaccion(Transaccion transaccion) {
        if (virtual == null) {
            System.err.println("Error: La Billetera no ha sido inicializada.");
            return false;
        } else {
            return virtual.agregarTransaccion(transaccion);
        }
    }

    public Collection<Transaccion> obtenerListaTransacciones() {
        if (virtual == null) {
            System.err.println("Error: No se puede obtener la lista de transacciones porque el sistema es null.");
            return null;
        } else {
            return virtual.getTransacciones();
        }
    }

    public boolean EliminarTransacciones(Transaccion transaccion) {
        if (virtual == null) {
            System.err.println("Error: No se puede eliminar la transaccion ya que la billetara es null.");
            return false;
        } else {
            return virtual.eliminarTransaccion(transaccion);
        }
    }

    public boolean EnviarTransaccion2(String id){
        if (virtual == null) {
            System.err.println("Error: No se puede eliminar la transaccion ya que la billetara es null.");
            return false;
        } else {
            return virtual.EnviarTransaccion(id);
        }
    }

    public Collection<CategoriaCompuesto> obtenerListaCategorias() {
        if (this.virtual == null) {
        }

        return this.virtual.obtenerListaCategoriaCompuestas();
    }

    public Collection<CuentaBancaria> obtenerListaCuentasBancarias() {
        if (this.virtual == null) {
        }
        return virtual.getCuentas();
    }
}
