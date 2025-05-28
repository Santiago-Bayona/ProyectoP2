package co.edu.uniquindio.poo.proyectofinal.Modelo;

public class Administrador extends Persona{

    private double salario;

    /**
     * Metodo Constructor de la clase
     * @param nombre
     * @param contrasenia
     * @param correo
     * @param telefono
     * @param direccion
     * @param respuestaSeguridad
     * @param PreguntaSeguridad
     * @param salario
     */
    public Administrador(String nombre, String cedula, String correo, String contrasenia, String telefono, String direccion, String respuestaSeguridad, PreguntaSeguridad PreguntaSeguridad, double salario) {
        super(nombre,cedula,correo,contrasenia,telefono,direccion,respuestaSeguridad,PreguntaSeguridad);
        this.salario=salario;
    }

    /**
     * Metodo que obtiene el salario del administrador.
     * @return el salario como un valor de tipo double
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Metodo que permite modificar el salario del administrador.
     * @param salario el nuevo salario que se desea establecer, expresado como un valor de tipo double.
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Administrador{" + super.toString() +
                "salario=" + salario +
                '}';
    }
}
