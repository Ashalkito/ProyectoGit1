package dam.psp.emuladores.dao;

import dam.psp.emuladores.modelo.Sistema;
import dam.psp.emuladores.modelo.Videojuego;

import java.util.List;

public interface SistemaDAO {
    public Sistema nuevoSistema(String nombre);

    public <T extends Sistema> List<T> getSistema();
}
