package co.edu.uniquindio.poo.proyectofinalcarrouq.Controller;

import java.util.ArrayList;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Exception.PersonaException;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Exception.VehiculoException;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.*;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract.Persona;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract.Vehiculo;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Utils.Persistencia;

import java.io.IOException;


public class ModelFactory {

    Concesionario concesionario;
    private Admin admin;
    private Empleado empleado;

    private static class SingletonHolder{
        private static final ModelFactory INSTANCE;

        static{
            try{
                INSTANCE = new ModelFactory();
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }
    }

    public static ModelFactory getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public Concesionario getConcesionario(){
        return concesionario;
    }

    public ModelFactory() throws PersonaException{
        concesionario = new Concesionario();
        System.out.printf("Concesionario creado");
        cargarDatos();
    }

    //Método Logging
    public int autentificacion(String username, String password){
        switch (concesionario.autentificacion(username, password)) {
            case 1:
                
                empleado= concesionario.obtenerEmpleadoUsername(username, password);
                System.out.println("\nEl empleado con CC: " +empleado.getCedula()+" ingreso");
                return 1;

            case 2:
                admin = concesionario.obtenerAdminUsername(username, password);
                System.out.println("\nEl admin con CC: "+admin.getCedula()+" ingreso");
                return 2;
        
            default:
                return 0;
        }
    }

    public void recuperar(String correo, String cedula){
        Persona persona = concesionario.buscarPersona(correo, cedula);
        if (persona != null){
            if ( persona instanceof Empleado){
                Empleado empleado = (Empleado) persona;
                System.out.println("Username Empleado: "+ empleado.getUserName().getUsername());
                System.out.println("Password Empleado: "+ empleado.getUserName().getPassword());
            } else if (persona instanceof Admin){
                Admin admin = (Admin) persona;
                System.out.println("Username Admin: "+ admin.getUserName().getUsername());
                System.out.println("Password Amin: "+ admin.getUserName().getUsername());
            }

        } else{
            System.out.println("Persona no encontrada");
        }
    }

    //Métodos del Empleado
    public int addEmpleado(Empleado empleado) throws PersonaException{
        if (empleado != null){
            concesionario.removePersona(empleado);
            salvarDatos();
            return 1;
        }else{
        return 2;}
    }

    public int deleteEmpleado(Empleado empleado) throws PersonaException {
        if (empleado != null) {
            concesionario.removePersona(empleado);
            salvarDatos();
            return 1;
        }else{
        return 2;}}

    public boolean actualizarEmpleado(String cedula, Empleado empleado) throws PersonaException{
        if (empleado != null){
            concesionario.actualizarEmpleado(cedula, empleado);
            salvarDatos();
            return true;
        }else{
            return false; }
    }

    public ArrayList<Empleado> obtenerEmpleados(){
        return concesionario.obtenerEmpleados();
    }

    public Empleado obtenerEmpleadoLogeado(){
        return empleado;
    }

    //Métodos del Cliente
    public int addCliente(Cliente cliente) throws PersonaException{
        if(concesionario.personaExiste(cliente.getCorreo(), cliente.getCedula())){
            concesionario.addPersona(cliente);
            salvarDatos();
            return 1;
        }else{
            return 2;
        }
    }

    public int deleteCliente(Cliente cliente) throws PersonaException{
        if (cliente != null){
            concesionario.removePersona(cliente);
            salvarDatos();
            return 1;
        }else{
            return 2;
        }
    }

    public boolean actualizarCliente(String cedula, Cliente cliente) throws PersonaException{
        if (cliente != null){
            concesionario.actualizarCliente(cedula, cliente);
            salvarDatos();
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<Cliente> obtenerClientes(){
        return concesionario.obtenerClientes();
    }

    //Métodos del Admin
    public int addAdmin(Admin admin) throws PersonaException{
        if (concesionario.personaExiste(admin.getCorreo(), admin.getCedula())){
            concesionario.addPersona(admin);
            salvarDatos();
            return 1;
        }else{
        return 2;
        }
    }

    public int deleteAdmin(Admin admin) throws PersonaException{
        if (admin != null){
            concesionario.removePersona(admin);
            salvarDatos();
            return 1;
        }else{
            return 2;
        }
    }

    public boolean actualizarAdmin(String cedula, Admin admin) throws PersonaException{
        if (admin != null){
            concesionario.actualizarAdmin(cedula, admin);
            salvarDatos();
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<Admin> obtenerAdmins(){
        return concesionario.obtenerAdmins();
    }

    //Métodos del Vehiculo
    public int deleteVehiculo(Vehiculo vehiculo) throws VehiculoException{
        if (vehiculo != null){
            concesionario.removeVehiculo(vehiculo);
            salvarDatos();
            return 1;
        }else{
            return 2;
        }
    }

    //Métodos del Sedan
    public int addSedan(Sedan sedan) throws VehiculoException{
        if (sedan != null){
            if (!concesionario.carroExiste(sedan.getPlaca())){
                concesionario.addVehiculo(sedan);
                return 1;
            }else{
                return 2;
            }
        }else{
            return 0;
        }
    }

    public boolean actualizarSedan(String placa, Sedan sedan) throws VehiculoException{
        if (sedan != null){
            concesionario.actualizarSedan(placa, sedan);
            salvarDatos();
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<Sedan> obtenerSedans(){
        return concesionario.obtenerSedans();
    }

    //Métodos de la Moto
    public int addMoto(Moto moto) throws VehiculoException{
        if(moto != null){
            if(!concesionario.carroExiste(moto.getPlaca())){
                concesionario.addVehiculo(moto);
                return 1;
            }else{
                return 2;
            }
        } else{
            return 0;
        }
    }

    public boolean actualizarMoto(String placa, Moto moto) throws VehiculoException{
        if(moto!= null){
            concesionario.actualizarMoto(placa, moto);
            salvarDatos();
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<Moto> obtenerMotos(){
        return concesionario.obtenerMotos();
    }

    //Métodos del Deportivo
    public int addDeportivo(Deportivo deportivo) throws VehiculoException{
        if(deportivo!= null){
            if (concesionario.carroExiste(deportivo.getPlaca())){
                concesionario.addVehiculo(deportivo);
                salvarDatos();
                return 1;
            }else{
                return 2;
            }
        }else{
            return 0;
        }
    }

    public boolean actualizarDeportivo(String placa, Deportivo deportivo) throws VehiculoException{
        if(deportivo!= null){
            concesionario.actualizarDeportivo(placa, deportivo);
            salvarDatos();
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<Deportivo> obtenerDeportivos(){
        return concesionario.obtenerDeportivos();
    }

    //Métodos de las Camionetas
    public int addCamioneta(Camioneta camioneta) throws VehiculoException{
        if(camioneta !=null){
            if(!concesionario.carroExiste(camioneta.getPlaca())){
                concesionario.addVehiculo(camioneta);
                salvarDatos();
                return 1;
            }else{
                return 2;
            }
        }else{
            return 0;
        }
    }

    public boolean actualizarCamioneta(String placa, Camioneta camionetas) throws VehiculoException {
        if (camionetas != null) {
            concesionario.actualizarCamioneta(placa, camionetas);
            salvarDatos();
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Camioneta> obtenerCamionetas(){
        return concesionario.obtenerCamionetas();
    }

    //Métodos del PickUps
    public int addPickUps(PickUps pickUps) throws VehiculoException{
        if (pickUps!= null){
            if(!concesionario.carroExiste(pickUps.getPlaca())){
                concesionario.addVehiculo(pickUps);
                salvarDatos();
                return 1;
            }else{
                return 2;
            }
        }else{
            return 0;
        }
    }

    public boolean actualizarPickUps(String placa, PickUps pickUps) throws VehiculoException {
        if (pickUps != null) {
            concesionario.actualizarPickUp(placa, pickUps);
            salvarDatos();
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<PickUps> obtenerPickUps(){
        return concesionario.obtenerPickUps();
    }

    //Métodos de las Vans
    public int addVans(Vans vans) throws VehiculoException{
        if(vans != null){
            if(!concesionario.carroExiste(vans.getPlaca())){
                concesionario.addVehiculo(vans);
                salvarDatos();
                return 1;
            }else{
                return 2;
            }
        }else{
            return 0;
        }
    }

    public boolean actualizarVans(String placa, Vans vans) throws VehiculoException {
        if (vans != null) {
            concesionario.actualizarVans(placa, vans);
            salvarDatos();
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Vans> obtenerVans(){
        return concesionario.obtenerVans();
    }

    //Métodos de los Buses
    public int addBuses(Bus buses) throws VehiculoException {
        if (buses != null) {
            if (!concesionario.carroExiste(buses.getPlaca())) {
                concesionario.addVehiculo(buses);
                salvarDatos();
                return 1;
            } else {
                return 2;
            }
        } else {
            return 0;
        }
    }

    public boolean actualizarBus(String placa, Bus bus) throws VehiculoException {
        if (bus != null) {
            concesionario.actualizarBus(placa, bus);
            salvarDatos();
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Bus> obtenerBuses(){
        return concesionario.obtenerBuses();
    }

    //Métodos de los Camiones
    public int addCamiones(Camion camion)throws VehiculoException{
        if (camion!=null){
            if(!concesionario.carroExiste(camion.getPlaca())){
                concesionario.addVehiculo(camion);
                salvarDatos();
                return 1;
            }else{
                return 2;
            }
        }else{
            return 0;
        }
    }

    public boolean actualizarCamion(String placa, Camion camion) throws VehiculoException{
        if (camion != null) {
            concesionario.actualizarCamion(placa, camion);
            salvarDatos();
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Camion> obtenerCamiones(){
        return concesionario.obtenerCamiones();
    }

     //Métodos de las Ventas
    public int addVenta(Venta venta) throws VehiculoException {
        if (venta != null){
            concesionario.agregarVenta(venta);
            salvarDatos();
            return 1;
        }else{
            return 0;
        }
    }

    public int deleteVenta(Venta venta) throws VehiculoException {
        if (venta != null){
            concesionario.deleteVenta(venta);
            salvarDatos();
            return 1;
        }else{
            return 0;
        }
    }

    public boolean actualizarVenta(String codigo, Venta venta) throws VehiculoException {
        if (venta != null) {
            concesionario.actualizarVenta(codigo, venta);
            salvarDatos();
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Venta> obtenerVentasEmpleado(String cedula){
        return concesionario.obtenerVentasPorEmpleado(cedula);
    }

    //Metodos de la persistencia para salvar los datos
    public void salvarDatos(){
        try {
            Persistencia.guardarEmpleados(getConcesionario().obtenerEmpleados());
            Persistencia.guardarAdministradores(getConcesionario().obtenerAdmins());
            Persistencia.guardarClientes(getConcesionario().obtenerClientes());
            Persistencia.guardarSedanes(getConcesionario().obtenerSedans());
            Persistencia.guardarMotos(getConcesionario().obtenerMotos());
            Persistencia.guardarDeportivos(getConcesionario().obtenerDeportivos());
            Persistencia.guardarCamionetas(getConcesionario().obtenerCamionetas());
            Persistencia.guardarPickUps(getConcesionario().obtenerPickUps());
            Persistencia.guardarVans(getConcesionario().obtenerVans());
            Persistencia.guardarBuses(getConcesionario().obtenerBuses());
            Persistencia.guardarCamiones(getConcesionario().obtenerCamiones());
            Persistencia.guardarVentas(getConcesionario().obtenerVentas());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Metodo de la persistencia para cargar los datos
    public void cargarDatos(){

        try {
            getConcesionario().getListaEmpleados().addAll(Persistencia.cargarEmpleados());
            getConcesionario().getListaAdmins().addAll(Persistencia.cargarAdministradores());
            getConcesionario().getListaClientes().addAll(Persistencia.cargarClientes());
            getConcesionario().getListaSedanes().addAll(Persistencia.cargarSedanes());
            getConcesionario().getListaMotos().addAll(Persistencia.cargarMotos());
            getConcesionario().getListaDeportivos().addAll(Persistencia.cargarDeportivos());
            getConcesionario().getListaCamionetas().addAll(Persistencia.cargarCamionetas());
            getConcesionario().getListaPickUps().addAll(Persistencia.cargarPickUps());
            getConcesionario().getListaVans().addAll(Persistencia.cargarVans());
            getConcesionario().getListaBuses().addAll(Persistencia.cargarBuses());
            getConcesionario().getListaCamiones().addAll(Persistencia.cargarCamiones());
            ArrayList<Vehiculo> vehiculosUnificadas = new ArrayList<>();
            vehiculosUnificadas.addAll(getConcesionario().obtenerSedans());
            vehiculosUnificadas.addAll(getConcesionario().obtenerCamiones());
            vehiculosUnificadas.addAll(getConcesionario().obtenerVans());
            vehiculosUnificadas.addAll(getConcesionario().obtenerBuses());
            vehiculosUnificadas.addAll(getConcesionario().obtenerCamionetas());
            vehiculosUnificadas.addAll(getConcesionario().obtenerPickUps());
            vehiculosUnificadas.addAll(getConcesionario().obtenerDeportivos());
            vehiculosUnificadas.addAll(getConcesionario().obtenerMotos());
            getConcesionario().getListaVentas().addAll(Persistencia.cargarVentas(obtenerClientes(),vehiculosUnificadas,obtenerEmpleados()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
