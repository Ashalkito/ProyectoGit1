package dam.psp.emuladores.gui.controladores;

import dam.psp.emuladores.gestores.GestorEntityManager;
import dam.psp.emuladores.modelo.DAOFactory;
import dam.psp.emuladores.modelo.jpa.VideojuegoJPA;
import jakarta.persistence.EntityManager;
import javafx.beans.property.SimpleObjectProperty;
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
import java.util.List;
import java.util.ResourceBundle;


public class ControladorPrincipal implements Initializable{

    private EntityManager em;

    @FXML
    private Button btnBuscar;

    @FXML
    private ChoiceBox<?> chbCategoria;

    @FXML
    private ChoiceBox<?> chbSistema;

    @FXML
    private TableColumn<VideojuegoJPA, String> colCategoria;

    @FXML
    private TableColumn<VideojuegoJPA, String> colNombre;

    @FXML
    private TableColumn<VideojuegoJPA, String> colSistema;

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
    private TableView<VideojuegoJPA> tv;

    @FXML
    private TextField txfBuscador;

    @FXML
    void pulsarBuscar(ActionEvent event) {

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
        em=GestorEntityManager.getINSTANCIA().getEntityManager();
        cargarCategorias();
        cargarSistemas();

        List<VideojuegoJPA> listavideo = em.createQuery("Select V from VideojuegoJPA V").getResultList();

        tv.getItems().addAll(listavideo);

        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));//propiedad en Robot
        colSistema.setCellValueFactory(new PropertyValueFactory<>("sistema"));//propiedad en Robot
        colCategoria.setCellValueFactory(fila -> new SimpleObjectProperty<>(fila.getValue().getCategorias().toString().substring(1,fila.getValue().getCategorias().toString().length()-1)));

    }

    public void cargarCategorias(){
        chbCategoria.getItems().addAll(DAOFactory.getCategoriaDAO().getCategorias());
    }
    public void cargarSistemas(){
        chbSistema.getItems().addAll(DAOFactory.getSistemaDAO().getSistema());
    }
}


