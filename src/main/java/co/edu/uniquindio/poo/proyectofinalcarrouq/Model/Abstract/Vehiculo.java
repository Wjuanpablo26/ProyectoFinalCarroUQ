package co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Combustible.Combustible;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoEstado;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoCambios;

public abstract class Vehiculo {

    private String placa;
    private String marca;
    private boolean esNuevo;
    private String modelo;
    private TipoCambios tiposCambios;
    private float velocidadMax;
    private float cilindraje;
    private int numPasajeros;
    private int numPuertas;
    private Combustible combustible;
    private String imagen;
    private TipoEstado tipoEstado;

    //Constructor con parametros
    public Vehiculo(String placa, String marca, boolean esNuevo, String modelo, TipoCambios tiposCambios, float velocidadMax, float cilindraje, int numPasajeros, int numPuertas, Combustible combustible, String imagen, TipoEstado tipoEstado) {
        this.placa = placa;
        this.marca = marca;
        this.esNuevo = esNuevo;
        this.modelo = modelo;
        this.tiposCambios = tiposCambios;
        this.velocidadMax = velocidadMax;
        this.cilindraje = cilindraje;
        this.numPasajeros = numPasajeros;
        this.numPuertas = numPuertas;
        this.combustible = combustible;
        this.imagen = imagen;
        this.tipoEstado = tipoEstado;
    }

    //Constructor vacio
    public Vehiculo() {
    }

    //Getters y Setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isEsNuevo() {
        return esNuevo;
    }

    public void setEsNuevo(boolean esNuevo) {
        this.esNuevo = esNuevo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public TipoCambios getTiposCambios() {
        return tiposCambios;
    }

    public void setTiposCambios(TipoCambios tiposCambios) {
        this.tiposCambios = tiposCambios;
    }

    public float getVelocidadMax() {
        return velocidadMax;
    }

    public void setVelocidadMax(float velocidadMax) {
        this.velocidadMax = velocidadMax;
    }

    public float getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(float cilindraje) {
        this.cilindraje = cilindraje;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public Combustible getCombustible() {
        return combustible;
    }

    public void setCombustible(Combustible combustible) {
        this.combustible = combustible;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public TipoEstado getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(TipoEstado tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

    
    
}
