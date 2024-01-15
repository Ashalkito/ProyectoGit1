package dam.psp.emuladores.dao.jpa;

import com.sun.tools.attach.VirtualMachineDescriptor;
import dam.psp.emuladores.dao.VideojuegoDAO;
import dam.psp.emuladores.gestores.GestorEntityManager;
import dam.psp.emuladores.modelo.Categoria;
import dam.psp.emuladores.modelo.Sistema;
import dam.psp.emuladores.modelo.Videojuego;
import dam.psp.emuladores.modelo.jpa.CategoriaJPA;
import dam.psp.emuladores.modelo.jpa.SistemaJPA;
import dam.psp.emuladores.modelo.jpa.VideojuegoJPA;

import java.util.ArrayList;
import java.util.List;


public class VideojuegoDAOJPA implements VideojuegoDAO {
    public VideojuegoDAOJPA() {
    }
    @Override
    public Videojuego nuevoVideojuego(String nombre, Sistema s, String rutaFoto, List<Categoria> c) {
        GestorEntityManager gm = GestorEntityManager.getINSTANCIA();
       VideojuegoJPA video = null;
        for(Categoria i:c ) {
            if (s instanceof SistemaJPA && i instanceof CategoriaJPA) {
                video = (VideojuegoJPA) nuevoVideojuego(nombre, s, rutaFoto, c);
            } else {
                throw new IllegalArgumentException("error");
            }
            try {
                gm.getEntityManager().getTransaction().begin();
                gm.getEntityManager().persist(video);
                gm.getEntityManager().getTransaction().commit();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return video;
    }

    @Override
    public List <VideojuegoJPA> getVideojuegos(String patron, Sistema s, Categoria c) {
        List<VideojuegoJPA> listavideo = new ArrayList<>();

        GestorEntityManager gm = GestorEntityManager.getINSTANCIA();
        VideojuegoJPA videoencontrar = new VideojuegoJPA();
        gm.getEntityManager().find(VideojuegoDAO.class,videoencontrar);

        return listavideo;
    }
}
