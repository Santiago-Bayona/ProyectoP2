package co.edu.uniquindio.poo.proyectofinal.ViewController;

import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.proyectofinal.App;
import co.edu.uniquindio.poo.proyectofinal.Controller.GestionUsuarioController;
import co.edu.uniquindio.poo.proyectofinal.Modelo.Persona;
import co.edu.uniquindio.poo.proyectofinal.Modelo.Usuario;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class GestionUsuariosVC {
    App app;
    private ObservableList<Usuario> listaUsuarios= FXCollections.observableArrayList();
    private Usuario selectedUsuario;
    GestionUsuarioController gestionUsuarioController;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btt_Actualizar;

    @FXML
    private Button btt_Bloquear;

    @FXML
    private Button btt_Eliminar;

    @FXML
    private Button btt_Limpiar;

    @FXML
    private Button btt_Realizar;

    @FXML
    private ComboBox<Persona.PreguntaSeguridad> cmbx_PreguntaSeguridad;

    @FXML
    private TableView<Usuario> tb_Usuario;

    @FXML
    private TableColumn<Usuario, String> tbc_Cedula;

    @FXML
    private TableColumn<Usuario, Boolean> tbc_Bloqueado;

    @FXML
    private TableColumn<Usuario, String> tbc_Nombre;

    @FXML
    private TableColumn<Usuario, Double> tbc_Saldo;

    @FXML
    private TableColumn<Usuario, String> tbc_Telefono;

    @FXML
    private TextField txt_Cedula;

    @FXML
    private TextField txt_Contraseña;

    @FXML
    private TextField txt_Correo;

    @FXML
    private TextField txt_Direccion;

    @FXML
    private TextField txt_RespuestaSeguridad;

    @FXML
    private TextField txt_Telefono;

    @FXML
    private TextField txt_nombre;

    @FXML
    void Actualizar(ActionEvent event) {
        actualizarUsuario();
    }

    @FXML
    void BloquearUsuario(ActionEvent event) {
        if (selectedUsuario != null) {
            if (gestionUsuarioController.Bloquear(selectedUsuario)) {
                tb_Usuario.refresh(); // Refresca la tabla para mostrar el estado bloqueado
            } else {
                System.out.println("No se pudo bloquear el usuario.");
            }
        }
    }


    @FXML
    void Eliminar(ActionEvent event) {
        eliminarUsuario();
    }

    @FXML
    void Limpoiar(ActionEvent event) {
        limpiarCampos();
    }

    @FXML
    void Realizar(ActionEvent event) {
        agregarUsuario();
    }

    @FXML
    void initialize() {
        assert btt_Actualizar != null : "fx:id=\"btt_Actualizar\" was not injected: check your FXML file 'GestionUsuarios.fxml'.";
        assert btt_Bloquear != null : "fx:id=\"btt_Bloquear\" was not injected: check your FXML file 'GestionUsuarios.fxml'.";
        assert btt_Eliminar != null : "fx:id=\"btt_Eliminar\" was not injected: check your FXML file 'GestionUsuarios.fxml'.";
        assert btt_Limpiar != null : "fx:id=\"btt_Limpiar\" was not injected: check your FXML file 'GestionUsuarios.fxml'.";
        assert btt_Realizar != null : "fx:id=\"btt_Realizar\" was not injected: check your FXML file 'GestionUsuarios.fxml'.";
        assert cmbx_PreguntaSeguridad != null : "fx:id=\"cmbx_PreguntaSeguridad\" was not injected: check your FXML file 'GestionUsuarios.fxml'.";
        assert tb_Usuario != null : "fx:id=\"tb_Usuario\" was not injected: check your FXML file 'GestionUsuarios.fxml'.";
        assert tbc_Cedula != null : "fx:id=\"tbc_Cedula\" was not injected: check your FXML file 'GestionUsuarios.fxml'.";
        assert tbc_Bloqueado != null : "fx:id=\"tbc_Bloqueado\" was not injected: check your FXML file 'GestionUsuarios.fxml'.";
        assert tbc_Nombre != null : "fx:id=\"tbc_Nombre\" was not injected: check your FXML file 'GestionUsuarios.fxml'.";
        assert tbc_Saldo != null : "fx:id=\"tbc_Saldo\" was not injected: check your FXML file 'GestionUsuarios.fxml'.";
        assert tbc_Telefono != null : "fx:id=\"tbc_Telefono\" was not injected: check your FXML file 'GestionUsuarios.fxml'.";
        assert txt_Cedula != null : "fx:id=\"txt_Cedula\" was not injected: check your FXML file 'GestionUsuarios.fxml'.";
        assert txt_Contraseña != null : "fx:id=\"txt_Contraseña\" was not injected: check your FXML file 'GestionUsuarios.fxml'.";
        assert txt_Correo != null : "fx:id=\"txt_Correo\" was not injected: check your FXML file 'GestionUsuarios.fxml'.";
        assert txt_Direccion != null : "fx:id=\"txt_Direccion\" was not injected: check your FXML file 'GestionUsuarios.fxml'.";
        assert txt_RespuestaSeguridad != null : "fx:id=\"txt_RespuestaSeguridad\" was not injected: check your FXML file 'GestionUsuarios.fxml'.";
        assert txt_Telefono != null : "fx:id=\"txt_Telefono\" was not injected: check your FXML file 'GestionUsuarios.fxml'.";
        assert txt_nombre != null : "fx:id=\"txt_nombre\" was not injected: check your FXML file 'GestionUsuarios.fxml'.";

        gestionUsuarioController=new GestionUsuarioController(App.billetara);
        obtenerUsuarios();
        initView();
    }

    private void obtenerUsuarios(){
        if (gestionUsuarioController != null) {
            Collection<Usuario> usuarios = gestionUsuarioController.obtenerlistaUsuarios();
            for (Usuario usuario : usuarios) {
                usuario.actualizarSaldoTotal();
            }
            listaUsuarios.addAll(gestionUsuarioController.obtenerlistaUsuarios());
        } else {
            System.err.println("gestionController no está inicializado.");
        }
    }

    private void initView() {
        initDataBinding();
        tb_Usuario.getItems().clear();
        tb_Usuario.setItems(listaUsuarios);
        listenerSelection();
    }

    /**
     * Método que configura el enlace entre los datos y la vista.
     */

    private void initDataBinding() {
        tbc_Nombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbc_Cedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tbc_Telefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        tbc_Saldo.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getSaldoTotal()));
        tbc_Bloqueado.setCellValueFactory(celldata -> new SimpleBooleanProperty(celldata.getValue().getBloqueado()));
    }

    /**
     * Método que configura un listener para la selección de elementos en la tabla de doctores.
     */

    private void listenerSelection() {
        tb_Usuario.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedUsuario = newSelection;
            mostrarInformacionUsuario(selectedUsuario);
        });
    }

    /**
     * Metodo que muestra la información del doctor  seleccionado en el campo de texto.
     * @param usuario
     */

    private void mostrarInformacionUsuario(Usuario usuario) {
        if (usuario != null) {
            txt_Cedula.setText(usuario.getCedula());
            txt_Contraseña.setText(usuario.getContrasenia());
            txt_Correo.setText(usuario.getCorreo());
            txt_Direccion.setText(usuario.getDireccion());
            txt_nombre.setText(usuario.getNombre());
            txt_Telefono.setText(usuario.getTelefono());
            txt_RespuestaSeguridad.setText(usuario.getRespuestaSeguridad());
            cmbx_PreguntaSeguridad.getSelectionModel().select(usuario.getPreguntaSeguridad());
        }
    }

    /**
     * Metodo que agrega un nuevo doctor a la lista y lo almacena en el controlador.
     * Se crea un nuevo doctor a partir de los datos ingresados y se añade a la lista si la operación es exitosa.
     */

    private void agregarUsuario() {
        Usuario usuario = buildUsuario();
        if(gestionUsuarioController.AgregarUsuario(usuario)){
            listaUsuarios.add(usuario);
            limpiarCampos();
        }
    }

    /**
     * Metodo que construye un objeto de tipo doctor con la información ingresada.
     * @return Un objeto Doctor con el código ingresado en el campo de texto.
     */

    private Usuario buildUsuario() {

        Usuario usuario = new Usuario(
                txt_nombre.getText(),
                txt_Cedula.getText(),
                txt_Correo.getText(),
                txt_Contraseña.getText(),
                txt_Telefono.getText(),
                txt_Direccion.getText(),
                txt_RespuestaSeguridad.getText(),
                cmbx_PreguntaSeguridad.getValue()
        );
        return usuario;
    }


    /**
     * Metodo que elimina el doctor seleccionado de la lista y del controlador.
     * Si la eliminación es exitosa, también se eliminan los datos de la tabla y se limpian los campos de entrada.
     */

    private void eliminarUsuario() {
        if (gestionUsuarioController.EliminarUsuarios(selectedUsuario)){
            listaUsuarios.remove(selectedUsuario);
            limpiarCampos();
            limpiarSeleccion();
        }
    }

    /**
     * Metodo que actualiza la información del doctor seleccionado.
     * Si el Doctor se encuentra en la lista y la actualización es exitosa,
     * se reemplaza por el nuevo objeto actualizado y se refresca la tabla.
     */

    private void actualizarUsuario() {

        if (selectedUsuario != null &&
                gestionUsuarioController.ActualizarUsuario(selectedUsuario.getCedula(), buildUsuario())) {

            int index = listaUsuarios.indexOf(selectedUsuario);
            if (index >= 0) {
                listaUsuarios.set(index, buildUsuario());
            }

            tb_Usuario.refresh();
            limpiarSeleccion();
            limpiarCampos();
        }
    }

    /**
     * Metodo que limpia la selección de la tabla de doctor y los campos de entrada.
     */
    private void limpiarSeleccion() {
        tb_Usuario.getSelectionModel().clearSelection();
        limpiarCampos();
    }

    /**
     * Metodo que limpia los campos de entrada y la selección de la tabla de Doctor.
     */
    private void limpiarCampos() {
        txt_nombre.clear();
                txt_Cedula.clear();
                txt_Correo.clear();
                txt_Contraseña.clear();
                txt_Telefono.clear();
                txt_Direccion.clear();
                txt_RespuestaSeguridad.clear();
                cmbx_PreguntaSeguridad.setValue(null);
    }

    public void CargarOpciones() {
        ObservableList<Persona.PreguntaSeguridad> options = FXCollections.observableArrayList(Persona.PreguntaSeguridad.values());
        cmbx_PreguntaSeguridad.setItems((options));
    }

    /**
     * Establece la instancia de la aplicación para acceder a sus métodos.
     * @param app
     */

    public void setApp(App app) {
        this.app = app;

    }
}