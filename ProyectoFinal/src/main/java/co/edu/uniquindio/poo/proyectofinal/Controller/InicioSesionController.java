package co.edu.uniquindio.poo.proyectofinal.Controller;

import co.edu.uniquindio.poo.proyectofinal.Modelo.BilleteraVirtual;

public class InicioSesionController {
    private BilleteraVirtual virtual;
    public InicioSesionController(BilleteraVirtual virtual){
        this.virtual = virtual;
    }

    public String manejarInicioSesion(String correo, String contrasenia) {
        return virtual.iniciarSesion2(correo, contrasenia);
    }
}
