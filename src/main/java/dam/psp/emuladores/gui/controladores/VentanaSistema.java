package dam.psp.emuladores.gui.controladores;

import dam.psp.emuladores.dao.SistemaDAO;
import dam.psp.emuladores.dao.jpa.SistemaDAOJPA;
import dam.psp.emuladores.modelo.Sistema;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class VentanaSistema extends ControladorSecundario implements Initializable {

    @FXML
    private Button btnAceptar;

    @FXML
    private TextField txfNombre;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnAceptar.setText("Aceptar");
    }

    public void btnAceptarSistema(ActionEvent actionEvent) {
        Sistema sistema = new SistemaDAOJPA().nuevoSistema(txfNombre.getText());
    }
}

