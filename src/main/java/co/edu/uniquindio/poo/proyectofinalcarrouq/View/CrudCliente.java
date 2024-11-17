package co.edu.uniquindio.poo.proyectofinalcarrouq.View;

import co.edu.uniquindio.poo.proyectofinalcarrouq.Controller.EmpleadoController;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Exception.PersonaException;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Cliente;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.Genero;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Utils.TextFormatterUtils;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;
import java.util.Optional;

public class CrudCliente {
    
    //Atributos
    @FXML
    private ComboBox<Genero> cbxGenero;

    @FXML
    private TableColumn<Cliente, String> colCedula, colCorreo,colNombre;

    @FXML
    private TableColumn<Cliente, Integer> colEdad;

    @FXML
    private TableColumn<Cliente, Genero> colGenero;


    @FXML
    private TableView<Cliente> tablaClientes;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtNombre;


    private EmpleadoController empleadoController;
    ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();

    //Metodo para inicializar la vista
    @FXML
    private void initialize() {
        empleadoController = new EmpleadoController();
        initView();
        obtenerClientes();
        tablaClientes.getItems().clear();
        tablaClientes.setItems(listaClientes);
        selectionModel();
        // Formato para solo aceptar numeros.
        txtEdad.setTextFormatter(new TextFormatter<>(TextFormatterUtils:: integerFormat));

    }

    //Metodo para inicializar la vista
    private void initView(){
        colCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colCorreo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        colGenero.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getGenero()));
        colEdad.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getEdad()).asObject());
        cbxGenero.setItems(FXCollections.observableArrayList(Genero.values()));
        cbxGenero.setItems(FXCollections.observableArrayList(Genero.values()));
    }

    //Metodo para obtener los clientes
    private void obtenerClientes(){
        listaClientes.addAll(empleadoController.obtenerClientes());
    }

    //Metodo para seleccionar un cliente
    private void selectionModel(){
        // It checks if the table is not empty.
        if (tablaClientes != null){
            // Method for selecting Admins.
            tablaClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelecation)->{
                // A AdminsDto is created with the one selected from the table.
                Cliente cliente = newSelecation;
                if (cliente != null){
                    // The method to fill the fields is called.
                    llenarCampos(cliente);
                    // The txt becomes non-editable.
                    txtCedula.setEditable(false);
                    txtCorreo.setEditable(false);
                }});
        }}

    //Metodo para crear un cliente
    public Cliente crearCliente(){
        Cliente cliente = new Cliente();
        cliente.setCedula(txtCedula.getText());
        cliente.setCorreo(txtCorreo.getText());
        cliente.setNombre(txtNombre.getText());
        cliente.setEdad(Integer.parseInt(txtEdad.getText()));
        cliente.setGenero(cbxGenero.getValue());
        cliente.setFechaRegistro(LocalDate.now());

        return cliente;
    }

    //Metodo para agregar un cliente
    @FXML
    void agregarCliente(ActionEvent event) throws PersonaException {
        if (camposLlenos()){
            int resultado = empleadoController.addCliente(crearCliente());

            switch (resultado){

                case 1:

                    mensajeInformacion("Creacion Completada","Se Creo el Cliente correctamente");
                    limpiarCampos();
                    listaClientes.clear();
                    obtenerClientes();
                    tablaClientes.refresh();
                    break;

                case 2:
                    mensajeError("Error en la Creacion","Los Datos son invalidos o ya utilizados");
            }}}

    //Metodo para editar un cliente
    @FXML
    void editarCliente(ActionEvent event) throws PersonaException {
        Cliente seleccionado = tablaClientes.getSelectionModel().getSelectedItem();
        if (seleccionado == null){
            mensajeError("Error al actualizar","Por favor, seleccione un cliente de la lista para actualizar");
        }else {
            if (mensajeConfirmacion("Confirmarcion de actualizar", "Actualizar Cliente",
                    "Desea Actualizar el Cliente?")) {
                Cliente cliente = crearCliente();
                if (empleadoController.actualizarCliente(seleccionado.getCedula(),cliente)){
                    mensajeInformacion("Cliente" +
                            " Actualizado", "Se actualizo el Cliente correctamente");
                    tablaClientes.getSelectionModel().clearSelection();
                    limpiarCampos();
                    listaClientes.clear();
                    obtenerClientes();
                    tablaClientes.refresh();
                }}}}

    //Metodo para eliminar un cliente
    @FXML
    void eliminarCliente(ActionEvent event) throws PersonaException {
        Cliente cliente = tablaClientes.getSelectionModel().getSelectedItem();
        if (cliente == null){
            mensajeError("Error al eliminar", "Por favor, seleccione un cliente de la lista para eliminar.");

        }else {
            if (mensajeConfirmacion("Confirmacion de eliminacion","Eliminar Empleado",
                    "Desea eliminar el Empleado?")){

                if (empleadoController.removeCliente(cliente) == 1){
                    mensajeInformacion("Empleado Eliminado", "Se elimino el Empleado correctamente");
                    tablaClientes.getSelectionModel().clearSelection();
                    limpiarCampos();
                    listaClientes.clear();
                    obtenerClientes();
                    tablaClientes.refresh();
                }else{
                    mensajeError("Error al eliminar", "Error al eliminar el cliente");
                }}}}

    //Metodo para limpiar los campos
    @FXML
    void limpiar(ActionEvent event) {
        limpiarCampos();
    }

    //Metodo para verificar si los campos estan llenos
    private boolean camposLlenos() {
        return !txtCedula.getText().isEmpty() &&
                !txtCorreo.getText().isEmpty() &&
                !txtEdad.getText().isEmpty() &&
                !txtNombre.getText().isEmpty() &&
                cbxGenero.getValue() != null;
    }

    //Metodo para limpiar los campos
    private void limpiarCampos() {
        txtCedula.clear();
        txtCorreo.clear();
        txtEdad.clear();
        txtNombre.clear();
        cbxGenero.setValue(null);
        txtCedula.setEditable
                (true);
        txtCorreo.setEditable(true);
    }

    //Metodo para llenar los campos
    public void llenarCampos(Cliente cliente) {
        if (cliente != null) {
            txtCedula.setText(cliente.getCedula());
            txtCorreo.setText(cliente.getCorreo());
            txtEdad.setText(String.valueOf(cliente.getEdad()));
            txtNombre.setText(cliente.getNombre());
            cbxGenero.setValue(cliente.getGenero());
        }
    }

    //Metodo para mostrar un mensaje de informacion
    public void mensajeInformacion(String title, String context){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(context);
        alert.showAndWait();
    }

    //Metodo para mostrar un mensaje de error
    public void mensajeError(String title, String context){

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(" Error!!");
        alert.setContentText(context);
        alert.showAndWait();
    }

    //Metodo para mostrar un mensaje de confirmacion
    public boolean mensajeConfirmacion(String title, String context, String opcion){
        Alert mensaje = new Alert(Alert.AlertType.WARNING);
        mensaje.setTitle(title);
        mensaje.setHeaderText(context);
        mensaje.setContentText(opcion);
        ButtonType botonSi = new ButtonType("Confirmar");
        ButtonType botonNo = new ButtonType("Rechazar");
        mensaje.getButtonTypes().setAll(botonSi,botonNo);
        Optional<ButtonType> opciones = mensaje.showAndWait();

        if (opciones.get() == botonSi){
            mensaje.close();
            return true;

        }else {
            mensaje.close();
            return false;
        }}
}
