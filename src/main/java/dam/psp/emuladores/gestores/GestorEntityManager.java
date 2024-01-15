package dam.psp.emuladores.gestores;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class GestorEntityManager {
    private static GestorEntityManager INSTANCIA;
    private EntityManager entityManager;
    private GestorEntityManager(){
        entityManager= Persistence.createEntityManagerFactory("PU_CARRERAS").createEntityManager();
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
        INSTANCIA=gem;
        return INSTANCIA;
    }
    public static void main(String[] args) {
        EntityManager ex=GestorEntityManager.getINSTANCIA().getEntityManager();
        if (ex==null){
            System.out.println("No funciona");
        }else{
            System.out.println("Sos un crack");
        }
    }
}
//static a la instancia
//
