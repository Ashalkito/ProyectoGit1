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
            if (s instanceof SistemaJPA sistema && i instanceof CategoriaJPA categoria) {
                try {
                    List<CategoriaJPA> listacat = new ArrayList<>();
                    listacat.add(categoria);
                    video.setNombre(nombre);
                    video.setSistema(sistema);
                    video.setCategorias(listacat);
                    video.setNombre(nombre);
                    video.setRutaFoto(rutaFoto);
                    video.setRuta(rutaJuego);
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


        String jpql= "SELECT c FROM VideoJuegoJPA c";

        if (patron==null || s==null || c==null){
            jpql.concat(" WHERE ");
        }

        String vi="c.nombre LIKE '%"+patron+"%'";
        String si="c.sistema_id = '"+s.getId()+"' ";
        String ca="id IN ( SELECT videojuegoJPA_id FROM videojuegojpa_categoriajpa WHERE categorias_id = '"+c.getId()+"' )";

        if(patron !=null){
            jpql.concat(vi);
        }
        if(s != null){
            jpql.concat(si);
        }
        if (c != null) {
            jpql.concat(ca);
        }

        EntityManager gm= GestorEntityManager.getINSTANCIA().getEntityManager();

        listavideo=gm.createQuery(jpql,VideojuegoJPA.class)
                .getResultList();

        return listavideo;

    }
}