package co.edu.uniquindio.poo.proyectofinal.ViewController;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import co.edu.uniquindio.poo.proyectofinal.App;
import co.edu.uniquindio.poo.proyectofinal.Controller.ReporteController;
import co.edu.uniquindio.poo.proyectofinal.Modelo.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ReporteVC {
    App app;
    private ObservableList<Reporte> listaReportes = FXCollections.observableArrayList();
    private ObservableList<Usuario> listaUsuario = FXCollections.observableArrayList();
    private Reporte selectedReporte;
    private Usuario selectedUsuario;
    private String correoUsuario;
    ReporteController reporteController;



    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Reporte.Tipo> Cmbx_Tipo;

    @FXML
    private DatePicker Date_Final;

    @FXML
    private DatePicker Date_Inicio;

    @FXML
    private Button btt_Actualizar;

    @FXML
    private Button btt_Eliminar;

    @FXML
    private Button btt_Generar;

    @FXML
    private Button btt_Limpiar;

    @FXML
    private Button btt_Realizar;

    @FXML
    private ComboBox<Reporte.Archivo> cmbx_Archivo;

    @FXML
    private TableView<Reporte> tb_Reporte;

    @FXML
    private TableView<Usuario> tb_Usuario;

    @FXML
    private TableColumn<Reporte, String> tbc_Archivo;

    @FXML
    private TableColumn<Usuario, String> tbc_Correo;

    @FXML
    private TableColumn<Reporte, LocalDate> tbc_FechaFInal;

    @FXML
    private TableColumn<Reporte, LocalDate> tbc_FechaINicio;

    @FXML
    private TableColumn<Usuario, String> tbc_Nombre;

    @FXML
    private TableColumn<Reporte, String> tbc_Tipo;

    @FXML
    private TableColumn<Reporte, String> tbc_Titulo;

    @FXML
    private TextField txt_ID;

    @FXML
    private TextField txt_Titulo;

    @FXML
    void Actualizar(ActionEvent event) {

    }

    @FXML
    void Eliminar(ActionEvent event) {
        eliminarReporte();
    }

    @FXML
    void Generar(ActionEvent event) {
        if (selectedUsuario == null) {
            mostrarAlerta("Error de Selección", "Por favor, selecciona un usuario.");
            return;
        }
        if (Date_Inicio.getValue() == null || Date_Final.getValue() == null) {
            mostrarAlerta("Error de Fechas", "Por favor, selecciona un rango de fechas.");
            return;
        }
        if (Cmbx_Tipo.getValue() == null) {
            mostrarAlerta("Error de Tipo de Reporte", "Por favor, selecciona un tipo de reporte (Ingreso/Gasto).");
            return;
        }
        if (cmbx_Archivo.getValue() == null) {
            mostrarAlerta("Error de Formato de Archivo", "Por favor, selecciona un formato de archivo (PDF/CSV).");
            return;
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(selectedReporte.getTitulo());

        if (cmbx_Archivo.getValue() == Reporte.Archivo.PDF) {
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos PDF (*.pdf)", "*.pdf"));
        } else if (cmbx_Archivo.getValue() == Reporte.Archivo.CSV) {
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos CSV (*.csv)", "*.csv"));
        }
        File archivoDestino = fileChooser.showSaveDialog(((Node)event.getSource()).getScene().getWindow());

        if (archivoDestino != null) {
            generarReporte(Date_Inicio.getValue(), Date_Final.getValue(), selectedUsuario, Cmbx_Tipo.getValue(), cmbx_Archivo.getValue(), archivoDestino);
        }    }

    @FXML
    void Limpoiar(ActionEvent event) {
        limpiarCampos();
    }

    @FXML
    void Realizar(ActionEvent event) {
        agregarReporte();
    }

    @FXML
    void initialize() {
        assert Cmbx_Tipo != null : "fx:id=\"Cmbx_Tipo\" was not injected: check your FXML file 'Reporte.fxml'.";
        assert Date_Final != null : "fx:id=\"Date_Final\" was not injected: check your FXML file 'Reporte.fxml'.";
        assert Date_Inicio != null : "fx:id=\"Date_Inicio\" was not injected: check your FXML file 'Reporte.fxml'.";
        assert btt_Actualizar != null : "fx:id=\"btt_Actualizar\" was not injected: check your FXML file 'Reporte.fxml'.";
        assert btt_Eliminar != null : "fx:id=\"btt_Eliminar\" was not injected: check your FXML file 'Reporte.fxml'.";
        assert btt_Generar != null : "fx:id=\"btt_Generar\" was not injected: check your FXML file 'Reporte.fxml'.";
        assert btt_Limpiar != null : "fx:id=\"btt_Limpiar\" was not injected: check your FXML file 'Reporte.fxml'.";
        assert btt_Realizar != null : "fx:id=\"btt_Realizar\" was not injected: check your FXML file 'Reporte.fxml'.";
        assert cmbx_Archivo != null : "fx:id=\"cmbx_Archivo\" was not injected: check your FXML file 'Reporte.fxml'.";
        assert tb_Reporte != null : "fx:id=\"tb_Reporte\" was not injected: check your FXML file 'Reporte.fxml'.";
        assert tb_Usuario != null : "fx:id=\"tb_Usuario\" was not injected: check your FXML file 'Reporte.fxml'.";
        assert tbc_Archivo != null : "fx:id=\"tbc_Archivo\" was not injected: check your FXML file 'Reporte.fxml'.";
        assert tbc_Correo != null : "fx:id=\"tbc_Correo\" was not injected: check your FXML file 'Reporte.fxml'.";
        assert tbc_FechaFInal != null : "fx:id=\"tbc_FechaFInal\" was not injected: check your FXML file 'Reporte.fxml'.";
        assert tbc_FechaINicio != null : "fx:id=\"tbc_FechaINicio\" was not injected: check your FXML file 'Reporte.fxml'.";
        assert tbc_Nombre != null : "fx:id=\"tbc_Nombre\" was not injected: check your FXML file 'Reporte.fxml'.";
        assert tbc_Tipo != null : "fx:id=\"tbc_Tipo\" was not injected: check your FXML file 'Reporte.fxml'.";
        assert tbc_Titulo != null : "fx:id=\"tbc_Titulo\" was not injected: check your FXML file 'Reporte.fxml'.";
        assert txt_ID != null : "fx:id=\"txt_ID\" was not injected: check your FXML file 'Reporte.fxml'.";
        assert txt_Titulo != null : "fx:id=\"txt_Titulo\" was not injected: check your FXML file 'Reporte.fxml'.";

        reporteController = new ReporteController(App.billetara);
        obtenerUsuario();
        obtenerReporte();
        initView();
    }

    private void obtenerUsuario() {
        if (listaUsuario == null) {
            listaUsuario = FXCollections.observableArrayList();
        }

        Collection<Usuario> usuarios =  reporteController.obtenerListaUsuarios();
        if (usuarios != null) {
            listaUsuario.setAll(usuarios);
        } else {
            System.out.println("No se encontraron Usuarios.");
        }

    }
    private void obtenerReporte() {
        if ( reporteController != null) {
            listaReportes.addAll( reporteController.obtenerlistaReporte());
        } else {
            System.err.println("ReporteController no está inicializado.");
        }

    }


    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;

    }

    public void cargarUsuario() {Collection<Usuario> todos = reporteController.obtenerListaUsuarios();
        for (Usuario u : todos) {
            if (u.getCorreo().equals(correoUsuario)) {
                listaUsuario.setAll(u);
                break;
            }
        }
    }

    private void initView() {
        initDataBinding();
        tb_Reporte.getItems().clear();
        tb_Reporte.setItems(listaReportes);
        tb_Usuario.setItems( listaUsuario);
        listenerSelectionReporte();
        listenerSelectionUsuario();
    }

    private void initDataBinding() {
        tbc_Nombre.setCellValueFactory((cellData) -> new SimpleStringProperty((cellData.getValue().getNombre())));
        tbc_Correo.setCellValueFactory((cellData) -> new SimpleStringProperty((cellData.getValue()).getCorreo()));

        tbc_Titulo.setCellValueFactory((cellData) -> new SimpleStringProperty((cellData.getValue()).getTitulo()));
        tbc_FechaFInal.setCellValueFactory((celldata)-> new SimpleObjectProperty<>(celldata.getValue().getFechaFinal()));
        tbc_FechaINicio.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getFechaInicio()));
        tbc_Archivo.setCellValueFactory((cellData) -> {
            Reporte.Archivo archivo = (cellData.getValue()).getArchivo();
            String nombreArchivo = archivo != null ? archivo.toString() : "Sin Categoria";
            return new SimpleStringProperty(nombreArchivo);
        });

        tbc_Tipo.setCellValueFactory((cellData) -> {
            Reporte.Tipo tipo = (cellData.getValue()).getTipo();
            String nombreTipo = tipo != null ? tipo.toString() : "Sin Categoria";
            return new SimpleStringProperty(nombreTipo);
        });
    }

    private void listenerSelectionReporte() {
        tb_Reporte.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedReporte = newSelection;
            mostrarInformacionReporte( selectedReporte);
        });
    }

    private void listenerSelectionUsuario() {
        tb_Usuario.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->  selectedUsuario = newSelection);
    }

    private void mostrarInformacionReporte(Reporte reporte) {
        if (reporte != null) {
            txt_ID.setText(reporte.getID());
            txt_Titulo.setText(reporte.getTitulo());
            Date_Final.setValue(reporte.getFechaFinal());
            Date_Inicio.setValue(reporte.getFechaInicio());
            cmbx_Archivo.setValue(reporte.getArchivo());
            Cmbx_Tipo.setValue(reporte.getTipo());
        }

    }

    private void agregarReporte() {
        Reporte reporte =  buildReporte();
        if ( reporteController.AgregarReporte(reporte)) {
            listaReportes.add(reporte);
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



    private Reporte buildReporte() {
        Reporte reporte = new Reporte( txt_Titulo.getText(),txt_ID.getText(), Date_Inicio.getValue(), Date_Final.getValue(),  selectedUsuario,Cmbx_Tipo.getValue(), cmbx_Archivo.getValue());
        return reporte;
    }

    private void eliminarReporte() {
        if ( reporteController.EliminarReporte( selectedReporte)) {
            listaReportes.remove( selectedReporte);
            limpiarCampos();
            limpiarSeleccion();
        }

    }


    private void limpiarSeleccion() {
        tb_Reporte.getSelectionModel().clearSelection();
        limpiarCampos();
    }

    private void limpiarCampos() {
        txt_ID.clear();
        txt_Titulo.clear();
        Date_Final.setValue(null);
        Date_Inicio.setValue(null);
        cmbx_Archivo.setValue(null);
        Cmbx_Tipo.setValue(null);
        tb_Usuario.getSelectionModel().select( null);
    }

    public void cargarOpciones(){
        ObservableList<Reporte.Tipo> options = FXCollections.observableArrayList(Reporte.Tipo.values());
        Cmbx_Tipo.setItems(options);

        ObservableList<Reporte.Archivo> options2 = FXCollections.observableArrayList(Reporte.Archivo.values());
        cmbx_Archivo.setItems(options2);

    }


    private List<Transaccion> filtrarTransacciones(LocalDate fechaInicio, LocalDate fechaFin, Usuario usuario) {
        return reporteController.obtenerListaTransaccionwes().stream()
                .filter(t -> t.getFechaTransaccion().isAfter(fechaInicio.minusDays(1)) && t.getFechaTransaccion().isBefore(fechaFin.plusDays(1))) // Filtrar por rango de fechas
                .filter(t -> {
                    boolean cuenta1Pertenece = t.getCuenta1() != null && t.getCuenta1().getUsuario() != null && t.getCuenta1().getUsuario().equals(usuario);
                    boolean cuenta2Pertenece = t.getCuenta2() != null && t.getCuenta2().getUsuario() != null && t.getCuenta2().getUsuario().equals(usuario);
                    return cuenta1Pertenece || cuenta2Pertenece;
                })
                .collect(Collectors.toList());
    }


    public void generarReporte(LocalDate fechaInicio, LocalDate fechaFin, Usuario usuario, Reporte.Tipo tipoReporte, Reporte.Archivo tipoArchivo, File archivoDestino) {
        List<Transaccion> transaccionesDelUsuarioEnRango = filtrarTransacciones(fechaInicio, fechaFin, usuario);

        Reporte reporte = new Reporte(
                "Reporte de " + tipoReporte.name() + " (" + usuario.getNombre() + ")",
                "ID-" + System.currentTimeMillis(), // Generar un ID único o usar uno del modelo
                fechaInicio,
                fechaFin,
                usuario,
                tipoReporte,
                tipoArchivo
        );
        reporte.setTransacciones(transaccionesDelUsuarioEnRango);

        ReporteExportador exportador = ExportarFactory.getExportador(tipoArchivo);

        try {

            exportador.exportarReporte(reporte, archivoDestino);
            mostrarAlerta("Éxito", "Reporte generado correctamente en: " + archivoDestino.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("Error al generar reporte", "Ocurrió un error al intentar generar el reporte: " + e.getMessage());
        }
    }


    public void setApp(App app) {
        this.app = app;
        cargarOpciones();
    }

}
