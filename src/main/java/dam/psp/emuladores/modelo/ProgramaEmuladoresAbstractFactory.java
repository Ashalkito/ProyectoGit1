package dam.psp.emuladores.modelo;

public class ProgramaEmuladoresAbstractFactory {

    public static ProgramaEmuladoresDAOFactory getDAOFactory(AlmacenDatos tipo){
        return switch (tipo) {
            case JPA -> new DAOJPAFactory();
            case ARCHIVO_BIN -> new DAOBinFactory();
        };
    }
}
