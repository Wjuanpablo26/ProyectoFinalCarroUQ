package co.edu.uniquindio.poo.proyectofinalcarrouq.Model;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Combustible.Combustible;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoCambios;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoEstado;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract.VConfort;

public class PickUps extends VConfort{

    private float capacidadCajaCarga;
    
    //Constructor con parametros
    public PickUps(String placa, String marca, boolean esNuevo, String modelo, TipoCambios tiposCambios, float velocidadMax, float cilindraje, int numPasajeros, int numPuertas, Combustible combustible, String imagen, TipoEstado tipoEstado, boolean tieneAcondicionado, boolean tieneCamaraReversa, boolean tieneVelocidadCrucero, int numeroBolsaAire, boolean tieneABS, boolean es4x4, float capacidadCajaCarga) {
        super(placa, marca, esNuevo, modelo, tiposCambios, velocidadMax, cilindraje, numPasajeros, numPuertas, combustible, imagen,tipoEstado, tieneAcondicionado, tieneCamaraReversa, false, numeroBolsaAire, tieneABS, es4x4);
        this.capacidadCajaCarga = capacidadCajaCarga;
    }

    //Constructor vacio
    public PickUps() {
    }

    //Getters y Setters
    public float getCapacidadCajaCarga() {
        return capacidadCajaCarga;
    }

    public void setCapacidadCajaCarga(float capacidadCajaCarga) {
        this.capacidadCajaCarga = capacidadCajaCarga;
    }
}
