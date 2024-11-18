package co.edu.uniquindio.poo.proyectofinalcarrouq.View;

import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract.Vehiculo;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoCamiones;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoCombustible;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoEstado;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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


        private void limpiarCampos(){
        // Limpiar todos los campos de texto
        txtMarca.clear();
        txtModelo.clear();
        txtCilindraje.clear();
        txtVelocidad.clear();
        txtNumPasajeros.clear();
        txtPuertas.clear();
        txtCapacidadCarga.clear();
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

        // Restablecer la sleccion en todos los comboBox
        cbxCambio.setValue(null);
        cbxCamiones.setValue(null);
        cbxCombustible.setValue(null);
        cbxTipoVehiculo.setValue(null);

        // Restablecer la seleccion en todos los ToggleGroups (RadioButtons)
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

    private boolean verificarCampos(){
        String tipoVehiculo = cbxTipoVehiculo.getValue();
        boolean camposCompletos = true;

        camposCompletos &= !txtPlaca.getText().isEmpty();
        camposCompletos &= !txtMarca.getText().isEmpty();
        camposCompletos &= esNuevo.getSelectedToggle() != null;
        camposCompletos &= !txtModelo.getText().isEmpty();
        camposCompletos &= cbxCambio.getValue() != null;
        camposCompletos &= !txtVelocidad.getText().isEmpty();
        camposCompletos &= !txtCilindraje.getText().isEmpty();
        camposCompletos &= !cbxCombustible.getValue() != null;

        // Verificar campos dependiendo del tipo de vehiculo
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
                camposCompletos &=  !txtNumPasajeros.getText().isEmpty();
                camposCompletos &= !txtPuertas.getText().isEmpty();
                camposCompletos &= tieneAireAcon.getSelectedToggle() != null;
                camposCompletos &= tieneCamara.getSelectedToggle() != null;
                camposCompletos &= !txtNumBolsasAire.getText().isEmpty();
                camposCompletos &= tieneABS.getSelectedToggle() != null;
                camposCompletos &= tiene4x4.getSelectedToggle() != null;
                camposCompletos &= !txtCapacidadCarga.getText().isEmpty();
                break;

            case "vans":
                camposCompletos &= !txtMarca.getText().isEmpty();
                camposCompletos &= esNuevo.getSelectedToggle() != null;
                camposCompletos &= !txtModelo.getText().isEmpty();
                camposCompletos &= cbxCambio.getValue() != null;
                camposCompletos &= !txtVelocidad.getText().isEmpty();
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

            case "buses":
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
                camposCompletos &= !txtCapacidadCarga.getText().isEmpty();
                camposCompletos &= tieneAireAcon.getSelectedToggle() != null;
                camposCompletos &= tieneFrenosAire.getSelectedToggle() != null;
                camposCompletos &= tieneABS1Cam.getSelectedToggle() != null;
                camposCompletos &= !txtNumEjesCam.getText().isEmpty();
                break;

            default:
                camposCompletos = false;
                break;

        }
        return camposCompletos;}


//----------------------- Message methods ----------------

public void mensajeInformacion(String title, String context){
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
     alert.setTitle(title);
     alert.setHeaderText(null);
     alert.setContentText(context);
     alert.showAndWait();

}

public void mensajeError(String title, String context){
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(title);
    alert.setHeaderText(" Error!!");
    alert.setContentText(context);
    alert.showAndWait();   
}
}
