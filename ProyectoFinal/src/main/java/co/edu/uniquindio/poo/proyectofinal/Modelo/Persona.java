package co.edu.uniquindio.poo.proyectofinal.Modelo;

public class Persona {
    private String nombre, correo, telefono, direccion, respuestaSeguridad,contrasenia,cedula;
    public enum PreguntaSeguridad{
        Cual_Es_El_Nombre_de_su_mascota,Pelicula_Favorita,Color_Favorito
    }
    private PreguntaSeguridad PreguntaSeguridad;

    /**
     * Metodo constructor de la clase persona
     * @param nombre
     * @param correo
     * @param telefono
     * @param direccion
     * @param respuestaSeguridad
     * @param PreguntaSeguridad
     * @param contrasenia
     */
    public Persona (String nombre, String cedula, String correo, String contrasenia, String telefono, String direccion, String respuestaSeguridad, PreguntaSeguridad PreguntaSeguridad) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.respuestaSeguridad = respuestaSeguridad;
        this.PreguntaSeguridad = PreguntaSeguridad;
        this.contrasenia=contrasenia;
        this.cedula=cedula;
    }

    /**
     * Metodo que obtiene el nombre
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que permite modificar el nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que obtiene la contraseña
     * @return apellido
     */
    public String getContrasenia() {
        return contrasenia;
    }


    /**
     * Metodo que permite modificar la contraseña
     * @param contrasenia
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Metodo que obtiene el correo
     * @return correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Metodo que permite modificar el correo
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Metodo que obtiene el telefono
     * @return telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Metodo que permite modificar el telefono
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Metodo que obtiene la direccion
     * @return direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Metodo que permite modificar la direccion
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Metodo que obtiene la respuesta de seguridad
     * @return RespuestaSeguridad
     */
    public String getRespuestaSeguridad() {
        return respuestaSeguridad;
    }

    /**
     * Metodo que permite modificar la respuesta de seguridad
     * @param respuestaSeguridad
     */
    public void setRespuestaSeguridad(String respuestaSeguridad) {
        this.respuestaSeguridad = respuestaSeguridad;
    }

    /**
     * Metodo que obtiene la pregunta seguridad
     * @return preguntaSeguridad
     */
    public PreguntaSeguridad getPreguntaSeguridad() {
        return PreguntaSeguridad;
    }

    /**
     * Metodo que permite modificar la pregunta seguridad
     * @param preguntaSeguridad
     */
    public void setPreguntaSeguridad(PreguntaSeguridad preguntaSeguridad) {
        PreguntaSeguridad = preguntaSeguridad;
    }

    /**
     * Metood que permite obtener la cedula de una persona
     * @return cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Metodo que permite modificar la cedula de una persona
     * @param cedula
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", respuestaSeguridad='" + respuestaSeguridad + '\'' +
                ", PreguntaSeguridad=" + PreguntaSeguridad +
                '}';
    }
}
