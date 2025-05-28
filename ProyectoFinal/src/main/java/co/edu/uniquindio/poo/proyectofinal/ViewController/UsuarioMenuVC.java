package co.edu.uniquindio.poo.proyectofinal.ViewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.proyectofinal.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class UsuarioMenuVC {

    App app;
    private String correoUsuario;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AP_Contenido;

    @FXML
    private Button btt_Cuneta;

    @FXML
    private Button btt_Repuestos;

    @FXML
    private Button btt_Transaccion;

    @FXML
    private Button btt_Reportes;


    @FXML
    private Button btt_Volver;

    @FXML
    private ImageView img_Cuenta;


    @FXML
    void MostrarCuentas(MouseEvent event) {
        cargarContenido("Cuenta.fxml");
    }

    @FXML
    void MostrarReportes(MouseEvent event) {
        cargarContenido("Reporte.fxml");
    }

    @FXML
    void MostrarPresupuestos(MouseEvent event) {

        cargarContenido("Presupuesto.fxml");

    }

    @FXML
    void MostrarTransacciones(MouseEvent event) {
        cargarContenido("Transaccion.fxml");
    }

    @FXML
    void Volver(ActionEvent event) {
        try{
            app.openViewPrincipal();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    void initialize() {
        assert AP_Contenido != null : "fx:id=\"AP_Contenido\" was not injected: check your FXML file 'UsuarioMenu.fxml'.";
        assert btt_Cuneta != null : "fx:id=\"btt_Cuneta\" was not injected: check your FXML file 'UsuarioMenu.fxml'.";
        assert btt_Repuestos != null : "fx:id=\"btt_Repuestos\" was not injected: check your FXML file 'UsuarioMenu.fxml'.";
        assert btt_Transaccion != null : "fx:id=\"btt_Transaccion\" was not injected: check your FXML file 'UsuarioMenu.fxml'.";
        assert btt_Volver != null : "fx:id=\"btt_Volver\" was not injected: check your FXML file 'UsuarioMenu.fxml'.";
        assert img_Cuenta != null : "fx:id=\"img_Cuenta\" was not injected: check your FXML file 'UsuarioMenu.fxml'.";
        assert btt_Reportes != null : "fx:id=\"btt_Reportes\" was not injected: check your FXML file 'UsuarioMenu.fxml'.";

    }
    private void cargarContenido(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/proyectofinal/Fxml/" + fxml));
            VBox vista = loader.load();
            Object controlador = loader.getController();
            if(controlador instanceof TransaccionVC) {
                TransaccionVC transaccionCtrl = (TransaccionVC) controlador;
                transaccionCtrl.cargarOpciones();
            }
            if(controlador instanceof ReporteVC) {
                ReporteVC reporteVC = (ReporteVC) controlador;
                reporteVC.cargarOpciones();
            }

            if(controlador instanceof CuentaVC) {
                CuentaVC cuentaVC = (CuentaVC) controlador;
                cuentaVC.cargarOpciones();
            }

            if (controlador instanceof CuentaVC cuentaVC) {
                cuentaVC.setCorreoUsuario(correoUsuario);
                cuentaVC.cargarCuentas();
                cuentaVC.obtenerCuentas();
            }

            if (controlador instanceof ReporteVC reporteVC) {
                reporteVC.setCorreoUsuario(correoUsuario);
                reporteVC.cargarUsuario();
            }

            if (controlador instanceof TransaccionVC transaccionVC) {
                transaccionVC.setCorreoUsuario(correoUsuario);
                transaccionVC.obtenerTransaccion();
                transaccionVC.obtenerCuentas();
            }

            if (controlador instanceof PresupuestoVC presupuestoVC) {
                presupuestoVC.setCorreoUsuario(correoUsuario);
                presupuestoVC.obtenerCuentas();
            }


            // Limpiar y agregar nuevo contenido
            AP_Contenido.getChildren().clear();
            AP_Contenido.getChildren().add(vista);

            // Ajustar anclaje (opcional pero recomendado)
            AnchorPane.setTopAnchor(vista, 0.0);
            AnchorPane.setBottomAnchor(vista, 0.0);
            AnchorPane.setLeftAnchor(vista, 0.0);
            AnchorPane.setRightAnchor(vista, 0.0);

            vista.prefWidthProperty().bind(AP_Contenido.widthProperty());
            vista.prefHeightProperty().bind(AP_Contenido.heightProperty());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public void setApp(App app) {
        this.app = app;
    }

}
