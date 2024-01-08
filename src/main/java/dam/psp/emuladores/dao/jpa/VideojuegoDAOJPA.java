package dam.psp.emuladores.dao.jpa;

import dam.psp.emuladores.dao.VideojuegoDAO;
import dam.psp.emuladores.modelo.Categoria;
import dam.psp.emuladores.modelo.Sistema;
import dam.psp.emuladores.modelo.Videojuego;

import java.util.List;

public class VideojuegoDAOJPA implements VideojuegoDAO {
    @Override
    public Videojuego nuevoVideojuego(String nombre, Sistema s, String rutaFoto, List<Categoria> c) {
        throw new UnsupportedOperationException("Método sin programar");
    }

    @Override
    public <T extends Videojuego> List<T> getVideojuegos(String patron, Sistema s, Categoria c) {
        throw new UnsupportedOperationException("Método sin programar");
    }
}
