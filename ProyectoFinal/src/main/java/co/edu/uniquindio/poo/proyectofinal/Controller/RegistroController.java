package co.edu.uniquindio.poo.proyectofinal.Controller;

import co.edu.uniquindio.poo.proyectofinal.Modelo.*;

import java.util.Collection;

public class RegistroController {
    private BilleteraVirtual virtual;

    public RegistroController(BilleteraVirtual virtual){
        this.virtual = virtual;
    }

    public boolean AgregarUsuario(Usuario usuario) {
        if (virtual == null) {
            System.err.println("Error: La Billetera no ha sido inicializada.");
            return false;
        } else {
            return virtual.agregarUsuario(usuario);
        }
    }

    public Collection<Usuario> obtenerListaUsuarios() {
        if (virtual == null) {
            System.err.println("Error: No se puede obtener la lista de usuarios porque el sistema es null.");
            return null;
        } else {
            return virtual.getUsuarios();
        }
    }

    public boolean EliminarUsuarios(Usuario usuario) {
        if (virtual == null) {
            System.err.println("Error: No se puede eliminar la transaccion ya que la billetara es null.");
            return false;
        } else {
            return virtual.eliminarUsuario(usuario);
        }
    }

}
