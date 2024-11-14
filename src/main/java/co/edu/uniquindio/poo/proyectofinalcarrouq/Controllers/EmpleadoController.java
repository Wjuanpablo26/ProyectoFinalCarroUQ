package co.edu.uniquindio.poo.proyectofinalcarrouq.Controllers;

import co.edu.uniquindio.poo.proyectofinalcarrouq.Exception.PersonaException;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Exception.VehiculoException;

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

}
