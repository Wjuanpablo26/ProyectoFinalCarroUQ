package co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.Genero;

public abstract class Persona {

    private String nombre;
    private String cedula;
    private String correo;
    private Genero genero;
    private int edad;

    //Constructor con parametros
    public Persona(String nombre, String cedula, String correo, Genero genero, int edad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.genero = genero;
        this.edad = edad;
    }

    //Constructor vacio
    public Persona() {
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    
}
