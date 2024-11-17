package co.edu.uniquindio.poo.proyectofinalcarrouq.View;

import java.time.LocalDate;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Controller.AdminController;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Empleado;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Venta;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class ReporteViewController {

    // Atributos
    @FXML
    private ComboBox<Empleado> cbxEmpleados;

    @FXML
    private TableColumn<Venta, String> tbCliente;

    @FXML
    private TableColumn<Venta, String> tbEmpleadoCedula;

    @FXML
    private TableColumn<Venta, String> tbEmpleadoNombre;

    @FXML
    private TableColumn<Venta, LocalDate> tbFechaVenta;

    @FXML
    private TableColumn<Venta, String> tbId;

    @FXML
    private TableColumn<Venta,String> tbTransaccion;

    @FXML
    private TableColumn<Venta, String> tbVehiculo;

    @FXML
    private TableView<Venta> tbVentas;

    @FXML
    private TextArea txtxDescripcion;

    ObservableList<Empleado> listaEmpleados = FXCollections.observableArrayList();
    ObservableList<Venta> listaVentas = FXCollections.observableArrayList();
    AdminController adminController;

    // Método que se ejecuta al inicial
    @FXML
    public void initialize() {

        adminController = new AdminController();
        initView();
        obtenerEmpleados();
        inicializarCombox();

        // Agrega un listener al ComboBox para actualizar la tabla al cambiar el empleado seleccionado
        cbxEmpleados.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                actualizarTablaVentas(newValue.getCedula());
            }
        });

        // Listener en la tabla para mostrar la descripción del vehículo seleccionado
        tbVentas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtxDescripcion.clear();
                txtxDescripcion.setText(newValue.getDescripcion());
            }
        });
    }

    // Método para inicializar la vista
    private void initView() {
// Columna de Cliente (puedes extraer el nombre o algún otro dato relevante del Cliente)
        tbCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente().getNombre()));

// Columna de Empleado - Cedula
        tbEmpleadoCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmpleado().getCedula()));

// Columna de Empleado - Nombre
        tbEmpleadoNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmpleado().getNombre()));

// Columna de Fecha de Venta
        tbFechaVenta.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getFechaVenta()));

// Columna de ID de Venta
        tbId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigo()));

// Columna de Tipo de Transacción (asumiendo que `TipoTransaccion` es un enum o similar)
        tbTransaccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoTransaccion().toString()));

// Columna de Vehículo (puedes mostrar la placa, modelo, o algún otro atributo relevante)
        tbVehiculo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVehiculo().getPlaca()));

    }

    // Método para inicializar el ComboBox
    public void inicializarCombox(){
        cbxEmpleados.setItems(listaEmpleados);
    }

    // Método para obtener los empleados
    private void obtenerEmpleados(){
        listaEmpleados.addAll(adminController.obtenerEmpleados());
    }


    // Método que obtiene las ventas del empleado seleccionado y actualiza la tabla
    private void actualizarTablaVentas(String cedulaEmpleado) {
        // Limpia la lista de ventas antes de llenarla con los nuevos datos
        listaVentas.clear();

        // Obtiene las ventas del empleado seleccionado
        listaVentas.addAll(adminController.obtenerVentasEmpleado(cedulaEmpleado));

        // Refresca la tabla para mostrar los nuevos datos
        tbVentas.setItems(listaVentas);
        tbVentas.refresh();
    }

    // Método para limpiar los campos
    @FXML
    void limpiar(ActionEvent event) {
        cbxEmpleados.getSelectionModel().clearSelection();
        listaVentas.clear();
        txtxDescripcion.clear();
        tbVentas.refresh();
    }

    // Método para resetear la vista
    @FXML
    void resetear(ActionEvent event) {
        listaVentas.clear();
        listaEmpleados.clear();
        txtxDescripcion.clear();
        obtenerEmpleados();
    }
    
}
