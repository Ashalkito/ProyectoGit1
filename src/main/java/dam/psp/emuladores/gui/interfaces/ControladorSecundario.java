package dam.psp.emuladores.gui.interfaces;

import dam.psp.emuladores.gui.controladores.ControladorPrincipal;
import jakarta.persistence.EntityManager;
import javafx.stage.Stage;

public class ControladorSecundario {
    private ControladorPrincipal cp;
    private EntityManager em;
    private Stage stage;

    public void setControladorPrincipal(ControladorPrincipal cp) {
        this.cp = cp;
    }

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void showStage() {
        this.stage.show();
    }
}
