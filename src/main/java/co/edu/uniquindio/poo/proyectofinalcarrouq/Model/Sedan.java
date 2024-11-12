package co.edu.uniquindio.poo.proyectofinalcarrouq.Model;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Combustible.Combustible;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoCambios;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoEstado;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract.VCSegAvanzada;

public class Sedan extends VCSegAvanzada{
    
    private float capacidadMaletero;

    //Constructor con parametros
    public Sedan(String placa, String marca, boolean esNuevo, String modelo, TipoCambios tiposCambios, float velocidadMax, TipoEstado tipoEstado, float cilindraje, int numPasajeros, int numPuertas, Combustible combustible, String imagen, boolean tieneAcondicionado, boolean tieneCamaraReversa, boolean tieneVelocidadCrucero, int numeroBolsaAire, boolean tieneABS, boolean es4x4, boolean tieneSensorColision, boolean tieneSensorTraficoCruzado, boolean tieneAsistentePermanencia, float capacidadMaletero) {
        super(placa, marca, esNuevo, modelo, tiposCambios, velocidadMax, cilindraje, numPasajeros, numPuertas, combustible, imagen,tipoEstado, tieneAcondicionado, tieneCamaraReversa, tieneVelocidadCrucero, numeroBolsaAire, tieneABS, false, tieneSensorColision, tieneSensorTraficoCruzado, tieneAsistentePermanencia);
        this.capacidadMaletero = capacidadMaletero;
    }

    //Constructor vacio
    public Sedan() {
    }

    //Getters y Setters
    public float getCapacidadMaletero() {
        return capacidadMaletero;
    }

    public void setCapacidadMaletero(float capacidadMaletero) {
        this.capacidadMaletero = capacidadMaletero;
    }
}
