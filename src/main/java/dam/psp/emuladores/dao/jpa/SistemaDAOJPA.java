package dam.psp.emuladores.dao.jpa;

import dam.psp.emuladores.dao.SistemaDAO;
import dam.psp.emuladores.modelo.Sistema;
import dam.psp.emuladores.modelo.Videojuego;

import java.util.List;

public class SistemaDAOJPA implements SistemaDAO {

    @Override
    public Sistema nuevoSistema(String nombre) {
        throw new UnsupportedOperationException("Método sin progrmar");
    }

    @Override
    public <T extends Sistema> List<T> getSistema() {
        throw new UnsupportedOperationException("Método sin progrmar");
    }
}
