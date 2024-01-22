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
        CategoriaJPA cj=new CategoriaJPA();
        try {
            cj.setNombre(n);
            EntityManager em=GestorEntityManager.getINSTANCIA().getEntityManager();
            em.getTransaction().begin();
            em.persist(cj);
            em.getTransaction().commit();
        }catch (Exception e){
            System.out.println("Fallo metodo nueva categoria");
            cj=null;
        }
        return cj;
    }

    @Override
    public List<CategoriaJPA> getCategorias() {
        List<CategoriaJPA> cts=null;
        try {
            EntityManager em=GestorEntityManager.getINSTANCIA().getEntityManager();
            cts=em.createQuery("SELECT c FROM CategoriaJPA c").getResultList();
        }catch (Exception e){
            System.out.println("No se pudo acceder a la lista de Categorias");
        }
        return cts;
    }
}
