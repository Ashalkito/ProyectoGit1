package dam.psp.emuladores.dao;

import dam.psp.emuladores.modelo.Categoria;

import java.util.List;

public interface CategoriaDAO {
    public Categoria nuevaCategoria(String n);

    public <T extends Categoria> List<T> getCategorias();
}
