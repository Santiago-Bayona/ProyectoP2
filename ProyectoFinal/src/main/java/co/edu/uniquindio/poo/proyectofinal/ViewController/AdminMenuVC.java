package co.edu.uniquindio.poo.proyectofinal.ViewController;

import co.edu.uniquindio.poo.proyectofinal.App;
import co.edu.uniquindio.poo.proyectofinal.Controller.GestionUsuarioController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuVC {
    App app;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btt_Estadisticas;

    @FXML
    private Button btt_Volver;

    @FXML
    private Button btt_cuentas;

    @FXML
    private Button btt_reportes;

    @FXML
    private Button btt_usuarios;

    @FXML
    private AnchorPane AP_Contenido;

    @FXML
    void MostrarCuentas(ActionEvent event) {

    }

    @FXML
    void MostrarEstadisticas(MouseEvent event) {
        cargarContenido("p.fxml");
    }

    @FXML
    void MostrarCategorias(MouseEvent event) {
        cargarContenido("Categoria.fxml");

    }



    @FXML
    void MostrarUsuarios(MouseEvent event) {
        cargarContenido("GestionUsuarios.fxml");
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
        assert btt_Estadisticas != null : "fx:id=\"btt_Estadisticas\" was not injected: check your FXML file 'AdminMenu.fxml'.";
        assert btt_Volver != null : "fx:id=\"btt_Volver\" was not injected: check your FXML file 'AdminMenu.fxml'.";
        assert btt_cuentas != null : "fx:id=\"btt_cuentas\" was not injected: check your FXML file 'AdminMenu.fxml'.";
        assert btt_reportes != null : "fx:id=\"btt_reportes\" was not injected: check your FXML file 'AdminMenu.fxml'.";
        assert btt_usuarios != null : "fx:id=\"btt_usuarios\" was not injected: check your FXML file 'AdminMenu.fxml'.";
        assert AP_Contenido != null : "fx:id=\"AP_Contenido\" was not injected: check your FXML file 'AdminMenu.fxml'.";

    }

    private void cargarContenido(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/proyectofinal/Fxml/" + fxml));
            VBox vista = loader.load();
            Object controlador = loader.getController();

            if(controlador instanceof GestionUsuariosVC) {
                GestionUsuariosVC gestionUsuariosVC = (GestionUsuariosVC) controlador;
                gestionUsuariosVC.CargarOpciones();
            }

            if(controlador instanceof CategoriaVC) {
                CategoriaVC categoriaVC = (CategoriaVC) controlador;
                categoriaVC.cargarOpciones();
                categoriaVC.cargarOpciones1();
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


    public void setApp(App app) {
        this.app = app;
    }
}
