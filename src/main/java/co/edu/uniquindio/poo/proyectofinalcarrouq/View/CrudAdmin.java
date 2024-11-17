package co.edu.uniquindio.poo.proyectofinalcarrouq.View;

import co.edu.uniquindio.poo.proyectofinalcarrouq.Controller.AdminController;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Exception.PersonaException;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Admin;
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
import java.util.Optional;

public class CrudAdmin {
    
    //Atributos
    @FXML
    private TextField txtCedula, txtNombre, txtCorreo, txtEdad, txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private ComboBox<Genero> cbxGenero;
    @FXML
    private TableView<Admin> tablaAdmins;
    @FXML
    private TableColumn<Admin, String> colCedula, colNombre, colCorreo, colUserName;
    @FXML
    private TableColumn<Admin, Genero> colGenero;
    @FXML
    private TableColumn<Admin, Integer> colEdad;

    private AdminController adminController;
    ObservableList<Admin> listaAdmins = FXCollections.observableArrayList();

    //Metodo para inicializar la vista
    @FXML
    private void initialize() {
        adminController = new AdminController();
        initView();
        obtenerAdmins();
        tablaAdmins.getItems().clear();
        tablaAdmins.setItems(listaAdmins);
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

        cbxGenero.setItems(FXCollections.observableArrayList(Genero.values()));
        cbxGenero.setItems(FXCollections.observableArrayList(Genero.values()));
    }

    private void obtenerAdmins(){
        listaAdmins.addAll(adminController.obtenerAdmins());
    }

    private void selectionModel(){
        // It checks if the table is not empty.
        if (tablaAdmins != null){
            // Method for selecting Admins.
            tablaAdmins.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelecation)->{
                // A AdminsDto is created with the one selected from the table.
                Admin admin = newSelecation;
                if (admin != null){
                    // The method to fill the fields is called.
                    llenarCampos(admin);
                    // The txt becomes non-editable.
                    txtCedula.setEditable(false);
                    txtCorreo.setEditable(false);
                }});
        }}

    //Metodo para crear un admin
    public Admin crearAdmin(){
        Admin admin = new Admin();
        admin.setCedula(txtCedula.getText());
        admin.setCorreo(txtCorreo.getText());
        admin.setNombre(txtNombre.getText());
        admin.setEdad(Integer.parseInt(txtEdad.getText()));
        admin.setGenero(cbxGenero.getValue());

        UserName userName = new UserName();
        userName.setUserName(txtUsername.getText());
        userName.setPassword(txtPassword.getText());
        admin.setUserName(userName);
        return admin;
    }

    //Metodo para agregar un admin
    @FXML
    void agregarAdmin(ActionEvent event) throws PersonaException {
        if (camposLlenos()){
            int resultado = adminController.addAdmin(crearAdmin());

            switch (resultado){

                case 1:

                    mensajeInformacion("Creacion Completada","Se Creo el Admin correctamente");
                    limpiarCampos();
                    listaAdmins.clear();
                    obtenerAdmins();
                    tablaAdmins.refresh();
                    break;

                case 2:
                    mensajeError("Error en la Creacion","Los Datos son invalidos o ya utilizados");
            }}}

    //Metodo para editar un admin
    @FXML
    void editarAdmin(ActionEvent event) throws PersonaException {
        Admin seleccionado = tablaAdmins.getSelectionModel().getSelectedItem();
        if (seleccionado == null){
            mensajeError("Error al actualizar","Por favor, seleccione un admin de la lista para actualizar");
        }else {
            if (mensajeConfirmacion("Confirmarcion de actualizar", "Actualizar Admin",
                    "Desea Actualizar el Admin?")) {
                Admin admin = crearAdmin();
                if (adminController.actualizarAdmin(seleccionado.getCedula(),admin)){
                    mensajeInformacion("Admin Actualizado", "Se actualizo el Admin correctamente");
                    tablaAdmins.getSelectionModel().clearSelection();
                    limpiarCampos();
                    listaAdmins.clear();
                    obtenerAdmins();
                    tablaAdmins.refresh();
                }}}}

    //Metodo para eliminar un admin
    @FXML
    void eliminarAdmin(ActionEvent event) throws PersonaException {

        Admin admin = tablaAdmins.getSelectionModel().getSelectedItem();
        if (admin == null){
            mensajeError("Error al eliminar", "Por favor, seleccione un admin de la lista para eliminar.");

        }else {
            if (mensajeConfirmacion("Confirmacion de eliminacion","Eliminar Empleado",
                    "Desea eliminar el Empleado?")){

                if (adminController.removeAdmin(admin) == 1){
                    mensajeInformacion("Empleado Eliminado", "Se elimino el Empleado correctamente");
                    tablaAdmins.getSelectionModel().clearSelection();
                    limpiarCampos();
                    listaAdmins.clear();
                    obtenerAdmins();
                    tablaAdmins.refresh();
                }else{
                    mensajeError("Error al eliminar", "Error al eliminar el admin");
                }}}}

    //Metodo para limpiar los campos
    @FXML
    void limpiar(ActionEvent event) {
        limpiarCampos();
    }

    //Metodo para validar que los campos esten llenos
    private boolean camposLlenos() {
        return !txtCedula.getText().isEmpty() &&
                !txtCorreo.getText().isEmpty() &&
                !txtEdad.getText().isEmpty() &&
                !txtNombre.getText().isEmpty() &&
                !txtPassword.getText().isEmpty() &&
                !txtUsername.getText().isEmpty() &&
                cbxGenero.getValue() != null;
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
        txtCedula.setEditable(true);
        txtCorreo.setEditable(true);
    }

    //Metodo para llenar los campos
    public void llenarCampos(Admin admin) {
        if (admin != null) {
            txtCedula.setText(admin.getCedula());
            txtCorreo.setText(admin.getCorreo());
            txtEdad.setText(String.valueOf(admin.getEdad()));
            txtNombre.setText(admin.getNombre());
            txtUsername.setText(admin.getUserName().getUsername());
            txtPassword.setText(admin.getUserName().getPassword());
            cbxGenero.setValue(admin.getGenero());
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
    

