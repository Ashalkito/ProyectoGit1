package dam.psp.emuladores.gui.controladores;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorPrincipal implements Initializable {

    @FXML
    private Button btnBuscar;

    @FXML
    private ChoiceBox<?> chbCategoria;

    @FXML
    private ChoiceBox<?> chbSistema;

    @FXML
    private GridPane gpn1;

    @FXML
    private Menu menuNuevo;

    @FXML
    private MenuItem miCategoria;

    @FXML
    private MenuItem miEmulador;

    @FXML
    private MenuItem miSistema;

    @FXML
    private MenuItem miVideojuego;

    @FXML
    private TextField txfBuscador;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}

