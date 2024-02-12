package dam.psp.emuladores.modelo;

import dam.psp.emuladores.dao.CategoriaDAO;
import dam.psp.emuladores.dao.EmuladorDAO;
import dam.psp.emuladores.dao.SistemaDAO;
import dam.psp.emuladores.dao.VideojuegoDAO;
import dam.psp.emuladores.dao.jpa.VideojuegoDAOJPA;
//a
public interface ProgramaEmuladoresDAOFactory {
    public SistemaDAO getSistemaDAO();
    public EmuladorDAO getEmuladorDAO();
    public VideojuegoDAO getVideojuegoDAO();
    public CategoriaDAO getCategoriaDAO();
}
