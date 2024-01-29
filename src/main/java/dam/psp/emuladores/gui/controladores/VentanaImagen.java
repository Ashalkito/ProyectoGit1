package dam.psp.emuladores.gui.controladores;

import dam.psp.emuladores.modelo.DAOFactory;
import dam.psp.emuladores.modelo.Sistema;
import dam.psp.emuladores.modelo.jpa.EmuladorJPA;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class VentanaImagen extends ControladorSecundario implements Initializable {

    @FXML
    private Button btnJugar;

    @FXML
    private CheckBox chkGrabar;

    @FXML
    private ComboBox<String> cmbEmulador;

    @FXML
    private ImageView imgImagen;

    @FXML
    private Label lblTitulo1;

    private ControladorPrincipal controladorprincipal;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Sistema> s=new ArrayList<>();

        cmbEmulador.getItems().addAll(DAOFactory.getEmuladorDAO().getEmuladores());



    }

    public void setControladorPrincipal(ControladorPrincipal controlador){
        this.controladorprincipal=controlador;
    }
    public void btnJugarJuego(ActionEvent actionEvent) {
    }
}