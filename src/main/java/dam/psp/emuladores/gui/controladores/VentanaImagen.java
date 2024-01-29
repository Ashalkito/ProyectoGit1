package dam.psp.emuladores.gui.controladores;

import dam.psp.emuladores.gestores.GestorEntityManager;
import dam.psp.emuladores.modelo.DAOFactory;
import dam.psp.emuladores.modelo.Emulador;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.net.URL;
import java.util.List;
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
    private Sistema sis;

    private String rutafoto;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GestorEntityManager em = GestorEntityManager.getINSTANCIA();
        em.getEntityManager().getTransaction().begin();
        List<Emulador> emuladores = em.getEntityManager().createQuery("Select e from EmuladorJPA e").getResultList();
        em.getEntityManager().getTransaction().commit();
        cmbEmulador.getItems().addAll(emuladores);


    }

    public void setSis(Sistema sis) {
        this.sis = sis;
    }

    public void setRutafoto(String ruta){
        this.rutafoto=ruta;
    }

    public void btnJugarJuego(ActionEvent actionEvent) {

    }
}