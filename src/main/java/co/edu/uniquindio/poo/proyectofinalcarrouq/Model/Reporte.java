package co.edu.uniquindio.poo.proyectofinalcarrouq.Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Reporte {
    
    private String id;
    private Empleado empleado;
    private ArrayList<Venta> listaVentas = new ArrayList<>();
    private LocalDate fecha;
    private String calificacion;

    //Constructor con parametros
    public Reporte(String id, Empleado empleado, ArrayList<Venta> listaVentas, LocalDate fecha, String calificacion) {
        this.id = id;
        this.empleado = empleado;
        this.listaVentas = listaVentas;
        this.fecha = fecha;
        actualizarCalificacion();
    }

    //Constructor vacio
    public Reporte() {
    }

    //Getters y Setters
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Empleado getEmpleado() {
        return this.empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public ArrayList<Venta> getListaVentas() {
        return this.listaVentas;
    }

    public void setListaVentas(ArrayList<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getCalificacion() {
        return this.calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    //Metodo para establecer la calificacion
    private void actualizarCalificacion() {
        int cantidadVentas = listaVentas.size();

        if (cantidadVentas < 3) {
            this.calificacion = "Mala";
        } else if (cantidadVentas >= 3 && cantidadVentas < 5) {
            this.calificacion = "Regular";
        } else {
            this.calificacion = "Sobresaliente";
        }
    }

}
