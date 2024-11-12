package co.edu.uniquindio.poo.proyectofinalcarrouq.Model;

import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract.Persona;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.Genero;
public class Admin extends Persona {

    private UserName userName;

    //Constructor con parametros
    public Admin( String cedula, String nombre, String correo, Genero genero, int edad, UserName userName) {
        super(cedula,nombre, correo, genero, edad);
        this.userName = userName;
    }

    //Constructor vacio
    public Admin() {
    }

    //Getters y Setters
    public UserName getUserName() {
        return userName;
    }

    public void setUserName(UserName userName) {
        this.userName = userName;
    }


}
