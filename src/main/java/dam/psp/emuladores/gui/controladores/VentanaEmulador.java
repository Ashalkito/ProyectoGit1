package dam.psp.emuladores.gui.controladores;

import dam.psp.emuladores.dao.jpa.EmuladorDAOJPA;
import dam.psp.emuladores.modelo.Emulador;
import dam.psp.emuladores.modelo.Sistema;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class VentanaEmulador extends ControladorSecundario implements Initializable {

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnExplorarInstalacion;

    @FXML
    private ChoiceBox<Sistema> chbSistemas;

    @FXML
    private TextField txfLineaComandos;

    @FXML
    private TextField txfNombre;

    @FXML
    private TextField txfRutaInstalacion;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnAceptar.setText("Aceptar");
    }

    public void btnExplorarEmulador(ActionEvent actionEvent) {
        DirectoryChooser dc = new DirectoryChooser();
        dc.setTitle("Elegir emulador");
        Stage stage = (Stage) btnExplorarInstalacion.getScene().getWindow();
        File ubicacion = dc.showDialog(stage);
        if(ubicacion!=null){
            txfRutaInstalacion.setText(ubicacion.getAbsolutePath());
        }
    }

    public void btnAceptarEmulador(ActionEvent actionEvent) {
        Emulador emulador = new EmuladorDAOJPA().nuevoEmulador(txfNombre.getText(),txfRutaInstalacion.getText(),txfLineaComandos
                .getText(),chbSistemas.getValue());
    }
}

