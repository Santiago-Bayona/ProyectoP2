package co.edu.uniquindio.poo.proyectofinal.ViewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.proyectofinal.App;
import co.edu.uniquindio.poo.proyectofinal.Controller.RegistroController;
import co.edu.uniquindio.poo.proyectofinal.Modelo.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegistroVC {
    App app;
    private ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();
    private Usuario selectedUsuario;
    RegistroController registroController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btt_Agregar;

    @FXML
    private Button btt_Eliminar;

    @FXML
    private Button btt_Limpiar;

    @FXML
    private Button btt_Volver;

    @FXML
    private ComboBox<Persona.PreguntaSeguridad> cmbx_PreguntaSeguridad;

    @FXML
    private TextField txt_Cedula;

    @FXML
    private TextField txt_Contrasenia;

    @FXML
    private TextField txt_Correo;

    @FXML
    private TextField txt_Nombre;

    @FXML
    private TextField txt_RespuestaSeguridad;

    @FXML
    private TextField txt_Saldo;

    @FXML
    private TextField txt_Telefono;

    @FXML
    private TextField txt__Direccion;

    @FXML
    void Agregar(ActionEvent event) {
        agregarUsuario();
        mostrarMensaje("El Usuario ha sido registrado Exitosamente", "Registro", "Usuario registrado exitosamente", Alert.AlertType.INFORMATION);
    }

    @FXML
    void Eliminar(ActionEvent event) {
        eliminarUsuario();
    }

    @FXML
    void Limpiar(ActionEvent event) {
        limpiarCampos();
    }

    @FXML
    void Volver(ActionEvent event) {
        try{
            app.openViewPrincipal();
        } catch (Exception e) {
            System.err.println("Error al volver a la vista principal.");
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert btt_Agregar != null : "fx:id=\"btt_Agregar\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
        assert btt_Eliminar != null : "fx:id=\"btt_Eliminar\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
        assert btt_Limpiar != null : "fx:id=\"btt_Limpiar\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
        assert btt_Volver != null : "fx:id=\"btt_Volver\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
        assert cmbx_PreguntaSeguridad != null : "fx:id=\"cmbx_PreguntaSeguridad\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
        assert txt_Cedula != null : "fx:id=\"txt_Cedula\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
        assert txt_Contrasenia != null : "fx:id=\"txt_Contrasenia\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
        assert txt_Correo != null : "fx:id=\"txt_Correo\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
        assert txt_Nombre != null : "fx:id=\"txt_Nombre\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
        assert txt_RespuestaSeguridad != null : "fx:id=\"txt_RespuestaSeguridad\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
        assert txt_Saldo != null : "fx:id=\"txt_Saldo\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
        assert txt_Telefono != null : "fx:id=\"txt_Telefono\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
        assert txt__Direccion != null : "fx:id=\"txt__Direccion\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";

        registroController = new RegistroController(App.billetara);
        obtenerUsuario();
        initView();

    }

    private void obtenerUsuario() {
        if ( registroController != null) {
            listaUsuarios.addAll( registroController.obtenerListaUsuarios());
        } else {
            System.err.println("RegistroController no está inicializado.");
        }

    }

    public void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private void initView() {
    }

    private void mostrarInformacionUsuario(Usuario usuario) {
        if (usuario != null) {
            txt_Nombre.setText(usuario.getNombre());
            txt__Direccion.setText(usuario.getDireccion());
            txt_Cedula.setText(usuario.getCedula());
            txt_Correo.setText(usuario.getCorreo());
            txt_Telefono.setText(usuario.getTelefono());
            //txt_Saldo.setText(String.valueOf(usuario.getSaldoTotal()));
            txt_Contrasenia.setText(usuario.getContrasenia());
            txt_RespuestaSeguridad.setText(usuario.getRespuestaSeguridad());
            cmbx_PreguntaSeguridad.setValue(usuario.getPreguntaSeguridad());
        }

    }

    private void agregarUsuario() {
        Usuario usuario =  buildUsuario();
        if ( registroController.AgregarUsuario(usuario)) {
            listaUsuarios.add(usuario);
            limpiarCampos();
        }

    }

    private Usuario buildUsuario() {
        String correo = txt_Correo.getText();
        if (!correo.contains("@")) {
            mostrarMensaje("Error", "Registro", "El correo ingresado no es valido, debe contener @", Alert.AlertType.ERROR);
            return null;
        }

        Usuario usuario = new Usuario( txt_Nombre.getText(),  txt_Cedula.getText(),  txt_Correo.getText(),  txt_Contrasenia.getText(), txt_Telefono.getText(),txt__Direccion.getText(), txt_RespuestaSeguridad.getText(), cmbx_PreguntaSeguridad.getValue());
        return usuario;
    }

    private void eliminarUsuario() {
        if ( registroController.EliminarUsuarios( selectedUsuario)) {
            listaUsuarios.remove( selectedUsuario);
            limpiarCampos();
        }

    }



    private void limpiarCampos() {
        txt_Contrasenia.clear();
        txt_Nombre.clear();
        //txt_Saldo.clear();
        txt_Correo.clear();
        txt_RespuestaSeguridad.clear();
        txt_Telefono.clear();
        txt__Direccion.clear();
        txt_Cedula.clear();
        cmbx_PreguntaSeguridad.getSelectionModel().clearSelection();
    }
    public void cargarOpciones(){
        ObservableList<Persona.PreguntaSeguridad> options = FXCollections.observableArrayList(Persona.PreguntaSeguridad.values());
        cmbx_PreguntaSeguridad.setItems(options);
    }

    public void setApp(App app) {
        this.app = app;
        cargarOpciones();
    }

}