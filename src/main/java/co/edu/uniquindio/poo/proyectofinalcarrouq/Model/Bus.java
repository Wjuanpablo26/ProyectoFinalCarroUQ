package co.edu.uniquindio.poo.proyectofinalcarrouq.Model;

import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract.VConfort;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoEstado;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoCambios;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Combustible.Combustible;;

public class Bus extends VConfort{

    private float capacidadMaletero;
    private int numEjes;

    //Constructor
    public Bus(String placa, String marca, boolean esNuevo, String modelo, TipoCambios tiposCambios, float velocidadMax, float cilindraje, int numPasajeros, int numPuertas, Combustible combustible, boolean tieneAcondicionado, boolean tieneCamaraReversa, boolean tieneVelocidadCrucero, int numeroBolsaAire, boolean tieneABS, float capacidadMaletero, int numEjes, String imagen, TipoEstado tipoEstado) {
        super(placa, marca, esNuevo, modelo, tiposCambios, velocidadMax, cilindraje, numPasajeros, numPuertas, combustible,imagen,tipoEstado, tieneAcondicionado, tieneCamaraReversa, false, numeroBolsaAire, tieneABS, false);
        this.capacidadMaletero = capacidadMaletero;
        this.numEjes = numEjes;
    }

    //Constructor vacio
    public Bus() {
    }

    //Getters y Setters
    public float getCapacidadMaletero() {
        return capacidadMaletero;
    }

    public void setCapacidadMaletero(float capacidadMaletero) {
        this.capacidadMaletero = capacidadMaletero;
    }

    public int getNumEjes() {
        return numEjes;
    }

    public void setNumEjes(int numEjes) {
        this.numEjes = numEjes;
    }

}
