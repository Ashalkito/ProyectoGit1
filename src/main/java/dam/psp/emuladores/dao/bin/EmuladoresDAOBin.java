package dam.psp.emuladores.dao.bin;

import dam.psp.emuladores.dao.EmuladorDAO;
import dam.psp.emuladores.modelo.Emulador;
import dam.psp.emuladores.modelo.Sistema;

import java.util.List;

public class EmuladoresDAOBin implements EmuladorDAO {
    @Override
    public Emulador nuevoEmulador(String nombre, String ruta, String lc, Sistema s) {
        return null;
    }

    @Override
    public <T extends Emulador> List<T> getEmuladores(Sistema s) {
        return null;
    }
}
