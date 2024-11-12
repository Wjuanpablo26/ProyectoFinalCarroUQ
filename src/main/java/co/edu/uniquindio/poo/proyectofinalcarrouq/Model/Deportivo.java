package co.edu.uniquindio.poo.proyectofinalcarrouq.Model;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Combustible.Combustible;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract.VDeportivo;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoEstado;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoCambios;


public class Deportivo extends VDeportivo{

    private boolean tieneAerodinamicaMejorada;
    
    //Constructor con parametros
    public Deportivo(String placa, String marca, boolean esNuevo, String modelo, TipoCambios tiposCambios, float velocidadMax, float cilindraje, int numPasajeros, int numPuertas, Combustible combustible, String imagen, TipoEstado tipoEstado, int numBolsasAire, int numCaballosFuerza, double tiempoAceleracion, boolean tieneAerodinamicaMejorada) {
        super(placa, marca, esNuevo, modelo, tiposCambios, velocidadMax, cilindraje, numPasajeros, numPuertas, combustible, imagen,tipoEstado, numBolsasAire, numCaballosFuerza, tiempoAceleracion);
        this.tieneAerodinamicaMejorada = tieneAerodinamicaMejorada;
    }

    //Constructor vacio
    public Deportivo() {
    }

    //Getters y Setters
    public boolean isTieneAerodinamicaMejorada() {
        return tieneAerodinamicaMejorada;
    }

    public void setTieneAerodinamicaMejorada(boolean tieneAerodinamicaMejorada) {
        this.tieneAerodinamicaMejorada = tieneAerodinamicaMejorada;
    }
}
