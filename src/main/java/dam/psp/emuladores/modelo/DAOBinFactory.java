package dam.psp.emuladores.modelo;

import dam.psp.emuladores.dao.CategoriaDAO;
import dam.psp.emuladores.dao.EmuladorDAO;
import dam.psp.emuladores.dao.SistemaDAO;
import dam.psp.emuladores.dao.VideojuegoDAO;

public class DAOBinFactory implements ProgramaEmuladoresDAOFactory{
    @Override
    public SistemaDAO getSistemaDAO() {
        return null;
    }

    @Override
    public EmuladorDAO getEmuladorDAO() {
        return null;
    }

    @Override
    public VideojuegoDAO getVideojuegoDAO() {
        return null;
    }

    @Override
    public CategoriaDAO getCategoriaDAO() {
        return null;
    }
}
