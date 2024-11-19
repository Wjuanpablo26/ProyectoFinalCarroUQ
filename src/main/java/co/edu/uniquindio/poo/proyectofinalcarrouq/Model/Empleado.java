package co.edu.uniquindio.poo.proyectofinalcarrouq.Model;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.Genero;

import java.time.LocalDate;

import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract.Persona;

public class Empleado extends Persona {

    private UserName userName;
    private LocalDate fechaContratacion;

    //Constructor con parametros
    public Empleado(String cedula, String nombre, String correo, Genero genero, int edad, UserName userName, LocalDate fechaContratacion) {
        super(cedula, nombre, correo, genero, edad);
        this.userName = userName;
        this.fechaContratacion = fechaContratacion;
    }

    //Constructor vacio
    public Empleado() {
    }

    //Getters y Setters
    public UserName getUserName() {
        return userName;
    }

    public void setUserName(UserName userName) {
        this.userName = userName;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    //Metodo to String
    @Override
    public String toString() {
        return ("Nombre:"+ super.getNombre()+ "  " +" Cedula:"+ super.getCedula());
    }

}
