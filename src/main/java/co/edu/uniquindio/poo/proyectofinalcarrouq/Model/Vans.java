package co.edu.uniquindio.poo.proyectofinalcarrouq.Model;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Combustible.Combustible;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract.VConfort;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoCambios;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoEstado;

public class Vans extends VConfort{

    private float capacidadMaletero;

    //Constructor con parametros
    public Vans(String placa, String marca, boolean esNuevo, String modelo, TipoCambios tiposCambios, float velocidadMax, float cilindraje, int numPasajeros, int numPuertas, Combustible combustible, String imagen, TipoEstado tipoEstado,  boolean tieneAcondicionado, boolean tieneCamaraReversa, boolean tieneVelocidadCrucero, int numeroBolsaAire, boolean tieneABS, boolean es4x4, float capacidadMaletero) {
        super(placa, marca, esNuevo, modelo, tiposCambios, velocidadMax, cilindraje, numPasajeros, numPuertas, combustible,imagen,tipoEstado,tieneAcondicionado, tieneCamaraReversa, false, numeroBolsaAire, tieneABS, false);
        this.capacidadMaletero = capacidadMaletero;
    }

    //Constructor vacio
    public Vans() {
    }

    //Getters y Setters
    public float getCapacidadMaletero() {
        return capacidadMaletero;
    }

    public void setCapacidadMaletero(float capacidadMaletero) {
        this.capacidadMaletero = capacidadMaletero;
    }
    
}
