package dam.psp.emuladores.dao.jpa;

import dam.psp.emuladores.dao.CategoriaDAO;
import dam.psp.emuladores.modelo.Categoria;

import java.util.List;

public class CategoriaDAOJPA implements CategoriaDAO {
    @Override
    public Categoria nuevaCategoria(String n) {
        throw new UnsupportedOperationException("Método sin programar");
    }

    @Override
    public <T extends Categoria> List<T> getCategorias() {
        throw new UnsupportedOperationException("Método sin programar");
    }
}
