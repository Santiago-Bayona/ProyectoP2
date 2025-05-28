package co.edu.uniquindio.poo.proyectofinal.ViewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.proyectofinal.App;
import co.edu.uniquindio.poo.proyectofinal.Controller.InicioSesionController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class BienvenidoVC {
    App app;
    InicioSesionController inicioSesionController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btt_Ingresar;

    @FXML
    private Text finTitle;

    @FXML
    private Hyperlink hyp_Recuperar;

    @FXML
    private Hyperlink hyp_Registar;

    @FXML
    private AnchorPane sideAnker;

    @FXML
    private AnchorPane sideBar;

    @FXML
    private Text titulo;

    @FXML
    private TextField txt_Contrasenia;

    @FXML
    private TextField txt_Correo;

    @FXML
    void Ingresar(ActionEvent event) {
        String correo = txt_Correo.getText();
        String contraseñaCorreo = txt_Contrasenia.getText();

        String tipoUsuario = inicioSesionController.manejarInicioSesion(correo, contraseñaCorreo);

        switch (tipoUsuario) {
            case "usuario":
                mostrarMensaje("Inicio de sesión exitoso", "Login", "Bienvenido, usuario", Alert.AlertType.INFORMATION);
                try {
                    app.UsuarioMenu(correo); // carga la vista de usuario
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case "admin":
                mostrarMensaje("Inicio de sesión exitoso", "Login", "Bienvenido, administrador", Alert.AlertType.INFORMATION);
                try {
                    app.AdminMenu();; // carga la vista de administrador
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            default:
                mostrarMensaje("Error de inicio de sesión", "Login", "Credenciales incorrectas", Alert.AlertType.WARNING);
                break;
        }
    }

    @FXML
    void Recuperar(ActionEvent event) {
        try {
            app.Recuperacion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Registrar(ActionEvent event) {
        try {
            app.Registro();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert btt_Ingresar != null : "fx:id=\"btt_Ingresar\" was not injected: check your FXML file 'BienvenidoMenu.fxml'.";
        assert finTitle != null : "fx:id=\"finTitle\" was not injected: check your FXML file 'BienvenidoMenu.fxml'.";
        assert hyp_Recuperar != null : "fx:id=\"hyp_Recuperar\" was not injected: check your FXML file 'BienvenidoMenu.fxml'.";
        assert hyp_Registar != null : "fx:id=\"hyp_Registar\" was not injected: check your FXML file 'BienvenidoMenu.fxml'.";
        assert sideAnker != null : "fx:id=\"sideAnker\" was not injected: check your FXML file 'BienvenidoMenu.fxml'.";
        assert sideBar != null : "fx:id=\"sideBar\" was not injected: check your FXML file 'BienvenidoMenu.fxml'.";
        assert titulo != null : "fx:id=\"titulo\" was not injected: check your FXML file 'BienvenidoMenu.fxml'.";
        assert txt_Contrasenia != null : "fx:id=\"txt_Contraseña\" was not injected: check your FXML file 'BienvenidoMenu.fxml'.";
        assert txt_Correo != null : "fx:id=\"txt_Correo\" was not injected: check your FXML file 'BienvenidoMenu.fxml'.";

        inicioSesionController = new InicioSesionController(App.billetara);
    }

    public void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    public void setApp(App app) {
        this.app = app;
    }

}




