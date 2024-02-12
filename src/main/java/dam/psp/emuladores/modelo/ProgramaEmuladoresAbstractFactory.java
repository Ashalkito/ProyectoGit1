package dam.psp.emuladores.modelo;

public class ProgramaEmuladoresAbstractFactory {
    public ProgramaEmuladoresDAOFactory getDAOFactory(AlmacenDatos tipo,String...datos){
        return switch (tipo) {
            case JPA -> new DAOJPAFactory();
            case ARCHIVO_BIN -> new DAOBinFactory();
        };
    }
}
