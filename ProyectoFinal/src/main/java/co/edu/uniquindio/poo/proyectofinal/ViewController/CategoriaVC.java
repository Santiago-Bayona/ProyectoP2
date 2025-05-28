package co.edu.uniquindio.poo.proyectofinal.ViewController;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.proyectofinal.App;
import co.edu.uniquindio.poo.proyectofinal.Controller.CategoriaController;
import co.edu.uniquindio.poo.proyectofinal.Modelo.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CategoriaVC {

    App app;
    private ObservableList<CategoriaCompuesto> listaCategoriaCompuestas = FXCollections.observableArrayList();
    private ObservableList<CategoriaSimple> listaCategoriaSimples = FXCollections.observableArrayList();
    private CategoriaCompuesto selectedCategoriaCompuesto;
    private CategoriaSimple selectedCategoriaSimple;
    CategoriaController categoriaController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<CategoriaCompuesto, String> tbc_ID;

    @FXML
    private ComboBox<NombreCategoria> cmbx_NombreSub;

    @FXML
    private TableColumn<CategoriaCompuesto, String> tbc_Descripcion;

    @FXML
    private TextField txt_IDSubcategoria;

    @FXML
    private Button btt_Eliminar;

    @FXML
    private Button btt_AgregarSub;

    @FXML
    private TableColumn<CategoriaSimple, String> tbc_DescripcionSub;

    @FXML
    private TextField txt_DescripcionSub;

    @FXML
    private TableView<CategoriaSimple> tb_Subcategoria;

    @FXML
    private ComboBox<NombreCategoria> cmbx_Nombre;

    @FXML
    private Button btt_EliminarSub;

    @FXML
    private TextField txt_ID;

    @FXML
    private Button btt_ActualizarSub;

    @FXML
    private TableColumn<CategoriaSimple, String> tbc_IDSubcategoria;

    @FXML
    private TableColumn<CategoriaSimple, String> tbc_NombreSub;

    @FXML
    private Button btt_Agregar;

    @FXML
    private TableColumn<CategoriaCompuesto, String> tbc_Nombre;

    @FXML
    private Button btt_LimpiarSub;

    @FXML
    private TextField txt_Descripcion;

    @FXML
    private Button btt_Limpiar;

    @FXML
    private TableView<CategoriaCompuesto> tb_CategoriaComp;

    @FXML
    void AgregarSub(ActionEvent event) {
        agregarCategoriaSimple();
    }

    @FXML
    void Actualizar(ActionEvent event) {
        actualizarCategoria();
    }

    @FXML
    void Limpiar2(ActionEvent event) {
        limpiarCampos2();
    }

    @FXML
    void Eliminar2(ActionEvent event) {
        eliminarCategoria2();
    }

    @FXML
    void AgregarCom(ActionEvent event) {
        agregarCategoriaCompuesto();
    }

    @FXML
    void Eliminar(ActionEvent event) {
        eliminarCategoria();
    }

    @FXML
    void Limpiar(ActionEvent event) {
        limpiarCampos();
    }

    @FXML
    void initialize() {
        assert tbc_ID != null : "fx:id=\"tbc_ID\" was not injected: check your FXML file 'Categoria.fxml'.";
        assert cmbx_NombreSub != null : "fx:id=\"cmbx_NombreSub\" was not injected: check your FXML file 'Categoria.fxml'.";
        assert tbc_Descripcion != null : "fx:id=\"tbc_Descripcion\" was not injected: check your FXML file 'Categoria.fxml'.";
        assert txt_IDSubcategoria != null : "fx:id=\"txt_IDSubcategoria\" was not injected: check your FXML file 'Categoria.fxml'.";
        assert btt_Eliminar != null : "fx:id=\"btt_Eliminar\" was not injected: check your FXML file 'Categoria.fxml'.";
        assert btt_AgregarSub != null : "fx:id=\"btt_AgregarSub\" was not injected: check your FXML file 'Categoria.fxml'.";
        assert tbc_DescripcionSub != null : "fx:id=\"tbc_DescripcionSub\" was not injected: check your FXML file 'Categoria.fxml'.";
        assert txt_DescripcionSub != null : "fx:id=\"txt_DescripcionSub\" was not injected: check your FXML file 'Categoria.fxml'.";
        assert tb_Subcategoria != null : "fx:id=\"tb_Subcategoria\" was not injected: check your FXML file 'Categoria.fxml'.";
        assert cmbx_Nombre != null : "fx:id=\"cmbx_Nombre\" was not injected: check your FXML file 'Categoria.fxml'.";
        assert btt_EliminarSub != null : "fx:id=\"btt_EliminarSub\" was not injected: check your FXML file 'Categoria.fxml'.";
        assert txt_ID != null : "fx:id=\"txt_ID\" was not injected: check your FXML file 'Categoria.fxml'.";
        assert btt_ActualizarSub != null : "fx:id=\"btt_ActualizarSub\" was not injected: check your FXML file 'Categoria.fxml'.";
        assert tbc_IDSubcategoria != null : "fx:id=\"tbc_IDSubcategoria\" was not injected: check your FXML file 'Categoria.fxml'.";
        assert tbc_NombreSub != null : "fx:id=\"tbc_NombreSub\" was not injected: check your FXML file 'Categoria.fxml'.";
        assert btt_Agregar != null : "fx:id=\"btt_Agregar\" was not injected: check your FXML file 'Categoria.fxml'.";
        assert tbc_Nombre != null : "fx:id=\"tbc_Nombre\" was not injected: check your FXML file 'Categoria.fxml'.";
        assert btt_LimpiarSub != null : "fx:id=\"btt_LimpiarSub\" was not injected: check your FXML file 'Categoria.fxml'.";
        assert txt_Descripcion != null : "fx:id=\"txt_Descripcion\" was not injected: check your FXML file 'Categoria.fxml'.";
        assert btt_Limpiar != null : "fx:id=\"btt_Limpiar\" was not injected: check your FXML file 'Categoria.fxml'.";
        assert tb_CategoriaComp != null : "fx:id=\"tb_CategoriaComp\" was not injected: check your FXML file 'Categoria.fxml'.";
        categoriaController = new CategoriaController(App.billetara);
        obtenerCategoriaCompuesta();
        obtenerCategoriaSimple();
        initView();
    }

    private void obtenerCategoriaCompuesta() {
        if (listaCategoriaCompuestas == null) {
            listaCategoriaCompuestas = FXCollections.observableArrayList();
        }

        Collection<CategoriaCompuesto> categorias = categoriaController.obtenerListaCategoriaCompuestas();
        if (categorias != null) {
            listaCategoriaCompuestas.setAll(categorias);
        } else {
            System.out.println("No se encontraron Categorias.");
        }

    }

    private void obtenerCategoriaSimple() {
        if (listaCategoriaSimples == null) {
            listaCategoriaSimples = FXCollections.observableArrayList();
        }

     Collection<CategoriaSimple> categoriaSimples = categoriaController.obtenerListaCategoriaSimples();
        if (categoriaSimples != null) {
            listaCategoriaSimples.setAll(categoriaSimples);
        } else {
            System.out.println("No se encontraron Subcategorias.");
        }

    }



    private void initView() {
        initDataBinding();
        tb_CategoriaComp.getItems().clear();
        tb_CategoriaComp.setItems(listaCategoriaCompuestas);
        tb_Subcategoria.getItems().clear();
        tb_Subcategoria.setItems(listaCategoriaSimples);


        listenerSelectionCategoriaCompuesta();
        listenerSelectionCategoriaSimple();


    }


    private void initDataBinding() {
        tbc_ID.setCellValueFactory((cellData) -> new SimpleStringProperty((cellData.getValue().getIdCategoria())));
        tbc_Nombre.setCellValueFactory((cellData) -> new SimpleStringProperty((cellData.getValue()).getNombreCategoria().toString()));
        tbc_Descripcion.setCellValueFactory((cellData) -> new SimpleObjectProperty<>((cellData.getValue()).getDescripcion()));
        tbc_IDSubcategoria.setCellValueFactory((celldata) -> new SimpleObjectProperty<>(celldata.getValue().getIdCategoria()));
        tbc_DescripcionSub.setCellValueFactory((cellData) -> new SimpleObjectProperty<>((cellData.getValue()).getDescripcion()));
        tbc_NombreSub.setCellValueFactory((celldata) -> new SimpleStringProperty(celldata.getValue().getNombreCategoria().toString()));
    }

    private void listenerSelectionCategoriaCompuesta() {
        tb_CategoriaComp.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedCategoriaCompuesto = newSelection;
            mostrarInformacionCategoriaCompuesta(selectedCategoriaCompuesto);
        });
    }

    private void listenerSelectionCategoriaSimple() {
        tb_Subcategoria.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedCategoriaSimple = newSelection;
            mostrarInformacionCategoriaSimple(selectedCategoriaSimple);
        });
    }


    private void mostrarInformacionCategoriaCompuesta(CategoriaCompuesto categoriaCompuesto) {
        if (categoriaCompuesto != null) {
            txt_ID.setText(categoriaCompuesto.getIdCategoria());
            txt_Descripcion.setText(categoriaCompuesto.getDescripcion());
            cmbx_Nombre.getSelectionModel().select(categoriaCompuesto.getNombreCategoria());

        }

    }

    private void mostrarInformacionCategoriaSimple(CategoriaSimple categoriaSimple) {
        if (categoriaSimple != null) {
            txt_IDSubcategoria.setText(categoriaSimple.getIdCategoria());
            txt_DescripcionSub.setText(categoriaSimple.getDescripcion());
            cmbx_NombreSub.getSelectionModel().select(categoriaSimple.getNombreCategoria());

        }

    }

    private void agregarCategoriaCompuesto() {
        CategoriaCompuesto categoriaCompuesto = buildCategoriaCompuesta();
        boolean agregado = categoriaController.crearCategoriaCompuesta(
                categoriaCompuesto.getIdCategoria(),
                categoriaCompuesto.getNombreCategoria(),
                categoriaCompuesto.getDescripcion()
        );

        if (agregado) {
            listaCategoriaCompuestas.add(categoriaCompuesto);
            limpiarCampos();
        }

    }

    private void agregarCategoriaSimple() {
        CategoriaSimple categoriaSimple = buildCategoriaSimple();
        if (categoriaController.agregarSubcategoria(0, categoriaSimple)) {
            listaCategoriaSimples.add(categoriaSimple);
            limpiarCampos();
        }

    }


    private CategoriaCompuesto buildCategoriaCompuesta() {
        return new CategoriaCompuesto(
                txt_ID.getText(),
                cmbx_Nombre.getSelectionModel().getSelectedItem(),
                txt_Descripcion.getText(),
                new ArrayList<>()
        );
    }

    private CategoriaSimple buildCategoriaSimple() {
        return new CategoriaSimple(
                txt_IDSubcategoria.getText(),
                cmbx_NombreSub.getSelectionModel().getSelectedItem(),
                txt_DescripcionSub.getText()
        );
    }


    private void eliminarCategoria() {
        if (selectedCategoriaCompuesto != null) {
            String idCategoria = selectedCategoriaCompuesto.getIdCategoria();
            if (categoriaController.eliminarCategoriaPorId(idCategoria)) {
                listaCategoriaCompuestas.remove(selectedCategoriaCompuesto);
                limpiarCampos();
                limpiarSeleccion();
            }
        } else {
            System.out.println("Debe seleccionar una categoría compuesta para eliminar.");
        }
    }

    private void eliminarCategoria2() {
        if (selectedCategoriaSimple != null) {
            String idCategoria = selectedCategoriaSimple.getIdCategoria();
            if (categoriaController.eliminarCategoriaPorId(idCategoria)) {
                listaCategoriaSimples.remove(selectedCategoriaSimple);
                limpiarCampos();
                limpiarSeleccion();
            }
        } else {
            System.out.println("Debe seleccionar una subcategoría para eliminar.");
        }
    }



    private void actualizarCategoria() {
        if (selectedCategoriaSimple != null) {
            Object seleccionado = cmbx_NombreSub.getSelectionModel().getSelectedItem();
            String nuevoNombreStr = seleccionado != null ? seleccionado.toString() : "";

            NombreCategoria nuevoNombre;
            try {
                nuevoNombre = NombreCategoria.valueOf(nuevoNombreStr);
            } catch (IllegalArgumentException e) {
                System.out.println("Nombre de categoría inválido: " + nuevoNombreStr);
                return; // salir del método porque el valor no es válido
            }

            String nuevaDescripcion = txt_DescripcionSub.getText();

            CategoriaSimple nuevaSubcategoria = new CategoriaSimple(
                    selectedCategoriaSimple.getIdCategoria(),
                    nuevoNombre,
                    nuevaDescripcion
            );

            if (categoriaController.actualizarSubcategoriaPorId(
                    selectedCategoriaSimple.getIdCategoria(),
                    nuevaSubcategoria)) {
                System.out.println("Subcategoría actualizada correctamente.");

                int index = listaCategoriaSimples.indexOf(selectedCategoriaSimple);
                if (index >= 0) {
                    listaCategoriaSimples.set(index, nuevaSubcategoria);
                }

                selectedCategoriaSimple = nuevaSubcategoria;

                limpiarCampos();
                limpiarSeleccion();

            } else {
                System.out.println("No se pudo actualizar la subcategoría.");
            }
        } else {
            System.out.println("Debe seleccionar una subcategoría para actualizar.");
        }
    }



    private void limpiarSeleccion() {
        tb_CategoriaComp.getSelectionModel().clearSelection();
        tb_Subcategoria.getSelectionModel().clearSelection();
        limpiarCampos();
    }

    private void limpiarCampos() {
        txt_ID.clear();
        txt_Descripcion.clear();
        cmbx_Nombre.getSelectionModel().clearSelection();
        tb_CategoriaComp.getSelectionModel().clearSelection();
    }

    private void limpiarCampos2() {
        txt_IDSubcategoria.clear();
        txt_DescripcionSub.clear();
        cmbx_NombreSub.getSelectionModel().clearSelection();
        tb_Subcategoria.getSelectionModel().clearSelection();
    }

    public void cargarOpciones() {
        ObservableList<NombreCategoria> options = FXCollections.observableArrayList(NombreCategoria.values());
        cmbx_Nombre.setItems(options);
    }

    public void cargarOpciones1() {
        ObservableList<NombreCategoria> options = FXCollections.observableArrayList(NombreCategoria.values());
        cmbx_NombreSub.setItems(options);
    }

    public void setApp(App app) {
        this.app = app;
        cargarOpciones();
        cargarOpciones1();
    }


}
