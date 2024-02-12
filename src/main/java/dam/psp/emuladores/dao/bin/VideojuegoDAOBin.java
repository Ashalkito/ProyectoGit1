package dam.psp.emuladores.dao.bin;

import dam.psp.emuladores.dao.VideojuegoDAO;
import dam.psp.emuladores.modelo.Categoria;
import dam.psp.emuladores.modelo.Sistema;
import dam.psp.emuladores.modelo.Videojuego;

import java.util.List;

public class VideojuegoDAOBin implements VideojuegoDAO {
    @Override
    public Videojuego nuevoVideojuego(String nombre, Sistema s, String rutaJuego, String rutaFoto, List<Categoria> c) {
        return null;
    }

    @Override
    public <T extends Videojuego> List<T> getVideojuegos(String patron, Sistema s, Categoria c) {
        return null;
    }
}
