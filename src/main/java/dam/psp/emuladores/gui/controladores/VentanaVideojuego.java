package dam.psp.emuladores.gui.controladores;

import dam.psp.emuladores.dao.jpa.VideojuegoDAOJPA;
import dam.psp.emuladores.gestores.GestorEntityManager;
import dam.psp.emuladores.modelo.Categoria;
import dam.psp.emuladores.modelo.Sistema;
import dam.psp.emuladores.modelo.Videojuego;
import dam.psp.emuladores.modelo.jpa.CategoriaJPA;
import dam.psp.emuladores.modelo.jpa.SistemaJPA;
import dam.psp.emuladores.modelo.jpa.VideojuegoJPA;
import jakarta.persistence.EntityManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class VentanaVideojuego extends ControladorSecundario implements Initializable {


    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnExplorarCaratula;

    @FXML
    private Button btnExplorarJuego;

    @FXML
    private ChoiceBox<Sistema> chbSistemas;

    @FXML
    private ListView<Categoria> lvCategoria;

    @FXML
    private TextField txfNombre;

    @FXML
    private TextField txfRutaJuego;

    @FXML
    private TextField txfRutacaratula;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<SistemaJPA> listasistema = new ArrayList<>();
        lvCategoria.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        GestorEntityManager gm = GestorEntityManager.getINSTANCIA();
        listasistema = gm.getEntityManager().createQuery("SELECT s FROM SistemaJPA s").getResultList();
        for (Sistema i : listasistema) {
            chbSistemas.getItems().add(i);
        }
        List<CategoriaJPA> listacategoria = new ArrayList<>();
        listacategoria = gm.getEntityManager().createQuery("SELECT c FROM CategoriaJPA c").getResultList();
        for (Categoria i : listacategoria) {
            lvCategoria.getItems().add(i);
        }

    }

    public void btnExplorarVideoJuego(ActionEvent actionEvent) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Elegir videojuego");
        Stage stage = (Stage) btnExplorarJuego.getScene().getWindow();
        File ubicacion = fc.showOpenDialog(stage);
        if (ubicacion != null) {
            txfRutaJuego.setText(ubicacion.getAbsolutePath());
        }
    }

    public void btnExplorarCaratula(ActionEvent actionEvent) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Elegir caratula");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagenes", "*.jpg", "*.png", "*.jpeg"));
        Stage stage = (Stage) btnExplorarCaratula.getScene().getWindow();
        File ubicacion = fc.showOpenDialog(stage);
        if (ubicacion != null) {
            txfRutacaratula.setText(ubicacion.getAbsolutePath());
        }
    }

    public void btnAceptarVideoJuego(ActionEvent actionEvent) {
        if(txfNombre.getText().isEmpty() || chbSistemas.getValue()==null ||
                txfRutaJuego.getText().isEmpty() || txfRutacaratula.getText().isEmpty() ||
                lvCategoria.getSelectionModel().getSelectedItems() == null){
            Alert alertaError=new Alert(Alert.AlertType.ERROR);
            alertaError.setTitle("Error");
            alertaError.setHeaderText("Error al introducir un nuevo videojuego");
            alertaError.setContentText("No se han introducido los datos necesarios");
            alertaError.showAndWait();
        }else{
            Videojuego vj = new VideojuegoDAOJPA().nuevoVideojuego(txfNombre.getText(), chbSistemas.getValue(), txfRutaJuego.getText(), txfRutacaratula.getText(), lvCategoria.getSelectionModel().getSelectedItems());
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle(new String("Nueva inserción".getBytes(), Charset.forName("UTF-8")));
            alerta.setHeaderText(new String("¿Introducir nuevo videojuego?".getBytes(), Charset.forName("UTF-8")));
            alerta.setContentText(new String("Se creará una nueva entrada en la base de datos.".getBytes(), Charset.forName("UTF-8")));

            Optional<ButtonType> resultado = alerta.showAndWait();
            if (resultado.isPresent() && resultado.get() == javafx.scene.control.ButtonType.OK && this.getStage()!=null) {
                this.getCp().recargarVentana();
                this.getStage().close();
            }
        }
    }
}