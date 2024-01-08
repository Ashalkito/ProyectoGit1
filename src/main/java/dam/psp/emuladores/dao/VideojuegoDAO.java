package dam.psp.emuladores.dao;

public interface VideojuegoDAO {
    public Videojuego nuevoVideojuego(String nombre, Sistema s, String rutaFoto, List<Categoria> c);
    public List<Videojuego> getVideojuegos(String patron, Sistema s, Categoria c);
}
