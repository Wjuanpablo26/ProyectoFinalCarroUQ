package co.edu.uniquindio.poo.proyectofinalcarrouq.Controller;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Exception.PersonaException;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Exception.VehiculoException;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Deportivo;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Cliente;
<<<<<<< HEAD
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Admin;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Bus;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Camion;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Camioneta;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Moto;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Empleado;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.PickUps;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Sedan;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Vans;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Venta;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract.Vehiculo;
import java.net.CacheRequest;
=======
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Camioneta;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Moto;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.PickUps;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Sedan;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Vans;



>>>>>>> 47469de6156276320d9e3e89706564475efa64ad
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

    //Vehículo
    public int removerVehiculo(Vehiculo vehiculo) throws PersonaException{
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
        return modelFactory.addMoto;
    }

    public boolean actualizarMoto(String placa, Moto moto) throws VehiculoException{
        return modelFactory.actualizarMoto(placa, moto);
    }

    public ArrayList<Moto> obtenerMotos(){
        return modelFactory.obtenerMotos();
    }

    //Camioneta
    public int addCamioneta(Camioneta camioneta) throws VehiculoException{
<<<<<<< HEAD
        return modelFactory.addCamioneta(camioneta);
=======
        return this.modelFactory.addCamioneta(camioneta);
    }

    public deleteCamioneta(Camioneta camioneta) throws VehiculoException{
        return this.modelFactory.deleteCamioneta(camioneta);
>>>>>>> 47469de6156276320d9e3e89706564475efa64ad
    }

    public boolean actualizarCamioneta(String placa, Camioneta camioneta) throws VehiculoException{
        return modelFactory.actualizarCamioneta(placa, camioneta);
    }

    public ArrayList<Camioneta> obtenerCamionetas(){
        return modelFactory.obtenerCamionetas();
    }

<<<<<<< HEAD
    //Pickup
    public int addPickUp(PickUps pickup) throws VehiculoException{
        return modelFactory.addPickUp(pickup);
    }

    public boolean actualizarPickUp(String placa, PickUps pickup) throws VehiculoException{
        return modelFactory.actualizarPickup(pickup);
    }

    public ArrayList<PickUps> obtenerPicKups(){
        return modelFactory.obtenerPicKups();
    }

    //Van
    public int addVan(Vans van) throws VehiculoException{
        return modelFactory.addVan(van);
    }

    public boolean actualizarVan(String placa, Vans van) throws VehiculoException{
        return modelFactory.actualizarVan(van);
    }

    public ArrayList<Vans> obtenerVan(){
        return modelFactory.obtenerVan();
    }

    //Bus
    public int addBus(Bus bus) throws VehiculoException{
        return modelFactory.addBus(bus);
    }

    public boolean actualizarBus(String placa, Bus bus) throws VehiculoException{
        return modelFactory.actualizarBus(placa, bus);
=======
    public int addPickUp(Pickups Pickups) throws VehiculoException{
        return this.modelFactory.addPickUp(Pickups);
    }

    public deletePickUp(PickUps pickups) throws VehiculoException{
        return this.modelFactory.deletePickUp(pickups);
    }

    public boolean actualizarPickUp(String placa, PickUps pickups) throws VehiculoException{
        return this.modelFactory.actualizarPickup(pickups);
    }

    public ArrayList<PickUps> obtenerPicKups(){
        return this.modelFactory.obtenerPicKups();
    }

    public int addVan(Vans vans) throws VehiculoException{
        return this.modelFactory.addVan(vans);
    }

    public deleteVan(Vans vans) throws VehiculoException{
        return this.modelFactory.deleteVan(vans);
    }

    public boolean actualizarVan(String placa, Vans vans) throws VehiculoException{
        return this.modelFactory.actualizarVan(vans);
    }

    public ArrayList<Vans> obtenerVan(){
        return this.modelFactory.obtenerVan();
>>>>>>> 47469de6156276320d9e3e89706564475efa64ad
    }

    public ArrayList<Bus> obtenerBuses(){
        return modelFactory.obtenerBuses();
    }

    //Camion
    public int addCamion(Camion camion) throws VehiculoException{
        return modelFactory.addCamion(camion);
    }

    public boolean actualizarCamion(String placa, Camion camion) throws VehiculoException{
        return modelFactory.actualizarCamion(placa, camion);
    }

    public ArrayList<Camion> obtenerCamiones(){
        return modelFactory.obtenerCamiones();
    }

    //Venta
    public int addVenta(Venta venta) throws VehiculoException{
        return modelFactory.addventa(venta);
    }

}
