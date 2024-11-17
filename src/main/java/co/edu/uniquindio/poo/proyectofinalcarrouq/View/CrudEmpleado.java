package co.edu.uniquindio.poo.proyectofinalcarrouq.View;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Controller.AdminController;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Exception.PersonaException;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Empleado;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.Genero;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.UserName;
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


public class CrudEmpleado {

    //Atributos
    @FXML
    private ComboBox<Genero> cbxGenero;

    @FXML
    private TableColumn<Empleado, String> colCedula;

    @FXML
    private TableColumn<Empleado, String> colCorreo;

    @FXML
    private TableColumn<Empleado,Integer> colEdad;

    @FXML
    private TableColumn<Empleado, LocalDate> colFechaContratacion;

    @FXML
    private TableColumn<Empleado, Genero> colGenero;

    @FXML
    private TableColumn<Empleado, String> colNombre;

    @FXML
    private TableColumn<Empleado, String> colUserName;

    @FXML
    private DatePicker dtFechaCont;

    @FXML
    private TableView<Empleado> tablaEmpleados;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtNombre;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

    private AdminController adminController;
    ObservableList<Empleado> listaEmpleados = FXCollections.observableArrayList();

    //Metodo para inicializar la vista
    @FXML
    private void initialize() {
        adminController = new AdminController();
        initView();
        obtenerEmpleados();
        tablaEmpleados.getItems().clear();
        tablaEmpleados.setItems(listaEmpleados);
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
        colUserName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUserName().getUsername()));
        colFechaContratacion.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getFechaContratacion()));

        cbxGenero.setItems(FXCollections.observableArrayList(Genero.values()));
        cbxGenero.setItems(FXCollections.observableArrayList(Genero.values()));
    }

    //Metodo para obtener los empleados
    private void obtenerEmpleados(){
        listaEmpleados.addAll(adminController.obtenerEmpleados());
    }

    //Metodo para seleccionar un empleado
    private void selectionModel(){
        // It checks if the table is not empty.
        if (tablaEmpleados != null){
            // Method for selecting Admins.
            tablaEmpleados.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelecation)->{
                // A AdminsDto is created with the one selected from the table.
                Empleado empleado = newSelecation;
                if (empleado != null){
                    // The method to fill the fields is called.
                    llenarCampos(empleado);
                    // The txt becomes non-editable.
                    txtCedula.setEditable(false);
                    txtCorreo.setEditable(false);
                }});
        }}

    //Metodo para crear un empleado
    public Empleado crearEmpleado(){
        Empleado empleado = new Empleado();
        empleado.setCedula(txtCedula.getText());
        empleado.setCorreo(txtCorreo.getText());
        empleado.setNombre(txtNombre.getText());
        empleado.setEdad(Integer.parseInt(txtEdad.getText()));
        empleado.setGenero(cbxGenero.getValue());
        empleado.setFechaContratacion(dtFechaCont.getValue());

        UserName userName = new UserName();
        userName.setUsername(txtUsername.getText());
        userName.setPassword(txtPassword.getText());

        empleado.setUserName(userName);

        return empleado;
    }

    //Metodo para agregar un empleado
    @FXML
    void agregarEmpleado(ActionEvent event) throws PersonaException {
        if (camposLlenos()){
            int resultado = adminController.addEmpleado(crearEmpleado());

            switch (resultado){

                case 1:

                    mensajeInformacion("Creacion Completada","Se Creo el Empleado correctamente");
                    limpiarCampos();
                    listaEmpleados.clear();
                    obtenerEmpleados();
                    tablaEmpleados.refresh();
                    break;

                case 2:
                    mensajeError("Error en la Creacion","Los Datos son invalidos o ya utilizados");
            }}}

    //Metodo para editar un empleado
    @FXML
    void editarEmpleado(ActionEvent event) throws PersonaException {
        Empleado seleccionado = tablaEmpleados.getSelectionModel().getSelectedItem();
        if (seleccionado == null){
            mensajeError("Error al actualizar","Por favor, seleccione un empleado de la lista para actualizar");
        }else {
            if (mensajeConfirmacion("Confirmarcion de actualizar", "Actualizar Empleado",
                    "Desea Actualizar el Empleado?")) {
                Empleado empleado = crearEmpleado();
                // The Admin Controller is called to start the update internally.
                if (adminController.actualizarEmpleado(seleccionado.getCedula(),empleado)){
                    mensajeInformacion("Empleado Actualizado", "Se actualizo el Empleado correctamente");
                    tablaEmpleados.getSelectionModel().clearSelection();
                    limpiarCampos();
                    listaEmpleados.clear();
                    obtenerEmpleados();
                    tablaEmpleados.refresh();
                }}}}

    //Metodo para eliminar un empleado
    @FXML
    void eliminarEmpleado(ActionEvent event) throws PersonaException {

        Empleado empleado = tablaEmpleados.getSelectionModel().getSelectedItem();
        if (empleado == null){
            mensajeError("Error al eliminar", "Por favor, seleccione un empleado de la lista para eliminar.");

        }else {
            if (mensajeConfirmacion("Confirmacion de eliminacion","Eliminar Empleado",
                    "Desea eliminar el Empleado?")){

                if (adminController.removeEmpleado(empleado) == 1){
                    mensajeInformacion("Empleado Eliminado", "Se elimino el Empleado correctamente");
                    tablaEmpleados.getSelectionModel().clearSelection();
                    limpiarCampos();
                    listaEmpleados.clear();
                    obtenerEmpleados();
                    tablaEmpleados.refresh();
                }else{
                    mensajeError("Error al eliminar", "Error al eliminar el empleado");
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
                !txtPassword.getText().isEmpty() &&
                !txtUsername.getText().isEmpty() &&
                cbxGenero.getValue() != null &&
                dtFechaCont.getValue() != null;
    }

    //Metodo para limpiar los campos
    private void limpiarCampos() {
        txtCedula.clear();
        txtCorreo.clear();
        txtEdad.clear();
        txtNombre.clear();
        txtPassword.clear();
        txtUsername.clear();
        cbxGenero.setValue(null);
        dtFechaCont.setValue(null);
        txtCedula.setEditable(true);
        txtCorreo.setEditable(true);
    }

    // Metodo para llenar los campos
    public void llenarCampos(Empleado empleado) {
        if (empleado != null) {
            txtCedula.setText(empleado.getCedula());
            txtCorreo.setText(empleado.getCorreo());
            txtEdad.setText(String.valueOf(empleado.getEdad()));
            txtNombre.setText(empleado.getNombre());
            txtUsername.setText(empleado.getUserName().getUsername());
            txtPassword.setText(empleado.getUserName().getPassword());
            cbxGenero.setValue(empleado.getGenero());
            dtFechaCont.setValue(empleado.getFechaContratacion());
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
