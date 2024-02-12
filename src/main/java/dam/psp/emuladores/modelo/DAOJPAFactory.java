package dam.psp.emuladores.modelo;

import dam.psp.emuladores.dao.CategoriaDAO;
import dam.psp.emuladores.dao.EmuladorDAO;
import dam.psp.emuladores.dao.SistemaDAO;
import dam.psp.emuladores.dao.VideojuegoDAO;
import dam.psp.emuladores.dao.jpa.CategoriaDAOJPA;
import dam.psp.emuladores.dao.jpa.EmuladorDAOJPA;
import dam.psp.emuladores.dao.jpa.SistemaDAOJPA;
import dam.psp.emuladores.dao.jpa.VideojuegoDAOJPA;
//aa
public class DAOJPAFactory implements ProgramaEmuladoresDAOFactory{
    public SistemaDAO getSistemaDAO() {

        return new SistemaDAOJPA();
    }

    public EmuladorDAO getEmuladorDAO() {
        return new EmuladorDAOJPA();
    }

    public VideojuegoDAO getVideojuegoDAO() {

        return new VideojuegoDAOJPA();
    }

    public  CategoriaDAO getCategoriaDAO() {

        return new CategoriaDAOJPA();
    }

}
