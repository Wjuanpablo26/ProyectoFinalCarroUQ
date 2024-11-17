package co.edu.uniquindio.poo.proyectofinalcarrouq.Controller;

import co.edu.uniquindio.poo.proyectofinalcarrouq.Exception.PersonaException;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Exception.VehiculoException;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Deportivo;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Cliente;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Camioneta;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Moto;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.PickUps;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Sedan;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Vans;



import java.util.ArrayList;


public class EmpleadoController {
    ModelFactory modelFactory = ModelFactory.getInstance();

    public EmpleadoController(){
    }

    public int addCliente(Cliente cliente) throws PersonaException{
        return this.modelFactory.addCliente(cliente);
    }

    public int removeCliente (Cliente cliente) throws PersonaException{
        return this.modelFactory.deleteCliente(cliente);
    }

    public boolean actualizarCliente (String cedula, Cliente cliente)throws PersonaException{
        return this.modelFactory.actualizarCliente(cedula, cliente);
    }

    public ArrayList<Cliente> obtenerClientes{
        return this.modelFactory.obtenerClientes();
    }

    public int addSedan (Sedan sedan) throws VehiculoException{
        return this.modelFactory.addSedan(sedan);
    }

    public int deleteSedan (Sedan sedan) throws VehiculoException{
        return this.modelFactory.deleteSedan(sedan);
    }

    public boolean actualizarSedan(String placa, Sedan sedan) throws VehiculoException{
        return this.modelFactory.actualizarSedan(placa, sedan);
    }

    public ArrayList<Sedan> obtenerSedans (){
        return this.modelFactory.obtenerSedans();
    }

    public int addDeportivo (Deportivo deportivo) throws VehiculoException{
        return this.modelFactory.addDeportivo(deportivo);
    }

    public int deleteDeportivo(Deportivo deportivo) throws VehiculoException{
        return this.modelFactory.deleteDeportivo(deportivo);
    }

    public boolean actualizarDeportivo(String placa, Deportivo deportivo){
        return this.modelFactory.actualizarDeportivo(placa, deportivo);
    }

    public ArrayList<Deportivo> obtenerDeportivos(){
        return this.modelFactory.obtenerDeportivos();
    }

    public int addMoto (Moto moto) throws VehiculoException{
        return this.modelFactory.addMoto;
    }

    public int deleteMoto (Moto moto) throws VehiculoException{
        return this.modelFactory.deleteMoto(moto);
    }

    public boolean actualizarMoto(String placa, Moto moto) throws VehiculoException{
        return this.modelFactory.actualizarMoto(placa, moto);
    }

    public ArrayList<Moto> obtenerMotos(){
        return this.modelFactory.obtenerMotos();
    }

    public int addCamioneta(Camioneta camioneta) throws VehiculoException{
        return this.modelFactory.addCamioneta(camioneta);
    }

    public deleteCamioneta(Camioneta camioneta) throws VehiculoException{
        return this.modelFactory.deleteCamioneta(camioneta);
    }

    public boolean actualizarCamioneta(String placa, Camioneta camioneta) throws VehiculoException{
        return this.modelFactory.actualizarCamioneta(placa, camioneta);
    }

    public ArrayList<Camioneta> obtenerCamionetas(){
        return this.modelFactory.obtenerCamionetas();
    }

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
    }


}
