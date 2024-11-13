package co.edu.uniquindio.poo.proyectofinalcarrouq.Model;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Exception.PersonaException;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Exception.VehiculoException;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract.Persona;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract.Vehiculo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;


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
    
    public void addPersona(Persona persona)throws PersonaException{
        if(persona == null){
            throw new PersonaException("La persona no puede ser nula");
        }else if (persona instanceof Cliente){
            Cliente cliente = (Cliente) persona;
            listaClientes.add(cliente);
        }else if (persona instanceof Empleado){
            Empleado empleado = (Empleado) persona;
            listaEmpleados.add(empleado);
        }else if (persona instanceof Admin){
            Admin admin = (Admin) persona;
            listaAdmins.add(admin);
        }else{
            throw new PersonaException("Tipo de persona no valido");
        }
    }

    //Metodo para eliminar Persona (Cliente, Empleado, Admin)
    public void removePersona(Persona persona)throws PersonaException{
        if(persona == null){
            throw new PersonaException("La persona no puede ser nula");
        }else if (persona instanceof Cliente){
            Cliente cliente = (Cliente) persona;
            listaClientes.remove(cliente);
        }else if (persona instanceof Empleado){
            Empleado empleado = (Empleado) persona;
            listaEmpleados.remove(empleado);
        }else if (persona instanceof Admin){
            Admin admin = (Admin) persona;
            listaAdmins.remove(admin);
        }else{
            throw new PersonaException("Tipo de persona no valido");
        }
    }

    //Metodo para saber si una persona existe
    public boolean personaExiste(String correo,String cedula){
        if(!correoExiste(correo)){
            if(!cedulaExiste(cedula)){
                return true;
            }
        }
        return false;
    }

    //Metodo para saber si un correo existe
    public boolean correoExiste(String correo){
        return Stream.of(listaAdmins,listaClientes,listaEmpleados)
        .flatMap(Collection::stream).anyMatch(persona -> persona.getCorreo().equalsIgnoreCase(correo));
    }

    //Metodo para saber si una cedula existe
    public boolean cedulaExiste(String cedula){
        return Stream.of(listaAdmins,listaClientes,listaEmpleados)
        .flatMap(Collection::stream).anyMatch(persona -> persona.getCedula().equalsIgnoreCase(cedula));
    }

    //Metodos de Logeo de Empleado y Admin
    public int autentificacion(String username,String password){
        if (logeoEmpleado(username,password)){
            return 1;
        }else if (logeoAdmin(username,password)){
            return 2;
        }else{
            return 0;
        }
    }

    //Metodo de logeo de Empleado
    public boolean logeoEmpleado(String username,String password){
        for(Empleado empleado: listaEmpleados){
            if(empleado.getUserName().getUsername().equals(username)|| empleado.getCorreo().equals(username)){
                return empleado.getUserName().getPassword().equals(password)? true:false;
            }
        }
        return false;
    }

    //Metodo de logeo de Admin
    public boolean logeoAdmin(String username,String password){
        for(Admin admin: listaAdmins){
            if(admin.getUserName().getUsername().equals(username)|| admin.getCorreo().equals(username)){
                return admin.getUserName().getPassword().equals(password)? true:false;
            }
        }
        return false;
    }

    //Metodo para obtener los empleados
    public ArrayList<Empleado> obtenerEmpleados(){
        return listaEmpleados;
    }

    //Metodo para obtener el empleado por cedula
    public Empleado obtenerEmpleadoCedula(String cedula){
        return listaEmpleados.stream().filter(empleado -> empleado.getCedula().equalsIgnoreCase(cedula)).findFirst().get();
    }

    //Metodo para obtener el empleado por UserName
    public Empleado obtenerEmpleadoUsername(String username,String password){
        return listaEmpleados.stream().filter(
                empleado -> empleado.getCorreo().equals(username)||
                    empleado.getUserName().getUsername().equalsIgnoreCase(username)
                    && empleado.getUserName().getPassword().equals(password)).findFirst().get();
    }

    //Metodo para actualizar el empleado
    public void actualizarEmpleado(String cedula, Empleado empleadoActualizado){
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getCedula().equals(cedula)) {
                listaEmpleados.set(listaEmpleados.indexOf(empleado), empleadoActualizado);
                break;
            }
        }
    }

    //Metodo para obtener los Clientes
    public ArrayList<Cliente> obtenerClientes(){
        return listaClientes;
    }

    //Metodo para obtener el cliente por cedula
    public Cliente obtenerClienteCedula(String cedula){
        return listaClientes.stream()
                .filter(cliente -> cliente.getCedula().equalsIgnoreCase(cedula))
                .findFirst()
                .orElse(null);
    }

    //Metodo para actualizar el cliente
    public void actualizarCliente(String cedula, Cliente clienteActualizado) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                listaClientes.set(listaClientes.indexOf(cliente), clienteActualizado);
                break;
            }
        }
    }

    //Metodo para obtener los Admins
    public ArrayList<Admin> obtenerAdmins(){
        return listaAdmins;
    }

    //Metodo para obtener el admin por cedula
    public Admin obtenerAdminCedula(String cedula) {
        return listaAdmins.stream()
                .filter(admin -> admin.getCedula().equalsIgnoreCase(cedula))
                .findFirst()
                .orElse(null);
    }

    //Metodo para obtener el admin por UserName
    public Admin obtenerAdminUsername(String username,String password){
        return listaAdmins.stream()
                .filter(admin -> admin.getCorreo().equals(username)||
                        admin.getUserName().getUsername().equalsIgnoreCase(username)
                            && admin.getUserName().getPassword().equals(password))
                        .findFirst()
                        .orElse(null);
    }

    //Metodo para actualizar el admin
    public void actualizarAdmin(String cedula, Admin adminActualizado) {
        for (Admin admin : listaAdmins) {
            if (admin.getCedula().equals(cedula)) {
                listaAdmins.set(listaAdmins.indexOf(admin), adminActualizado);
                break;
            }
        }
    }

    //metodo para agregar vehiculo
    public void addVehiculo(Vehiculo vehiculo)throws VehiculoException{
        if (vehiculo == null){
            throw new VehiculoException("El vehiculo no puede ser nulo");
        }else if (vehiculo instanceof Sedan){
            Sedan sedan = (Sedan) vehiculo;
            listaSedanes.add(sedan);
        }else if (vehiculo instanceof Moto){
            Moto moto = (Moto) vehiculo;
            listaMotos.add(moto);
        }else if (vehiculo instanceof Deportivo){
            Deportivo deportivo = (Deportivo) vehiculo;
            listaDeportivos.add(deportivo);
        }else if (vehiculo instanceof Bus){
            Bus bus = (Bus) vehiculo;
            listaBuses.add(bus);
        }else if (vehiculo instanceof Camion){
            Camion camion = (Camion) vehiculo;
            listaCamiones.add(camion);
        }else if (vehiculo instanceof Camioneta){
            Camioneta camioneta = (Camioneta) vehiculo;
            listaCamionetas.add(camioneta);
        }else if (vehiculo instanceof Vans){
            Vans vans = (Vans) vehiculo;
            listaVans.add(vans);
        }else if (vehiculo instanceof PickUps){
            PickUps pickUps = (PickUps) vehiculo;
            listaPickUps.add(pickUps);
        }else{
            throw new VehiculoException("Tipo de vehiculo no encontrado");
        }
    }

    //metodo para remover vehiculo
    public void removerVehiculo(Vehiculo vehiculo) throws VehiculoException {
        if (vehiculo == null){
            throw new VehiculoException("Vehiculo Nulo");
        } else if (vehiculo instanceof Sedan){
            Sedan sedan = (Sedan) vehiculo;
            if(!listaSedanes.remove(sedan)) {
                throw new VehiculoException("Vehiculo no encontrado en la lista de sedanes");
            }
        } else if (vehiculo instanceof Moto) {
            Moto moto = (Moto) vehiculo;
            if (!listaMotos.remove(moto)) {
                throw new VehiculoException("Vehiculo no encontrado en la lista de motos");
            }
        } else if (vehiculo instanceof Deportivo) {
            Deportivo deportivo = (Deportivo) vehiculo;
            if(!listaDeportivos.remove(deportivo)) {
                throw new VehiculoException("vehiculo no encontrado en la lista de deportivos");
            }
        } else if (vehiculo instanceof Camioneta) {
            Camioneta camioneta = (Camioneta) vehiculo;
            if(!listaCamionetas.remove(camioneta)){
                throw new VehiculoException("vehiculo no encontrado en la lista de camionetas");
            }
        } else if (vehiculo instanceof PickUps) {
            PickUps pickUps = (PickUps) vehiculo;
            if(!listaPickUps.remove(pickUps)){
                throw new VehiculoException("vehiculo no encontrado en la lista de PickUps");
            }
        } else if (vehiculo instanceof Vans) {
            Vans vans = (Vans) vehiculo;
            if(!listaVans.remove(vans)){
                throw new VehiculoException("vehiculo no encontrado en la lista de vans");
            }
        } else if (vehiculo instanceof Bus) {
            Bus bus = (Bus) vehiculo;
            if(!listaBuses.remove(bus)){
                throw new VehiculoException("vehiculo no encontrado en la lista de camionetas");
            }
        } else if (vehiculo instanceof Camion) {
            Camion camion = (Camion) vehiculo;
            if(!listaCamiones.remove(camion)){
                throw new VehiculoException("vehiculo no encontrado en la lista de camiones");
            }
        } else {
            throw new VehiculoException("vehiculo no encontrado");
        }}
    

    //metodo para actualizar vehiculo
    public void actualizarVehiculo(Vehiculo vehiculo){
        if (vehiculo != null){
            if (vehiculo instanceof Sedan){
                Sedan sedan = (Sedan) vehiculo;
                listaSedanes.set(listaSedanes.indexOf(sedan),sedan);
            } else if (vehiculo instanceof Moto) {
                Moto moto = (Moto) vehiculo;
                listaMotos.set(listaMotos.indexOf(moto), moto);
            } else if (vehiculo instanceof Deportivo) {
                Deportivo deportivo = (Deportivo) vehiculo;
                listaDeportivos.set(listaDeportivos.indexOf(deportivo), deportivo);
            } else if (vehiculo instanceof Camioneta) {
                Camioneta camioneta = (Camioneta) vehiculo;
                listaCamionetas.set(listaCamionetas.indexOf(camioneta), camioneta);
            } else if (vehiculo instanceof PickUps) {
                PickUps pickUps = (PickUps) vehiculo;
                listaPickUps.set(listaPickUps.indexOf(pickUps), pickUps);
            } else if (vehiculo instanceof Vans) {
                Vans vans = (Vans) vehiculo;
                listaVans.set(listaVans.indexOf(vans), vans);
            } else if (vehiculo instanceof Bus) {
                Bus bus = (Bus) vehiculo;
                listaBuses.set(listaBuses.indexOf(bus), bus);
            }
        }
    }
}
