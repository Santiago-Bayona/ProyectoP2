package co.edu.uniquindio.poo.proyectofinal.ViewController;

import co.edu.uniquindio.poo.proyectofinal.App;
import co.edu.uniquindio.poo.proyectofinal.Modelo.*;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;

public class EstadisticasVC {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BarChart<String, Number> bChart_saldoUsuarios;

    @FXML
    private BarChart<String, Number> bChart_tipoCuenta;

    @FXML
    private BarChart<String, Number> bChart_transacciones;

    @FXML
    private PieChart pChart_categorias;

    private final BilleteraVirtual sistema = App.billetara;

    @FXML
    void initialize() {
        assert bChart_saldoUsuarios != null : "fx:id=\"bChart_saldoUsuarios\" was not injected: check your FXML file 'Estadisticas.fxml'.";
        assert bChart_tipoCuenta != null : "fx:id=\"bChart_tipoCuenta\" was not injected: check your FXML file 'Estadisticas.fxml'.";
        assert bChart_transacciones != null : "fx:id=\"bChart_transacciones\" was not injected: check your FXML file 'Estadisticas.fxml'.";
        assert pChart_categorias != null : "fx:id=\"pChart_categorias\" was not injected: check your FXML file 'Estadisticas.fxml'.";

        cargarGraficoSaldoUsuarios();
        cargarGraficoTipoCuenta();
        cargarGraficoTransaccionesMensuales();
        cargarGraficoCategorias();
    }

    private void cargarGraficoSaldoUsuarios() {
        int[] intervalos = new int[4];

        for (Usuario usuario : sistema.getUsuarios()) {
            double saldo = usuario.getSaldoTotal();
            if (saldo < 10000) intervalos[0]++;
            else if (saldo < 100000) intervalos[1]++;
            else if (saldo < 1000000) intervalos[2]++;
            else intervalos[3]++;
        }

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Distribución de Saldo");
        series.getData().add(new XYChart.Data<>("[0 - 10K)", intervalos[0]));
        series.getData().add(new XYChart.Data<>("[10K - 100K)", intervalos[1]));
        series.getData().add(new XYChart.Data<>("[100K - 1M)", intervalos[2]));
        series.getData().add(new XYChart.Data<>(">= 1M", intervalos[3]));

        bChart_saldoUsuarios.getData().add(series);
    }

    private void cargarGraficoTipoCuenta() {
        int ahorro = 0, corriente = 0;
        for (CuentaBancaria cuenta : sistema.getCuentas()) {
            if (cuenta.getTipoCuenta().equals(TipoCuenta.AHORRO)) ahorro++;
            else if (cuenta.getTipoCuenta().equals(TipoCuenta.CORRIENTE)) corriente++;
        }

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Tipo de Cuenta");
        series.getData().add(new XYChart.Data<>("Ahorro", ahorro));
        series.getData().add(new XYChart.Data<>("Corriente", corriente));

        bChart_tipoCuenta.getData().add(series);
    }

    private void cargarGraficoTransaccionesMensuales() {
        Map<Month, Long> conteoMensual = sistema.getTransacciones().stream()
                .collect(Collectors.groupingBy(t -> t.getFechaTransaccion().getMonth(), Collectors.counting()));

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Transacciones por Mes");

        for (Month mes : Month.values()) {
            long cantidad = conteoMensual.getOrDefault(mes, 0L);
            series.getData().add(new XYChart.Data<>(mes.getDisplayName(TextStyle.SHORT, new Locale("es")), cantidad));
        }

        bChart_transacciones.getData().add(series);
    }

    private void cargarGraficoCategorias() {
        Map<String, Long> conteo = sistema.getTransacciones().stream()
                .filter(t -> t.getCategoria() != null)
                .collect(Collectors.groupingBy(t -> t.getCategoria().getNombreCategoria().name(), Collectors.counting()));


        List<PieChart.Data> data = conteo.entrySet().stream()
                .map(e -> new PieChart.Data(e.getKey(), e.getValue()))
                .collect(Collectors.toList());

        pChart_categorias.setData(javafx.collections.FXCollections.observableArrayList(data));
    }
}
