package co.edu.uniquindio.poo.proyectofinalcarrouq.Controllers;

import co.edu.uniquindio.poo.proyectofinalcarrouq.Exception.PersonaException;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Exception.VehiculoException;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Deportivo;

import java.util.ArrayList;

import com.uniquindio.carrouq.Model.Cliente;

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
        returns this.modelFactory.deleteCamioneta(camioneta);
    }

    public boolean actualizarCamioneta(String placa, Camioneta camioneta) throws VehiculoException{
        return this.modelFactory.actualizarCamioneta(placa, camioneta);
    }

    public ArrayList<Camioneta> obtenerCamionetas(){
        return this.modelFactory.obtenerCamionetas();
    }

    public int addPickUp(Pickup pickup) throws VehiculoException{
        return this.modelFactory.addPickUp(pickup);
    }

    public deletePickUp(PickUp pickup) throws VehiculoException{
        returns this.modelFactory.deletePickUp(pickup);
    }

    public boolean actualizarPickUp(String placa, PickUp pickup) throws VehiculoException{
        return this.modelFactory.actualizarPickup(pickup);
    }

    public ArrayList<PickUp> obtenerPicKups(){
        return this.modelFactory.obtenerPicKups());
    }

    public int addVan(Van van) throws VehiculoException{
        return this.modelFactory.addVan(van);
    }

    public deleteVan(Van van) throws VehiculoException{
        returns this.modelFactory.deleteVan(van);
    }

    public boolean actualizarVan(String placa, Van van) throws VehiculoException{
        return this.modelFactory.actualizarVan(van);
    }

    public ArrayList<Van> obtenerVan(){
        return this.modelFactory.obtenerVan();
    }


}
