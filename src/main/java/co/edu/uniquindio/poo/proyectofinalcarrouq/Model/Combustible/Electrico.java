package co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Combustible;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoCombustible;

public class Electrico extends Combustible {

    private int autonomia;
    private int tiempoCarga;

    //Constructor
    public Electrico(TipoCombustible TipoCombustible, int autonomia, int tiempoCarga) {
        super(TipoCombustible);
        this.autonomia = autonomia;
        this.tiempoCarga = tiempoCarga;
    }

    public Electrico(TipoCombustible tipoCombustible) {
        super(tipoCombustible);
    }
    
    //Getters y Setters
    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    public int getTiempoCarga() {
        return tiempoCarga;
    }

    public void setTiempoCarga(int tiempoCarga) {
        this.tiempoCarga = tiempoCarga;
    }

}
