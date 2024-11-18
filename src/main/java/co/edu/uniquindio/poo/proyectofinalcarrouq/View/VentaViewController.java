package co.edu.uniquindio.poo.proyectofinalcarrouq.View;

import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import co.edu.uniquindio.poo.proyectofinalcarrouq.Controller.EmpleadoController;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Exception.VehiculoException;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Bus;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Camion;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Camioneta;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Cliente;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Deportivo;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Moto;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.PickUps;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Sedan;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Vans;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Venta;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract.Vehiculo;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoCamiones;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoEstado;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoTransaccion;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.StageStyle;

public class VentaViewController {

    @FXML
    private ImageView vehiculoImagen;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    private ComboBox<String> cbxVehiculos;

    @FXML
    private ComboBox<Cliente> cbxClientes;

    @FXML
    private TableView<Sedan> tblSedan;

    @FXML
    private TableColumn<Sedan, String> colMaleteroSedan, colMarcaSedan, colModeloSedan, colPlacaSedan;

    @FXML
    private TableColumn<Sedan, Boolean> colNuevoSedan;

    @FXML
    private TableColumn<Moto, String> colMarcaMoto, colModeloMoto, colPlacaMoto, colCilindrajeMoto, colVelMaxMoto;

    @FXML
    private TableColumn<Moto, Boolean> colNuevoMoto;

    @FXML
    private TableView<Moto> tblMoto;

    @FXML
    private TableColumn<Deportivo, String> colPlacaDep, colModeloDep, colMarcaDep, colCaballoFuerDep;

    @FXML
    private TableColumn<Deportivo,  Boolean> colNuevoDep, colTieneAeroDep;

    @FXML
    private TableView<Deportivo> tblDeportivo;

    @FXML
    private TableColumn<Camioneta, String> colPlacaCam,colModeloCam,colMarcaCam,colCapacidadMalCam;

    @FXML
    private TableColumn<Camioneta, Boolean> colNuevoCam, colEs4X4Cam;

    @FXML
    private TableView<Camioneta> tblCamionetas;

    @FXML
    private TableColumn<PickUps, String> colPlacaPick,colModeloPick,colMarcaPick,colCapacidadCajPick;

    @FXML
    private TableColumn<PickUps, Boolean> colNuevoPick, colEs4X4Pick;

    @FXML
    private TableView<PickUps> tblPickUps;


    @FXML
    private TableColumn<Vans, String> colPlacaVans, colModeloVans, colMarcaVans, colCapacidadMalVans;

    
    @FXML
    private TableColumn<Vans, Boolean> colNuevoVans, colEsABSVans;

    @FXML
    private TableView<Vans> tblVans;

    @FXML
    private TableColumn<Bus, String> colPlacaBus, colModeloBus, colMarcaBus, colCapacidadMalBus, colNumBolsasBus;

    @FXML
    private TableColumn<Bus, Boolean> colNuevoBus;

    @FXML
    private TableView<Bus> tblBuses;

    @FXML
    private TableColumn<Camion, String> colPlacaCamn, colModeloCamn,colMarcaCamn, colCapCargaCamn;

    @FXML
    private TableColumn<Camion, TipoCamiones> colTipoCamn;

    @FXML
    private TableColumn<Camion, Boolean> colNuevoCamn;

    @FXML
    private TableView<Camion> tblCamiones;

    private EmpleadoController empleadoController;
    ObservableList<Sedan> listaSedans = FXCollections.observableArrayList();
    ObservableList<Moto> listaMotos = FXCollections.observableArrayList();
    ObservableList<Deportivo> listaDeportivos = FXCollections.observableArrayList();
    ObservableList<Camioneta> listaCamionetas = FXCollections.observableArrayList();
    ObservableList<PickUps> listaPick = FXCollections.observableArrayList();
    ObservableList<Vans> listaVans = FXCollections.observableArrayList();
    ObservableList<Bus> listaBuses = FXCollections.observableArrayList();
    ObservableList<Camion> listaCamiones = FXCollections.observableArrayList();
    ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
    
    
    Vehiculo vehiculoSeleccionado;
    private List<TableView<? extends Vehiculo>> tablas;



    @FXML
    public void initialize() {

        empleadoController = new EmpleadoController();
        initView();
        obtenerVehiculos();
        configTablas();
        inicializarComboBoxClientes();
        configSeleccion();
    }

    private void initView(){
        // Configurar columnas de la tabla
        colPlacaSedan.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlaca()));
        colModeloSedan.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
                colMarcaSedan.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
                colNuevoSedan.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isEsNuevo()));
                colMaleteroSedan.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().getCapacidadMaletero()).asString());

                colPlacaMoto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlaca()));
            colModeloMoto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
            colMarcaMoto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
            colNuevoMoto.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isEsNuevo()));
            colCilindrajeMoto.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().getCilindraje()).asString());
            colVelMaxMoto.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().getVelocidadMax()).asString());
    
            colPlacaDep.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlaca()));
            colModeloDep.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
            colMarcaDep.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
            colNuevoDep.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isEsNuevo()));
            colCaballoFuerDep.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getNumCaballosFuerza()).asString());
            colTieneAeroDep.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isTieneAerodinamicaMejorada()));
    
            colPlacaCam.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlaca()));
            colModeloCam.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
            colMarcaCam.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
            colCapacidadMalCam.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().getCapacidadMaletero()).asString());
            colNuevoCam.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isEsNuevo()));
            colEs4X4Cam.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isEs4x4()));
    
            colPlacaPick.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlaca()));
            colModeloPick.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
            colMarcaPick.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
            colCapacidadCajPick.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCapacidadCajaCarga())));
            colNuevoPick.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isEsNuevo()));
            colEs4X4Pick.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isEs4x4()));
    
            colPlacaVans.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlaca()));
            colModeloVans.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
            colMarcaVans.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
            colCapacidadMalVans.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCapacidadMaletero())));
            colNuevoVans.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isEsNuevo()));
            colEsABSVans.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isTieneABS()));
    
            colPlacaBus.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlaca()));
            colModeloBus.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
            colMarcaBus.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
            colCapacidadMalBus.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCapacidadMaletero())));
            colNumBolsasBus.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNumeroBolsaAire())));
            colNuevoBus.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isEsNuevo()));
    
            colPlacaCamn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlaca()));
            colModeloCamn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
            colMarcaCamn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
            colCapCargaCamn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCapCarga())));
            colTipoCamn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getTipoCamion()));
            colNuevoCamn.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isEsNuevo()));


            cbxVehiculos.getItems().addAll("Sedan", "Motos", "Deportivo", "Camionetas",
                        "PickUps", "Vans", "Buses", "Camiones");
                        cbxVehiculos.setOnAction(this::onVehiculoChange);
                    }
    // Metodo para inicializar el ComboBox de clientes con la lista de clientes disponibles                
    public void inicializarComboBoxClientes() {
        cbxClientes.setItems(listaClientes);
    }
    
    // Metodo para configurar la seleccion de las tablas de vehiculos
    public void configSeleccion(){
        tablas = Arrays.asList(tblSedan, tblMoto, tblDeportivo, tblCamionetas,
                tblPickUps, tblVans, tblBuses, tblCamiones);

        tablas.forEach(this::configurarSeleccion);
    }

    //  Metodo para configurara la seleccion de un vehiculo en la tabla proporcionado 
    
    private void configurarSeleccion(TableView<? extends Vehiculo> tabla) {
        tabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Vehiculo>() {
            @Override
            public void changed(ObservableValue<? extends Vehiculo> observable, Vehiculo oldValue, Vehiculo newValue){
                if (newValue != null) {
                    vehiculoSeleccionado = newValue;  // Guardar el vehículo seleccionado en la variable
                    vehiculoImagen.setImage(new Image(new File(newValue.getImagen()).toURI().toString()));
                }}});
            }

    // Metodo para obtener Vehiculos

    private void obtenerVehiculos(){
        listaSedans.addAll(empleadoController.obtenerSedans());
        listaMotos.addAll(empleadoController.obtenerMotos());
        listaDeportivos.addAll(empleadoController.obtenerDeportivos());
        listaCamionetas.addAll(empleadoController.obtenerCamionetas());
        listaPick.addAll(empleadoController.obtenerPicKups());
        listaVans.addAll(empleadoController.obtenerVan());
        listaBuses.addAll(empleadoController.obtenerBuses());
        listaCamiones.addAll(empleadoController.obtenerCamiones());

        listaClientes.addAll(empleadoController.obtenerClientes());
    }
    
    // Metodo para limpiar la tabla de vehiculos y configurar cada una con sus listas de vehiculo
    private void configTablas(){
        tblSedan.getItems().clear();
        tblMoto.getItems().clear();
        tblDeportivo.getItems().clear();
        tblCamionetas.getItems().clear();
        tblPickUps.getItems().clear();
        tblVans.getItems().clear();
        tblBuses.getItems().clear();
        tblCamiones.getItems().clear();
        tblSedan.setItems(listaSedans);
        tblMoto.setItems(listaMotos);
        tblDeportivo.setItems(listaDeportivos);
        tblCamionetas.setItems(listaCamionetas);
        tblPickUps.setItems(listaPick);
        tblVans.setItems(listaVans);
        tblBuses.setItems(listaBuses);
        tblCamiones.setItems(listaCamiones);
    
    }
    
    
    // Metodo para mostrar la tabla correspondiente al tipo de vehículo seleccionado y oculta las demás
    @FXML
    void onVehiculoChange(ActionEvent event) {

        String selectedVehicle = String.valueOf(cbxVehiculos.getValue());

        tblSedan.setVisible(false);
        tblMoto.setVisible(false);
        tblDeportivo.setVisible(false);
        tblCamionetas.setVisible(false);
        tblPickUps.setVisible(false);
        tblVans.setVisible(false);
        tblBuses.setVisible(false);
        tblCamiones.setVisible(false);

        switch (selectedVehicle) {
            case "Sedan":
                tblSedan.setVisible(true);
                break;

            case "Motos":
                tblMoto.setVisible(true);
                break;

            case "Deportivo":
                tblDeportivo.setVisible(true);
                break;

            case "Camionetas":
                tblCamionetas.setVisible(true);
                break;

            case "PickUps":
                tblPickUps.setVisible(true);
                break;

            case "Vans":
                tblVans.setVisible(true);
                break;

            case "Buses":
                tblBuses.setVisible(true);
                break;

            case "Camiones":
                tblCamiones.setVisible(true);
                break;}
            }

    @FXML
    void actualizarTbls(ActionEvent event) {
        listaSedans.clear();
        listaMotos.clear();
        listaDeportivos.clear();
        listaCamionetas.clear();
        listaPick.clear();
        listaVans.clear();
        listaBuses.clear();
        listaCamiones.clear();
        listaClientes.clear();
        obtenerVehiculos();
    }

    //Metodo para realizar la venta de un vehiculo seleccionado

    @FXML
    void venderVehiculo(ActionEvent event) throws VehiculoException {
        if (vehiculoSeleccionado.getTipoEstado().equals(TipoEstado.EN_POSESION)){
        Venta venta = new Venta();
        venta.setCodigo(UUID.randomUUID().toString());
        vehiculoSeleccionado.setTipoEstado(TipoEstado.COMPRADO);
        venta.setVehiculo(vehiculoSeleccionado);
        venta.setCliente(cbxClientes.getValue());
        venta.setDescripcion(txtDescripcion.getText());
        venta.setEmpleado(empleadoController.obtenerEmpleadoLogeado());
        venta.setFechaVenta(LocalDate.now());
        venta.setTipoTransaccion(TipoTransaccion.VENTA);
        if (empleadoController.addVenta(venta) == 1){
            mensajeInformacion("Venta Completada","Se Creo la venta correctamente");
            limpiarCampos();
        }else{
            mensajeError("Error en la Venta","Los Datos son invalidos o ya utilizados");
        }
        }else{
            mensajeError("Error en la Venta","El vehiculo ya no esta en el catalogo");
        }
    }
    
    //Metodo para realizar la compra de un vehiculo seleccionado

    @FXML
    void comprarVehiculo(ActionEvent event) throws VehiculoException {
        if (mostrarAlertaConOpciones()){
            Venta venta = new Venta();
            venta.setCodigo(UUID.randomUUID().toString());
            vehiculoSeleccionado.setTipoEstado(TipoEstado.COMPRADO);
            venta.setVehiculo(vehiculoSeleccionado);
            venta.setCliente(cbxClientes.getValue());
            venta.setDescripcion(txtDescripcion.getText());
            venta.setEmpleado(empleadoController.obtenerEmpleadoLogeado());
            venta.setFechaVenta(LocalDate.now());
            venta.setTipoTransaccion(TipoTransaccion.COMPRA);
            if (empleadoController.addVenta(venta) == 1){
                mensajeInformacion("Venta Completada","Se Creo la venta correctamente");
                limpiarCampos();
            }else{
                mensajeError("Error en la Venta","Los Datos son invalidos o ya utilizados");
            }
        }
    }

    // Metodo para realizae el alquiler de un vehiculo

    @FXML
    void alquilarVehiculo(ActionEvent event) throws VehiculoException {
        if (vehiculoSeleccionado.getTipoEstado().equals(TipoEstado.EN_POSESION)){
        Venta venta = new Venta();
        venta.setCodigo(UUID.randomUUID().toString());
        vehiculoSeleccionado.setTipoEstado(TipoEstado.ALQUILADO);
        venta.setVehiculo(vehiculoSeleccionado);
        venta.setCliente(cbxClientes.getValue());
        venta.setDescripcion(txtDescripcion.getText());
        venta.setEmpleado(empleadoController.obtenerEmpleadoLogeado());
        venta.setFechaVenta(LocalDate.now());
        venta.setTipoTransaccion(TipoTransaccion.ALQUILER);
        if (empleadoController.addVenta(venta) == 1){
            mensajeInformacion("Venta Completada","Se Creo la venta correctamente");
            limpiarCampos();
        }else{
            mensajeError("Error en la Venta","Los Datos son invalidos o ya utilizados");
        }
        }else{
            mensajeError("Error en la Venta","El vehiculo ya no esta en el catalogo");
        }
    }

// Metodo para mostrar una confirmacion  para verificar si el vehiculo paso su revision

    public Boolean mostrarAlertaConOpciones(){
        // Crear la alerta
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Seleccione una opción");
        alerta.setHeaderText("¿El Vehiculo paso la revision Tecnica?");
        alerta.initStyle(StageStyle.UTILITY);

        // Crear los RadioButton
        RadioButton rbSi = new RadioButton("Sí");
        RadioButton rbNo = new RadioButton("No");

        // Agrupar los RadioButton en un ToggleGroup
        ToggleGroup toggleGroup = new ToggleGroup();
        rbSi.setToggleGroup(toggleGroup);
        rbNo.setToggleGroup(toggleGroup);
        
        // Colocar los RadioButton en un HBox
        HBox hBox = new HBox(10, rbSi, rbNo);

        // Añadir el HBox a la alerta
        alerta.getDialogPane().setContent(hBox);

        // Mostrar la alerta y esperar la respuesta
        alerta.showAndWait();

        // Retornar true si se seleccionó "Sí" y false si se seleccionó "No"
        return rbSi.isSelected();
    }

    // Metodo para mostrar un mensaje de informacion 


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

    //Metodo para limpiar los campos de la interfaz

    public void limpiarCampos(){
        cbxVehiculos.setValue(null);
        cbxClientes.setValue(null);
        txtDescripcion.setText(null);

    }
    }









    
















    

