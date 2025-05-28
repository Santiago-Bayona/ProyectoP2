package co.edu.uniquindio.poo.proyectofinal.ViewController;

import java.net.URL;
import java.time.LocalDate;
import java.util.Collection;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.proyectofinal.App;
import co.edu.uniquindio.poo.proyectofinal.Controller.TransaccionController;
import co.edu.uniquindio.poo.proyectofinal.Modelo.*;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TransaccionVC {

    App app;
    private ObservableList<Transaccion> listaTransaccion = FXCollections.observableArrayList();
    private ObservableList<CategoriaCompuesto> listaCategoria = FXCollections.observableArrayList();
    private ObservableList<CuentaBancaria> listaCuentaOrigen = FXCollections.observableArrayList();
    private ObservableList<CuentaBancaria> listaCuentaDestino = FXCollections.observableArrayList();
    private Transaccion selectedTransaccion;
    private Categoria selectedCategoria;
    private CuentaBancaria selectedCuentaOrigen;
    private CuentaBancaria selectedCuentaDestino;
    private String correoUsuario;
    TransaccionController transaccionController;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker Date_Fecha;

    @FXML
    private Button btt_Cancelar;

    @FXML
    private Button btt_Limpiar;

    @FXML
    private Button btt_Realizar;

    @FXML
    private ComboBox<TipoTransaccion> cmbx_Tipo;

    @FXML
    private TableView<CategoriaCompuesto> tb_Categoria;

    @FXML
    private TableView<CuentaBancaria> tb_Destino;

    @FXML
    private TableView<CuentaBancaria> tb_Origen;

    @FXML
    private TableView<Transaccion> tb_Transaccion;

    @FXML
    private TableColumn<Transaccion, String> tbc_CatG;

    @FXML
    private TableColumn<CuentaBancaria, Double> tbc_CuentaDestino;

    @FXML
    private TableColumn<CuentaBancaria, Double> tbc_CuentaOrigen;

    @FXML
    private TableColumn<Transaccion, String> tbc_DesG;

    @FXML
    private TableColumn<Transaccion, String> tbc_DestG;

    @FXML
    private TableColumn<Transaccion, LocalDate> tbc_FechaG;

    @FXML
    private TableColumn<Transaccion, String> tbc_IDG;

    @FXML
    private TableColumn<Transaccion, Double> tbc_MontoG;

    @FXML
    private TableColumn<Categoria, String> tbc_NombreCategoria;

    @FXML
    private TableColumn<Transaccion ,Integer> tbc_OriG;

    @FXML
    private TableColumn<Transaccion, String> tbc_TipoG;

    @FXML
    private TableColumn<CuentaBancaria, String> tbc_UsuarioDestino;

    @FXML
    private TableColumn<CuentaBancaria, String> tbc_UsuuarioOrigen;

    @FXML
    private TextField txt_Descripcion;

    @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_monto;

    @FXML
    void Cancelar(ActionEvent event) {
        eliminarTransaccion();
    }

    @FXML
    void Limpiar(ActionEvent event) {
        limpiarCampos();
    }

    @FXML
    void Realizar(ActionEvent event) {
        String id = txt_id.getText();
        agregarTransaccion();
        transaccionController.EnviarTransaccion2(id);
        tb_Origen.refresh();
        tb_Destino.refresh();
        tb_Transaccion.refresh();
    }

    @FXML
    void initialize() {
        assert Date_Fecha != null : "fx:id=\"Date_Fecha\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert btt_Cancelar != null : "fx:id=\"btt_Cancelar\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert btt_Limpiar != null : "fx:id=\"btt_Limpiar\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert btt_Realizar != null : "fx:id=\"btt_Realizar\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert cmbx_Tipo != null : "fx:id=\"cmbx_Tipo\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert tb_Categoria != null : "fx:id=\"tb_Categoria\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert tb_Destino != null : "fx:id=\"tb_Destino\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert tb_Origen != null : "fx:id=\"tb_Origen\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert tb_Transaccion != null : "fx:id=\"tb_Transaccion\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert tbc_CatG != null : "fx:id=\"tbc_CatG\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert tbc_CuentaDestino != null : "fx:id=\"tbc_CuentaDestino\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert tbc_CuentaOrigen != null : "fx:id=\"tbc_CuentaOrigen\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert tbc_DesG != null : "fx:id=\"tbc_DesG\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert tbc_DestG != null : "fx:id=\"tbc_DestG\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert tbc_FechaG != null : "fx:id=\"tbc_FechaG\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert tbc_IDG != null : "fx:id=\"tbc_IDG\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert tbc_MontoG != null : "fx:id=\"tbc_MontoG\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert tbc_NombreCategoria != null : "fx:id=\"tbc_NombreCategoria\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert tbc_OriG != null : "fx:id=\"tbc_OriG\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert tbc_TipoG != null : "fx:id=\"tbc_TipoG\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert tbc_UsuarioDestino != null : "fx:id=\"tbc_UsuarioDestino\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert tbc_UsuuarioOrigen != null : "fx:id=\"tbc_UsuuarioOrigen\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert txt_Descripcion != null : "fx:id=\"txt_Descripcion\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert txt_id != null : "fx:id=\"txt_id\" was not injected: check your FXML file 'Transaccion.fxml'.";
        assert txt_monto != null : "fx:id=\"txt_monto\" was not injected: check your FXML file 'Transaccion.fxml'.";

        transaccionController = new TransaccionController(App.billetara);
        obtenerTransaccion();
        obtenerCategoria();
        obtenerCuentas();
        initView();

    }

    private void obtenerCategoria() {
        if (listaCategoria == null) {
            listaCategoria = FXCollections.observableArrayList();
        }

        Collection<CategoriaCompuesto> categorias =  transaccionController.obtenerListaCategorias();
        if (categorias != null) {
             listaCategoria.setAll(categorias);
        } else {
            System.out.println("No se encontraron Categorias.");
        }

    }

    public void setCorreoUsuario (String correoUsuario){
        this.correoUsuario = correoUsuario;
    }

    public void obtenerCuentas() {
        if (transaccionController != null) {
            Collection<CuentaBancaria> todas = transaccionController.obtenerListaCuentasBancarias();
            listaCuentaOrigen.clear();
            listaCuentaDestino.clear();
            for (CuentaBancaria cuenta : todas) {
                if (cuenta.getUsuario().getCorreo().equals(correoUsuario)) {
                    listaCuentaOrigen.add(cuenta);
                }
                listaCuentaDestino.add(cuenta);
            }
        } else {
            System.err.println("transaccionController no está inicializado.");
        }
    }

    public void obtenerTransaccion() {
        if (transaccionController != null && correoUsuario != null) {
            Collection<Transaccion> todasTransacciones = transaccionController.obtenerListaTransacciones();
            listaTransaccion.clear();

            for (Transaccion t : todasTransacciones) {
                boolean esOrigen = t.getCuenta1() != null && t.getCuenta1().getUsuario() != null
                        && t.getCuenta1().getUsuario().getCorreo().equalsIgnoreCase(correoUsuario);

                boolean esDestino = t.getCuenta2() != null && t.getCuenta2().getUsuario() != null
                        && t.getCuenta2().getUsuario().getCorreo().equalsIgnoreCase(correoUsuario);

                if (esOrigen || esDestino) {
                    listaTransaccion.add(t);
                }
            }
        } else {
            //System.err.println("TransaccionController o correoUsuario no están inicializados.");
        }
    }


    private void initView() {
        initDataBinding();
        tb_Transaccion.getItems().clear();
        tb_Transaccion.setItems(listaTransaccion);
        tb_Categoria.setItems(listaCategoria);
        tb_Origen.setItems(listaCuentaOrigen);
        tb_Destino.setItems(listaCuentaDestino);

        tb_Destino.setVisible(false);

        listenerSelectionCategoria();
        listenerSelectionTransaccion();
        listenerSelectionCuentaDestino();
        listenerSelectionCuentaOrigen();

        cmbx_Tipo.valueProperty().addListener((obs, oldTipo, newTipo) -> {
            if (newTipo != null) {
                actualizarTablasSegunTipo(newTipo.name());
            }
        });


    }


    private void initDataBinding() {
         tbc_IDG.setCellValueFactory((cellData) -> new SimpleStringProperty((cellData.getValue().getIdTransaccion())));
         tbc_DesG.setCellValueFactory((cellData) -> new SimpleStringProperty((cellData.getValue()).getDescripcion()));
        tbc_MontoG.setCellValueFactory((cellData) -> new SimpleObjectProperty<>((cellData.getValue()).getMonto()));
        tbc_FechaG.setCellValueFactory((celldata)-> new SimpleObjectProperty<>(celldata.getValue().getFechaTransaccion()));

         tbc_CatG.setCellValueFactory((cellData) -> {
            Categoria categoria = (cellData.getValue()).getCategoria();
            String nombreCategoria = categoria != null ? categoria.getNombreCategoria().toString() : "Sin Categoria";
            return new SimpleStringProperty(nombreCategoria);
        });

        tbc_DestG.setCellValueFactory(cellData -> {
            CuentaBancaria destino = cellData.getValue().getCuenta2();
            String cuenta = (destino != null && !"N/A".equals(destino.getNumeroCuenta() + ""))
                    ? String.valueOf(destino.getNumeroCuenta())
                    : "N/A";
            return new SimpleStringProperty(cuenta);
        });


        tbc_OriG.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCuenta1().getNumeroCuenta()));

        tbc_TipoG.setCellValueFactory((celldata) -> {
            TipoTransaccion tipo = (celldata.getValue()).getTipoTransaccion();
            String TamanioString = tipo != null ? tipo.toString() : "Sin Tipo";
            return new SimpleStringProperty(TamanioString);
        });
        

         tbc_UsuuarioOrigen.setCellValueFactory((cellData) -> new SimpleStringProperty((cellData.getValue()).getUsuario().getNombre()));
         tbc_CuentaOrigen.setCellValueFactory((cellData) -> new SimpleObjectProperty<>((cellData.getValue()).getSaldoCuenta()));
        tbc_UsuarioDestino.setCellValueFactory((cellData) -> new SimpleStringProperty((cellData.getValue()).getUsuario().getNombre()));
        tbc_CuentaDestino.setCellValueFactory((cellData) -> new SimpleObjectProperty<>((cellData.getValue()).getSaldoCuenta()));
        tbc_NombreCategoria.setCellValueFactory((celldata)-> new SimpleStringProperty(celldata.getValue().getNombreCategoria().toString()));
    }

    private void listenerSelectionTransaccion() {
         tb_Transaccion.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
             selectedTransaccion = newSelection;
             mostrarInformacionTransaccion( selectedTransaccion);
        });
    }

    private void listenerSelectionCategoria() {
        tb_Categoria.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->  selectedCategoria = newSelection);
    }

    private void listenerSelectionCuentaOrigen() {
        tb_Origen.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->  selectedCuentaOrigen = newSelection);
    }

    private void listenerSelectionCuentaDestino() {
        tb_Destino.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->  selectedCuentaDestino = newSelection);
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        javafx.scene.control.Alert alerta = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void mostrarInformacionTransaccion(Transaccion transaccion) {
        if (transaccion != null) {
             txt_Descripcion.setText(transaccion.getDescripcion());
             txt_id.setText(transaccion.getIdTransaccion());
             cmbx_Tipo.getSelectionModel().select(transaccion.getTipoTransaccion());
             txt_monto.setText(transaccion.getMonto().toString());
             Date_Fecha.setValue(transaccion.getFechaTransaccion());
        }

    }

    private void agregarTransaccion() {
        Transaccion transaccion = buildTransaccion();
        if (transaccion == null) {
            System.out.println("No se creó la transacción debido a un error en los datos.");
            return;
        }
        if (transaccionController.AgregarTransaccion(transaccion)) {
            listaTransaccion.add(transaccion);
            limpiarCampos();
        }
    }


    private void actualizarTablasSegunTipo(String tipo) {
        switch (tipo) {
            case "DEPOSITO":
            case "RETIRO":
                tb_Destino.setVisible(false);
                selectedCuentaDestino = new CuentaBancaria("N/A", "N/A", 0,null,null); // o un constructor válido
                break;
            case "TRANSFERENCIA":
                tb_Destino.setVisible(true);
                selectedCuentaDestino = null;
                break;
            default:
                tb_Destino.setVisible(false);
                selectedCuentaDestino = new CuentaBancaria("N/A", "N/A", 0,null,null); // o un constructor válido
                break;
        }
    }





    private Transaccion buildTransaccion() {
        String montoStr = txt_monto.getText();

        if (montoStr == null || montoStr.trim().isEmpty()) {
            mostrarAlerta("Campo Vacio", "El Monto esta vacio");
            return null;
        }

        double monto;
        try {
            monto = Double.parseDouble(montoStr);
        } catch (NumberFormatException e) {
            mostrarAlerta("Monto Invalido", "El Monto es invalido");
            return null;
        }

        // Validar que el monto sea mayor que 0
        if (monto <= 0) {
            mostrarAlerta("Monto Invalido", "El Monto debe ser mayor que 0");
            return null;
        }

        TipoTransaccion tipo = cmbx_Tipo.getValue();

        if (tipo == null || selectedCuentaOrigen == null) {
            mostrarAlerta("ERROR", "Se deb escoger un tipo y una cuenta origen");
            return null;
        }

        if ((tipo == TipoTransaccion.RETIRO || tipo == TipoTransaccion.TRANSFERENCIA) &&
                monto > selectedCuentaOrigen.getSaldoCuenta()) {
            mostrarAlerta("ERROR", "Fondos insuficientes en la cuenta origen");
            return null;
        }

        if (selectedCuentaOrigen.getUsuario().getBloqueado() == true) {
           mostrarAlerta("ERROR", "El usuario de origen esta bloqueado");
            return null;
        }

        if (tipo == TipoTransaccion.TRANSFERENCIA && selectedCuentaDestino.getUsuario().getBloqueado() == true) {
            mostrarAlerta("ERROR", "El usuario de destino esta bloqueado");
            return null;
        }

        // Crear y devolver la transacción
        return new Transaccion(
                txt_id.getText(),
                monto,
                Date_Fecha.getValue(),
                txt_Descripcion.getText(),
                selectedCategoria,
                tipo,
                selectedCuentaOrigen,
                selectedCuentaDestino
        );
    }


    private void eliminarTransaccion() {
        if ( transaccionController.EliminarTransacciones( selectedTransaccion)) {
             listaTransaccion.remove( selectedTransaccion);
             limpiarCampos();
             limpiarSeleccion();
        }

    }


    private void limpiarSeleccion() {
         tb_Transaccion.getSelectionModel().clearSelection();
         limpiarCampos();
    }

    private void limpiarCampos() {
         txt_monto.clear();
         txt_Descripcion.clear();
         txt_id.clear();
         Date_Fecha.setValue(null);
         cmbx_Tipo.setValue((null));
         tb_Destino.getSelectionModel().clearSelection();
         tb_Origen.getSelectionModel().clearSelection();
         tb_Categoria.getSelectionModel().clearSelection();
    }
    public void cargarOpciones(){
        ObservableList<TipoTransaccion> options = FXCollections.observableArrayList(TipoTransaccion.values());
         cmbx_Tipo.setItems(options);
    }

    public void setApp(App app) {
         this.app = app;
        cargarOpciones();
    }

}
