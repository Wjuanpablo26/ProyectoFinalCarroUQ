import co.edu.uniquindio.poo.proyectofinalcarrouq.Controller.EmpleadoController;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Exception.VehiculoException;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Combustible.Combustible;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Combustible.Gasolina;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoCombustible;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoEstado;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.TipoCambios;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Moto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VehiculoControllerTest {

    private EmpleadoController vehiculoController;

    @BeforeEach
    public void setUp() {
        vehiculoController = new EmpleadoController();
    }

    @Test
    public void testRegistrarVehiculoExitoso() throws VehiculoException {
        // Datos para el constructor de Moto
        String placa = "ABC123";
        String marca = "Yamaha";
        boolean esNuevo = true;
        String modelo = "MT-07";
        TipoCambios tiposCambios = TipoCambios.MANUAL;
        float velocidadMax = 210.5f;
        float cilindraje = 689.0f;
        Combustible gasolina = new Gasolina(TipoCombustible.GASOLINA);
        String imagen = "ruta/a/imagen.png";
        TipoEstado tipoEstado = TipoEstado.EN_POSESION;
        Moto moto = new Moto(placa, marca, esNuevo, modelo, tiposCambios, velocidadMax, cilindraje, gasolina, imagen, tipoEstado);
        boolean resultado;

        if(vehiculoController.addMoto(moto) == 1){
            resultado = true;
        }else{
            resultado = false;
        }
        assertTrue(resultado, "Debería registrar el vehículo exitosamente");
    }

    @Test
    public void testRegistrarVehiculoDuplicado() throws VehiculoException {
        // Datos para el constructor de Moto
        String placa = "ABC123";
        String marca = "Yamaha";
        boolean esNuevo = true;
        String modelo = "MT-07";
        TipoCambios tiposCambios = TipoCambios.MANUAL;
        float velocidadMax = 210.5f;
        float cilindraje = 689.0f;
        Combustible gasolina = new Gasolina(TipoCombustible.GASOLINA);
        String imagen = "ruta/a/imagen.png";
        TipoEstado tipoEstado = TipoEstado.EN_POSESION;
        Moto moto = new Moto(placa, marca, esNuevo, modelo, tiposCambios, velocidadMax, cilindraje, gasolina, imagen, tipoEstado);
        boolean resultado;

        if(vehiculoController.addMoto(moto) == 1){
            resultado = true;
        }else{
            resultado = false;
        }
        assertFalse(resultado, "No debería permitir el registro de un vehículo duplicado");
    }
}

