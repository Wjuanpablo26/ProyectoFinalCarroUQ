package co.edu.uniquindio.poo.proyectofinalcarrouq.Model;

import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract.Vehiculo;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Combustible.Combustible;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoCamiones;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoEstado;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoCambios;

public class Camion extends Vehiculo {
    
    private float capCarga;
    private boolean tieneAireAcondicionado;
    private boolean tieneFrenosAire;
    private boolean tieneABS;
    private int numeroEjes;
    private TipoCamiones tipoCamion;

    //Constructor con parametros
    public Camion(String placa, String marca, boolean esNuevo, String modelo, TipoCambios tiposCambios, float velocidadMax, float cilindraje, Combustible combustible, float capCarga, boolean tieneAireAcondicionado, boolean tieneFrenosAire, boolean tieneABS, int numeroEjes, TipoCamiones tipoCamion, String imagen, TipoEstado tipoEstado) {
        super(placa, marca, esNuevo, modelo, tiposCambios, velocidadMax, cilindraje, 0, 0, combustible,imagen,tipoEstado);
        this.capCarga = capCarga;
        this.tieneAireAcondicionado = tieneAireAcondicionado;
        this.tieneFrenosAire = tieneFrenosAire;
        this.tieneABS = tieneABS;
        this.numeroEjes = numeroEjes;
        this.tipoCamion = tipoCamion;
    }

    //Constructor vacio
    public Camion() {
    }

    //Getters y Setters
    public float getCapCarga() {
        return capCarga;
    }

    public void setCapCarga(float capCarga) {
        this.capCarga = capCarga;
    }

    public boolean isTieneAireAcondicionado() {
        return tieneAireAcondicionado;
    }

    public void setTieneAireAcondicionado(boolean tieneAireAcondicionado) {
        this.tieneAireAcondicionado = tieneAireAcondicionado;
    }

    public boolean isTieneFrenosAire() {
        return tieneFrenosAire;
    }

    public void setTieneFrenosAire(boolean tieneFrenosAire) {
        this.tieneFrenosAire = tieneFrenosAire;
    }

    public boolean isTieneABS() {
        return tieneABS;
    }

    public void setTieneABS(boolean tieneABS) {
        this.tieneABS = tieneABS;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    public void setNumeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
    }

    public TipoCamiones getTipoCamion() {
        return tipoCamion;
    }

    public void setTipoCamion(TipoCamiones tipoCamion) {
        this.tipoCamion = tipoCamion;
    }

    
}
