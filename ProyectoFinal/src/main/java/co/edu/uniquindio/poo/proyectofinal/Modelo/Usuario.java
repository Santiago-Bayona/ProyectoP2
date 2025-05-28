package co.edu.uniquindio.poo.proyectofinal.Modelo;

import java.util.Collection;
import java.util.LinkedList;

public class Usuario extends Persona  {

    private Collection<CuentaBancaria> cuentaBancarias;
    private BilleteraVirtual billetera;
    private double saldoTotal;
     private boolean bloqueado;

    /**
     * Constructor de la clase Usuario.
     * Inicializa el saldo total a 0, el estado de bloqueo a falso, y
     * las colecciones necesarias como las cuentas bancarias y la billetera virtual.
     *
     * @param nombre             Nombre del usuario
     * @param cedula             Cédula del usuario
     * @param correo             Correo electrónico del usuario
     * @param contrasenia        Contraseña del usuario
     * @param telefono           Teléfono del usuario
     * @param direccion          Dirección del usuario
     * @param respuestaSeguridad Respuesta de seguridad del usuario
     * @param PreguntaSeguridad  Pregunta de seguridad seleccionada por el usuario
     */
    public Usuario(String nombre, String cedula, String correo, String contrasenia, String telefono, String direccion, String respuestaSeguridad, PreguntaSeguridad PreguntaSeguridad) {
        super(nombre, cedula, correo, contrasenia, telefono, direccion, respuestaSeguridad, PreguntaSeguridad);
        this.saldoTotal = 0;
        this.bloqueado = false;
        this.cuentaBancarias = new LinkedList<>();
        this.billetera = new BilleteraVirtual("djdj");
    }

    /**
     * Método que actualiza el saldo total del usuario.
     * Calcula el saldo sumando los saldos de todas las cuentas bancarias asociadas al usuario.
     */
    public void actualizarSaldoTotal() {
        double total = 0;
        Collection<CuentaBancaria> cuentas = billetera.getCuentasPorUsuario(this);
        for (CuentaBancaria cuenta : cuentas) {
            total += cuenta.getSaldoCuenta();
        }
        setSaldoTotal(total);
    }

    /**
     * Obtiene el estado de bloqueo del usuario.
     *
     * @return true si el usuario está bloqueado, false en caso contrario
     */
    public boolean getBloqueado() {
        return bloqueado;
    }

    /**
     * Modifica el estado de bloqueo del usuario.
     *
     * @param bloqueado Nuevo estado de bloqueo del usuario
     */
    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    /**
     * Obtiene el saldo total del usuario.
     *
     * @return saldoTotal Saldo total del usuario
     */
    public double getSaldoTotal() {
        return saldoTotal;
    }

    /**
     * Modifica el saldo total del usuario.
     *
     * @param saldoTotal Saldo total nuevo del usuario
     */
    public void setSaldoTotal(double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    @Override
    public String toString() {
        return "Usuario{" + super.toString()+ ", saldoTotal=" + saldoTotal +
                '}';
    }
}
