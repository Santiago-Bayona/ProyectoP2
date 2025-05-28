module co.edu.uniquindio.poo.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.pdfbox;
    requires commons.math3;


    opens co.edu.uniquindio.poo.proyectofinal to javafx.fxml;
    exports co.edu.uniquindio.poo.proyectofinal;
    exports co.edu.uniquindio.poo.proyectofinal.Controller;
    opens co.edu.uniquindio.poo.proyectofinal.Controller to javafx.fxml;
    exports co.edu.uniquindio.poo.proyectofinal.Modelo;
    opens co.edu.uniquindio.poo.proyectofinal.Modelo to javafx.fxml;
    exports co.edu.uniquindio.poo.proyectofinal.ViewController;
    opens co.edu.uniquindio.poo.proyectofinal.ViewController to javafx.fxml;
}