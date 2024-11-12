package co.edu.uniquindio.poo.proyectofinalcarrouq.Model;
import java.time.LocalDate;

import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract.Vehiculo;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoTransaccion;

public class Venta {

    private String codigo;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private Empleado empleado;
    private TipoTransaccion tipoTransaccion;
    private String descripcion;
    private LocalDate fechaVenta;
    private boolean revisionTecnica;

    //Constructor con parametros
    public Venta(String codigo, Cliente cliente, Vehiculo vehiculo, Empleado empleado, TipoTransaccion tipoTransaccion, String descripcion, LocalDate fechaVenta, boolean revisionTecnica) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.empleado = empleado;
        this.tipoTransaccion = tipoTransaccion;
        this.descripcion = descripcion;
        this.fechaVenta = fechaVenta;
        this.revisionTecnica = revisionTecnica;
    }

    //Constructor vacio
    public Venta() {
    }

    //Metodos Getters y Setters
    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Empleado getEmpleado() {
        return this.empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public TipoTransaccion getTipoTransaccion() {
        return this.tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaVenta() {
        return this.fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public boolean isRevisionTecnica() {
        return this.revisionTecnica;
    }

    public boolean getRevisionTecnica() {
        return this.revisionTecnica;
    }

    public void setRevisionTecnica(boolean revisionTecnica) {
        this.revisionTecnica = revisionTecnica;
    }


    
}
