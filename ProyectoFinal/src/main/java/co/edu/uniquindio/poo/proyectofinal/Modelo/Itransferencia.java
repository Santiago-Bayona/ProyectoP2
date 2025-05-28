package co.edu.uniquindio.poo.proyectofinal.Modelo;

public interface Itransferencia {
    public boolean verificarTransaccion(String id);
    public boolean agregarTransaccion(Transaccion transaccion);
    public boolean eliminarTransaccion(Transaccion transaccion);
}
