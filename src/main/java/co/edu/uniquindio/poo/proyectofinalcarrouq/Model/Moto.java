package co.edu.uniquindio.poo.proyectofinalcarrouq.Model;

import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract.Vehiculo;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoEstado;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoCambios;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Combustible.Combustible;

public class Moto extends Vehiculo{
    
    //Constructor con parametros
    public Moto(String placa, String marca, boolean esNuevo, String modelo, TipoCambios tiposCambios, float velocidadMax, float cilindraje, Combustible combustible, String imagen, TipoEstado tipoEstado) {
        super(placa, marca, esNuevo, modelo, tiposCambios, velocidadMax, cilindraje, 2, 0, combustible, imagen,tipoEstado);
    }

    //Constructor vacio
    public Moto() {
    }
}
