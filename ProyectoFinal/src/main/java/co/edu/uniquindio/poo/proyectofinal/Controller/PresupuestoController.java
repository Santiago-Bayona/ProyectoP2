package co.edu.uniquindio.poo.proyectofinal.Controller;

import co.edu.uniquindio.poo.proyectofinal.Modelo.*;

import java.util.Collection;

public class PresupuestoController {
    private BilleteraVirtual virtual;

    public PresupuestoController(BilleteraVirtual virtual){
        this.virtual = virtual;
    }

    public boolean AgregrarPresupuesto(Presupuesto presupuesto) {
        if (virtual == null) {
            System.err.println("Error: La Billetera no ha sido inicializada.");
            return false;
        } else {
            return virtual.agregarPresupuesto(presupuesto);
        }
    }

    public Collection<Presupuesto> obtenerlistaPresupuesto() {
        if (virtual == null) {
            System.err.println("Error: No se puede obtener la lista de presupuestos porque el sistema es null.");
            return null;
        } else {
            return virtual.getPresupuestos();
        }
    }

    public boolean EliminarPresupuestos(Presupuesto presupuesto) {
        if (virtual == null) {
            System.err.println("Error: No se puede eliminar el presupuesto ya que la billetara es null.");
            return false;
        } else {
            return virtual.eliminarPresupuesto(presupuesto);
        }
    }

    public boolean ActualizarPresupuesto(String ID,Presupuesto presupuesto) {
        if (virtual == null) {
            System.err.println("Error: No se puede eliminar el presupuesto ya que la billetara es null.");
            return false;
        } else {
            return virtual.actualizarPresupuesto(ID,presupuesto);
        }
    }


    public Collection<CuentaBancaria> obtenerListaCuentasBancarias() {
        if (this.virtual == null) {
        }
        return virtual.getCuentas();
    }
}
