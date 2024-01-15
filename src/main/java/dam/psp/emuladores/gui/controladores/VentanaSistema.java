package dam.psp.emuladores.gui.controladores;

import dam.psp.emuladores.gui.interfaces.ControladorSecundario;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.naming.ldap.Control;
import java.net.URL;
import java.util.ResourceBundle;

public class VentanaSistema implements Initializable, ControladorSecundario {

    @FXML
    private Button btnAceptar;

    @FXML
    private TextField txfNombre;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

