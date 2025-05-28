package co.edu.uniquindio.poo.proyectofinal.Modelo;

public interface IUsuario {
    public boolean verificarUsuario(String cedula);
    public boolean agregarUsuario(Usuario usuario);
    public boolean eliminarUsuario(Usuario usuario);
}
