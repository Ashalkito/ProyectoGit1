package dam.psp.emuladores.gui.controladores;

import dam.psp.emuladores.modelo.DAOJPAFactory;
import dam.psp.emuladores.modelo.Emulador;
import dam.psp.emuladores.modelo.Videojuego;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class VentanaImagen extends ControladorSecundario implements Initializable {

    @FXML
    private Button btnJugar;

    @FXML
    private CheckBox chkGrabar;

    @FXML
    private ComboBox<Emulador> cmbEmulador;

    @FXML
    private ImageView imgImagen;

    @FXML
    private Label lblTitulo1;

    private Videojuego videojuego;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmbEmulador.getItems().clear();
    }

    public void setVideojuego(Videojuego v) {
        videojuego = v;
    }


    @FXML
    public void btnJugarJuego(ActionEvent actionEvent) {
        if (chkGrabar.isSelected()) {
            cmbEmulador.getSelectionModel().getSelectedItem().abrir(getVideojuego(), true);
        } else {
            cmbEmulador.getSelectionModel().getSelectedItem().abrir(getVideojuego(), false);
        }
    }

    public Videojuego getVideojuego() {
        return videojuego;
    }

    public void cargarVentana(Videojuego vj) {
        this.videojuego = vj;
        cmbEmulador.getItems().addAll(DAOJPAFactory.getEmuladorDAO().getEmuladores(videojuego.getSistema()));
        try {
            InputStream is = new FileInputStream(videojuego.getRutaFoto());
            Image imagen = new Image(is);
            imgImagen.setImage(imagen);

        } catch (Exception e) {
            System.out.println("Error al cargar la imagen");
        }
    }
}