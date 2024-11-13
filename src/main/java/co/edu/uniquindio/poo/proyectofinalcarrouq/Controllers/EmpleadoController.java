package co.edu.uniquindio.poo.proyectofinalcarrouq.Controllers;

import co.edu.uniquindio.poo.proyectofinalcarrouq.Exception.PersonaException;

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

}
