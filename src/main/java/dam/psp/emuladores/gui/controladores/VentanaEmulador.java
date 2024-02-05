package dam.psp.emuladores.gui.controladores;

import dam.psp.emuladores.dao.jpa.EmuladorDAOJPA;
import dam.psp.emuladores.dao.jpa.VideojuegoDAOJPA;
import dam.psp.emuladores.gestores.GestorEntityManager;
import dam.psp.emuladores.modelo.Emulador;
import dam.psp.emuladores.modelo.Sistema;
import dam.psp.emuladores.modelo.Videojuego;
import dam.psp.emuladores.modelo.jpa.SistemaJPA;
import dam.psp.emuladores.modelo.jpa.VideojuegoJPA;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        List<SistemaJPA> lista = new ArrayList<>();
        GestorEntityManager gm = GestorEntityManager.getINSTANCIA();
        lista  = gm.getEntityManager().createQuery("SELECT s FROM SistemaJPA s").getResultList();
        for(Sistema i : lista){
            chbSistemas.getItems().add(i);
        }
    }

    public void btnExplorarEmulador(ActionEvent actionEvent) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Elegir emulador");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Ejecutable", "*.exe"));
        Stage stage = (Stage) btnExplorarInstalacion.getScene().getWindow();
        File ubicacion = fc.showOpenDialog(stage);
        if (ubicacion != null) {
            txfRutaInstalacion.setText(ubicacion.getAbsolutePath());
        }
    }

    public void btnAceptarEmulador(ActionEvent actionEvent) {
        if(chbSistemas.getValue()==null || txfLineaComandos.getText().isEmpty() ||
                txfNombre.getText().isEmpty() || txfRutaInstalacion.getText().isEmpty()){
            Alert alertaError=new Alert(Alert.AlertType.ERROR);
            alertaError.setTitle("Error");
            alertaError.setHeaderText("Error al introducir un nuevo emulador");
            alertaError.setContentText("No se han introducido los datos necesarios");
            alertaError.showAndWait();
        }else{
            Emulador emulador = new EmuladorDAOJPA().nuevoEmulador(txfNombre.getText(),txfRutaInstalacion.getText(),txfLineaComandos
                    .getText(),chbSistemas.getValue());
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle(new String("Nueva inserción".getBytes(), Charset.forName("UTF-8")));
            alerta.setHeaderText(new String("¿Introducir nuevo emulador?".getBytes(), Charset.forName("UTF-8")));
            alerta.setContentText(new String("Se creará una nueva entrada en la base de datos.".getBytes(), Charset.forName("UTF-8")));

            Optional<ButtonType> resultado = alerta.showAndWait();
            if (resultado.isPresent() && resultado.get() == javafx.scene.control.ButtonType.OK && this.getStage()!=null) {
                this.getCp().recargarVentana();
                this.getStage().close();
            }
        }
    }
}