package co.edu.uniquindio.poo.proyectofinalcarrouq.Model;

import java.util.ArrayList;

public class Concesionario {

    //Listas Personas
    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    private ArrayList<Admin> listaAdmins = new ArrayList<>();

    //Listas Vehiculos
    private ArrayList<Moto> listaMotos = new ArrayList<>();
    private ArrayList<Sedan> listaSedanes = new ArrayList<>();
    private ArrayList<Deportivo> listaDeportivos = new ArrayList<>();   
    private ArrayList<Bus> listaBuses = new ArrayList<>();
    private ArrayList<Camion> listaCamiones = new ArrayList<>();
    private ArrayList<Camioneta> listaCamionetas = new ArrayList<>();
    private ArrayList<Vans> listaVans = new ArrayList<>();
    private ArrayList<PickUps> listaPickUps = new ArrayList<>();

    //Listas Reportes
    private ArrayList<Reporte> listaReportes = new ArrayList<>();
    private ArrayList<Venta> listaVentas = new ArrayList<>();

    //Constructor
    public Concesionario() {
    }

    //Getters y Setters
    public ArrayList<Cliente> getListaClientes() {
        return this.listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return this.listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public ArrayList<Admin> getListaAdmins() {
        return this.listaAdmins;
    }

    public void setListaAdmins(ArrayList<Admin> listaAdmins) {
        this.listaAdmins = listaAdmins;
    }

    public ArrayList<Moto> getListaMotos() {
        return this.listaMotos;
    }

    public void setListaMotos(ArrayList<Moto> listaMotos) {
        this.listaMotos = listaMotos;
    }

    public ArrayList<Sedan> getListaSedanes() {
        return this.listaSedanes;
    }

    public void setListaSedanes(ArrayList<Sedan> listaSedanes) {
        this.listaSedanes = listaSedanes;
    }

    public ArrayList<Deportivo> getListaDeportivos() {
        return this.listaDeportivos;
    }

    public void setListaDeportivos(ArrayList<Deportivo> listaDeportivos) {
        this.listaDeportivos = listaDeportivos;
    }

    public ArrayList<Bus> getListaBuses() {
        return this.listaBuses;
    }

    public void setListaBuses(ArrayList<Bus> listaBuses) {
        this.listaBuses = listaBuses;
    }

    public ArrayList<Camion> getListaCamiones() {
        return this.listaCamiones;
    }

    public void setListaCamiones(ArrayList<Camion> listaCamiones) {
        this.listaCamiones = listaCamiones;
    }

    public ArrayList<Camioneta> getListaCamionetas() {
        return this.listaCamionetas;
    }

    public void setListaCamionetas(ArrayList<Camioneta> listaCamionetas) {
        this.listaCamionetas = listaCamionetas;
    }

    public ArrayList<Vans> getListaVans() {
        return this.listaVans;
    }

    public void setListaVans(ArrayList<Vans> listaVans) {
        this.listaVans = listaVans;
    }

    public ArrayList<PickUps> getListaPickUps() {
        return this.listaPickUps;
    }

    public void setListaPickUps(ArrayList<PickUps> listaPickUps) {
        this.listaPickUps = listaPickUps;
    }

    public ArrayList<Reporte> getListaReportes() {
        return this.listaReportes;
    }

    public void setListaReportes(ArrayList<Reporte> listaReportes) {
        this.listaReportes = listaReportes;
    }

    public ArrayList<Venta> getListaVentas() {
        return this.listaVentas;
    }

    public void setListaVentas(ArrayList<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    //Metodo para crear Persona (Cliente, Empleado, Admin)
    
    
}
