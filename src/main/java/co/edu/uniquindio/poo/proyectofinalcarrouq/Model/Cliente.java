package co.edu.uniquindio.poo.proyectofinalcarrouq.Model;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.Genero;

import java.time.LocalDate;

import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract.Persona;

public class Cliente extends Persona{

    private LocalDate fechaRegistro;

    //Constructor con parametros
    public Cliente(String cedula, String nombre, String correo, Genero genero, int edad, LocalDate fechaRegistro) {
        super(cedula, nombre, correo, genero, edad);
        this.fechaRegistro = fechaRegistro;
    }

    //Constructor vacio
    public Cliente() {
    }

    //Getters y Setters
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
}
