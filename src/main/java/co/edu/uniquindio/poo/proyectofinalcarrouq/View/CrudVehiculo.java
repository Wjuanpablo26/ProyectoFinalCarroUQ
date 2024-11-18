package co.edu.uniquindio.poo.proyectofinalcarrouq.View;

import co.edu.uniquindio.poo.proyectofinalcarrouq.Controller.EmpleadoController;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Exception.VehiculoException;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.*;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract.Vehiculo;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Combustible.*;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.*;
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
    
}
