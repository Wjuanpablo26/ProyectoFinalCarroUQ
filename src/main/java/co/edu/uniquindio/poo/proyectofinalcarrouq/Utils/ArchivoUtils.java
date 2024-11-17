package co.edu.uniquindio.poo.proyectofinalcarrouq.Utils;

import java.io.*;
import java.util.ArrayList;

public class ArchivoUtils {

    //Método para guardar un archivo
    public static void guardarArchivo(String rutaArchivo, String contendio, boolean bandera) throws IOException {
        FileWriter fw = new FileWriter(rutaArchivo, bandera);
        BufferedWriter br = new BufferedWriter(fw);
        br.write(contendio);
        br.close();
        fw.close();

    }

    //Método para leer un archivo
    public static ArrayList<String> leerArchivos(String rutaArchivo) throws IOException {

        ArrayList<String> leerArchivos = new ArrayList<>();

        FileReader fr = new FileReader(rutaArchivo);
        BufferedReader br = new BufferedReader(fr);
        String linea = "";

        while ((linea = br.readLine()) != null){
            leerArchivos.add(linea);
        }
        br.close();
        fr.close();

        return leerArchivos;
    }
    
}
