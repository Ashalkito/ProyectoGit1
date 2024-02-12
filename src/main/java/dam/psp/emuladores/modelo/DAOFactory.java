package dam.psp.emuladores.modelo;

import dam.psp.emuladores.dao.CategoriaDAO;
import dam.psp.emuladores.dao.EmuladorDAO;
import dam.psp.emuladores.dao.SistemaDAO;
import dam.psp.emuladores.dao.VideojuegoDAO;
import dam.psp.emuladores.dao.jpa.CategoriaDAOJPA;
import dam.psp.emuladores.dao.jpa.EmuladorDAOJPA;
import dam.psp.emuladores.dao.jpa.SistemaDAOJPA;
import dam.psp.emuladores.dao.jpa.VideojuegoDAOJPA;

public class DAOFactory {
    public static SistemaDAO getSistemaDAO(){
        return new SistemaDAOJPA();
    }
    public static EmuladorDAO getEmuladorDAO(){
        return new EmuladorDAOJPA();
    }
    public static VideojuegoDAO getVideojuegoDAO(){
        return new VideojuegoDAOJPA();
    }
    public static CategoriaDAO getCategoriaDAO(){
        return new CategoriaDAOJPA();
    }

    public static void main(String[] args) {
        if(DAOFactory.getSistemaDAO() == null){

        }
        Object sistemadao = DAOFactory.getSistemaDAO();
        Object emuladordao = DAOFactory.getEmuladorDAO();
        Object videojuegodao = DAOFactory.getVideojuegoDAO();
        if(sistemadao instanceof SistemaDAOJPA){
            System.out.println("SistemaDAO está bien");
        } else {
            System.out.println("SistemaDAO  no está bien");
        }
        if(emuladordao instanceof EmuladorDAOJPA){
            System.out.println("EmuladorDAO está bien");
        } else {
            System.out.println("EmuladorDAO  no está bien");
        }
        if(videojuegodao instanceof VideojuegoDAOJPA){
            System.out.println("videojuegodao está bien");
        } else {
            System.out.println("videojuegodao no está bien");
        }
    }
}
