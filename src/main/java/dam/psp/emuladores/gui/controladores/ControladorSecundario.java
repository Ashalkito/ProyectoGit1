package dam.psp.emuladores.gui.controladores;

import dam.psp.emuladores.gui.controladores.ControladorPrincipal;
import jakarta.persistence.EntityManager;
import javafx.stage.Stage;

public class ControladorSecundario {
    private ControladorPrincipal cp;
    private EntityManager em;
    private Stage stage;

    public void setCp(ControladorPrincipal cp) {
        this.cp = cp;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public ControladorPrincipal getCp() {
        return cp;
    }

    public EntityManager getEm() {
        return em;
    }

    public Stage getStage() {
        return stage;
    }

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

    public void closeStage() { this.stage.close();}
}
