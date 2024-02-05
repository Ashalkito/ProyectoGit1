package dam.psp.emuladores.gui.controladores;

import dam.psp.emuladores.gestores.GestorEntityManager;
import dam.psp.emuladores.modelo.Categoria;
import dam.psp.emuladores.modelo.DAOFactory;
import dam.psp.emuladores.modelo.Sistema;
import dam.psp.emuladores.modelo.Videojuego;
import dam.psp.emuladores.modelo.jpa.VideojuegoJPA;
import jakarta.persistence.EntityManager;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


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
        String patron= txfBuscador.getText();
        if(patron.equals("")){
            patron=null;
        }
        List<Videojuego> listaVJ= DAOFactory.getVideojuegoDAO().getVideojuegos(
                patron,
                chbSistema.getValue(),
                chbCategoria.getValue()
        );
        tv.getItems().clear();
        tv.getItems().addAll(listaVJ);

    }

    @FXML
    void pulsarCategoria(ActionEvent event) {
        try {
            FXMLLoader carga;

            carga = new FXMLLoader(getClass().getResource("/interfazCategoria.fxml"));

            Parent root = carga.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setScene(new Scene(root, 400, 107));
            ControladorSecundario controlador = carga.getController();
            controlador.setEntityManager(this.em);
            controlador.setControladorPrincipal(this);
            controlador.setStage(stage);
            controlador.showStage();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void pulsarEmulador(ActionEvent event) {
        try {
            FXMLLoader carga;

            carga = new FXMLLoader(getClass().getResource("/interfazEmulador.fxml"));

            Parent root = carga.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setScene(new Scene(root, 400, 212));
            ControladorSecundario controlador = carga.getController();
            controlador.setEntityManager(this.em);
            controlador.setControladorPrincipal(this);
            controlador.setStage(stage);
            controlador.showStage();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void pulsarSistema(ActionEvent event) {
        try {
            FXMLLoader carga;

            carga = new FXMLLoader(getClass().getResource("/interfazSistema.fxml"));

            Parent root = carga.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setScene(new Scene(root, 400, 107));
            ControladorSecundario controlador = carga.getController();
            controlador.setEntityManager(this.em);
            controlador.setControladorPrincipal(this);
            controlador.setStage(stage);
            controlador.showStage();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void pulsarVideojuego(ActionEvent event) {
        try {
            FXMLLoader carga;

            carga = new FXMLLoader(getClass().getResource("/interfazVideojuego.fxml"));

            Parent root = carga.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setScene(new Scene(root, 400, 305));
            ControladorSecundario controlador = carga.getController();
            controlador.setEntityManager(this.em);
            controlador.setControladorPrincipal(this);
            controlador.setStage(stage);
            controlador.showStage();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        em = GestorEntityManager.getINSTANCIA().getEntityManager();
        cargarCategorias();
        cargarSistemas();
        chbCategoria.getSelectionModel().selectFirst();
        chbSistema.getSelectionModel().selectFirst();

        recargarVentana();

        tv.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                try {
                    FXMLLoader carga = new FXMLLoader(getClass().getResource("/interfazTabla.fxml"));
                    Parent root = carga.load();
                    VentanaImagen vi = carga.getController();
                    vi.setSis(tv.getSelectionModel().getSelectedItem().getSistema());
                    vi.setRutafoto(tv.getSelectionModel().getSelectedItem().getRutaFoto());
                    vi.setVideojuego(tv.getSelectionModel().getSelectedItem());
                    System.out.println("Foto" + tv.getSelectionModel().getSelectedItem().getRutaFoto());
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException error) {
                    System.out.println(error.getMessage());
                    //error.printStackTrace();
                }
            }
        });
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colSistema.setCellValueFactory(new PropertyValueFactory<>("sistema"));
        colCategoria.setCellValueFactory(fila -> new SimpleObjectProperty<>(fila.getValue().getCategorias().toString().substring(1, fila.getValue().getCategorias().toString().length() - 1)));
    }


    public void cargarCategorias() {
        Categoria c=null;
        chbCategoria.getItems().addAll(c);
        chbCategoria.getItems().addAll(DAOFactory.getCategoriaDAO().getCategorias());
    }

    public void cargarSistemas() {
        Sistema s=null;
        chbSistema.getItems().addAll(s);
        chbSistema.getItems().addAll(DAOFactory.getSistemaDAO().getSistema());
    }

    public void recargarVentana() {
        tv.getItems().clear();
        chbCategoria.getItems().clear();
        chbSistema.getItems().clear();
        cargarCategorias();
        cargarSistemas();
        em.getTransaction().begin();
        List<Videojuego> listavideo= DAOFactory.getVideojuegoDAO().getVideojuegos(null,null,null);
        em.getTransaction().commit();
        tv.getItems().addAll(listavideo);

    }

}


