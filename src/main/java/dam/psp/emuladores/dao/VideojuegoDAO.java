package dam.psp.emuladores.dao;

import dam.psp.emuladores.modelo.Categoria;
import dam.psp.emuladores.modelo.Sistema;
import dam.psp.emuladores.modelo.Videojuego;

import java.util.List;

public interface VideojuegoDAO {
    public Videojuego nuevoVideojuego(String nombre, Sistema s, String rutaFoto, List<Categoria> c);
    public <T extends Videojuego> List<T> getVideojuegos(String patron, Sistema s, Categoria c);
}
