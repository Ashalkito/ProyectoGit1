package dam.psp.emuladores.dao.jpa;

import dam.psp.emuladores.dao.SistemaDAO;
import dam.psp.emuladores.gestores.GestorEntityManager;
import dam.psp.emuladores.modelo.Sistema;
import dam.psp.emuladores.modelo.Videojuego;
import dam.psp.emuladores.modelo.jpa.SistemaJPA;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class SistemaDAOJPA implements SistemaDAO {

    @Override
    public Sistema nuevoSistema(String nombre) {
        SistemaJPA s = new SistemaJPA();
        if(s != null)
        {
            GestorEntityManager gm = GestorEntityManager.getINSTANCIA();
            s.setNombre(nombre);

            try{
                gm.getEntityManager().getTransaction().begin();
                gm.getEntityManager().persist(s);
                gm.getEntityManager().getTransaction().commit();

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return s;
    }

    @Override
    public List<SistemaJPA> getSistema() {
        GestorEntityManager gm = GestorEntityManager.getINSTANCIA();
        List<SistemaJPA> resultado = new ArrayList<>();

        try{
            resultado = gm.getEntityManager().createQuery("SELECT c FROM SistemaJPA c",SistemaJPA.class).getResultList();

        }catch (Exception e ){
            System.out.println(e.getMessage());
        }
        return resultado;
    }


    public static void main(String[] args) {

        //1
        SistemaDAOJPA sistema = new SistemaDAOJPA();
        sistema.nuevoSistema("game boy");
        sistema.nuevoSistema("megadrive");
        sistema.nuevoSistema("neo geo");
        //2
        for(SistemaJPA s: sistema.getSistema()){
            System.out.println(s.getNombre()+" "+s.getEmuladores()+" "+s.getJuegos());
        }
    }
}
