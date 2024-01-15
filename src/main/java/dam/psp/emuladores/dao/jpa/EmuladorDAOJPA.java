package dam.psp.emuladores.dao.jpa;

import dam.psp.emuladores.dao.EmuladorDAO;
import dam.psp.emuladores.gestores.GestorEntityManager;
import dam.psp.emuladores.modelo.Emulador;
import dam.psp.emuladores.modelo.Sistema;
import dam.psp.emuladores.modelo.jpa.CategoriaJPA;
import dam.psp.emuladores.modelo.jpa.EmuladorJPA;
import dam.psp.emuladores.modelo.jpa.SistemaJPA;
import dam.psp.emuladores.modelo.jpa.VideojuegoJPA;

import java.util.ArrayList;
import java.util.List;

public class EmuladorDAOJPA implements EmuladorDAO {

    @Override
    public Emulador nuevoEmulador(String nombre, String ruta, String lc, Sistema s){
        EmuladorJPA e=null;
        if(s instanceof SistemaJPA){
            GestorEntityManager gem=GestorEntityManager.getINSTANCIA();
            e=new EmuladorJPA();
            e.setNombre(nombre);
            e.setRuta(ruta);
            e.setLineaComandos(lc);
            e.setSistema((SistemaJPA) s);

            gem.getEntityManager().getTransaction().begin();
            gem.getEntityManager().persist(e);
            gem.getEntityManager().getTransaction().commit();
        }else{
            throw new IllegalArgumentException("El sistema no puede ser guardado en la base de datos");
        }
        return e;
    }
    @Override
    public List<EmuladorJPA> getEmuladores(Sistema s) {
        GestorEntityManager gem=GestorEntityManager.getINSTANCIA();
        return gem.getEntityManager()
                .createQuery("Select emu from EmuladorJPA emu", EmuladorJPA.class)
                .getResultList();
    }

    public static void main(String[] args) {
        ej1();
    }
    public static void ej1(){
        Emulador e1=new EmuladorDAOJPA()
                .nuevoEmulador("game boy","a","a",new SistemaJPA());
        Emulador e2=new EmuladorDAOJPA()
                .nuevoEmulador("megadrive","b","b", new SistemaJPA());
        Emulador e3=new EmuladorDAOJPA()
                .nuevoEmulador("neo geo","c","c", new SistemaJPA());
    }

}
