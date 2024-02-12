package dam.psp.emuladores.dao.bin;

import dam.psp.emuladores.dao.EmuladorDAO;
import dam.psp.emuladores.gestores.GestorArchivoBin;
import dam.psp.emuladores.gestores.GestorEntityManager;
import dam.psp.emuladores.modelo.Emulador;
import dam.psp.emuladores.modelo.Sistema;
import dam.psp.emuladores.modelo.bin.EmuladorBin;
import dam.psp.emuladores.modelo.bin.SistemaBin;
import dam.psp.emuladores.modelo.jpa.EmuladorJPA;
import dam.psp.emuladores.modelo.jpa.SistemaJPA;

import java.util.List;

public class EmuladoresDAOBin implements EmuladorDAO {
    @Override
    public Emulador nuevoEmulador(String nombre, String ruta, String lc, Sistema s) {
        EmuladorBin e = null;
        if (s instanceof SistemaBin sistema) {
            GestorArchivoBin gab = GestorArchivoBin.getInstancia();
            List<EmuladorBin> emuladores = gab.getEmuladores();
            int longitud = emuladores.size();
            e = new EmuladorBin(emuladores.get(longitud - 1).getId(), nombre, ruta, lc, sistema);
        } else {
            throw new IllegalArgumentException("El emulador no puede ser guardado en la base de datos");
        }
        return e;
    }

    @Override
    public List<EmuladorBin> getEmuladores(Sistema s) {
        return GestorArchivoBin.getInstancia().getEmuladores();
    }
}
