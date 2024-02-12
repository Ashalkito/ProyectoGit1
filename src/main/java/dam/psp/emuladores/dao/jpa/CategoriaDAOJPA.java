package dam.psp.emuladores.dao.jpa;

import dam.psp.emuladores.dao.CategoriaDAO;
import dam.psp.emuladores.gestores.GestorEntityManager;
import dam.psp.emuladores.modelo.Categoria;
import dam.psp.emuladores.modelo.jpa.CategoriaJPA;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDAOJPA implements CategoriaDAO {
    @Override
    public Categoria nuevaCategoria(String n) {
        EntityManager em = GestorEntityManager.getINSTANCIA().getEntityManager();
        CategoriaJPA categoria = null;

        try {
            categoria=new CategoriaJPA();
            categoria.setNombre(n);
            em.getTransaction().begin();
            em.persist(categoria);
            em.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return categoria;
    }

    @Override
    public List<CategoriaJPA> getCategorias() {
        EntityManager em = GestorEntityManager.getINSTANCIA().getEntityManager();
        List<CategoriaJPA> cts = null;
        try {
            cts = em.createQuery("SELECT c FROM CategoriaJPA c").getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cts;
    }
}
