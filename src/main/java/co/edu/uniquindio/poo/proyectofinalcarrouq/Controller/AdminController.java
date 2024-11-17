package co.edu.uniquindio.poo.proyectofinalcarrouq.Controller;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Admin;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Venta;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Exception.PersonaException;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Empleado;;
import java.util.ArrayList;


public class AdminController {

    ModelFactory modelFactory;

    public AdminController() {
        modelFactory = ModelFactory.getInstance();
    }

    //Empleado
    public int addEmpleado(Empleado empleado) throws PersonaException {
        return modelFactory.addEmpleado(empleado);
    }

    public int removeEmpleado(Empleado empleado) throws PersonaException {
        return modelFactory.deleteEmpleado(empleado);
    }

    public boolean actualizarEmpleado(String cedula,Empleado empleado) throws PersonaException {
        return modelFactory.actualizarEmpleado(cedula, empleado);
    }

    public ArrayList<Empleado> obtenerEmpleados() {
        return modelFactory.obtenerEmpleados();
    }

    //Admin
    public int addAdmin(Admin admin) throws PersonaException {
        return modelFactory.addAdmin(admin);
    }

    public int removeAdmin(Admin admin) throws PersonaException {
        return modelFactory.deleteAdmin(admin);
    }

    public boolean actualizarAdmin(String cedula,Admin admin) throws PersonaException {
        return modelFactory.actualizarAdmin(cedula, admin);
    }

    public ArrayList<Admin> obtenerAdmins() {
        return modelFactory.obtenerAdmins();
    }

    //Ventas
    public ArrayList<Venta> obtenerVentasEmpleado(String cedula){
        return modelFactory.obtenerVentasEmpleado(cedula);
    }


}