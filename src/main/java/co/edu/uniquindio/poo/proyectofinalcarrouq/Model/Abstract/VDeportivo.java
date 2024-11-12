package co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Combustible.Combustible;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoEstado;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoCambios;

public abstract class VDeportivo extends Vehiculo{

    private int numBolsasAire;
    private int numCaballosFuerza;
    private double tiempoAceleracion;

    //Constructor
    public VDeportivo(String placa, String marca, boolean esNuevo, String modelo, TipoCambios tiposCambios, float velocidadMax, float cilindraje, int numPasajeros, int numPuertas, Combustible combustible, String imagen, TipoEstado tipoEstado, int numBolsasAire, int numCaballosFuerza, double tiempoAceleracion) {
        super(placa, marca, esNuevo, modelo, tiposCambios, velocidadMax, cilindraje, numPasajeros, numPuertas, combustible, imagen, tipoEstado);
        this.numBolsasAire = numBolsasAire;
        this.numCaballosFuerza = numCaballosFuerza;
        this.tiempoAceleracion = tiempoAceleracion;
    }

    //Constructor vacio
    public VDeportivo() {
    }

    //Getters y Setters
    public int getNumBolsasAire() {
        return numBolsasAire;
    }

    public void setNumBolsasAire(int numBolsasAire) {
        this.numBolsasAire = numBolsasAire;
    }

    public int getNumCaballosFuerza() {
        return numCaballosFuerza;
    }

    public void setNumCaballosFuerza(int numCaballosFuerza) {
        this.numCaballosFuerza = numCaballosFuerza;
    }

    public double getTiempoAceleracion() {
        return tiempoAceleracion;
    }

    public void setTiempoAceleracion(double tiempoAceleracion) {
        this.tiempoAceleracion = tiempoAceleracion;
    }
    
}
