package co.edu.uniquindio.poo.proyectofinal.Controller;

import co.edu.uniquindio.poo.proyectofinal.Modelo.BilleteraVirtual;
import co.edu.uniquindio.poo.proyectofinal.Modelo.Presupuesto;
import co.edu.uniquindio.poo.proyectofinal.Modelo.Usuario;

import java.util.Collection;

public class GestionUsuarioController {

    private BilleteraVirtual virtual;
    public GestionUsuarioController(BilleteraVirtual virtual){
        this.virtual = virtual;
    }

    public boolean AgregarUsuario(Usuario Usuario) {
        if (virtual == null) {
            System.err.println("Error: La Billetera no ha sido inicializada.");
            return false;
        } else {
            return virtual.agregarUsuario(Usuario);
        }
    }

    public Collection<Usuario> obtenerlistaUsuarios() {
        if (virtual == null) {
            System.err.println("Error: No se puede obtener la lista de presupuestos porque el sistema es null.");
            return null;
        } else {
            return virtual.getUsuarios();
        }
    }

    public boolean EliminarUsuarios(Usuario usuario) {
        if (virtual == null) {
            System.err.println("Error: No se puede eliminar el presupuesto ya que la billetara es null.");
            return false;
        } else {
            return virtual.eliminarUsuario(usuario);
        }
    }

    public boolean ActualizarUsuario(String ID,Usuario usuario) {
        if (virtual == null) {
            System.err.println("Error: No se puede eliminar el presupuesto ya que la billetara es null.");
            return false;
        } else {
            return virtual.actualizarUsuario(ID,usuario);
        }
    }


    public boolean Bloquear(Usuario usuario) {
        if (this.virtual == null) {
            System.err.println("Error: porque el sistema es null.");
            return false;
        }
        return virtual.bloquearUsuario(usuario);
    }

}
