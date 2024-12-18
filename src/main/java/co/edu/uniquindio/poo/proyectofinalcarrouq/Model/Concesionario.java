package co.edu.uniquindio.poo.proyectofinalcarrouq.Model;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Exception.PersonaException;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Exception.VehiculoException;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract.Persona;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract.Vehiculo;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoTransaccion;

import java.util.List;
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

    //Metodo para buscar una persona por cedula y correo
    public Persona buscarPersona(String cedula,String correo) {
        // Buscar en listaEmpleados
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getCedula().equals(cedula) && empleado.getCorreo().equals(correo)) {
                return empleado;
            }
        }

        // Buscar en listaAdmin
        for (Admin asociado : listaAdmins) {
            if (asociado.getCedula().equals(cedula) && correo.equals(asociado.getCorreo())) {
                return asociado;
            }
        }

        // Si no se encontró en ninguna lista, retorna null
        return null;
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

    // Método para obtener las ventas de un empleado específico según la cédula
    public ArrayList<Venta> obtenerVentasPorEmpleado(String cedulaEmpleado) {
        ArrayList<Venta> ventasEmpleado = new ArrayList<>();

        for (Venta venta : listaVentas) {
            if (venta.getEmpleado().getCedula().equals(cedulaEmpleado)) {
                ventasEmpleado.add(venta);
            }
        }
        return ventasEmpleado;
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
    public void removeVehiculo(Vehiculo vehiculo) throws VehiculoException {
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

    //metodo para saber si un vehiculo existe
    public boolean carroExiste(String placa){
        return Stream.of(listaSedanes, listaMotos, listaDeportivos, listaCamionetas, listaPickUps, listaVans, listaBuses, listaCamiones)
                .flatMap(Collection::stream).anyMatch(persona-> persona.getPlaca().equalsIgnoreCase(placa));
    }

    //metodo para encontrar un vehiculo
    public Vehiculo encontrarVehiculo(String placa){
        return Stream.of(listaSedanes, listaMotos, listaDeportivos, listaCamionetas, listaPickUps, listaVans, listaBuses, listaCamiones)
                .flatMap(Collection::stream)
                .filter(vehiculo -> vehiculo.getPlaca().equalsIgnoreCase(placa)) //filtrar por placa
                .findFirst()//obtener el primer elemento encontrado
                .orElse(null);//si no se encuentra, retorna null
    }

    
    //Metodo para obtener los sedanes
    public ArrayList<Sedan> obtenerSedans(){
        return listaSedanes;
    }

    //Metodo para actualizar el sedan
    public void actualizarSedan(String placa, Sedan sedanActualizado){
        for(Sedan sedan : listaSedanes){
            if(sedan.getPlaca().equals(placa)) {
                listaSedanes.set(listaSedanes.indexOf(sedan), sedanActualizado);
                break;}}}

    //Metodo para encontrar un sedan
    public Sedan encontrarSedan(String placa){
        return listaSedanes.stream()
                .filter(sedan -> sedan.getPlaca().equalsIgnoreCase(placa))
                .findFirst().orElse(null);}

    
    //Metodo para obtener las motos
    public ArrayList<Moto> obtenerMotos(){
        return listaMotos;
    }

    //Metodo para actualizar la moto
    public void actualizarMoto(String placa, Moto motoActualizado){
        for(Moto moto : listaMotos){
            if(moto.getPlaca().equals(placa)){
                listaMotos.set(listaMotos.indexOf(moto), motoActualizado);
                break;}}}
    

    //Metodo para encontrar una moto
    public Moto encontrarMoto(String placa){
        return listaMotos.stream()
                .filter(moto -> moto.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);}
    

    //Metodo para obtener los deportivos

    public ArrayList<Deportivo> obtenerDeportivos(){
        return listaDeportivos;
    }

    //Metodo para actualizar el deportivo
    public void actualizarDeportivo(String placa, Deportivo deportivoActualizado){
        for(Deportivo deportivo : listaDeportivos){
            if(deportivo.getPlaca().equals(placa)){
                listaDeportivos.set(listaDeportivos.indexOf(deportivo), deportivoActualizado);
                break;}}}
    

    //Metodo para encontrar un deportivo
    public Deportivo encontrarDeportivo(String placa){
        return listaDeportivos.stream()
                .filter(deportivo -> deportivo.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);}


    
    //Metodo para obtener las camionetas
    public ArrayList<Camioneta> obtenerCamionetas(){
        return listaCamionetas;
    }

    //Metodo para actualizar la camioneta
    public void actualizarCamioneta(String placa, Camioneta camionetaActualizado){
        for(Camioneta camioneta : listaCamionetas){
            if(camioneta.getPlaca().equals(placa)){
                listaCamionetas.set(listaCamionetas.indexOf(camioneta), camionetaActualizado);
                break;}}}
    

    //Metodo para encontrar una camioneta
    public Camioneta encontrarCamioneta(String placa){
        return listaCamionetas.stream()
                .filter(camioneta -> camioneta.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);}


    //Metodo para obtener los PickUps
    public ArrayList<PickUps> obtenerPickUps(){
        return listaPickUps;
    }

    //Metodo para actualizar el PickUp
    public void actualizarPickUp(String placa, PickUps pickUpActualizada){
        for(PickUps pickUp : listaPickUps){
            if(pickUp.getPlaca().equals(placa)){
                listaPickUps.set(listaPickUps.indexOf(pickUp), pickUpActualizada);
                break;}}}
    
    //Metodo para encontrar un PickUp
    public PickUps encontrarPickUp(String placa){
        return listaPickUps.stream()
                .filter(pickUp -> pickUp.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);}


    //Metodo para obtener las Vans
    public ArrayList<Vans> obtenerVans(){
        return listaVans;
    }

    //Metodo para actualizar la Van
    public void actualizarVans(String placa, Vans vanActualizada){
        for(Vans vans : listaVans){
            if(vans.getPlaca().equals(placa)){
                listaVans.set(listaVans.indexOf(vans), vanActualizada);
                break;}}}
    
    //Metodo para encontrar una Van
    public Vans encontrarVans(String placa){
        return listaVans.stream()
                .filter(vans -> vans.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);}

    //Metodo para obtener los Buses

    public ArrayList<Bus> obtenerBuses(){
        return listaBuses;
    }

    //Metodo para actualizar el Bus
    public void actualizarBus(String placa, Bus busActualizado){
        for(Bus bus : listaBuses){
            if(bus.getPlaca().equals(placa)){
                listaBuses.set(listaBuses.indexOf(bus), busActualizado);
                break;}}}
    
    //Metodo para encontrar un Bus
    public Bus encontrarBus(String placa){
        return listaBuses.stream()
                .filter(bus -> bus.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);}


    //Metodo para obtener los Camiones

    public ArrayList<Camion> obtenerCamiones(){
        return listaCamiones;
    }

    //Metodo para actualizar el Camion
    public void actualizarCamion(String placa, Camion camionActualizado){
        for(Camion camion : listaCamiones){
            if(camion.getPlaca().equals(placa)){
                listaCamiones.set(listaCamiones.indexOf(camion), camionActualizado);
                break;}}}
    
    //Metodo para encontrar un Camion
    public Camion encontrarCamion(String placa){
        return listaCamiones.stream()
                .filter(camion -> camion.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);}
    

    //Metodo para agregar una venta

    public void agregarVenta(Venta venta) throws VehiculoException{
        if(venta != null){
            listaVentas.add(venta);
            Vehiculo vehiculo = venta.getVehiculo();
            actualizarVehiculo(vehiculo);
        }else{
            throw new VehiculoException("la venta no puede ser nula");
        }
    }

    //Metodo para eliminar una venta
    public void deleteVenta(Venta venta) throws VehiculoException {
        if(!venta.getTipoTransaccion().equals(TipoTransaccion.VENTA)){
            listaVentas.remove(venta);
            Vehiculo vehiculo = venta.getVehiculo();
            actualizarVehiculo(vehiculo);
        }else{
            throw new VehiculoException("la venta no puede ser borrada");
        }
    }

    //Metodo para actualizar una venta
    public void actualizarVenta(String id, Venta ventaActualizada) throws VehiculoException{
        if(!ventaActualizada.getTipoTransaccion().equals(TipoTransaccion.VENTA)){
            for(Venta venta : listaVentas){
                if(venta.getCodigo().equals(id)){
                    listaVentas.set(listaVentas.indexOf(venta), ventaActualizada);
                    break;
                }}
        }else{
            throw new VehiculoException("la venta no puede ser actualizada");}}

    public ArrayList<Venta> obtenerVentas(){
        return listaVentas;
    }
}


