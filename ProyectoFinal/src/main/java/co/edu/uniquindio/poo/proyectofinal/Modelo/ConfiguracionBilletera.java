package co.edu.uniquindio.poo.proyectofinal.Modelo;

public class ConfiguracionBilletera {
    private static ConfiguracionBilletera instance;
    private String horarioAtencion;
    private String contactoSoporte;

    /**
     * Constructor privado para evitar la creación de instancias externas.
     * Inicializa la configuración con valores predeterminados.
     */
    private ConfiguracionBilletera() {
        this.horarioAtencion = "7:00 AM - 7:00 PM";
        this.contactoSoporte = "018000#1234";
    }

    /**
     * @return la instancia única de ConfiguracionBilletera
     */
    public static ConfiguracionBilletera getInstance() {
        if (instance == null) {
            instance = new ConfiguracionBilletera();
        }
        return instance;
    }

    /**
     * Establece una nueva instancia de ConfiguracionBilletera.
     *
     * @param instance
     */
    public static void setInstance(ConfiguracionBilletera instance) {

        ConfiguracionBilletera.instance = instance;
    }

    /**
     * Obtiene el horario de atención de la billetera.
     *
     * @return el horario de atención.
     */
    public String getHorarioAtencion() {

        return horarioAtencion;
    }

    /**
     * Permite modificar el horario de atencion.
     * @param horarioAtencion
     */
    public void setHorarioAtencion(String horarioAtencion) {

        this.horarioAtencion = horarioAtencion;
    }

    /**
     * Obtiene el contacto soporte de la billetera.
     * @return contacteSoporte
     */
    public String getContactoSoporte() {
        return contactoSoporte;
    }

    /**
     * Metodo que permite modificar el contactoSoporte.
     * @param contactoSoporte
     */
    public void setContactoSoporte(String contactoSoporte) {

        this.contactoSoporte = contactoSoporte;
    }

    /**
     * Representación en cadena de la configuración de la billetera.
     *
     * @return una cadena con los valores actuales de la configuración.
     */
    @Override
    public String toString() {
        return "ConfiguracionBilletera{" +
                "horarioAtencion='" + horarioAtencion + '\'' +
                ", contacto='" + contactoSoporte + '\'' +
                '}';
    }
}
