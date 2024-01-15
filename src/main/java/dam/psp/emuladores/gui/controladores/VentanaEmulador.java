package dam.psp.emuladores.gui.controladores;

import dam.psp.emuladores.gui.interfaces.ControladorSecundario;
import jakarta.persistence.EntityManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class VentanaEmulador extends ControladorSecundario implements Initializable {

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnExplorarInstalacion;

    @FXML
    private ChoiceBox<?> chbSistemas;

    @FXML
    private TextField txfLineaComandos;

    @FXML
    private TextField txfNombre;

    @FXML
    private TextField txfRutaInstalacion;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}

