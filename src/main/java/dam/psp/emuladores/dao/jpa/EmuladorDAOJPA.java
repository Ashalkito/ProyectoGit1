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
    public Emulador nuevoEmulador(String nombre, String ruta, String lc, Sistema s) {
        GestorEntityManager gem = GestorEntityManager.getINSTANCIA();
        EmuladorJPA emulador = null;
        try {
            emulador = new EmuladorJPA();

            if (s instanceof SistemaJPA) {
                emulador.setNombre(nombre);
                emulador.setRuta(ruta);
                emulador.setLineaComandos(lc);
                emulador.setSistema((SistemaJPA) s);

                gem.getEntityManager().getTransaction().begin();
                gem.getEntityManager().persist(emulador);
                gem.getEntityManager().getTransaction().commit();

            } else {
                throw new IllegalArgumentException("El sistema no puede ser guardado en la base de datos");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return emulador;
    }

    @Override
    public List<EmuladorJPA> getEmuladores(Sistema s) {
        GestorEntityManager gem = GestorEntityManager.getINSTANCIA();
        return gem.getEntityManager()
                .createQuery("Select emu from EmuladorJPA emu", EmuladorJPA.class)
                .getResultList();
    }
}