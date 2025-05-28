package co.edu.uniquindio.poo.proyectofinal.ViewController;

import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.proyectofinal.App;
import co.edu.uniquindio.poo.proyectofinal.Controller.PresupuestoController;
import co.edu.uniquindio.poo.proyectofinal.Controller.TransaccionController;
import co.edu.uniquindio.poo.proyectofinal.Modelo.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;

public class PresupuestoVC {
    App app;
    private ObservableList<Presupuesto> listaPresupuesto = FXCollections.observableArrayList();
    private ObservableList<CuentaBancaria> listaCuenta = FXCollections.observableArrayList();
    private Presupuesto selectedPresupuesto;
    private CuentaBancaria selectedCuenta;
    private String correoUsuario;
    PresupuestoController presupuestoController;

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
    private TableView<CuentaBancaria> tb_Cuenta;

    @FXML
    private TableView<Presupuesto> tb_Presupuesto;

    @FXML
    private TableColumn<Presupuesto, Double> tbc_Asignado;

    @FXML
    private TableColumn<Presupuesto, Integer> tbc_Cuenta;

    @FXML
    private TableColumn<Presupuesto, Double> tbc_Gastado;

    @FXML
    private TableColumn<Presupuesto, String> tbc_ID;

    @FXML
    private TableColumn<Presupuesto, String> tbc_Nombre;

    @FXML
    private TableColumn<CuentaBancaria, Integer> tbc_NumeroCuenta;

    @FXML
    private TableColumn<CuentaBancaria, Double> tbc_Saldo;

    @FXML
    private TextField txt_ID;

    @FXML
    private TextField txt_MontoGastado;

    @FXML
    private TextField txt_montoAsignado;

    @FXML
    private TextField txt_nombre;

    @FXML
    void Actualizar(ActionEvent event) {
        actualizarPresupuesto();
    }

    @FXML
    void Eliminar(ActionEvent event) {
        eliminarPresupuesto();
    }

    @FXML
    void Limpoiar(ActionEvent event) {
        limpiarCampos();
    }

    @FXML
    void Realizar(ActionEvent event) {
        agregarPresupuesto();
    }

    @FXML
    void initialize() {
        assert btt_Actualizar != null : "fx:id=\"btt_Actualizar\" was not injected: check your FXML file 'Presupuesto.fxml'.";
        assert btt_Eliminar != null : "fx:id=\"btt_Eliminar\" was not injected: check your FXML file 'Presupuesto.fxml'.";
        assert btt_Limpiar != null : "fx:id=\"btt_Limpiar\" was not injected: check your FXML file 'Presupuesto.fxml'.";
        assert btt_Realizar != null : "fx:id=\"btt_Realizar\" was not injected: check your FXML file 'Presupuesto.fxml'.";
        assert tb_Cuenta != null : "fx:id=\"tb_Cuenta\" was not injected: check your FXML file 'Presupuesto.fxml'.";
        assert tb_Presupuesto != null : "fx:id=\"tb_Presupuesto\" was not injected: check your FXML file 'Presupuesto.fxml'.";
        assert tbc_Asignado != null : "fx:id=\"tbc_Asignado\" was not injected: check your FXML file 'Presupuesto.fxml'.";
        assert tbc_Cuenta != null : "fx:id=\"tbc_Cuenta\" was not injected: check your FXML file 'Presupuesto.fxml'.";
        assert tbc_Gastado != null : "fx:id=\"tbc_Gastado\" was not injected: check your FXML file 'Presupuesto.fxml'.";
        assert tbc_ID != null : "fx:id=\"tbc_ID\" was not injected: check your FXML file 'Presupuesto.fxml'.";
        assert tbc_Nombre != null : "fx:id=\"tbc_Nombre\" was not injected: check your FXML file 'Presupuesto.fxml'.";
        assert tbc_NumeroCuenta != null : "fx:id=\"tbc_NumeroCuenta\" was not injected: check your FXML file 'Presupuesto.fxml'.";
        assert tbc_Saldo != null : "fx:id=\"tbc_Saldo\" was not injected: check your FXML file 'Presupuesto.fxml'.";
        assert txt_ID != null : "fx:id=\"txt_ID\" was not injected: check your FXML file 'Presupuesto.fxml'.";
        assert txt_MontoGastado != null : "fx:id=\"txt_MontoGastado\" was not injected: check your FXML file 'Presupuesto.fxml'.";
        assert txt_montoAsignado != null : "fx:id=\"txt_montoAsignado\" was not injected: check your FXML file 'Presupuesto.fxml'.";
        assert txt_nombre != null : "fx:id=\"txt_nombre\" was not injected: check your FXML file 'Presupuesto.fxml'.";

        presupuestoController = new PresupuestoController(App.billetara);
        obtenerPresupuesto();
        obtenerCuentas();
        initView();
    }

    public void setCorreoUsuario(String correoUsuario){
        this.correoUsuario= correoUsuario;
    }

    private void obtenerPresupuesto() {
        if ( presupuestoController != null) {
            listaPresupuesto.addAll( presupuestoController.obtenerlistaPresupuesto());
        } else {
            System.err.println("presupuestoController no está inicializado.");
        }

    }

    public void obtenerCuentas() {
        if (presupuestoController != null) {
            Collection<CuentaBancaria> todas = presupuestoController.obtenerListaCuentasBancarias();
            for (CuentaBancaria cuenta : todas) {
                if (cuenta.getUsuario().getCorreo().equals(correoUsuario)) {
                    listaCuenta.add(cuenta);
                }
            }
        } else {
            System.err.println("cuentaController no está inicializado.");
        }
    }

    private void initView() {
        initDataBinding();
        tb_Presupuesto.getItems().clear();
        tb_Presupuesto.setItems(listaPresupuesto);
        tb_Cuenta.setItems( listaCuenta);
        listenerSelectionPresupuesto();
        listenerSelectionCuenta();
    }

    private void initDataBinding() {
        tbc_Nombre.setCellValueFactory((cellData) -> new SimpleStringProperty((cellData.getValue().getNombre())));
        tbc_ID.setCellValueFactory((cellData) -> new SimpleStringProperty((cellData.getValue()).getId()));
        tbc_Asignado.setCellValueFactory((cellData) -> new SimpleObjectProperty<>((cellData.getValue()).getMontoAsignado()));
        tbc_Gastado.setCellValueFactory((celldata)-> new SimpleObjectProperty<>(celldata.getValue().getMontoGastado()));
        tbc_Cuenta.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCuentaBancaria().getNumeroCuenta()));

        tbc_Saldo.setCellValueFactory(celldata-> new SimpleObjectProperty<>(celldata.getValue().getUsuario().getSaldoTotal()));
        tbc_NumeroCuenta.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNumeroCuenta()));

    }

    private void listenerSelectionPresupuesto() {
        tb_Presupuesto.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedPresupuesto = newSelection;
            mostrarInformacionPresupuesto( selectedPresupuesto);
        });
    }

    private void listenerSelectionCuenta() {
        tb_Cuenta.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->  selectedCuenta = newSelection);
    }

    private void mostrarInformacionPresupuesto(Presupuesto presupuesto) {
        if (presupuesto != null) {
            txt_ID.setText(presupuesto.getId());
            txt_montoAsignado.setText(String.valueOf(presupuesto.getMontoAsignado()));
            txt_MontoGastado.setText(String.valueOf(presupuesto.getMontoGastado()));
            txt_nombre.setText(presupuesto.getNombre());
        }

    }

    private void actualizarPresupuesto() {

        if (selectedPresupuesto != null &&
                presupuestoController.ActualizarPresupuesto(selectedPresupuesto.getId(), buildPresupuesto())) {

            int index = listaPresupuesto.indexOf(selectedPresupuesto);
            if (index >= 0) {
                listaPresupuesto.set(index, buildPresupuesto());
            }

            tb_Presupuesto.refresh();
            limpiarSeleccion();
            limpiarCampos();
        }
    }

    private void agregarPresupuesto() {
        Presupuesto presupuesto = buildPresupuesto();

        double montoAsignado = presupuesto.getMontoAsignado();
        double montoGastado = presupuesto.getMontoGastado();
        double saldoUsuario = presupuesto.getCuentaBancaria().getUsuario().getSaldoTotal();

        if (montoAsignado <= 0 || montoGastado < 0) {
            mostrarAlerta("Error de Validación", "El monto asignado debe ser mayor a 0 y el monto gastado no puede ser negativo.");
            return;
        }

        if (montoGastado > montoAsignado) {
            mostrarAlerta("Error de Validación", "El monto gastado no puede ser mayor al monto asignado.");
            return;
        }
        if (montoAsignado > saldoUsuario) {
            mostrarAlerta("Error de Validación", "El monto asignado no puede ser mayor al saldo disponible en la cuenta.");
            return;
        }

        // Si pasa todas las validaciones
        if (presupuestoController.AgregrarPresupuesto(presupuesto)) {
            listaPresupuesto.add(presupuesto);
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



    private Presupuesto buildPresupuesto() {
        double montoA = Double.parseDouble(txt_montoAsignado.getText());
        double montoG = Double.parseDouble(txt_MontoGastado.getText());
        Presupuesto presupuesto = new Presupuesto( txt_ID.getText(),  txt_nombre.getText(), montoA,  montoG, selectedCuenta);
        return presupuesto;
    }

    private void eliminarPresupuesto() {
        if ( presupuestoController.EliminarPresupuestos( selectedPresupuesto)) {
            listaPresupuesto.remove( selectedPresupuesto);
            limpiarCampos();
            limpiarSeleccion();
        }

    }


    private void limpiarSeleccion() {
        tb_Presupuesto.getSelectionModel().clearSelection();
        limpiarCampos();
    }

    private void limpiarCampos() {
        txt_ID.clear();
        txt_MontoGastado.clear();
        txt_nombre.clear();
        txt_montoAsignado.clear();
        tb_Cuenta.getSelectionModel().clearSelection();
    }

    public void setApp(App app) {
        this.app = app;
    }


}
