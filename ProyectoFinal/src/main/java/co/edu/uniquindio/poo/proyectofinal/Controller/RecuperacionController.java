package co.edu.uniquindio.poo.proyectofinal.Controller;

import co.edu.uniquindio.poo.proyectofinal.Modelo.BilleteraVirtual;
import co.edu.uniquindio.poo.proyectofinal.Modelo.Categoria;
import co.edu.uniquindio.poo.proyectofinal.Modelo.Persona;
import co.edu.uniquindio.poo.proyectofinal.Modelo.Usuario;

import java.util.Collection;

public class RecuperacionController {
    private BilleteraVirtual virtual;
    public RecuperacionController(BilleteraVirtual virtual){
        this.virtual = virtual;
    }

    public Collection<Usuario> obtenerListaUsuarios() {
        if (this.virtual == null) {
        }

        return this.virtual.getUsuarios();
    }

    public Boolean CambiarContrasenia(Usuario usuario, String respuesta, Persona.PreguntaSeguridad pregunta, String ContraseniaNueva) {
        return virtual.RecuperarContraseña(usuario, respuesta, pregunta, ContraseniaNueva);
    }
}
