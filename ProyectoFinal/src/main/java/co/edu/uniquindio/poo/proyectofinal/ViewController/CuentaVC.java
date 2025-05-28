package co.edu.uniquindio.poo.proyectofinal.ViewController;

import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.proyectofinal.App;
import co.edu.uniquindio.poo.proyectofinal.Controller.CuentaController;
import co.edu.uniquindio.poo.proyectofinal.Controller.PresupuestoController;
import co.edu.uniquindio.poo.proyectofinal.Modelo.*;
import javafx.beans.property.SimpleObjectProperty;
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

public class CuentaVC {

    App app;
    private ObservableList<Usuario> listaUsuario = FXCollections.observableArrayList();
    private ObservableList<CuentaBancaria> listaCuenta = FXCollections.observableArrayList();
    private Usuario selectedUsuario;
    private CuentaBancaria selectedCuenta;
    private String correoUsuario;
    CuentaController cuentaController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btt_Actualizar;

    @FXML
    private Button btt_Eliminar;

    @FXML
    private Button btt_Limpiar;

    @FXML
    private Button btt_Realizar;

    @FXML
    private ComboBox<TipoCuenta> cmbx_Tipo;

    @FXML
    private TableView<CuentaBancaria> tb_Cuenta;

    @FXML
    private TableView<Usuario> tb_Usuario;

    @FXML
    private TableColumn<CuentaBancaria, String> tbc_Banco;

    @FXML
    private TableColumn<Usuario, String> tbc_Correo;

    @FXML
    private TableColumn<CuentaBancaria, String> tbc_ID;

    @FXML
    private TableColumn<Usuario, String> tbc_Nombre;

    @FXML
    private TableColumn<CuentaBancaria, Double> tbc_Saldo;

    @FXML
    private TableColumn<CuentaBancaria, String> tbc_Tipo;

    @FXML
    private TableColumn<CuentaBancaria, String> tbc_Usuario;

    @FXML
    private TextField txt_Banco;

    @FXML
    private TextField txt_ID;

    @FXML
    private TextField txt_NumCuenta;

    @FXML
    void Actualizar(ActionEvent event) {
        actualizarCuenta();
    }

    @FXML
    void Eliminar(ActionEvent event) {
        eliminarCuenta();
    }

    @FXML
    void Limpoiar(ActionEvent event) {
        limpiarCampos();
    }

    @FXML
    void Realizar(ActionEvent event) {
        agregarCuenta();
    }

    @FXML
    void initialize() {
        assert btt_Actualizar != null : "fx:id=\"btt_Actualizar\" was not injected: check your FXML file 'Cuenta.fxml'.";
        assert btt_Eliminar != null : "fx:id=\"btt_Eliminar\" was not injected: check your FXML file 'Cuenta.fxml'.";
        assert btt_Limpiar != null : "fx:id=\"btt_Limpiar\" was not injected: check your FXML file 'Cuenta.fxml'.";
        assert btt_Realizar != null : "fx:id=\"btt_Realizar\" was not injected: check your FXML file 'Cuenta.fxml'.";
        assert cmbx_Tipo != null : "fx:id=\"cmbx_Tipo\" was not injected: check your FXML file 'Cuenta.fxml'.";
        assert tb_Cuenta != null : "fx:id=\"tb_Cuenta\" was not injected: check your FXML file 'Cuenta.fxml'.";
        assert tb_Usuario != null : "fx:id=\"tb_Usuario\" was not injected: check your FXML file 'Cuenta.fxml'.";
        assert tbc_Banco != null : "fx:id=\"tbc_Banco\" was not injected: check your FXML file 'Cuenta.fxml'.";
        assert tbc_Correo != null : "fx:id=\"tbc_Correo\" was not injected: check your FXML file 'Cuenta.fxml'.";
        assert tbc_ID != null : "fx:id=\"tbc_ID\" was not injected: check your FXML file 'Cuenta.fxml'.";
        assert tbc_Nombre != null : "fx:id=\"tbc_Nombre\" was not injected: check your FXML file 'Cuenta.fxml'.";
        assert tbc_Saldo != null : "fx:id=\"tbc_Saldo\" was not injected: check your FXML file 'Cuenta.fxml'.";
        assert tbc_Tipo != null : "fx:id=\"tbc_Tipo\" was not injected: check your FXML file 'Cuenta.fxml'.";
        assert tbc_Usuario != null : "fx:id=\"tbc_Usuario\" was not injected: check your FXML file 'Cuenta.fxml'.";
        assert txt_Banco != null : "fx:id=\"txt_Banco\" was not injected: check your FXML file 'Cuenta.fxml'.";
        assert txt_ID != null : "fx:id=\"txt_ID\" was not injected: check your FXML file 'Cuenta.fxml'.";
        assert txt_NumCuenta != null : "fx:id=\"txt_NumCuenta\" was not injected: check your FXML file 'Cuenta.fxml'.";

        cuentaController = new CuentaController(App.billetara);
        obtenerCuentas();
        initView();
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;

    }

    public void cargarCuentas() {
        Collection<Usuario> todos = cuentaController.obtenerListaUsuario();
        for (Usuario u : todos) {
            if (u.getCorreo().equals(correoUsuario)) {
                listaUsuario.setAll(u);
                break;
            }
        }
    }

    private void initView() {
        initDataBinding();
        tb_Cuenta.getItems().clear();
        tb_Usuario.setItems(listaUsuario);
        tb_Cuenta.setItems( listaCuenta);
        listenerSelectionUsuarios();
        listenerSelectionCuenta();
    }

    private void initDataBinding() {
        tbc_Banco.setCellValueFactory((cellData) -> new SimpleStringProperty((cellData.getValue().getBanco())));
        tbc_ID.setCellValueFactory((cellData) -> new SimpleStringProperty((cellData.getValue()).getIdCuenta()));
        tbc_Saldo.setCellValueFactory((cellData) -> new SimpleObjectProperty<>((cellData.getValue()).getSaldoCuenta()));
        tbc_Tipo.setCellValueFactory((celldata) -> {
            TipoCuenta tipo = (celldata.getValue()).getTipoCuenta();
            String TipoString = tipo != null ? tipo.toString() : "Sin Tipo";
            return new SimpleStringProperty(TipoString);
        });
        tbc_Usuario.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getUsuario().getCorreo()));

        tbc_Correo.setCellValueFactory(celldata-> new SimpleStringProperty(celldata.getValue().getCorreo()));
        tbc_Nombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));

    }

    private void listenerSelectionCuenta() {
        tb_Cuenta.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedCuenta = newSelection;
            mostrarInformacionCuenta( selectedCuenta);
        });
    }

    private void listenerSelectionUsuarios() {
        tb_Usuario.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->  selectedUsuario = newSelection);
    }

    private void mostrarInformacionCuenta(CuentaBancaria cuentaBancaria) {
        if (cuentaBancaria != null) {
            txt_ID.setText(cuentaBancaria.getIdCuenta());
            txt_Banco.setText(cuentaBancaria.getBanco());
            txt_NumCuenta.setText(String.valueOf(cuentaBancaria.getNumeroCuenta()));
            cmbx_Tipo.getSelectionModel().select(cuentaBancaria.getTipoCuenta());
            tb_Usuario.getSelectionModel().select(cuentaBancaria.getUsuario());
        }

    }

    private void actualizarCuenta() {

        if (selectedCuenta != null &&
                cuentaController.ActualizarCuenta(selectedCuenta.getIdCuenta(), buildCuenta())) {

            int index = listaCuenta.indexOf(selectedCuenta);
            if (index >= 0) {
                listaCuenta.set(index, buildCuenta());
            }

            tb_Cuenta.refresh();
            limpiarSeleccion();
            limpiarCampos();
        }
    }

    private void agregarCuenta() {
        CuentaBancaria cuentaBancaria = buildCuenta();
        cuentaController.AgregarCuenta(cuentaBancaria);
        {
            listaCuenta.add(cuentaBancaria);
            limpiarCampos();
        }
    }


    private void mostrarAlerta(String titulo, String mensaje) {
        javafx.scene.control.Alert alerta = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    public void obtenerCuentas() {
        if (cuentaController != null) {
            Collection<CuentaBancaria> todas = cuentaController.obtenerlistaCuentas();
            for (CuentaBancaria cuenta : todas) {
                if (cuenta.getUsuario().getCorreo().equals(correoUsuario)) {
                    listaCuenta.add(cuenta);
                }
            }
        } else {
            System.err.println("cuentaController no está inicializado.");
        }
    }




    private CuentaBancaria buildCuenta() {
        int NumCuenta = Integer.parseInt(txt_NumCuenta.getText());

        CuentaBancaria cuentaBancaria = new CuentaBancaria( txt_ID.getText(),  txt_Banco.getText(), NumCuenta,  cmbx_Tipo.getValue(), selectedUsuario);
        return cuentaBancaria;
    }

    private void eliminarCuenta() {
        if ( cuentaController.EliminarCuenta( selectedCuenta)) {
            listaCuenta.remove( selectedCuenta);
            limpiarCampos();
            limpiarSeleccion();
        }

    }


    private void limpiarSeleccion() {
        tb_Cuenta.getSelectionModel().clearSelection();
        limpiarCampos();
    }

    private void limpiarCampos() {
        txt_ID.clear();
        txt_Banco.clear();
        txt_NumCuenta.clear();
        cmbx_Tipo.setValue( null);
        tb_Cuenta.getSelectionModel().clearSelection();
    }
    public void cargarOpciones(){
        ObservableList<TipoCuenta> options = FXCollections.observableArrayList(TipoCuenta.values());
        cmbx_Tipo.setItems(options);
    }

    public void setApp(App app) {
        this.app = app;
        cargarOpciones();
    }


}
