package co.edu.uniquindio.poo.proyectofinal;

import co.edu.uniquindio.poo.proyectofinal.Modelo.*;
import co.edu.uniquindio.poo.proyectofinal.ViewController.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class App extends Application {
    public static BilleteraVirtual billetara = new BilleteraVirtual("Zeki");
    private Stage primaryStage;
    private boolean datosInicializados=false;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Bienvenido");
        openViewPrincipal();
    }



    public void openViewPrincipal() {
        if (!datosInicializados) {
            inicializarData();
            datosInicializados = true;
        }
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/proyectofinal/Fxml/BienvenidoMenu.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            BienvenidoVC primaryController = loader.getController();
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setMinWidth(600);
            primaryStage.setMinHeight(800);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Registro() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/proyectofinal/Fxml/RegistroUsuario.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            RegistroVC registroVC = loader.getController();
            registroVC.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void AdminMenu() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/proyectofinal/Fxml/AdminMenu.fxml"));
            BorderPane rootLayout = (BorderPane) loader.load();
            AdminMenuVC adminMenuVC = loader.getController();
            adminMenuVC.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setMinHeight(900);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void UsuarioMenu(String correo) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/proyectofinal/Fxml/UsuarioMenu.fxml"));
            BorderPane rootLayout = (BorderPane) loader.load();
            UsuarioMenuVC usuarioMenuVC = loader.getController();
            usuarioMenuVC.setApp(this);
            usuarioMenuVC.setCorreoUsuario(correo);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setMinWidth(800);
            primaryStage.setMinHeight(900);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void Recuperacion() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/proyectofinal/Fxml/Recuperacion.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            RecuperacionVC recuperacionVC = loader.getController();
            recuperacionVC.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    public void inicializarData() {

        Usuario usuario = new Usuario("Maria","100055445","Maria@gmail.com","maria2","3124759954","Puerto Espejo","Daiky", Persona.PreguntaSeguridad.Pelicula_Favorita);
        Usuario usuario2 = new Usuario("Jose","10323265","Jose@gmail.com","jose3","3845972645","Galan","hola2", Persona.PreguntaSeguridad.Pelicula_Favorita);
        billetara.agregarUsuario(usuario);
        billetara.agregarUsuario(usuario2);
        Administrador administrador = new Administrador("Antonio","10444554","Antonio@gmail.com","antonio","3124487","sghshg","kity", Persona.PreguntaSeguridad.Pelicula_Favorita,300);
        billetara.agregarAdministrador(administrador);
        CuentaBancaria cuenta1 = new CuentaBancaria("924787","BBVA", 15478, TipoCuenta.CORRIENTE,usuario);
        CuentaBancaria cuenta2 = new CuentaBancaria("9488745","Bancolombia", 12546, TipoCuenta.AHORRO,usuario2);
        billetara.agregarCuentaBancaria(cuenta1);
        billetara.agregarCuentaBancaria(cuenta2);
        cuenta1.setSaldoCuenta(10000.0);
        Presupuesto presupuesto = new Presupuesto("P1","Moto", 5000, 1000.0, cuenta1);
        billetara.agregarPresupuesto(presupuesto);
    }
}