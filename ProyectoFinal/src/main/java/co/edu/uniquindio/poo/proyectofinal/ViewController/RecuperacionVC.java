package co.edu.uniquindio.poo.proyectofinal.ViewController;

import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.proyectofinal.App;
import co.edu.uniquindio.poo.proyectofinal.Controller.RecuperacionController;
import co.edu.uniquindio.poo.proyectofinal.Controller.TransaccionController;
import co.edu.uniquindio.poo.proyectofinal.Modelo.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class RecuperacionVC {
    App app;
    RecuperacionController recuperacionController;
    private Usuario selectedUsuario;
    private ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btt_Cambiar;

    @FXML
    private Button btt_Volver;

    @FXML
    private ComboBox<Persona.PreguntaSeguridad> cmbx_Pregunta;

    @FXML
    private TableView<Usuario> tb_Usuario;

    @FXML
    private TableColumn<Usuario, String> tbc_Cedula;

    @FXML
    private TextField txt_ContraseniaNueva;

    @FXML
    private TextField txt_Respuesta;

    @FXML
    void CambiarContrasenia(ActionEvent event) {
        if (selectedUsuario == null) {
            System.out.println("Debe seleccionar un usuario en la tabla.");
            return;
        }

        String nuevaContrasenia = txt_ContraseniaNueva.getText();
        String respuesta = txt_Respuesta.getText();
        Persona.PreguntaSeguridad pregunta = cmbx_Pregunta.getValue();

        if (nuevaContrasenia == null || nuevaContrasenia.isBlank() ||
                respuesta == null || respuesta.isBlank() ||
                pregunta == null) {
            System.out.println("Debe llenar todos los campos.");
            return;
        }

        boolean exito = recuperacionController.CambiarContrasenia(selectedUsuario, respuesta, pregunta, nuevaContrasenia);

        if (exito) {
            System.out.println("Contraseña cambiada exitosamente.");
            txt_ContraseniaNueva.clear();
            txt_Respuesta.clear();
            cmbx_Pregunta.getSelectionModel().clearSelection();
        } else {
            mostrarAlerta("Datos Incorrectos", "Respuesta incorrecta o pregunta incorrecta.");}
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        javafx.scene.control.Alert alerta = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
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
        assert btt_Cambiar != null : "fx:id=\"btt_Cambiar\" was not injected: check your FXML file 'Recuperacion.fxml'.";
        assert btt_Volver != null : "fx:id=\"btt_Volver\" was not injected: check your FXML file 'Recuperacion.fxml'.";
        assert cmbx_Pregunta != null : "fx:id=\"cmbx_Pregunta\" was not injected: check your FXML file 'Recuperacion.fxml'.";
        assert tb_Usuario != null : "fx:id=\"tb_Usuario\" was not injected: check your FXML file 'Recuperacion.fxml'.";
        assert tbc_Cedula != null : "fx:id=\"tbc_Cedula\" was not injected: check your FXML file 'Recuperacion.fxml'.";
        assert txt_ContraseniaNueva != null : "fx:id=\"txt_ContraseniaNueva\" was not injected: check your FXML file 'Recuperacion.fxml'.";
        assert txt_Respuesta != null : "fx:id=\"txt_Respuesta\" was not injected: check your FXML file 'Recuperacion.fxml'.";

        recuperacionController = new RecuperacionController(App.billetara);
        obtenerUsuarios();
        initView();
    }

    private void initView() {
        initDataBinding();
        tb_Usuario.setItems(listaUsuarios);
        listenerSelectionUsuario();
    }

    private void obtenerUsuarios() {
        if (listaUsuarios == null) {
            listaUsuarios = FXCollections.observableArrayList();
        }

        Collection<Usuario> usuario =  recuperacionController.obtenerListaUsuarios();
        if (usuario != null) {
            listaUsuarios.setAll(usuario);
        } else {
            System.out.println("No se encontraron Usuarios.");
        }

    }

    private void listenerSelectionUsuario() {
        tb_Usuario.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->  selectedUsuario = newSelection);
    }

    private void initDataBinding() {
        tbc_Cedula.setCellValueFactory((cellData) -> new SimpleStringProperty((cellData.getValue().getCedula())));
    }


    public void setApp(App app) {
        this.app = app;
        ObservableList<Persona.PreguntaSeguridad> options = FXCollections.observableArrayList(Persona.PreguntaSeguridad.values());
        cmbx_Pregunta.setItems(options);
    }
}
