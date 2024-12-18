package co.edu.uniquindio.poo.proyectofinalcarrouq.Controller;


import co.edu.uniquindio.poo.proyectofinalcarrouq.Exception.PersonaException;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Exception.VehiculoException;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.*;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract.Vehiculo;
import java.util.ArrayList;


public class EmpleadoController {
    ModelFactory modelFactory;

    public EmpleadoController(){
        modelFactory = ModelFactory.getInstance();
    }

    //Cliente
    public int addCliente(Cliente cliente) throws PersonaException{
        return modelFactory.addCliente(cliente);
    }

    public int removeCliente (Cliente cliente) throws PersonaException{
        return modelFactory.deleteCliente(cliente);
    }

    public boolean actualizarCliente (String cedula, Cliente cliente)throws PersonaException{
        return modelFactory.actualizarCliente(cedula, cliente);
    }

    public ArrayList<Cliente> obtenerClientes(){
        return modelFactory.obtenerClientes();
    }

    //Empleado
    public Empleado obtenerEmpleadoLogeado(){
        return modelFactory.obtenerEmpleadoLogeado();
    }

    //Vehículo
    public int removerVehiculo(Vehiculo vehiculo) throws VehiculoException {
        return modelFactory.deleteVehiculo(vehiculo);
    }

    //Sedan
    public int addSedan (Sedan sedan) throws VehiculoException{
        return modelFactory.addSedan(sedan);
    }

    public boolean actualizarSedan(String placa, Sedan sedan) throws VehiculoException{
        return modelFactory.actualizarSedan(placa, sedan);
    }

    public ArrayList<Sedan> obtenerSedans (){
        return modelFactory.obtenerSedans();
    }

    //Deportivo
    public int addDeportivo (Deportivo deportivo) throws VehiculoException{
        return modelFactory.addDeportivo(deportivo);
    }

    public boolean actualizarDeportivo(String placa, Deportivo deportivo) throws VehiculoException{
        return modelFactory.actualizarDeportivo(placa, deportivo);
    }

    public ArrayList<Deportivo> obtenerDeportivos(){
        return modelFactory.obtenerDeportivos();
    }

    //Moto
    public int addMoto (Moto moto) throws VehiculoException{
        return modelFactory.addMoto(moto);
    }

    public boolean actualizarMoto(String placa, Moto moto) throws VehiculoException{
        return modelFactory.actualizarMoto(placa, moto);
    }

    public ArrayList<Moto> obtenerMotos(){
        return modelFactory.obtenerMotos();
    }

    //Camioneta
    public int addCamioneta(Camioneta camioneta) throws VehiculoException{
        return modelFactory.addCamioneta(camioneta);
    }

    public boolean actualizarCamioneta(String placa, Camioneta camioneta) throws VehiculoException{
        return modelFactory.actualizarCamioneta(placa, camioneta);
    }

    public ArrayList<Camioneta> obtenerCamionetas(){
        return modelFactory.obtenerCamionetas();
    }

    //Pickup
    public int addPickUp(PickUps pickup) throws VehiculoException{
        return modelFactory.addPickUps(pickup);
    }

    public boolean actualizarPickUp(String placa, PickUps pickup) throws VehiculoException{
        return modelFactory.actualizarPickUps(placa,pickup);
    }

    public ArrayList<PickUps> obtenerPickups(){
        return modelFactory.obtenerPickUps();
    }

    //Van
    public int addVan(Vans van) throws VehiculoException{
        return modelFactory.addVans(van);
    }

    public boolean actualizarVan(String placa, Vans van) throws VehiculoException{
        return modelFactory.actualizarVans(placa,van);
    }

    public ArrayList<Vans> obtenerVan(){
        return modelFactory.obtenerVans();
    }

    //Bus
    public int addBus(Bus bus) throws VehiculoException{
        return modelFactory.addBuses(bus);
    }

    public boolean actualizarBus(String placa, Bus bus) throws VehiculoException{
        return modelFactory.actualizarBus(placa, bus);
    }

    public ArrayList<Bus> obtenerBuses(){
        return modelFactory.obtenerBuses();
    }

    //Camion
    public int addCamion(Camion camion) throws VehiculoException{
        return modelFactory.addCamiones(camion);
    }

    public boolean actualizarCamion(String placa, Camion camion) throws VehiculoException{
        return modelFactory.actualizarCamion(placa, camion);
    }

    public ArrayList<Camion> obtenerCamiones(){
        return modelFactory.obtenerCamiones();
    }

    //Venta
    public int addVenta(Venta venta) throws VehiculoException{
        return modelFactory.addVenta(venta);
    }

}
