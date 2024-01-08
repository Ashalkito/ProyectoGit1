package dam.psp.emuladores.dao;

public interface CategoriaDAO {
    public Categoria nuevaCategoria(String n);

    public List<Categoria> getCategorias();
}
