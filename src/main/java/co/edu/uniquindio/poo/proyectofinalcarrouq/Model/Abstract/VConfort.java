package co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Combustible.Combustible;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoEstado;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoCambios;

public abstract class VConfort extends Vehiculo {
    
    private boolean tieneAcondicionado;
    private boolean tieneCamaraReversa;
    private boolean tieneVelocidadCrucero;
    private int numeroBolsaAire;
    private boolean tieneABS;
    private boolean es4x4;

    //Constructor con parametros
    public VConfort(String placa, String marca, boolean esNuevo, String modelo, TipoCambios tiposCambios, float velocidadMax, float cilindraje, int numPasajeros, int numPuertas, Combustible combustible, String imagen, TipoEstado tipoEstado, boolean tieneAcondicionado, boolean tieneCamaraReversa, boolean tieneVelocidadCrucero, int numeroBolsaAire, boolean tieneABS, boolean es4x4) {
        super(placa, marca, esNuevo, modelo, tiposCambios, velocidadMax, cilindraje, numPasajeros, numPuertas, combustible, imagen, tipoEstado);
        this.tieneAcondicionado = tieneAcondicionado;
        this.tieneCamaraReversa = tieneCamaraReversa;
        this.tieneVelocidadCrucero = tieneVelocidadCrucero;
        this.numeroBolsaAire = numeroBolsaAire;
        this.tieneABS = tieneABS;
        this.es4x4 = es4x4;
    }

    //Constructor vacio
    public VConfort() {
    }

    //Getters y Setters
    public boolean isTieneAcondicionado() {
        return tieneAcondicionado;
    }

    public void setTieneAcondicionado(boolean tieneAcondicionado) {
        this.tieneAcondicionado = tieneAcondicionado;
    }

    public boolean isTieneCamaraReversa() {
        return tieneCamaraReversa;
    }

    public void setTieneCamaraReversa(boolean tieneCamaraReversa) {
        this.tieneCamaraReversa = tieneCamaraReversa;
    }

    public boolean isTieneVelocidadCrucero() {
        return tieneVelocidadCrucero;
    }

    public void setTieneVelocidadCrucero(boolean tieneVelocidadCrucero) {
        this.tieneVelocidadCrucero = tieneVelocidadCrucero;
    }

    public int getNumeroBolsaAire() {
        return numeroBolsaAire;
    }

    public void setNumeroBolsaAire(int numeroBolsaAire) {
        this.numeroBolsaAire = numeroBolsaAire;
    }

    public boolean isTieneABS() {
        return tieneABS;
    }

    public void setTieneABS(boolean tieneABS) {
        this.tieneABS = tieneABS;
    }

    public boolean isEs4x4() {
        return es4x4;
    }

    public void setEs4x4(boolean es4x4) {
        this.es4x4 = es4x4;
    }

}
