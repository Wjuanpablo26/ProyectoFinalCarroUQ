package co.edu.uniquindio.poo.proyectofinalcarrouq.Model;

public class UserName {
    private String userName;
    private String password;

    //Constructor con parametros
    public UserName(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    //Constructor Vacio
    public UserName() {
    }

    //Getters y Setters
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
