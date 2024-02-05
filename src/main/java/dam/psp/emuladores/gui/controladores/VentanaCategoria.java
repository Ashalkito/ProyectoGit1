package dam.psp.emuladores.gui.controladores;

import dam.psp.emuladores.dao.CategoriaDAO;
import dam.psp.emuladores.dao.jpa.CategoriaDAOJPA;
import dam.psp.emuladores.dao.jpa.SistemaDAOJPA;
import dam.psp.emuladores.modelo.Categoria;
import dam.psp.emuladores.modelo.Sistema;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.net.URL;
import java.nio.charset.Charset;
import java.util.Optional;
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
        if(txfNombre.getText().isEmpty()){
            Alert alertaError=new Alert(Alert.AlertType.ERROR);
            alertaError.setTitle("Error");
            alertaError.setHeaderText("Error al introducir una nueva categoria");
            alertaError.setContentText("No se han introducido los datos necesarios");
            alertaError.showAndWait();
        }else{
            Categoria c= new CategoriaDAOJPA().nuevaCategoria(txfNombre.getText());
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle(new String("Nueva inserción".getBytes(), Charset.forName("UTF-8")));
            alerta.setHeaderText(new String("¿Introducir nueva categoria?".getBytes(), Charset.forName("UTF-8")));
            alerta.setContentText(new String("Se creará una nueva entrada en la base de datos.".getBytes(), Charset.forName("UTF-8")));

            Optional<ButtonType> resultado = alerta.showAndWait();
            if (resultado.isPresent() && resultado.get() == javafx.scene.control.ButtonType.OK && this.getStage()!=null) {
                this.getCp().recargarVentana();
                this.getStage().close();
            }
        }
    }
}

