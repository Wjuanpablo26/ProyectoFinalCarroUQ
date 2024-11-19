import static org.junit.jupiter.api.Assertions.*;

import com.uniquindio.carrouq.Controller.AdminController;
import com.uniquindio.carrouq.Exception.PersonaException;
import com.uniquindio.carrouq.Model.Admin;
import com.uniquindio.carrouq.Model.Enum.Genero;
import com.uniquindio.carrouq.Model.UserName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdminControllerTest {

    private AdminController adminController;

    @BeforeEach
    public void setUp() {
        adminController = new AdminController();
    }

    @Test
    public void testRegistrarAdminExitoso() throws PersonaException {
        UserName userName = new UserName("john1","333");
        Admin admin = new Admin("1234", "John Doe", "john.doe@example.com", Genero.MASCULINO,20,userName);
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
        UserName userName = new UserName("john1","333");
        Admin admin1 = new Admin("1234", "John Doe", "john.doe@example.com", Genero.MASCULINO,20,userName);
        boolean resultado;
        if(adminController.addAdmin(admin1) == 1){
            resultado = true;
        }else{
            resultado = false;
        }
        assertFalse(resultado, "No debería permitir el registro de un Admin duplicado");
    }
}
