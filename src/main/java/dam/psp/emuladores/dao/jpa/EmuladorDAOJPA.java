package dam.psp.emuladores.dao.jpa;

import dam.psp.emuladores.dao.EmuladorDAO;
import dam.psp.emuladores.gestores.GestorEntityManager;
import dam.psp.emuladores.modelo.Emulador;
import dam.psp.emuladores.modelo.Sistema;
import dam.psp.emuladores.modelo.jpa.EmuladorJPA;
import dam.psp.emuladores.modelo.jpa.SistemaJPA;

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
        List<EmuladorJPA> lista=new ArrayList<>();
        GestorEntityManager gem=GestorEntityManager.getINSTANCIA();
        lista=gem.getEntityManager()
                .createQuery("Select emu from EmuladorJPA emu", EmuladorJPA.class)
                .getResultList();

        return lista;
    }

}
