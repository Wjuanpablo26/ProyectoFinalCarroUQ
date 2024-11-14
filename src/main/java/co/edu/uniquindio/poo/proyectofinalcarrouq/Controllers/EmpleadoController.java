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

    public boolean actualizarDeportivo(Deportivo deportivo){
        return this.modelFactory.actualizarDeportivo(deportivo);
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

    public boolean actualizarMoto(Moto moto) throws VehiculoException{
        return this.modelFactory.actualizarMoto(moto);
    }

    public ArrayList<Moto> obtenerMotos(){
        return this.modelFactory.obtenerMotos();
    }
}
