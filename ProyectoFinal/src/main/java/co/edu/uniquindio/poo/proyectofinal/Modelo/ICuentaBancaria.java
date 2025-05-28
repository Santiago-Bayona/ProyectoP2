package co.edu.uniquindio.poo.proyectofinal.Modelo;

public interface ICuentaBancaria {
    public boolean verificarCuentaBancaria(String id);
    public boolean agregarCuentaBancaria(CuentaBancaria cuentaBancaria);
    public boolean eliminarCuentaBancaria(CuentaBancaria cuentaBancaria);
    public boolean actualizarCuenta(String id, CuentaBancaria cuentaBancaria);
}
