package dam.psp.emuladores.gui.controladores;

import dam.psp.emuladores.gestores.GestorEntityManager;
import dam.psp.emuladores.modelo.*;
import jakarta.persistence.EntityManager;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static dam.psp.emuladores.modelo.AlmacenDatos.JPA;


public class ControladorPrincipal implements Initializable {

    private EntityManager em;

    @FXML
    private Button btnBuscar;

    @FXML
    private ChoiceBox<Categoria> chbCategoria;

    @FXML
    private ChoiceBox<Sistema> chbSistema;

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

    @FXML
    private TableColumn<Videojuego, String> colCategoria;

    @FXML
    private TableColumn<Videojuego, String> colNombre;

    @FXML
    private TableColumn<Videojuego, String> colSistema;

    @FXML
    private TableView<Videojuego> tv;

    private Videojuego videojuego;

    @FXML
    void pulsarBuscar(ActionEvent event) {
        buscarVideoJuego();
    }

    @FXML
    void pulsarEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            buscarVideoJuego();
        }
    }

    @FXML
    void pulsarCategoria(ActionEvent event) {
        lanzarVentanaSecundaria("/interfazCategoria.fxml",400,107);
    }

    @FXML
    void pulsarEmulador(ActionEvent event) {
        lanzarVentanaSecundaria("/interfazEmulador.fxml",400,212);
    }

    @FXML
    void pulsarSistema(ActionEvent event) {
        lanzarVentanaSecundaria("/interfazSistema.fxml",400,107);
    }

    @FXML
    void pulsarVideojuego(ActionEvent event) {
        lanzarVentanaSecundaria("/interfazVideojuego.fxml",400,305);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ConfiguracionLectura.progEmDAOFac = ProgramaEmuladoresAbstractFactory.getDAOFactory(JPA);

        em = GestorEntityManager.getINSTANCIA().getEntityManager();
        chbCategoria.getSelectionModel().selectFirst();
        chbSistema.getSelectionModel().selectFirst();

        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colSistema.setCellValueFactory(new PropertyValueFactory<>("sistema"));
        colCategoria.setCellValueFactory(fila -> new SimpleObjectProperty<>(fila.getValue().getCategorias().toString().substring(1, fila.getValue().getCategorias().toString().length() - 1)));

        recargarVentana();

        tv.setOnMouseClicked(e -> {

            if (e.getClickCount() == 2) {
                try {
                    FXMLLoader carga = new FXMLLoader(getClass().getResource("/interfazTabla.fxml"));

                    Parent root = carga.load();
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setResizable(false);
                    stage.setScene(new Scene(root));
                    VentanaImagen vi = carga.getController();
                    vi.setEntityManager(this.em);
                    vi.setControladorPrincipal(this);
                    vi.setStage(stage);
                    vi.cargarVentana(tv.getSelectionModel().getSelectedItem());
                    vi.showStage();

                } catch (IOException error) {
                    System.out.println(error.getMessage());
                }
            }
        });

    }


    public void buscarVideoJuego() {
        String patron = txfBuscador.getText();
        if (patron.equals("")) {
            patron = null;
        }
        List<Videojuego> listaVJ = ConfiguracionLectura.progEmDAOFac.getVideojuegoDAO().getVideojuegos(

                patron,
                chbSistema.getSelectionModel().getSelectedItem(),
                chbCategoria.getValue()
        );

        tv.getItems().clear();
        tv.getItems().addAll(listaVJ);
    }

    public void cargarCategorias() {
        Categoria c = null;
        chbCategoria.getItems().addAll(c);
        chbCategoria.getItems().addAll(ConfiguracionLectura.progEmDAOFac.getCategoriaDAO().getCategorias());
    }

    public void cargarSistemas() {
        Sistema s = null;
        chbSistema.getItems().addAll(s);
        chbSistema.getItems().addAll(ConfiguracionLectura.progEmDAOFac.getSistemaDAO().getSistema());
    }

    public void recargarVentana() {
        tv.getItems().clear();
        chbCategoria.getItems().clear();
        chbSistema.getItems().clear();
        cargarCategorias();
        cargarSistemas();
        em.getTransaction().begin();
        List<Videojuego> listavideo = ConfiguracionLectura.progEmDAOFac.getVideojuegoDAO().getVideojuegos(null, null, null);
        em.getTransaction().commit();
        tv.getItems().addAll(listavideo);

    }

    public void lanzarVentanaSecundaria(String fxml, Integer width, Integer height) {
        try {
            FXMLLoader carga = new FXMLLoader(getClass().getResource(fxml));

            Parent root = carga.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            if (width == null || height == null) {
                stage.setScene((new Scene(root)));
            } else {
                stage.setScene(new Scene(root, width, height));
            }
            ControladorSecundario controlador = carga.getController();
            controlador.setEntityManager(this.em);
            controlador.setControladorPrincipal(this);
            controlador.setStage(stage);
            controlador.showStage();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
//HOLAAA
}


