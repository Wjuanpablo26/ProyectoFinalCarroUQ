module co.edu.uniquindio.poo.proyectofinalcarrouq {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens co.edu.uniquindio.poo.proyectofinalcarrouq to javafx.fxml;
    exports co.edu.uniquindio.poo.proyectofinalcarrouq;

    opens co.edu.uniquindio.poo.proyectofinalcarrouq.Controller to javafx.fxml;
    exports co.edu.uniquindio.poo.proyectofinalcarrouq.Controller;

    opens co.edu.uniquindio.poo.proyectofinalcarrouq.Model to javafx.fxml;
    exports co.edu.uniquindio.poo.proyectofinalcarrouq.Model;

    opens co.edu.uniquindio.poo.proyectofinalcarrouq.View to javafx.fxml;
    exports co.edu.uniquindio.poo.proyectofinalcarrouq.View;

    opens co.edu.uniquindio.poo.proyectofinalcarrouq.Utils to javafx.fxml;
    exports co.edu.uniquindio.poo.proyectofinalcarrouq.Utils;

    exports co.edu.uniquindio.poo.proyectofinalcarrouq.Exception;
    exports co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum;
    exports co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Combustible;



}