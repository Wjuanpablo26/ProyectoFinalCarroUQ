package co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Combustible;

import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoCombustible;

public abstract class Combustible {

    private TipoCombustible tipoCombustible;

    //Constructor
    public Combustible(TipoCombustible tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    //Getters y Setters
    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(TipoCombustible tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }
    
}
