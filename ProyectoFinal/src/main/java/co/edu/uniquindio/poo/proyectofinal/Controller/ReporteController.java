package co.edu.uniquindio.poo.proyectofinal.Controller;

import co.edu.uniquindio.poo.proyectofinal.Modelo.*;

import java.util.Collection;

public class ReporteController {
    private BilleteraVirtual virtual;

    public ReporteController(BilleteraVirtual virtual){
        this.virtual = virtual;
    }

    public boolean AgregarReporte(Reporte reporte) {
        if (virtual == null) {
            System.err.println("Error: La Billetera no ha sido inicializada.");
            return false;
        } else {
            return virtual.agregarReporte(reporte);
        }
    }

    public Collection<Reporte> obtenerlistaReporte() {
        if (virtual == null) {
            System.err.println("Error: No se puede obtener la lista de presupuestos porque el sistema es null.");
            return null;
        } else {
            return virtual.getReportes();
        }
    }

    public boolean EliminarReporte(Reporte reporte) {
        if (virtual == null) {
            System.err.println("Error: No se puede eliminar el reporte ya que la billetara es null.");
            return false;
        } else {
            return virtual.eliminarReporte(reporte);
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


    public Collection<Usuario> obtenerListaUsuarios() {
        if (this.virtual == null) {
            System.err.println("Error: No se puede obtener la lista de usuarios porque el sistema es null.");
            return null;
        }
        return virtual.getUsuarios();
    }
    public Collection<Transaccion> obtenerListaTransaccionwes() {
        if (this.virtual == null) {
            System.err.println("Error: No se puede obtener la lista de usuarios porque el sistema es null.");
            return null;
        }
        return virtual.getTransacciones();
    }
}
