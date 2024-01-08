package dam.psp.emuladores.gestores;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class GestorEntityManager {
    private static GestorEntityManager INSTANCIA;
    private EntityManager entityManager;
    private GestorEntityManager(){
        entityManager= Persistence.createEntityManagerFactory("PU_EMULADORES").createEntityManager();
    }
    public EntityManager getEntityManager(){
        return entityManager;
    }
    public static GestorEntityManager getINSTANCIA(){
        GestorEntityManager gem;
        if(INSTANCIA==null){
            gem=new GestorEntityManager();
        }else {
            gem=INSTANCIA;
        }
        return gem;
    }

}
//static a la instancia
//
