package co.edu.uniquindio.poo.proyectofinal.Controller;

import co.edu.uniquindio.poo.proyectofinal.Modelo.BilleteraVirtual;
import co.edu.uniquindio.poo.proyectofinal.Modelo.CuentaBancaria;
import co.edu.uniquindio.poo.proyectofinal.Modelo.Presupuesto;
import co.edu.uniquindio.poo.proyectofinal.Modelo.Usuario;

import java.util.Collection;

public class CuentaController {
    private BilleteraVirtual virtual;
    public CuentaController(BilleteraVirtual virtual){
        this.virtual = virtual;
    }

    public boolean AgregarCuenta(CuentaBancaria cuentaBancaria) {
        if (virtual == null) {
            System.err.println("Error: La Billetera no ha sido inicializada.");
            return false;
        } else {
            return virtual.agregarCuentaBancaria(cuentaBancaria);
        }
    }

    public Collection<CuentaBancaria> obtenerlistaCuentas() {
        if (virtual == null) {
            System.err.println("Error: No se puede obtener la lista de Cuentas porque el sistema es null.");
            return null;
        } else {
            return virtual.getCuentas();
        }
    }

    public boolean EliminarCuenta(CuentaBancaria Cuenta) {
        if (virtual == null) {
            System.err.println("Error: No se puede eliminar el presupuesto ya que la billetara es null.");
            return false;
        } else {
            return virtual.eliminarCuentaBancaria(Cuenta);
        }
    }

    public boolean ActualizarCuenta(String ID,CuentaBancaria cuentaBancaria) {
        if (virtual == null) {
            System.err.println("Error: No se puede eliminar el presupuesto ya que la billetara es null.");
            return false;
        } else {
            return virtual.actualizarCuenta(ID,cuentaBancaria);
        }
    }


    public Collection<Usuario> obtenerListaUsuario() {
        if (this.virtual == null) {
        }
        return virtual.getUsuarios();
    }
}
