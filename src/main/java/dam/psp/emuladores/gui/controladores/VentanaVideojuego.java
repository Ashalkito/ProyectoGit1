package dam.psp.emuladores.gui.controladores;

import dam.psp.emuladores.dao.jpa.VideojuegoDAOJPA;
import dam.psp.emuladores.modelo.Sistema;
import dam.psp.emuladores.modelo.Videojuego;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class VentanaVideojuego extends ControladorSecundario implements Initializable {

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnExplorarCaratula;

    @FXML
    private Button btnExplorarJuego;

    @FXML
    private ChoiceBox<Sistema> chbCategorias;

    @FXML
    private TextField txfNombre;

    @FXML
    private TextField txfRutaJuego;

    @FXML
    private TextField txfRutacaratula;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void btnExplorarVideoJuego(ActionEvent actionEvent) {
        FileChooser fc=new FileChooser();
        fc.setTitle("Elegir videojuego");
        Stage stage=(Stage) btnExplorarJuego.getScene().getWindow();
        File ubicacion = fc.showOpenDialog(stage);
        if(ubicacion!=null){
            txfRutaJuego.setText(ubicacion.getAbsolutePath());
        }
    }

    public void btnExplorarCaratula(ActionEvent actionEvent) {
        FileChooser fc=new FileChooser();
        fc.setTitle("Elegir caratula");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagenes","*.jpg","*.png","*.jpeg"));
        Stage stage=(Stage) btnExplorarCaratula.getScene().getWindow();
        File ubicacion = fc.showOpenDialog(stage);
        if(ubicacion!=null){
            txfRutacaratula.setText(ubicacion.getAbsolutePath());
        }
    }

    public void btnAceptarVideoJuego(ActionEvent actionEvent) {
        //Videojuego vj=new VideojuegoDAOJPA().nuevoVideojuego(txfNombre.getText(),chbCategorias.getValue(),txfRutacaratula.getText(),)
    }
}

