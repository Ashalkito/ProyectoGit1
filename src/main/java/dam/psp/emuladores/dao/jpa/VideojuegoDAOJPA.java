package dam.psp.emuladores.dao.jpa;

import dam.psp.emuladores.dao.VideojuegoDAO;

public class VideojuegoDAOJPA implements VideojuegoDAO {
    @Override
    public Videojuego nuevoVideojuego(String nombre, Sistema s, String rutaFoto, List<Categoria> c) {
        throw new UnsupportedOperationException("Método sin programar");
    }

    @Override
    public List<Videojuego> getVideojuegos(String patron, Sistema s, Categoria c) {
        throw new UnsupportedOperationException("Método sin programar");
    }
}
