package dam.psp.emuladores.dao.bin;

import dam.psp.emuladores.dao.CategoriaDAO;
import dam.psp.emuladores.modelo.Categoria;

import java.util.List;

public class CategoriaDAOBin implements CategoriaDAO {
    @Override
    public Categoria nuevaCategoria(String n) {
        return null;
    }

    @Override
    public <T extends Categoria> List<T> getCategorias() {
        return null;
    }
}
