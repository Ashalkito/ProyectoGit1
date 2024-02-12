package dam.psp.emuladores.dao.bin;

import dam.psp.emuladores.dao.SistemaDAO;
import dam.psp.emuladores.gestores.GestorArchivoBin;
import dam.psp.emuladores.modelo.Sistema;
import dam.psp.emuladores.modelo.bin.SistemaBin;

import java.util.List;

public class SistemaDAOBin implements SistemaDAO {
    @Override
    public Sistema nuevoSistema(String nombre) {
        GestorArchivoBin gab = GestorArchivoBin.getInstancia();
        List<SistemaBin> lista=gab.getSistemas();
        SistemaBin ultimo = lista.get(lista.size()-1);
        SistemaBin s=new SistemaBin(ultimo.getId()+1,nombre,gab.getVideojuegos(),gab.getEmuladores());
        lista.add(s);
        return s;
    }

    @Override
    public List<SistemaBin> getSistema() {
        return GestorArchivoBin.getInstancia().getSistemas();
    }
}
