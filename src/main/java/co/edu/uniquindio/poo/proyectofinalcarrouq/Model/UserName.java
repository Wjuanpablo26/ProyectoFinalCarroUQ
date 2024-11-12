package co.edu.uniquindio.poo.proyectofinalcarrouq.Model;

public class UserName {
    private String username;
    private String password;

    //Constructor con parametros
    public UserName(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //Constructor Vacio
    public UserName() {
    }

    //Getters y Setters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
