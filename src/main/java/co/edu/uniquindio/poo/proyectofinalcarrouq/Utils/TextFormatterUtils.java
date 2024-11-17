package co.edu.uniquindio.poo.proyectofinalcarrouq.Utils;

import javafx.scene.control.TextFormatter.Change;


public class TextFormatterUtils {

    /**
     * Tool used which converts the structure into lowercase.
     * @param change
     */
    public static Change upperCaseFormat(Change change){
        change.setText(change.getText().toUpperCase());
        return change;
    }


    /**
     * Tool used to deny the writing of the alphabet on the keyboard.
     * @param change
     */
    public static Change integerFormat (Change change){
        if (change.getText().matches("[0-9]*")){
            return change;
        }
        return null;
    }

    public static Change floatFormat(Change change) {
        // Verificar si el texto introducido es un número válido con decimales
        if (change.getText().matches("^[0-9]*\\.?[0-9]*$")) {
            return change;
        }
        return null;
    }

    
}
