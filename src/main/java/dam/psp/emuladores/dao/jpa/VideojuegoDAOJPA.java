package dam.psp.emuladores.dao.jpa;

import com.sun.tools.attach.VirtualMachineDescriptor;
import dam.psp.emuladores.dao.CategoriaDAO;
import dam.psp.emuladores.dao.VideojuegoDAO;
import dam.psp.emuladores.gestores.GestorEntityManager;
import dam.psp.emuladores.modelo.*;
import dam.psp.emuladores.modelo.jpa.CategoriaJPA;
import dam.psp.emuladores.modelo.jpa.EmuladorJPA;
import dam.psp.emuladores.modelo.jpa.SistemaJPA;
import dam.psp.emuladores.modelo.jpa.VideojuegoJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.hibernate.sql.results.graph.EntityGraphTraversalState;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class VideojuegoDAOJPA implements VideojuegoDAO {
    public VideojuegoDAOJPA() {
    }

    @Override
    public Videojuego nuevoVideojuego(String nombre, Sistema s, String rutaJuego, String rutaFoto, List<Categoria> c) {
        GestorEntityManager gm = GestorEntityManager.getINSTANCIA();
        VideojuegoJPA video = new VideojuegoJPA();

        for (Categoria i : c) {
            if (s instanceof SistemaJPA && i instanceof CategoriaJPA) {
                try {
                    video.setNombre(nombre);

                    gm.getEntityManager().getTransaction().begin();
                    gm.getEntityManager().persist(video);
                    gm.getEntityManager().getTransaction().commit();

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                throw new IllegalArgumentException("Los parámetros no se pueden guardar en la base de datos");
            }
        }
        return video;
    }

    @Override
    public List<VideojuegoJPA> getVideojuegos(String patron, Sistema s, Categoria c) {
        List<VideojuegoJPA> listavideo = new ArrayList<>();

        GestorEntityManager gm = GestorEntityManager.getINSTANCIA();

        listavideo = gm.getEntityManager().createQuery("Select e from Emuladores where nombre like '%patron%' and sistema like '%s%' and categoria like '%c%' ").getResultList();

        gm.getEntityManager().find(VideojuegoDAO.class, listavideo);

        return listavideo;
    }
}