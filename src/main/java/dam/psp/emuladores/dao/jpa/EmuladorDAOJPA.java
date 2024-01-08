package dam.psp.emuladores.dao.jpa;

import dam.psp.emuladores.dao.EmuladorDAO;
import dam.psp.emuladores.modelo.Emulador;
import dam.psp.emuladores.modelo.Sistema;

import java.util.List;

public class EmuladorDAOJPA implements EmuladorDAO {

    @Override
    public Emulador nuevoEmulador(String nombre, String ruta, String lc, Sistema s){
        throw new UnsupportedOperationException("Método sin programar");
    }
    @Override
    public <T extends Emulador> List<T> getEmuladores(Sistema s) {
        throw new UnsupportedOperationException("Método sin programar");
    }

}
