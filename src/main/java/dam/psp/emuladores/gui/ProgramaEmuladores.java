package dam.psp.emuladores.gui;

import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
public class ProgramaEmuladores extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primeraEscena) throws Exception {

        URL u = getClass().getResource("/interfaz.fxml");
        if(u==null){
            System.out.println("NO LO HA CARGADO");
        }else{
            System.out.println("SI");
        }
        Parent root = FXMLLoader.load(u);
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("./css/style.css").toExternalForm());
        primeraEscena.setScene(scene);
        primeraEscena.setResizable(false);
        primeraEscena.show();
    }
}
