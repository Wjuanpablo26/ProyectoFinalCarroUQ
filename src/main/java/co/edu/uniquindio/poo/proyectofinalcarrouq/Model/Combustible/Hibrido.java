package co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Combustible;

import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoCombustible;

public class Hibrido extends Combustible {

    
    public boolean esEnchufable;
    public boolean esHibridoLigero;

    //Constructor
    public Hibrido(TipoCombustible tipoCombustible, boolean esEnchufable, boolean esHibridoLigero) {
        super(tipoCombustible);
        this.esEnchufable = esEnchufable;
        this.esHibridoLigero = esHibridoLigero;
    }

    public Hibrido(TipoCombustible tipoCombustible) {
        super(tipoCombustible);
    }

    //Getters y Setters
    public boolean isEsEnchufable() {
        return esEnchufable;
    }

    public void setEsEnchufable(boolean esEnchufable) {
        this.esEnchufable = esEnchufable;
    }

    public boolean isEsHibridoLigero() {
        return esHibridoLigero;
    }

    public void setEsHibridoLigero(boolean esHibridoLigero) {
        this.esHibridoLigero = esHibridoLigero;
    }
    
}
