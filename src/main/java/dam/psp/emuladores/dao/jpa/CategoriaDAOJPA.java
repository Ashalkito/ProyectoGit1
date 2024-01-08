package dam.psp.emuladores.dao.jpa;

import dam.psp.emuladores.dao.CategoriaDAO;
import dam.psp.emuladores.gestores.GestorEntityManager;
import dam.psp.emuladores.modelo.Categoria;
import dam.psp.emuladores.modelo.jpa.CategoriaJPA;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CategoriaDAOJPA implements CategoriaDAO {
    @Override
    public Categoria nuevaCategoria(String n) {
        Categoria c;
        try {
            CategoriaJPA cj=new CategoriaJPA();
            cj.setNombre(n);
            c= (Categoria) cj;
            EntityManager em=GestorEntityManager.getINSTANCIA().getEntityManager();
        }catch (Exception e){
            return  null;
        }
        return c;
    }

    @Override
    public List<CategoriaJPA> getCategorias() {
        throw new UnsupportedOperationException("Método sin programar");
    }
}
