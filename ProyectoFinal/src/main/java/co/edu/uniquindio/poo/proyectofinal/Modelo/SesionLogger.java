package co.edu.uniquindio.poo.proyectofinal.Modelo;

public class SesionLogger implements SesionObserver {


    /**
     * Este método se ejecuta cuando se inicia sesión.
     *
     * @param correo      el correo electrónico del usuario que inició sesión
     * @param tipoUsuario el tipo de usuario que inició sesión
     */
    @Override
    public void sesionIniciada(String correo, String tipoUsuario) {
        System.out.println("Se inició sesión como " + tipoUsuario + " con el correo: " + correo);
    }
}
