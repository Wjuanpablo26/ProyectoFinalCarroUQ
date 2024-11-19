import co.edu.uniquindio.poo.proyectofinalcarrouq.Controller.AdminController;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Exception.PersonaException;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Admin;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.Genero;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.UserName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdminControllerTest {

    private AdminController adminController;

    @BeforeEach
    public void setUp() {
        adminController = new AdminController();
    }

    @Test
    public void testRegistrarAdminExitoso() throws PersonaException {
        UserName userName = new UserName("john22","3321");
        Admin admin = new Admin("1234", "John Doeaa", "john.doe@example.com", Genero.MASCULINO,20,userName);
        boolean resultado;
        if(adminController.addAdmin(admin) == 1){
            resultado = true;
        }else{
            resultado = false;
        }
        assertTrue(resultado, "Debería registrar el Admin exitosamente");
    }

    @Test
    public void testRegistrarAdminDuplicado() throws PersonaException {
        UserName userName = new UserName("john22","3321");
        Admin admin1 = new Admin("1234", "John Doea", "john.doe@example.com", Genero.MASCULINO,20,userName);
        boolean resultado;
        if(adminController.addAdmin(admin1) == 1){
            resultado = true;
        }else{
            resultado = false;
        }
        assertFalse(resultado, "No debería permitir el registro de un Admin duplicado");
    }
}
