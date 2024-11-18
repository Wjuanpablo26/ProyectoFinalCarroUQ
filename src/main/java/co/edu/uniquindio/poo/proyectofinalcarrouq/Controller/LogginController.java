package co.edu.uniquindio.poo.proyectofinalcarrouq.Controller;

public class LogginController {
    ModelFactory modelFactory;

    public LogginController(){
        modelFactory= ModelFactory.getInstance();
    }

    //Método para autentificar
    public int authenticate(String username, String password){
        return modelFactory.autentificacion(username, password);
    }

    //Método para buscar a una persona
    public void buscarPersona(String correo, String cedula){
        modelFactory.recuperar(correo, cedula);
    }
    
}
