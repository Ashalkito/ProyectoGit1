package dam.psp.emuladores.dao;

import dam.psp.emuladores.modelo.Emulador;
import dam.psp.emuladores.modelo.Sistema;

import java.util.List;

public interface EmuladorDAO {
    public Emulador nuevoEmulador(String nombre, String ruta, String lc, Sistema s);

    public <T extends Emulador> List<T> getEmuladores(Sistema s);
}
