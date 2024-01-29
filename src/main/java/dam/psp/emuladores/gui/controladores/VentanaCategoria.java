package dam.psp.emuladores.gui.controladores;

import dam.psp.emuladores.dao.CategoriaDAO;
import dam.psp.emuladores.dao.jpa.CategoriaDAOJPA;
import dam.psp.emuladores.modelo.Categoria;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class VentanaCategoria extends ControladorSecundario implements Initializable {

    @FXML
    private Button btnAceptar;

    @FXML
    private TextField txfNombre;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnAceptar.setText("Aceptar");
    }

    public void btnAceptarCategoria(ActionEvent actionEvent) {
        Categoria c= new CategoriaDAOJPA().nuevaCategoria(txfNombre.getText());
        this.getCp().recargarVentana();
        this.getStage().close();
    }
}

