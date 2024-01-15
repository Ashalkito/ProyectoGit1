package dam.psp.emuladores.dao.jpa;

import dam.psp.emuladores.dao.EmuladorDAO;
import dam.psp.emuladores.modelo.Emulador;
import dam.psp.emuladores.modelo.Sistema;
import dam.psp.emuladores.modelo.jpa.EmuladorJPA;
import dam.psp.emuladores.modelo.jpa.SistemaJPA;

import java.util.List;

public class EmuladorDAOJPA implements EmuladorDAO {

    @Override
    public Emulador nuevoEmulador(String nombre, String ruta, String lc, Sistema s){
        /*if(s instanceof SistemaJPA){

        }*/
        throw new UnsupportedOperationException("Método sin programar");
    }
    @Override
    public <T extends Emulador> List<T> getEmuladores(Sistema s) {
        throw new UnsupportedOperationException("Método sin programar");
    }

}
