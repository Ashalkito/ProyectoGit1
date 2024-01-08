package dam.psp.emuladores.modelo;

import dam.psp.emuladores.dao.CategoriaDAO;
import dam.psp.emuladores.dao.EmuladorDAO;
import dam.psp.emuladores.dao.SistemaDAO;
import dam.psp.emuladores.dao.VideojuegoDAO;

public class DAOFactory {
    public static SistemaDAO getSistemaDAO(){
        throw new UnsupportedOperationException("Sin programar");
    }
    public static EmuladorDAO getEmuladorDAO(){
        throw new UnsupportedOperationException("Sin programar");
    }
    public static VideojuegoDAO getVideojuegoDAO(){
        throw new UnsupportedOperationException("Sin programar");
    }
    public static CategoriaDAO getCategoriaDAO(){
        throw new UnsupportedOperationException("Sin programar");
    }
}
