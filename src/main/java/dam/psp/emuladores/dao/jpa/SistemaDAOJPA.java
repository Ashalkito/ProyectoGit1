package dam.psp.emuladores.dao.jpa;

import dam.psp.emuladores.dao.SistemaDAO;
import dam.psp.emuladores.gestores.GestorEntityManager;
import dam.psp.emuladores.modelo.Sistema;
import dam.psp.emuladores.modelo.Videojuego;
import dam.psp.emuladores.modelo.jpa.SistemaJPA;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class SistemaDAOJPA implements SistemaDAO {

    @Override
    public Sistema nuevoSistema(String nombre) {
        GestorEntityManager gm = GestorEntityManager.getINSTANCIA();

        SistemaJPA s = null;

        try {
            s=new SistemaJPA();
            s.setNombre(nombre);
            gm.getEntityManager().getTransaction().begin();
            gm.getEntityManager().persist(s);
            gm.getEntityManager().getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return s;
    }

    @Override
    public List<SistemaJPA> getSistema() {
        GestorEntityManager gm = GestorEntityManager.getINSTANCIA();

        List<SistemaJPA> resultado = new ArrayList<>();

        try {
            resultado = gm.getEntityManager().createQuery("SELECT c FROM SistemaJPA c", SistemaJPA.class).getResultList();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
}
