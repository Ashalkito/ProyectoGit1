package dam.psp.emuladores.modelo;

public class ProgramaEmuladoresAbstractFactory {
    // Errata: hay que hacer el método static
    public static ProgramaEmuladoresDAOFactory getDAOFactory(AlmacenDatos tipo,String...datos){
        return switch (tipo) {
            case JPA -> new DAOJPAFactory();
            case ARCHIVO_BIN -> new DAOBinFactory();
        };
    }
}
