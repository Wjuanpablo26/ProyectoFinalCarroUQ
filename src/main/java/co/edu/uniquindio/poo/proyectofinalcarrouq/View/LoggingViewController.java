package co.edu.uniquindio.poo.proyectofinalcarrouq.View;

import java.io.IOException;
import java.util.Optional;


import co.edu.uniquindio.poo.proyectofinalcarrouq.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoggingViewController {
    
    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUsername;

    LogginController logginController;
    
    
    // Metodo de inicio se sesion
    @FXML
    private void initialize(){
        logginController = new LogginController();
    }

//Metodo para manejar el incio se sesion
    @FXML
    void Ingresar(ActionEvent event) throws IOException {
        if(verificarCampo()){
            abrirVentanaSegunTipo(event);
        }
    }

    //Metodo para recuperar el correo

    @FXML
    void recuperarCorreo(ActionEvent event){
        mostrarAlertaConDosTextFields();
    }

    //Metodo para abrir la ventana segun el tipo de Usuario
    private void abrirVentanaSegunTipo(ActionEvent event) throws IOException{

        if(verificarCampo()){

            int opciones = logginController.authenticate(txtUsername.getText(), txtPassword.getText());

            switch (opciones){
                case 1: cambiarVentana("EmpleadoGeneral.fxml",event);
                break;

                case 2: cambiarVentana("AdminGeneral.fxml",event);
                break;

                case 0: mostrarMensaje("Error Al Iniciar Sesion", "Error con los datos" , "El Usuario "+ "o Contraseña no han sido registrados", Alert.AlertType.ERROR);
                break;
            }
        }
    }

    // Metodo para verificar si los campos estan llenos
    private boolean verificarCampo(){
        String mensaje = "";

        if (txtPassword.getText().isEmpty() || txtPassword.getText().equals("")) {
            mensaje += "Ingrese el campo de Password\n";
        }
        if (txtUsername.getText().isEmpty() || txtUsername.getText().equals("")) {
            mensaje += "Ingrese el campo de Username\n";
        }
        if (mensaje.equals("")) {
            return true;
        } else {
            mostrarMensaje("Datos incorrectos", "Datos invalidos", mensaje, Alert.AlertType.ERROR);
            return false;
        }
    }

    //Metodo para mostrar un mensaje de alerta
    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    public void cambiarVentana(String nombreFxml,ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource(nombreFxml));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        // Obtener la referencia a la ventana actual
        Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageActual.close(); // Cerrar a la ventana actual

        // Abrir la nueva ventana 
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }


    //Metodo para mostrar una alerta de confirmacion

    private void mostrarAlertaConDosTextFields(){
        //Crear una alerta de tipo CONFIRMATION
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Ingresar datos");
        alerta.setHeaderText("Por favor, ingresa los valores requerido");

        // Crear los TextField para los valores de entrada
        TextField textField1 = new TextField();
        textField1.setPromptText("Cedula");

        TextField textField2 = new TextField();
        textField2.setPromptText("Correo");

        // Configurar el layout para los TextFields
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(textField1, 0, 0);
        gridPane.add(textField2, 0, 1);

        //Ajustar el ancho del Textfield dentro del GridPane
        GridPane.setHgrow(textField1, Priority.ALWAYS);
        GridPane.setHgrow(textField2, Priority.ALWAYS);

        // Añadir  el GridPane a la alerta
        alerta.getDialogPane().setContent(gridPane);

        //Definir el boton "OK" para confirmar
        ButtonType botonOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        alerta.getButtonTypes().setAll(botonOk, ButtonType.CANCEL);

        // Mostrar la alerta y esperar la respuesta del usuario
        Optional<ButtonType> resultado = alerta.showAndWait();

        // Verificar si el usuario presiono Ok
        if (resultado.isPresent() && resultado.get() == botonOk) {
            String valor1 = textField1.getText();
            String valor2 = textField2.getText();

            // Llamar al metodo para procesar los datos ingresados 
            logginController.buscarPersona(valor2, valor1);
        }
    }
}



    

