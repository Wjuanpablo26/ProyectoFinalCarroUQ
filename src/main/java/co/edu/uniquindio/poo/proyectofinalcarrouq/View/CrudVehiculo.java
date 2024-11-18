package co.edu.uniquindio.poo.proyectofinalcarrouq.View;

import co.edu.uniquindio.poo.proyectofinalcarrouq.Controller.EmpleadoController;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Exception.VehiculoException;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.*;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract.Vehiculo;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Combustible.*;
import co.edu.uniquindio.poo.proyectofinalcarrouq   .Model.Enum.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CrudVehiculo {
    
    @FXML
    private GridPane Deportivo;

    @FXML
    private GridPane IdNumEjes;

    @FXML
    private GridPane VCSegAvanzada;

    @FXML
    private GridPane VConfort;

    @FXML
    private RadioButton aireAcondicionadoNo;

    @FXML
    private RadioButton aireAcondicionadoSi;

    @FXML
    private Button btnImagen;

    @FXML
    private ComboBox<TipoCambios> cbxCambio;

    @FXML
    private ComboBox<TipoCamiones> cbxCamiones;

    @FXML
    private ComboBox<TipoCombustible> cbxCombustible;

    @FXML
    private ComboBox<String> cbxTipoVehiculo;

    @FXML
    private TableColumn<Vehiculo, TipoCombustible> colCombustible;

    @FXML
    private TableColumn<Vehiculo, String> colMarca;

    @FXML
    private TableColumn<Vehiculo, String> colModelo;

    @FXML
    private TableColumn<Vehiculo, String> colPlaca;

    @FXML
    private TableColumn<Vehiculo, TipoCambios> colTipoCambio;

    @FXML
    private TableColumn<Vehiculo, TipoEstado> colEstado;

    @FXML
    private TableView<Vehiculo> tblVehiculo;

    @FXML
    private GridPane electricFields;

    @FXML
    private ToggleGroup esEnchufable;

    @FXML
    private ToggleGroup esHibridoLigero;

    @FXML
    private RadioButton esHibridoNo;

    @FXML
    private RadioButton esHibridoSi;

    @FXML
    private ToggleGroup esNuevo;

    @FXML
    private GridPane hybridFields;

    @FXML
    private GridPane hybridFields2;

    @FXML
    private GridPane idCamiones;

    @FXML
    private GridPane idCapCajaCarga;

    @FXML
    private ImageView imagenView;

    @FXML
    private RadioButton rdAcondicionCamNo;

    @FXML
    private RadioButton rdAcondicionCamSi;

    @FXML
    private RadioButton rdCamaraReversaNo;

    @FXML
    private RadioButton rdCamaraReversaSi;

    @FXML
    private RadioButton rdEsEnchufableNo;

    @FXML
    private RadioButton rdEsEnchufableSi;

    @FXML
    private RadioButton rdEsNuevoNo;

    @FXML
    private RadioButton rdEsNuevoSi;

    @FXML
    private RadioButton rdFrenosAireNo;

    @FXML
    private RadioButton rdFrenosAireSi;

    @FXML
    private RadioButton rdSensorColisionNo;

    @FXML
    private RadioButton rdSensorColisionSi;

    @FXML
    private RadioButton rdTiene4X4No;

    @FXML
    private RadioButton rdTiene4X4Si;

    @FXML
    private RadioButton rdTieneABSNo;

    @FXML
    private RadioButton rdTieneABSSi;

    @FXML
    private RadioButton rdTieneAbsCamNo;

    @FXML
    private RadioButton rdTieneAbsCamSi;

    @FXML
    private RadioButton rdTieneAsistenciaNo;

    @FXML
    private RadioButton rdTieneAsistenciaSi;

    @FXML
    private RadioButton rdVelocidadCruceroNo;

    @FXML
    private RadioButton rdVelocidadCruceroSi;

    @FXML
    private ToggleGroup tiene4x4;

    @FXML
    private ToggleGroup tieneABS;

    @FXML
    private ToggleGroup tieneABS1Cam;

    @FXML
    private ToggleGroup tieneAerodinamicaDep;

    @FXML
    private RadioButton tieneAerodinamicaNo;

    @FXML
    private RadioButton tieneAerodinamicaSi;

    @FXML
    private ToggleGroup tieneAireAcon;

    @FXML
    private ToggleGroup tieneAireAconCam;

    @FXML
    private ToggleGroup tieneAsistente;

    @FXML
    private ToggleGroup tieneCamara;

    @FXML
    private ToggleGroup tieneFrenosAire;

    @FXML
    private ToggleGroup tieneSensorColi;

    @FXML
    private ToggleGroup tieneSensorTraf;

    @FXML
    private RadioButton tieneSensorTraficoNo;

    @FXML
    private RadioButton tieneSensorTraficoSi;

    @FXML
    private ToggleGroup tieneVelocidad;

    @FXML
    private TextField txtBolsaAireDep;

    @FXML
    private TextField txtCaballosFuerzaDep;

    @FXML
    private TextField txtCapCargaCam;

    @FXML
    private TextField txtCapacidadCarga;

    @FXML
    private TextField txtCapacidadMaletero;

    @FXML
    private TextField txtCargaRapida;

    @FXML
    private TextField txtCilindraje;

    @FXML
    private TextField txtDuracionBateria;

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtModelo;

    @FXML
    private TextField txtNumBolsasAire;

    @FXML
    private TextField txtNumEjes;

    @FXML
    private TextField txtNumEjesCam;

    @FXML
    private TextField txtNumPasajeros;

    @FXML
    private TextField txtPlaca;

    @FXML
    private TextField txtPuertas;

    @FXML
    private TextField txtTiempAceleDep;

    @FXML
    private TextField txtVelocidad;

    private EmpleadoController empleadoController;
    ObservableList<Vehiculo> listaVehiculo = FXCollections.observableArrayList();
    private File imagenSeleccionada;

    @FXML
    public void initialize(){
        empleadoController = new EmpleadoController();
        initView();
        obtenerVehiculos();
        tblVehiculo.getItems().clear();
        tblVehiculo.setItems(listaVehiculo);
        selection();
    }

    //Método que configura la vista de la interfaz de usuario
    private void initView(){
        colPlaca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlaca()));

        colModelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));

        colMarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));

        colTipoCambio.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getTiposCambios()));

        colCombustible.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getCombustible().getTipoCombustible()));

        colEstado.setCellValueFactory(cellData -> new  SimpleObjectProperty<>(cellData.getValue().getTipoEstado()));

        cbxCambio.setItems(FXCollections.observableArrayList(TipoCambios.values()));

        cbxTipoVehiculo.getItems().addAll("Sedan", "Moto", "Deportivo", "Camioneta", "PickUps", "Vans", "Bus", "Camion");

        cbxTipoVehiculo.setOnAction(this::onVehiculoChange);

        cbxCombustible.setItems(FXCollections.observableArrayList(TipoCombustible.values()));
        cbxCombustible.setOnAction(this::onCombustibleChange);

        cbxCamiones.setItems(FXCollections.observableArrayList(TipoCamiones.values()));
    }

    //Método para añadir y obtener los vehículos a la lista
    private void obtenerVehiculos(){
        listaVehiculo.addAll(empleadoController.obtenerSedans());
        listaVehiculo.addAll(empleadoController.obtenerMotos());
        listaVehiculo.addAll(empleadoController.obtenerDeportivos());
        listaVehiculo.addAll(empleadoController.obtenerCamionetas());
        listaVehiculo.addAll(empleadoController.obtenerPicKups());
        listaVehiculo.addAll(empleadoController.obtenerVan());
        listaVehiculo.addAll(empleadoController.obtenerBuses());
        listaVehiculo.addAll(empleadoController.obtenerCamiones());
    }

    @FXML
    void onVehiculoChange(ActionEvent event){
        //Parte del método que reestablece la visibilidad de los componentes y habilita los campos necesarios al inicio del método
        Deportivo.setVisible(false);
        VCSegAvanzada.setVisible(false);
        VConfort.setVisible(false);
        idCapCajaCarga.setVisible(false);
        idCamiones.setVisible(false);
        IdNumEjes.setVisible(false);
        txtCapacidadMaletero.setVisible(false);
        txtNumPasajeros.setVisible(false);
        txtPuertas.setVisible(false);

        //Parte del método que habilita los TadioButtons en los grupos "tiene4x4" y "tieneVelocidad"
        for (Toggle toggle: tiene4x4.getToggles()){
            ((RadioButton)toggle).setDisable(false);
        }
        for (Toggle toggle: tieneVelocidad.getToggles()){
            ((RadioButton) toggle).setDisable(false);
        }

        //Parte del método que obtiene al vehículo seleccionado
        String selectedVehicle = String.valueOf(cbxTipoVehiculo.getValue());

        switch (selectedVehicle) {
            case "Sedan":
                VCSegAvanzada.setVisible(true);
                VConfort.setVisible(true);
                for (Toggle toggle: tiene4x4.getToggles()){
                    ((RadioButton) toggle).setDisable(true);
                }
                break;

            case "Motos":
                txtNumPasajeros.setDisable(true);
                txtPuertas.setDisable(true);
                txtCapacidadMaletero.setVisible(true);
                break;

            case "Deportivo":
                Deportivo.setVisible(true);
                txtCapacidadMaletero.setVisible(true);
                break;

            case "Camioneta":
                VCSegAvanzada.setVisible(true);
                VConfort.setVisible(true);
                break;

            case "PickUps":
                VConfort.setVisible(true);
                idCapCajaCarga.setVisible(true);
                txtCapacidadMaletero.setVisible(false);
                for (Toggle toggle: tieneVelocidad.getToggles()){
                    ((RadioButton) toggle).setDisable(true);
                }
                break;
            
            case "Vans":
                VConfort.setVisible(true);
                for(Toggle toggle: tieneVelocidad.getToggles()){
                    ((RadioButton)toggle).setDisable(true);
                }
                for (Toggle toogle: tiene4x4.getToggles()){
                    ((RadioButton)toogle).setDisable(true);
                }
                break;

            case "Bus":
                VConfort.setVisible(true);
                IdNumEjes.setVisible(true);
                for(Toggle toggle: tieneVelocidad.getToggles()){
                    ((RadioButton)toggle).setDisable(true);
                }
                for (Toggle toggle: tiene4x4.getToggles()){
                    ((RadioButton)toggle).setDisable(true);
                }
                break;

            case "Camion":
                idCamiones.setVisible(true);
                txtNumPasajeros.setDisable(true);
                txtPuertas.setDisable(true);
                txtCapacidadMaletero.setVisible(false);
                break;
        
            default:
                break;
        }
    }

    //Método que cambia la visibilidad de los elementos en función del comboBox de TipoCombustible
    @FXML
    void onCombustibleChange(ActionEvent event){
        String selectedFuel = String.valueOf(cbxCombustible.getValue());
        if ("ELÉCTRICO".equals(selectedFuel)){
            electricFields.setVisible(true);
            hybridFields.setVisible(false);
            hybridFields2.setVisible(false);
        }else if("HÍBRIDO".equals(selectedFuel)){
            electricFields.setVisible(false);
            hybridFields.setVisible(true);
            esEnchufable.selectedToggleProperty().addListener((observable, oldToggle, newToggle) ->{
                if (newToggle == rdEsEnchufableNo){
                    hybridFields2.setVisible(true);
                }else{
                    hybridFields2.setVisible(false);
                }
            });
        }else{
            electricFields.setVisible(false);
            hybridFields.setVisible(false);
            hybridFields2.setVisible(false);
        }
    }

    //Método que maneja la selección de los elementos dentro de la tabla
    public void selection(){
        tblVehiculo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)-> {
            if(newValue != null){
                limpiarCampos();
                txtPlaca.setEditable(false);
                cbxTipoVehiculo.setDisable(true);
                mostrarDatosVehiculo(newValue);
            }
        });
    }

    //Método que muestra los datos del Vehiculo
    private void mostrarDatosVehiculo(Vehiculo vehiculo){
        txtPlaca.setText(vehiculo.getPlaca());
        txtMarca.setText(vehiculo.getMarca());
        txtModelo.setText(vehiculo.getModelo());
        cbxCambio.setValue(vehiculo.getTiposCambios());
        txtVelocidad.setText(String.valueOf(vehiculo.getVelocidadMax()));
        txtCilindraje.setText(String.valueOf(vehiculo.getCilindraje()));
        esNuevo.selectToggle(vehiculo.isEsNuevo()? rdEsNuevoSi : rdEsNuevoNo); //Ejemplo de selección
        imagenView.setImage(new Image(new File(vehiculo.getImagen()).toURI().toString()));

        cbxCombustible.setValue(vehiculo.getCombustible().getTipoCombustible());
        if (vehiculo.getCombustible().getTipoCombustible().equals(TipoCombustible.ELECTRICO)){
            Electrico electrico = (Electrico) vehiculo.getCombustible();
            txtDuracionBateria.setText(String.valueOf(electrico.getAutonomia()));
            txtCargaRapida.setText(String.valueOf(0));
        }else if (vehiculo.getCombustible().getTipoCombustible().equals(TipoCombustible.HIBRIDO)){
            Hibrido hibrido = (Hibrido) vehiculo.getCombustible();
            esEnchufable.selectToggle(hibrido.isEsEnchufable() ? rdEsEnchufableSi : rdEsEnchufableNo);
            esHibridoLigero.selectToggle(hibrido.isEsHibridoLigero() ? esHibridoSi : esHibridoNo);
        }

        if (vehiculo instanceof Moto){
            Moto moto = (Moto) vehiculo;
            cbxTipoVehiculo.setValue("Motos");

        }else if(vehiculo instanceof Sedan){
            Sedan sedan = (Sedan) vehiculo;
            cbxTipoVehiculo.setValue("Sedan");
            //Configuración de los campos del Sedan
            txtNumPasajeros.setText(String.valueOf(sedan.getNumPasajeros()));
            txtPuertas.setText(String.valueOf(sedan.getNumPuertas()));
            txtCapacidadMaletero.setText(String.valueOf(sedan.getCapacidadMaletero()));
            txtNumBolsasAire.setText(String.valueOf(sedan.getNumeroBolsaAire()));
            tieneAireAcon.selectToggle(sedan.isTieneAcondicionado() ? aireAcondicionadoSi : aireAcondicionadoNo);
            tieneCamara.selectToggle(sedan.isTieneCamaraReversa() ? rdCamaraReversaSi : rdCamaraReversaNo);
            tieneVelocidad.selectToggle(sedan.isTieneVelocidadCrucero() ? rdVelocidadCruceroSi : rdVelocidadCruceroNo);
            tieneSensorColi.selectToggle(sedan.isTieneSensorColision() ? rdSensorColisionSi : rdSensorColisionNo);
            tieneSensorTraf.selectToggle(sedan.isTieneSensorTraficoCruzado() ? tieneSensorTraficoSi : tieneSensorTraficoNo);
            tieneAsistente.selectToggle(sedan.isTieneAsistentePermanencia() ? rdTieneAsistenciaSi : rdTieneAsistenciaNo);
            tieneABS.selectToggle(sedan.isTieneABS() ? rdTieneABSSi : rdTieneABSNo);

        }else if(vehiculo instanceof Deportivo){
            Deportivo deportivo = (Deportivo) vehiculo;
            cbxTipoVehiculo.setValue("Deportivo");
            //Configuración de los campos del Deportivo
            txtNumPasajeros.setText(String.valueOf(deportivo.getNumPuertas()));
            txtBolsaAireDep.setText(String.valueOf(deportivo.getNumBolsasAire()));
            txtCaballosFuerzaDep.setText(String.valueOf(deportivo.getTiempoAceleracion()));
            tieneAerodinamicaDep.selectToggle(deportivo.isTieneAerodinamicaMejorada() ? tieneAerodinamicaSi : tieneAerodinamicaNo);

        }else if(vehiculo instanceof Camioneta){
            Camioneta camioneta =(Camioneta) vehiculo;
            cbxTipoVehiculo.setValue("Camioneta");
            //Configuración de los campos de la Camioneta
            txtNumPasajeros.setText(String.valueOf(camioneta.getNumPasajeros()));
            txtPuertas.setText(String.valueOf(camioneta.getNumPuertas()));
            txtCapacidadMaletero.setText(String.valueOf(camioneta.getCapacidadMaletero()));
            txtNumBolsasAire.setText(String.valueOf(camioneta.getNumeroBolsaAire()));
            tieneAireAcon.selectToggle(camioneta.isTieneAcondicionado() ? aireAcondicionadoSi : aireAcondicionadoNo);
            tieneCamara.selectToggle(camioneta.isTieneCamaraReversa() ? rdCamaraReversaSi : rdCamaraReversaNo);
            tieneVelocidad.selectToggle(camioneta.isTieneVelocidadCrucero() ? rdVelocidadCruceroSi : rdVelocidadCruceroNo);
            tieneABS.selectToggle(camioneta.isTieneABS() ? rdTieneABSSi : rdTieneABSNo);
            tiene4x4.selectToggle(camioneta.isEs4x4() ? rdTiene4X4Si : rdTiene4X4No);
            tieneSensorColi.selectToggle(camioneta.isTieneSensorColision() ? rdSensorColisionSi : rdSensorColisionNo);
            tieneSensorTraf.selectToggle(camioneta.isTieneSensorTraficoCruzado() ? tieneSensorTraficoSi : tieneSensorTraficoNo);
            tieneAsistente.selectToggle(camioneta.isTieneAsistentePermanencia() ? rdTieneAsistenciaSi : rdTieneAsistenciaNo);

        }else if(vehiculo instanceof PickUps){
            PickUps pickUp= (PickUps)vehiculo;
            cbxTipoVehiculo.setValue("PickUps");
            //Configuración de los campos de la PickUps
            txtNumPasajeros.setText(String.valueOf(pickUp.getNumPasajeros()));
            txtPuertas.setText(String.valueOf(pickUp.getNumPuertas()));
            txtCapacidadCarga.setText(String.valueOf(pickUp.getCapacidadCajaCarga()));
            txtNumBolsasAire.setText(String.valueOf(pickUp.getNumeroBolsaAire()));
            tieneAireAcon.selectToggle(pickUp.isTieneAcondicionado() ? aireAcondicionadoSi : aireAcondicionadoNo);
            tieneCamara.selectToggle(pickUp.isTieneCamaraReversa() ? rdCamaraReversaSi : rdCamaraReversaNo);
            tieneABS.selectToggle(pickUp.isTieneABS() ? rdTieneABSSi : rdTieneABSNo);
            tiene4x4.selectToggle(pickUp.isEs4x4() ? rdTiene4X4Si : rdTiene4X4No);

        }else if(vehiculo instanceof Vans){
            Vans vans= (Vans) vehiculo;
            cbxTipoVehiculo.setValue("Vans");
            //Configuración de los campos de la Vans
            cbxTipoVehiculo.setValue("Vans");
            txtNumPasajeros.setText(String.valueOf(vans.getNumPasajeros()));
            txtPuertas.setText(String.valueOf(vans.getNumPuertas()));
            txtCapacidadMaletero.setText(String.valueOf(vans.getCapacidadMaletero()));
            txtNumBolsasAire.setText(String.valueOf(vans.getNumeroBolsaAire()));
            tieneAireAcon.selectToggle(vans.isTieneAcondicionado() ? aireAcondicionadoSi : aireAcondicionadoNo);
            tieneCamara.selectToggle(vans.isTieneCamaraReversa() ? rdCamaraReversaSi : rdCamaraReversaNo);
            tieneABS.selectToggle(vans.isTieneABS() ? rdTieneABSSi : rdTieneABSNo);

        }else if(vehiculo instanceof Bus){
            Bus bus= (Bus) vehiculo;
            cbxTipoVehiculo.setValue("Bus");
            //Configuración de los campos del Bus
            txtNumPasajeros.setText(String.valueOf(bus.getNumPasajeros()));
            txtPuertas.setText(String.valueOf(bus.getNumPuertas()));
            txtCapacidadMaletero.setText(String.valueOf(bus.getCapacidadMaletero()));
            txtNumEjes.setText(String.valueOf(bus.getNumEjes()));
            txtNumBolsasAire.setText(String.valueOf(bus.getNumeroBolsaAire()));
            tieneAireAcon.selectToggle(bus.isTieneAcondicionado() ? aireAcondicionadoSi : aireAcondicionadoNo);
            tieneCamara.selectToggle(bus.isTieneCamaraReversa() ? rdCamaraReversaSi : rdCamaraReversaNo);
            tieneABS.selectToggle(bus.isTieneABS() ? rdTieneABSSi : rdTieneABSNo);

        }else if(vehiculo instanceof Camion){
            Camion camion= (Camion) vehiculo;
            cbxTipoVehiculo.setValue("Camion");
            //Configuración de los campos del Camion
            txtCapacidadCarga.setText(String.valueOf(camion.getCapCarga()));
            txtNumEjes.setText(String.valueOf(camion.getNumeroEjes()));
            tieneAireAconCam.selectToggle(camion.isTieneAireAcondicionado() ? rdAcondicionCamSi : rdAcondicionCamNo);
            tieneFrenosAire.selectToggle(camion.isTieneFrenosAire() ? rdFrenosAireSi : rdFrenosAireNo);
            tieneABS1Cam.selectToggle(camion.isTieneABS()? rdTieneAbsCamSi : rdTieneAbsCamNo);
            cbxCamiones.setValue(camion.getTipoCamion());
        }
    }

    //Método para actualizar el evento
    @FXML
    void eventoActualizar(ActionEvent event) throws VehiculoException {
        Vehiculo vehiculoAntiguo = tblVehiculo.getSelectionModel().getSelectedItem();
        if (verificarCampos() && vehiculoAntiguo != null) {
            Vehiculo vehiculoActualizado = crearVehiculo(cbxTipoVehiculo.getValue());
            vehiculoActualizado.setTipoEstado(vehiculoAntiguo.getTipoEstado());

        if (imagenSeleccionada != null) {
            copiarImagenAdmin(imagenSeleccionada,vehiculoActualizado);
        }else{
            vehiculoActualizado.setImagen(vehiculoAntiguo.getImagen());}

        if (vehiculoAntiguo.getTipoEstado().equals(TipoEstado.EN_POSESION)){
            if (vehiculoActualizado instanceof Moto){
                Moto moto = (Moto) vehiculoActualizado;
                    if (empleadoController.actualizarMoto(vehiculoAntiguo.getPlaca(),moto)){
                        mensajeInformacion("Vehículo actualizado","El vehículo se ha actualizado con éxito");
                        limpiarCampos();
                        listaVehiculo.clear();
                        obtenerVehiculos();
                        tblVehiculo.refresh();
                    }else{
                        mensajeError("Error actualización","El vehiculo no se ha podido actualizar");
                    }
                } else if (vehiculoActualizado instanceof Sedan) {
                    Sedan sedan = (Sedan) vehiculoActualizado;
                    if (empleadoController.actualizarSedan(vehiculoAntiguo.getPlaca(),sedan)){
                        mensajeInformacion("Vehículo actualizado","El vehículo se ha actualizado con éxito");
                        limpiarCampos();
                        listaVehiculo.clear();
                        obtenerVehiculos();
                        tblVehiculo.refresh();
                    }else{
                        mensajeError("Error actualización","El vehículo no se ha podido actualizar");
                    }
                } else if (vehiculoActualizado instanceof Deportivo) {
                    Deportivo deportivo = (Deportivo) vehiculoActualizado;
                    if (empleadoController.actualizarDeportivo(vehiculoAntiguo.getPlaca(),deportivo)){
                        mensajeInformacion("Vehículo actualizado","El vehículo se ha actualizado con éxito");
                        limpiarCampos();
                        listaVehiculo.clear();
                        obtenerVehiculos();
                        tblVehiculo.refresh();
                    }else{
                        mensajeError("Error actualización","El vehiculo no se ha podido actualizar");
                    }
                } else if (vehiculoActualizado instanceof Camioneta) {
                    Camioneta camioneta = (Camioneta) vehiculoActualizado;
                    if (empleadoController.actualizarCamioneta(vehiculoAntiguo.getPlaca(),camioneta)){
                        mensajeInformacion("Vehiculo actualizado","El vehículo se ha actualizado con éxito");
                        limpiarCampos();
                        listaVehiculo.clear();
                        obtenerVehiculos();
                        tblVehiculo.refresh();
                    }else{
                        mensajeError("Error actualización","El vehículo no se ha podido actualizar");
                    }
                } else if (vehiculoActualizado instanceof PickUps) {
                    PickUps pickUps = (PickUps) vehiculoActualizado;
                    if (empleadoController.actualizarPickUp(vehiculoAntiguo.getPlaca(),pickUps)){
                        mensajeInformacion("Vehículo actualizado","El vehículo se ha actualizado con éxito");
                        limpiarCampos();
                        listaVehiculo.clear();
                        obtenerVehiculos();
                        tblVehiculo.refresh();
                    }else{
                        mensajeError("Error actualización","El vehículo no se ha podido actualizar");
                    }
                } else if (vehiculoActualizado instanceof Vans) {
                    Vans vans = (Vans) vehiculoActualizado;
                    if (empleadoController.actualizarVan(vehiculoAntiguo.getPlaca(),vans)){
                        mensajeInformacion("Vehículo actualizado","El vehiculo se ha actualizado con éxito");
                        limpiarCampos();
                        listaVehiculo.clear();
                        obtenerVehiculos();
                        tblVehiculo.refresh();
                    }else{
                        mensajeError("Error actualización","El vehículo no se ha podido actualizar");
                    }
                } else if (vehiculoActualizado instanceof Bus) {
                    Bus bus = (Bus) vehiculoActualizado;
                    if (empleadoController.actualizarBus(vehiculoAntiguo.getPlaca(),bus)){
                        mensajeInformacion("Vehículo actualizado","El vehículo se ha actualizado con éxito");
                        limpiarCampos();
                        listaVehiculo.clear();
                        obtenerVehiculos();
                        tblVehiculo.refresh();
                    }else{
                        mensajeError("Error actualización","El vehículo no se ha podido actualizar");
                    }
                } else if (vehiculoActualizado instanceof  Camion) {
                    Camion camion = (Camion) vehiculoActualizado;
                    if (empleadoController.actualizarCamion(vehiculoAntiguo.getPlaca(),camion)){
                        mensajeInformacion("Vehículo actualizado","El vehículo se ha actualizado con éxito");
                        limpiarCampos();
                        listaVehiculo.clear();
                        obtenerVehiculos();
                        tblVehiculo.refresh();
                    }else{
                        mensajeError("Error actualización","El vehículo no se ha podido actualizar");
                    }}
                }else{
                    mensajeError("Error actualización","Vehículo no está en posesión");
                }
                }else{
                    mensajeError("Error actualización","Seleccione un vehículo de la tabla");
                }}

    //Método para agregar el evento
    @FXML
    void eventoAgregar(ActionEvent event) throws VehiculoException{
        if(verificarCampos()){
            Vehiculo vehiculo= crearVehiculo(cbxTipoVehiculo.getValue());

            if(imagenSeleccionada!= null){
                copiarImagenAdmin(imagenSeleccionada, vehiculo);
            }else{
                vehiculo.setImagen("src/main/resources/Images/404.jpg");
            }

            if (vehiculo== null){
                mensajeError("Error en la creación", "Los datos son inválidos o ya fueron utilizados");
                return;
            }
            
            boolean exito= false;
            String tipoVehiculo= vehiculo.getClass().getSimpleName();//Esto es para el mensaje
            //Parte del método que llama en EmpleadoController según el tip de vehículo
            if(vehiculo instanceof Sedan){
                exito=(empleadoController.addSedan((Sedan)vehiculo)==1);
            }else if(vehiculo instanceof Moto){
                exito = (empleadoController.addMoto((Moto) vehiculo) == 1);
            } else if (vehiculo instanceof Deportivo) {
                exito = (empleadoController.addDeportivo((Deportivo) vehiculo) == 1);
            } else if (vehiculo instanceof Camioneta) {
                exito = (empleadoController.addCamioneta((Camioneta) vehiculo) == 1);
            } else if (vehiculo instanceof PickUps) {
                exito = (empleadoController.addPickUp((PickUps) vehiculo) == 1);
            } else if (vehiculo instanceof Vans) {
                exito = (empleadoController.addVan((Vans) vehiculo) == 1);
            } else if (vehiculo instanceof Bus) {
                exito = (empleadoController.addBus((Bus) vehiculo) == 1);
            } else if (vehiculo instanceof Camion) {
                exito = (empleadoController.addCamion((Camion) vehiculo) == 1);
            }

            if(exito){
                mensajeInformacion("Creación completada", "Se creó el "+ tipoVehiculo+ " correctamente");
                limpiarCampos();
                listaVehiculo.clear();
                obtenerVehiculos();
                tblVehiculo.refresh();
            }else{
                mensajeError("Error en la creación", "Los datos son inválidos o ya fueron utilizados");
            }
        }else{
            mensajeError("Error en la creación", "Los campos no están completos")
        }
    }


    //Metodo para crear un vehiculo
    private Vehiculo crearVehiculo(String vehiculo){

        switch (vehiculo) {
            //Caso para crear un vehiculo moto
            case "Motos":
                Moto moto = new Moto();
                moto.setPlaca(txtPlaca.getText());
                moto.setMarca(txtMarca.getText());
                moto.setEsNuevo(esNuevo.getSelectedToggle().equals(rdEsNuevoSi));
                moto.setModelo(txtModelo.getText());
                moto.setTiposCambios(cbxCambio.getValue());
                moto.setVelocidadMax(Float.parseFloat(txtVelocidad.getText()));
                moto.setCilindraje(Float.parseFloat(txtCilindraje.getText()));
                moto.setCombustible(crearCombustible());
                return moto;
        
            //Caso para crear un vehiculo sedan
            case "Sedan":
                Sedan sedan = new Sedan();

                sedan.setPlaca(txtPlaca.getText());
                sedan.setMarca(txtMarca.getText());
                sedan.setEsNuevo(esNuevo.getSelectedToggle().equals(rdEsNuevoSi));
                sedan.setModelo(txtModelo.getText());
                sedan.setTiposCambios(cbxCambio.getValue());
                sedan.setVelocidadMax(Float.parseFloat(txtVelocidad.getText()));
                sedan.setCilindraje(Float.parseFloat(txtCilindraje.getText()));
                sedan.setCombustible(crearCombustible());
                sedan.setNumPasajeros(Integer.parseInt(txtNumPasajeros.getText()));
                sedan.setNumPuertas(Integer.parseInt(txtPuertas.getText()));
                sedan.setCapacidadMaletero(Float.parseFloat(txtCapacidadMaletero.getText()));
                sedan.setNumeroBolsaAire(Integer.parseInt(txtNumBolsasAire.getText()));
                sedan.setTieneAcondicionado(tieneAireAcon.getSelectedToggle().equals(aireAcondicionadoSi));
                sedan.setTieneCamaraReversa(tieneCamara.getSelectedToggle().equals(rdCamaraReversaSi));
                sedan.setTieneVelocidadCrucero(tieneVelocidad.getSelectedToggle().equals(rdVelocidadCruceroSi));
                sedan.setTieneSensorColision(tieneSensorColi.getSelectedToggle().equals(rdSensorColisionSi));
                sedan.setTieneSensorTraficoCruzado(tieneSensorTraf.getSelectedToggle().equals(tieneSensorTraficoSi));
                sedan.setTieneAsistentePermanencia(tieneAsistente.getSelectedToggle().equals(rdTieneAsistenciaSi));
                sedan.setTieneABS(tieneABS.getSelectedToggle().equals(rdTieneABSSi));
                return sedan;

            //Caso para crear un vehiculo deportivo
            case "Deportivo":
                Deportivo deportivo = new Deportivo();
                deportivo.setPlaca(txtPlaca.getText());
                deportivo.setMarca(txtMarca.getText());
                deportivo.setEsNuevo(esNuevo.getSelectedToggle().equals(rdEsNuevoSi));
                deportivo.setModelo(txtModelo.getText());
                deportivo.setTiposCambios(cbxCambio.getValue());
                deportivo.setVelocidadMax(Float.parseFloat(txtVelocidad.getText()));
                deportivo.setCilindraje(Float.parseFloat(txtCilindraje.getText()));
                deportivo.setNumPasajeros(Integer.parseInt(txtNumPasajeros.getText()));
                deportivo.setNumPuertas(Integer.parseInt(txtPuertas.getText()));
                deportivo.setCombustible(crearCombustible());
                deportivo.setNumBolsasAire(Integer.parseInt(txtBolsaAireDep.getText()));
                deportivo.setNumCaballosFuerza(Integer.parseInt(txtCaballosFuerzaDep.getText()));
                deportivo.setTiempoAceleracion(Double.parseDouble(txtTiempAceleDep.getText()));
                deportivo.setTieneAerodinamicaMejorada(tieneAerodinamicaDep.getSelectedToggle().equals(tieneAerodinamicaSi));
                return deportivo;

            //Caso para crear un vehiculo Camioneta
            case "Camionetas":
                Camioneta camioneta = new Camioneta();
                camioneta.setPlaca(txtPlaca.getText());
                camioneta.setMarca(txtMarca.getText());
                camioneta.setEsNuevo(esNuevo.getSelectedToggle().equals(rdEsNuevoSi));
                camioneta.setModelo(txtModelo.getText());
                camioneta.setTiposCambios(cbxCambio.getValue());
                camioneta.setVelocidadMax(Float.parseFloat(txtVelocidad.getText()));
                camioneta.setCilindraje(Float.parseFloat(txtCilindraje.getText()));
                camioneta.setNumPasajeros(Integer.parseInt(txtNumPasajeros.getText()));
                camioneta.setNumPuertas(Integer.parseInt(txtPuertas.getText()));
                camioneta.setCapacidadMaletero(Float.parseFloat(txtCapacidadMaletero.getText()));
                camioneta.setCombustible(crearCombustible());
                camioneta.setTieneAcondicionado(tieneAireAcon.getSelectedToggle().equals(aireAcondicionadoSi));
                camioneta.setTieneCamaraReversa(tieneCamara.getSelectedToggle().equals(rdCamaraReversaSi));
                camioneta.setTieneVelocidadCrucero(tieneVelocidad.getSelectedToggle().equals(rdVelocidadCruceroSi));
                camioneta.setNumeroBolsaAire(Integer.parseInt(txtNumBolsasAire.getText()));
                camioneta.setTieneABS(tieneABS.getSelectedToggle().equals(rdTieneABSSi));
                camioneta.setEs4x4(tiene4x4.getSelectedToggle().equals(rdTiene4X4Si));
                camioneta.setTieneSensorColision(tieneSensorColi.getSelectedToggle().equals(rdSensorColisionSi));
                camioneta.setTieneSensorTraficoCruzado(tieneSensorTraf.getSelectedToggle().equals(tieneSensorTraficoSi));
                camioneta.setTieneAsistentePermanencia(tieneAsistente.getSelectedToggle().equals(rdTieneAsistenciaSi));
                return camioneta;

            //Caso para crear un vehiculo PickUps
            case "PickUps":
                PickUps pickUp = new PickUps();
                pickUp.setPlaca(txtPlaca.getText());
                pickUp.setMarca(txtMarca.getText());
                pickUp.setEsNuevo(esNuevo.getSelectedToggle().equals(rdEsNuevoSi));
                pickUp.setModelo(txtModelo.getText());
                pickUp.setTiposCambios(cbxCambio.getValue());
                pickUp.setVelocidadMax(Float.parseFloat(txtVelocidad.getText()));
                pickUp.setCilindraje(Float.parseFloat(txtCilindraje.getText()));
                pickUp.setNumPasajeros(Integer.parseInt(txtNumPasajeros.getText()));
                pickUp.setNumPuertas(Integer.parseInt(txtPuertas.getText()));
                pickUp.setCapacidadCajaCarga(Float.parseFloat(txtCapacidadCarga.getText()));
                pickUp.setCombustible(crearCombustible());
                pickUp.setTieneAcondicionado(tieneAireAcon.getSelectedToggle().equals(aireAcondicionadoSi));
                pickUp.setTieneCamaraReversa(tieneCamara.getSelectedToggle().equals(rdCamaraReversaSi));
                pickUp.setNumeroBolsaAire(Integer.parseInt(txtNumBolsasAire.getText()));
                pickUp.setTieneABS(tieneABS.getSelectedToggle().equals(rdTieneABSSi));
                pickUp.setEs4x4(tiene4x4.getSelectedToggle().equals(rdTiene4X4Si));
                return pickUp;

            //Caso para crear un vehiculo Vans
            case "Vans":
                Vans vans = new Vans();
                vans.setPlaca(txtPlaca.getText());
                vans.setMarca(txtMarca.getText());
                vans.setEsNuevo(esNuevo.getSelectedToggle().equals(rdEsNuevoSi));
                vans.setModelo(txtModelo.getText());
                vans.setTiposCambios(cbxCambio.getValue());
                vans.setVelocidadMax(Float.parseFloat(txtVelocidad.getText()));
                vans.setCilindraje(Float.parseFloat(txtCilindraje.getText()));
                vans.setNumPasajeros(Integer.parseInt(txtNumPasajeros.getText()));
                vans.setNumPuertas(Integer.parseInt(txtPuertas.getText()));
                vans.setCapacidadMaletero(Float.parseFloat(txtCapacidadMaletero.getText()));
                vans.setCombustible(crearCombustible());
                vans.setTieneAcondicionado(tieneAireAcon.getSelectedToggle().equals(aireAcondicionadoSi));
                vans.setTieneCamaraReversa(tieneCamara.getSelectedToggle().equals(rdCamaraReversaSi));
                vans.setNumeroBolsaAire(Integer.parseInt(txtNumBolsasAire.getText()));
                vans.setTieneABS(tieneABS.getSelectedToggle().equals(rdTieneABSSi));
                return vans;

            //Caso para crear un vehiculo Bus
            case "Buses":
                Bus buses = new Bus();
                buses.setPlaca(txtPlaca.getText());
                buses.setMarca(txtMarca.getText());
                buses.setEsNuevo(esNuevo.getSelectedToggle().equals(rdEsNuevoSi));
                buses.setModelo(txtModelo.getText());
                buses.setTiposCambios(cbxCambio.getValue());
                buses.setVelocidadMax(Float.parseFloat(txtVelocidad.getText()));
                buses.setCilindraje(Float.parseFloat(txtCilindraje.getText()));
                buses.setNumPasajeros(Integer.parseInt(txtNumPasajeros.getText()));
                buses.setNumPuertas(Integer.parseInt(txtPuertas.getText()));
                buses.setCapacidadMaletero(Float.parseFloat(txtCapacidadMaletero.getText()));
                buses.setNumEjes(Integer.parseInt(txtNumEjes.getText()));
                buses.setCombustible(crearCombustible());
                buses.setTieneAcondicionado(tieneAireAcon.getSelectedToggle().equals(aireAcondicionadoSi));
                buses.setTieneCamaraReversa(tieneCamara.getSelectedToggle().equals(rdCamaraReversaSi));
                buses.setNumeroBolsaAire(Integer.parseInt(txtNumBolsasAire.getText()));
                buses.setTieneABS(tieneABS.getSelectedToggle().equals(rdTieneABSSi));
                return buses;

            //Caso para crear un vehiculo Camion
            case "Camiones":
                Camion camiones = new Camion();
                camiones.setPlaca(txtPlaca.getText());
                camiones.setMarca(txtMarca.getText());
                camiones.setEsNuevo(esNuevo.getSelectedToggle().equals(rdEsNuevoSi));
                camiones.setModelo(txtModelo.getText());
                camiones.setTiposCambios(cbxCambio.getValue());
                camiones.setVelocidadMax(Float.parseFloat(txtVelocidad.getText()));
                camiones.setCilindraje(Float.parseFloat(txtCilindraje.getText()));
                camiones.setCapCarga(Float.parseFloat(txtCapCargaCam.getText()));
                camiones.setTieneAireAcondicionado(tieneAireAconCam.getSelectedToggle().equals(rdAcondicionCamSi));
                camiones.setTieneFrenosAire(tieneFrenosAire.getSelectedToggle().equals(rdFrenosAireSi));
                camiones.setTieneABS(tieneABS1Cam.getSelectedToggle().equals(rdTieneAbsCamSi));
                camiones.setNumeroEjes(Integer.parseInt(txtNumEjesCam.getText()));
                camiones.setTipoCamion(cbxCamiones.getValue());
                camiones.setCombustible(crearCombustible());
                return camiones;

            //Default para retornar null
            default:
                return null;
        }
    }

    //Evento para eliminar un vehiculo
    @FXML
    void eventoEliminar(ActionEvent event) throws VehiculoException{
        Vehiculo vehiculo = tblVehiculo.getSelectionModel().getSelectedItem();
        String ruta;
        if(!vehiculo.getImagen().equals("src/main/resources/Images/404.jpg")){
            ruta = vehiculo.getImagen();
        }else{
            ruta = "";
        }

        if (vehiculo != null) {
            if (empleadoController.removerVehiculo(vehiculo) == 1) {
                eliminarImagenProducto(ruta);

                mensajeInformacion("Vehiculo Eliminado", "EL Vehiculo se ha eliminado con exito");
                limpiarCampos();
                listaVehiculo.clear();
                obtenerVehiculos();
                tblVehiculo.refresh();
            } else {
                mensajeError("Vehiculo no Elimnado", "El Admin no se ah eliminado");
            }
        } else {
            mensajeError("Vehiculo no seleccionado", "Seleccione un vehiculo para continuar con la eliminicacion");
        }
    }

    //Metodo para el evento de limpiar campos
    @FXML
    void eventoLimpiar(ActionEvent event) {
        limpiarCampos();
    }

    //evento para guardar una imagen
    @FXML
    void guardarImagen(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccione una imagen");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imágenes", "*.jpg", "*.jpeg", "*.png", "*.gif")
        );

        // Obtener la ventana principal para que el diálogo se abra en el contexto adecuado
        Stage stage = (Stage) imagenView.getScene().getWindow();
        imagenSeleccionada = fileChooser.showOpenDialog(stage);

        if (imagenSeleccionada!= null) {
            // Mostrar la imagen seleccionada en el ImageView
            imagenView.setImage(new Image(imagenSeleccionada.toURI().toString()));
        }
    }

    //Metodo para copiar la imagen de un vehiculo
    public void copiarImagenAdmin(File archivoImagen,Vehiculo vehiculo){
        String carpetaDestino = "src/main/resources/Images";
        String extension = getExtension(archivoImagen.getName());
        Path destino = Path.of(carpetaDestino, vehiculo.getPlaca() + "." + extension);

        try {
            // Copiar la imagen al destino
            Files.copy(archivoImagen.toPath(), destino, StandardCopyOption.REPLACE_EXISTING);

            // Actualizar la ruta de la imagen en el objeto Producto
            vehiculo.setImagen(destino.toString());
            System.out.println("Imagen copiada en: " + destino.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Metodo para obtener la extension de un archivo
    private String getExtension(String nombreArchivo) {
        int i = nombreArchivo.lastIndexOf('.');
        return (i > 0) ? nombreArchivo.substring(i + 1) : "";
    }

    //Metodo para eliminar la imagen
    private void eliminarImagenProducto(String rutaImagen) {
        try {
            Path path = Paths.get(rutaImagen);
            Files.deleteIfExists(path); // Elimina el archivo si existe
        } catch (IOException e) {}
    }

    //Metodo para crear un combustible
    private Combustible crearCombustible(){
        String tipo = cbxCombustible.getValue().toString();
        switch (tipo) {
            case "ELECTRICO":
                Electrico electrico = new Electrico(TipoCombustible.ELECTRICO);
                electrico.setAutonomia(Integer.parseInt(txtDuracionBateria.getText()));
                electrico.setTiempoCarga(Integer.parseInt(txtCargaRapida.getText()));
                return electrico;
            case "HIBRIDO":
                Hibrido hibrido = new Hibrido(TipoCombustible.HIBRIDO);
                boolean enchufable = esEnchufable.getSelectedToggle().equals(rdEsEnchufableSi);
                hibrido.setEsEnchufable(enchufable);
                if (enchufable) {
                    hibrido.setEsHibridoLigero(false);
                }else{
                    boolean esHibrido = esHibridoLigero.getSelectedToggle().equals(esHibridoSi);
                    hibrido.setEsHibridoLigero(esHibrido);
                }
                return hibrido;
            case "DIESEL":
                return new Diesel(TipoCombustible.DIESEL);
            case "GASOLINA":
                return new Gasolina(TipoCombustible.GASOLINA);
            default:
                return null;
        }
    }
    
    //Metodo para limpiar los campos
    private void limpiarCampos() {
        // Limpiar todos los campos de texto
        txtMarca.clear();
        txtModelo.clear();
        txtCilindraje.clear();
        txtVelocidad.clear();
        txtNumPasajeros.clear();
        txtPuertas.clear();
        txtCapacidadMaletero.clear();
        txtCapacidadCarga.clear();
        txtNumEjes.clear();
        txtNumBolsasAire.clear();
        txtBolsaAireDep.clear();
        txtCaballosFuerzaDep.clear();
        txtTiempAceleDep.clear();
        txtCapCargaCam.clear();
        txtCargaRapida.clear();
        txtDuracionBateria.clear();
        txtNumEjesCam.clear();
        txtCapacidadCarga.clear();
        txtPlaca.clear();

        // Restablecer la selección en todos los ComboBox
        cbxCambio.setValue(null);
        cbxCamiones.setValue(null);
        cbxCombustible.setValue(null);
        cbxTipoVehiculo.setValue(null);

        // Restablecer la selección en todos los ToggleGroups (RadioButtons)
        tieneABS.selectToggle(null);
        tieneAireAcon.selectToggle(null);
        tieneCamara.selectToggle(null);
        tieneVelocidad.selectToggle(null);
        tieneSensorColi.selectToggle(null);
        tieneSensorTraf.selectToggle(null);
        tieneAsistente.selectToggle(null);
        tiene4x4.selectToggle(null);
        tieneAerodinamicaDep.selectToggle(null);
        tieneFrenosAire.selectToggle(null);
        esNuevo.selectToggle(null);
        esEnchufable.selectToggle(null);
        esHibridoLigero.selectToggle(null);

        // Limpiar imagen seleccionada en ImageView, si es necesario
        imagenView.setImage(null);
        txtPlaca.setEditable(true);
        cbxTipoVehiculo.setDisable(false);
        imagenSeleccionada = null;
    }

    // Método para verificar que todos los campos estén completos
    private boolean verificarCampos() {
        String tipoVehiculo = cbxTipoVehiculo.getValue();
        boolean camposCompletos = true;

        camposCompletos &= !txtPlaca.getText().isEmpty();
        camposCompletos &= !txtMarca.getText().isEmpty();
        camposCompletos &= esNuevo.getSelectedToggle() != null;
        camposCompletos &= !txtModelo.getText().isEmpty();
        camposCompletos &= cbxCambio.getValue() != null;
        camposCompletos &= !txtVelocidad.getText().isEmpty();
        camposCompletos &= !txtCilindraje.getText().isEmpty();
        camposCompletos &= cbxCombustible.getValue() != null;

        // Verificar campos dependiendo del tipo de vehículo
        switch (tipoVehiculo) {
            case "Motos":
                break;

            case "Sedan":
                camposCompletos &= !txtNumPasajeros.getText().isEmpty();
                camposCompletos &= !txtPuertas.getText().isEmpty();
                camposCompletos &= !txtCapacidadMaletero.getText().isEmpty();
                camposCompletos &= tieneAireAcon.getSelectedToggle() != null;
                camposCompletos &= tieneCamara.getSelectedToggle() != null;
                camposCompletos &= tieneVelocidad.getSelectedToggle() != null;
                camposCompletos &= !txtNumBolsasAire.getText().isEmpty();
                camposCompletos &= tieneABS.getSelectedToggle() != null;
                camposCompletos &= tieneSensorColi.getSelectedToggle() != null;
                camposCompletos &= tieneSensorTraf.getSelectedToggle() != null;
                camposCompletos &= tieneAsistente.getSelectedToggle() != null;
                break;

            case "Deportivo":
                camposCompletos &= !txtMarca.getText().isEmpty();
                camposCompletos &= esNuevo.getSelectedToggle() != null;
                camposCompletos &= !txtModelo.getText().isEmpty();
                camposCompletos &= cbxCambio.getValue() != null;
                camposCompletos &= !txtVelocidad.getText().isEmpty();
                camposCompletos &= !txtCilindraje.getText().isEmpty();
                camposCompletos &= !txtNumPasajeros.getText().isEmpty();
                camposCompletos &= !txtPuertas.getText().isEmpty();
                camposCompletos &= !txtBolsaAireDep.getText().isEmpty();
                camposCompletos &= !txtCaballosFuerzaDep.getText().isEmpty();
                camposCompletos &= !txtTiempAceleDep.getText().isEmpty();
                break;

            case "Camionetas":
                camposCompletos &= !txtMarca.getText().isEmpty();
                camposCompletos &= esNuevo.getSelectedToggle() != null;
                camposCompletos &= !txtModelo.getText().isEmpty();
                camposCompletos &= cbxCambio.getValue() != null;
                camposCompletos &= !txtVelocidad.getText().isEmpty();
                camposCompletos &= !txtCilindraje.getText().isEmpty();
                camposCompletos &= !txtNumPasajeros.getText().isEmpty();
                camposCompletos &= !txtPuertas.getText().isEmpty();
                camposCompletos &= !txtCapacidadMaletero.getText().isEmpty();
                camposCompletos &= tieneAireAcon.getSelectedToggle() != null;
                camposCompletos &= tieneCamara.getSelectedToggle() != null;
                camposCompletos &= tieneVelocidad.getSelectedToggle() != null;
                camposCompletos &= !txtNumBolsasAire.getText().isEmpty();
                camposCompletos &= tieneABS.getSelectedToggle() != null;
                camposCompletos &= tieneSensorColi.getSelectedToggle() != null;
                camposCompletos &= tieneSensorTraf.getSelectedToggle() != null;
                camposCompletos &= tieneAsistente.getSelectedToggle() != null;
                camposCompletos &= tiene4x4.getSelectedToggle() != null;
                break;

            case "PickUps":
                camposCompletos &= !txtNumPasajeros.getText().isEmpty();
                camposCompletos &= !txtPuertas.getText().isEmpty();
                camposCompletos &= tieneAireAcon.getSelectedToggle() != null;
                camposCompletos &= tieneCamara.getSelectedToggle() != null;
                camposCompletos &= !txtNumBolsasAire.getText().isEmpty();
                camposCompletos &= tieneABS.getSelectedToggle() != null;
                camposCompletos &= tiene4x4.getSelectedToggle() != null;
                camposCompletos &= !txtCapacidadCarga.getText().isEmpty();
                break;

            case "Vans":
                camposCompletos &= !txtMarca.getText().isEmpty();
                camposCompletos &= esNuevo.getSelectedToggle() != null;
                camposCompletos &= !txtModelo.getText().isEmpty();
                camposCompletos &= cbxCambio.getValue() != null;
                camposCompletos &= !txtVelocidad.getText().isEmpty();
                camposCompletos &= !txtCilindraje.getText().isEmpty();
                camposCompletos &= !txtNumPasajeros.getText().isEmpty();
                camposCompletos &= !txtPuertas.getText().isEmpty();
                camposCompletos &= !txtCapacidadMaletero.getText().isEmpty();
                camposCompletos &= tieneAireAcon.getSelectedToggle() != null;
                camposCompletos &= tieneCamara.getSelectedToggle() != null;
                camposCompletos &= !txtNumBolsasAire.getText().isEmpty();
                camposCompletos &= tieneABS.getSelectedToggle() != null;
                break;

            case "Buses":
                camposCompletos &= !txtMarca.getText().isEmpty();
                camposCompletos &= esNuevo.getSelectedToggle() != null;
                camposCompletos &= !txtModelo.getText().isEmpty();
                camposCompletos &= cbxCambio.getValue() != null;
                camposCompletos &= !txtVelocidad.getText().isEmpty();
                camposCompletos &= !txtCilindraje.getText().isEmpty();
                camposCompletos &= !txtNumPasajeros.getText().isEmpty();
                camposCompletos &= !txtPuertas.getText().isEmpty();
                camposCompletos &= !txtCapacidadMaletero.getText().isEmpty();
                camposCompletos &= tieneAireAcon.getSelectedToggle() != null;
                camposCompletos &= tieneCamara.getSelectedToggle() != null;
                camposCompletos &= !txtNumBolsasAire.getText().isEmpty();
                camposCompletos &= tieneABS.getSelectedToggle() != null;
                camposCompletos &= !txtNumEjes.getText().isEmpty();
                break;

            case "Camiones":
                camposCompletos &= !txtMarca.getText().isEmpty();
                camposCompletos &= esNuevo.getSelectedToggle() != null;
                camposCompletos &= !txtModelo.getText().isEmpty();
                camposCompletos &= cbxCambio.getValue() != null;
                camposCompletos &= !txtVelocidad.getText().isEmpty();
                camposCompletos &= !txtCilindraje.getText().isEmpty();
                camposCompletos &= !txtCapCargaCam.getText().isEmpty();
                camposCompletos &= tieneAireAconCam.getSelectedToggle() != null;
                camposCompletos &= tieneFrenosAire.getSelectedToggle() != null;
                camposCompletos &= tieneABS1Cam.getSelectedToggle() != null;
                camposCompletos &= !txtNumEjesCam.getText().isEmpty();
                break;

            default:
                camposCompletos = false;
                break;
        }
        return camposCompletos;
    }

    //Metodo para mostrar un mensaje de información
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
}
