package co.edu.uniquindio.poo.proyectofinal.Modelo;

public class Presupuesto {
    private String id,nombre;
    private double montoAsignado, montoGastado;
    public CuentaBancaria cuentaBancaria;

    /**
     * Matodo constructor de la clase
     * @param id
     * @param nombre
     * @param montoAsignado
     * @param montoGastado
     */
    public Presupuesto(String id, String nombre, double montoAsignado, double montoGastado, CuentaBancaria cuentaBancaria) {
        this.id = id;
        this.nombre = nombre;
        this.montoAsignado = montoAsignado;
        this.montoGastado = montoGastado;
        this.cuentaBancaria = cuentaBancaria;
    }

    /**
     * Metodo que obtiene el id del pesupuesto
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Metodo que obtiene el nombre
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que obtiene el monto del presupuesto
     * @return
     */
    public double getMontoAsignado() {
        return montoAsignado;
    }

    /**
     *
     * @param montoAsignado
     */
    public void setMontoAsignado(double montoAsignado) {
        if (montoAsignado < 0) {
            throw new IllegalArgumentException("El monto asignado no puede ser menor que 0.");
        }
        if (cuentaBancaria != null && montoAsignado > cuentaBancaria.getUsuario().getSaldoTotal()) {
            throw new IllegalArgumentException("El monto asignado no puede ser mayor que el saldo de la cuenta bancaria.");
        }
        this.montoAsignado = montoAsignado;
    }

    /**
     * Establece el monto gastado en el presupuesto
     *
     * @param montoGastado Monto gastado que se quiere establecer
     * @throws IllegalArgumentException Si el monto gastado es menor que 0 o es mayor que el monto asignado
     */
    public void setMontoGastado(double montoGastado) {
        if (montoGastado < 0) {
            throw new IllegalArgumentException("El monto gastado no puede ser menor que 0.");
        }
        if (montoGastado > montoAsignado) {
            throw new IllegalArgumentException("El monto gastado no puede ser mayor que el monto asignado.");
        }
        this.montoGastado = montoGastado;
    }

    /**
     * Obtiene el monto gastado del presupuesto
     *
     * @return Monto gastado
     */
    public double getMontoGastado() {
        return montoGastado;
    }

    /**
     * Establece la cuenta bancaria asociada al presupuesto
     *
     * @param cuentaBancaria Cuenta bancaria que se quiere asociar
     */
    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    /**
     * Obtiene la cuenta bancaria asociada al presupuesto
     *
     * @return Cuenta bancaria asociada
     */
    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    @Override
    public String toString() {
        return "Presupuesto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", monto=" + montoAsignado +
                ", TotalAsignado=" + montoGastado +
                '}';
    }
}
