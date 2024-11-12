package co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Combustible.Combustible;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoEstado;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoCambios;

public abstract class VCSegAvanzada extends VConfort{
    
    private boolean tieneSensorColision;
    private boolean tieneSensorTraficoCruzado;
    private boolean tieneAsistentePermanencia;

    //Constructor con parametros
    public VCSegAvanzada(String placa, String marca, boolean esNuevo, String modelo, TipoCambios tiposCambios, float velocidadMax, float cilindraje, int numPasajeros, int numPuertas, Combustible combustible, String imagen, TipoEstado tipoEstado, boolean tieneAcondicionado, boolean tieneCamaraReversa, boolean tieneVelocidadCrucero, int numeroBolsaAire, boolean tieneABS, boolean es4x4, boolean tieneSensorColision, boolean tieneSensorTraficoCruzado, boolean tieneAsistentePermanencia) {
        super(placa, marca, esNuevo, modelo, tiposCambios, velocidadMax, cilindraje, numPasajeros, numPuertas, combustible, imagen, tipoEstado, tieneAcondicionado, tieneCamaraReversa, tieneVelocidadCrucero, numeroBolsaAire, tieneABS, es4x4);
        this.tieneSensorColision = tieneSensorColision;
        this.tieneSensorTraficoCruzado = tieneSensorTraficoCruzado;
        this.tieneAsistentePermanencia = tieneAsistentePermanencia;
    }

    //Constructor vacio
    public VCSegAvanzada() {
    }

    //Getters y Setters
    public boolean isTieneSensorColision() {
        return tieneSensorColision;
    }

    public void setTieneSensorColision(boolean tieneSensorColision) {
        this.tieneSensorColision = tieneSensorColision;
    }

    public boolean isTieneSensorTraficoCruzado() {
        return tieneSensorTraficoCruzado;
    }

    public void setTieneSensorTraficoCruzado(boolean tieneSensorTraficoCruzado) {
        this.tieneSensorTraficoCruzado = tieneSensorTraficoCruzado;
    }

    public boolean isTieneAsistentePermanencia() {
        return tieneAsistentePermanencia;
    }

    public void setTieneAsistentePermanencia(boolean tieneAsistentePermanencia) {
        this.tieneAsistentePermanencia = tieneAsistentePermanencia;
    }

}
