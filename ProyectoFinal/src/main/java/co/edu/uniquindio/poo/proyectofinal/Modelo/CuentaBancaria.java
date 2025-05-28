package co.edu.uniquindio.poo.proyectofinal.Modelo;

import java.util.Collection;

public class CuentaBancaria {
    private String idCuenta;
    private String banco;
    private int numeroCuenta;
    private TipoCuenta tipoCuenta;
    private Usuario usuario;
    public Double SaldoCuenta;

    public Collection<Transaccion> transacciones;

    /**
     * Constructor de la clase CuentaBancaria
     *
     * @param idCuenta     Identificador único de la cuenta bancaria
     * @param banco        Nombre del banco al que pertenece la cuenta bancaria
     * @param numeroCuenta Número de la cuenta bancaria
     * @param tipoCuenta   Tipo de cuenta bancaria (AHORRO o CORRIENTE)
     * @param usuario      Usuario asociado a la cuenta bancaria
     */
    public CuentaBancaria(String idCuenta, String banco, int numeroCuenta, TipoCuenta tipoCuenta, Usuario usuario) {
        this.idCuenta = idCuenta;
        this.banco = banco;
        this.tipoCuenta = tipoCuenta;
        this.numeroCuenta = numeroCuenta;
        this.usuario = usuario;
        this.SaldoCuenta = 0.0;
    }

    /**
     * Obtiene el identificador único de la cuenta bancaria
     *
     * @return Identificador de la cuenta bancaria
     */
    public String getIdCuenta() {
        return idCuenta;
    }

    /**
     * Establece el identificador único de la cuenta bancaria
     *
     * @param idCuenta Identificador de la cuenta bancaria
     */
    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    /**
     * Obtiene el nombre del banco al que pertenece la cuenta bancaria
     *
     * @return Nombre del banco
     */
    public String getBanco() {
        return banco;
    }

    /**
     * Establece el nombre del banco al que pertenece la cuenta bancaria
     *
     * @param banco Nombre del banco
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * Obtiene el tipo de cuenta bancaria (AHORRO o CORRIENTE)
     *
     * @return Tipo de cuenta bancaria
     */
    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    /**
     * Establece el tipo de cuenta bancaria
     *
     * @param tipoCuenta Tipo de cuenta bancaria (AHORRO o CORRIENTE)
     */
    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    /**
     * Obtiene el número de la cuenta bancaria
     *
     * @return Número de la cuenta bancaria
     */
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Establece el número de la cuenta bancaria
     *
     * @param numeroCuenta Número de la cuenta bancaria
     */
    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * Obtiene el usuario asociado a la cuenta bancaria
     *
     * @return Usuario asociado
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario asociado a la cuenta bancaria
     *
     * @param usuario Usuario asociado
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene el saldo actual de la cuenta bancaria
     *
     * @return Saldo de la cuenta bancaria
     */
    public Double getSaldoCuenta() {
        return SaldoCuenta;
    }

    /**
     * Establece el saldo de la cuenta bancaria
     *
     * @param saldoCuenta Saldo de la cuenta bancaria
     */
    public void setSaldoCuenta(Double saldoCuenta) {
        SaldoCuenta = saldoCuenta;
    }
    
    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "idCuenta='" + idCuenta + '\'' +
                ", banco='" + banco + '\'' +
                ", tipoCuenta=" + tipoCuenta +
                '}';
    }
}
