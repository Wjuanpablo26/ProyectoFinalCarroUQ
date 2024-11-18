package co.edu.uniquindio.poo.proyectofinalcarrouq.View;

import java.io.File;

import co.edu.uniquindio.poo.proyectofinalcarrouq.Controller.EmpleadoController;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Exception.VehiculoException;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Bus;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Camion;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Camioneta;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Deportivo;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Moto;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.PickUps;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Sedan;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Vans;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract.Vehiculo;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Combustible.Electrico;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Combustible.Hibrido;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoCamiones;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoCombustible;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoEstado;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

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
    private ComboBox<TiposCambios> cbxCambio;

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
    private TableColumn<Vehiculo, TiposCambios> colTipoCambio;

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
        obtenervehiculos();
        tblVehiculo.getItems().clear();
        tblVehiculo.setItems(lsitaVehiculo);
        selection();
    }

    //Método que configura la vista de la interfaz de usuario
    private void initView(){
        colPlaca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlaca()));

        colModelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));

        colMarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));

        colTipoCambio.setCellValueFactory(cellData -> new SimpleStringProperty<>(cellData.getValue().getCombustible().getTipoCombustible()));

        colCombustible.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCombustible().getTipoCombustible()));

        colEstado.setCellValueFactory(cellData -> new SimpleStringProperty<>(cellData.getValue().getTipoEstado()));

        cbxCambio.setItems(FXCollections.observableArrayList(TiposCambios.values()));

        cbxTipoVehiculo.getItems().addAll("Sedan", "Moto", "Deportivo", "Camioneta", "PickUps", "Vans", "Bus", "Camion");

        cbxTipoVehiculo.setOnAction(this::onVehiculoChange);

        cbxCombustible.setItems(FXCollections.observableArrayList(TipoCombustible.values()));
        cbxCombustible.setOnAction(this::onCombustibleChange);

        cbxCamiones.setItems(FXCollections.observableArrayList(TipoCamiones.values()));
    }

    //Método para añadir y obtener los vehículos a la lista
    private void obtenervehiculos(){
        listaVehiculo.addAll(empleadoController.obtenerSedans());
        listaVehiculo.addAll(empleadoController.obtenerMotos());
        listaVehiculo.addAll(empleadoController.obtenerDeportivos());
        listaVehiculo.addAll(empleadoController.obtenerCamionetas());
        listaVehiculo.addAll(empleadoController.obtenerPicKups());
        listaVehiculo.addAll(empleadoController.obtenerVans());
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
                    if (empleadoController.actualizarPickups(vehiculoAntiguo.getPlaca(),pickUps)){
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
                exito = (empleadoController.addPickups((PickUps) vehiculo) == 1);
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
                obtenervehiculos();
                tblVehiculo.refresh();
            }else{
                mensajeError("Error en la creación", "Los datos son inválidos o ya fueron utilizados");
            }
        }else{
            mensajeError("Error en la creación", "Los campos no están completos")
        }
    }
}
