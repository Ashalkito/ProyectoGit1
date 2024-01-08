package dam.psp.emuladores.gestores;

import jakarta.persistence.EntityManager;

public class GestorEntityManager {
    private static GestorEntityManager INSTANCIA;
    private EntityManager entityManager;
    private GestorEntityManager(){

    }
    public EntityManager getEntityManager(){
        throw new UnsupportedOperationException();
    }
    public static GestorEntityManager getINSTANCIA(){
        throw new UnsupportedOperationException();
    }

}
//static a la instancia
//
