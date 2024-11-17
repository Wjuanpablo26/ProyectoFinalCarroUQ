package co.edu.uniquindio.poo.proyectofinalcarrouq.View;

import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Cliente;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Deportivo;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Moto;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.PickUps;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Sedan;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Vans;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoCamiones;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

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
    private TableColumn<Deportivo, String> colPlacaDep, colModeloDep, colMarcaDep,colCaballoFuerDep;

    @FXML
    private TableColumn<Deportivo, Boolean> colNuevoDep, colTieneAeroDep;

    @FXML
    private TableView<Deportivo> tblDeportivo;

    @FXML
    private TableColumn<Camionetas, String> colPlacaCam,colModeloCam,colMarcaCam,colCapacidadMalCam;

    @FXML
    private TableColumn<Camionetas, Boolean> colNuevoCam, colEs4X4Cam;

    @FXML
    private TableView<Camionetas> tblCamionetas;

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
    private TableColumn<Buses, String> colPlacaBus, colModeloBus, colMarcaBus, colCapacidadMalBus, colNumBolsasBus;

    @FXML
    private TableColumn<Buses, Boolean> colNuevoBus;

    @FXML
    private TableView<Buses> tblBuses;

    @FXML
    private TableColumn<Camiones, String> colPlacaCamn, colModeloCamn,colMarcaCamn, colCapCargaCamn;

    @FXML
    private TableColumn<Camiones, TipoCamiones> colTipoCamn;

    @FXML
    private TableColumn<Camiones, Boolean> colNuevoCamn;

    @FXML
    private TableView<Camiones> tblCamiones;


}
