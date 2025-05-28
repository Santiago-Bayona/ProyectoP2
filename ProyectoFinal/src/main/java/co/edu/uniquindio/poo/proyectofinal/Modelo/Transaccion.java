package co.edu.uniquindio.poo.proyectofinal.Modelo;

import java.time.LocalDate;

public class Transaccion {
    private String idTransaccion;
    private LocalDate fechaTransaccion;
    private Double monto;
    private String descripcion;
    private TipoTransaccion tipoTransaccion;
    private Categoria categoria;
    private CuentaBancaria cuenta1,cuenta2;

    /**
     * Constructor de la clase Transaccion.
     *
     * @param idTransaccion    Identificador único de la transacción.
     * @param monto            Monto de la transacción.
     * @param fechaTransaccion Fecha en que se realiza la transacción.
     * @param descripcion      Descripción de la transacción.
     * @param categoria        Categoría asociada a la transacción.
     * @param tipoTransaccion  Tipo de la transacción (DEPOSITO, RETIRO, TRANSFERENCIA).
     * @param cuenta1          Primera cuenta asociada a la transacción.
     * @param cuenta2          Segunda cuenta asociada a la transacción (puede ser null en algunas transacciones).
     */
    public Transaccion(String idTransaccion, Double monto, LocalDate fechaTransaccion, String descripcion, Categoria categoria, TipoTransaccion tipoTransaccion, CuentaBancaria cuenta1, CuentaBancaria cuenta2) {
        this.idTransaccion = idTransaccion;
        this.monto = monto;
        this.fechaTransaccion = fechaTransaccion;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.tipoTransaccion = tipoTransaccion;
        this.cuenta1 = cuenta1;
        this.cuenta2 = cuenta2;
    }

    /**
     * Obtiene el identificador único de la transacción.
     *
     * @return Identificador de la transacción.
     */
    public String getIdTransaccion() {
        return idTransaccion;
    }

    /**
     * Establece el identificador único de la transacción.
     *
     * @param idTransaccion Identificador de la transacción.
     */
    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    /**
     * Obtiene la fecha en la que se realiza la transacción.
     *
     * @return Fecha de la transacción.
     */
    public LocalDate getFechaTransaccion() {
        return fechaTransaccion;
    }

    /**
     * Establece la fecha de la transacción.
     *
     * @param fechaTransaccion Fecha de la transacción.
     */
    public void setFechaTransaccion(LocalDate fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    /**
     * Obtiene el monto de la transacción.
     *
     * @return Monto de la transacción.
     */
    public Double getMonto() {
        return monto;
    }

    /**
     * Establece el monto de la transacción.
     *
     * @param monto Monto de la transacción.
     */
    public void setMonto(Double monto) {
        this.monto = monto;
    }

    /**
     * Obtiene la descripción de la transacción.
     *
     * @return Descripción de la transacción.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la transacción.
     *
     * @param descripcion Descripción de la transacción.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el tipo de la transacción.
     *
     * @return Tipo de transacción.
     */
    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    /**
     * Establece el tipo de la transacción.
     *
     * @param tipoTransaccion Tipo de la transacción.
     */
    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    /**
     * Obtiene la categoría asociada a la transacción.
     *
     * @return Categoría de la transacción.
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría asociada a la transacción.
     *
     * @param categoria Categoría de la transacción.
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * Obtiene la primera cuenta asociada a la transacción.
     *
     * @return Primera cuenta de la transacción.
     */
    public CuentaBancaria getCuenta1() {
        return cuenta1;
    }

    /**
     * Establece la primera cuenta asociada a la transacción.
     *
     * @param cuenta1 Primera cuenta de la transacción.
     */
    public void setCuenta1(CuentaBancaria cuenta1) {
        this.cuenta1 = cuenta1;
    }

    /**
     * Obtiene la segunda cuenta asociada a la transacción.
     *
     * @return Segunda cuenta de la transacción.
     */
    public CuentaBancaria getCuenta2() {
        return cuenta2;
    }

    /**
     * Establece la segunda cuenta asociada a la transacción.
     *
     * @param cuenta2 Segunda cuenta de la transacción.
     */
    public void setCuenta2(CuentaBancaria cuenta2) {
        this.cuenta2 = cuenta2;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "idTransaccion='" + idTransaccion + '\'' +
                ", fechaTransaccion=" + fechaTransaccion +
                ", monto=" + monto +
                ", descripcion='" + descripcion + '\'' +
                ", tipoTransaccion=" + tipoTransaccion +
                ", categoria=" + categoria +
                '}';
    }
}
