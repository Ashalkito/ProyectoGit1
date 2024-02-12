package dam.psp.emuladores.dao.bin;

import dam.psp.emuladores.dao.CategoriaDAO;
import dam.psp.emuladores.gestores.GestorArchivoBin;
import dam.psp.emuladores.modelo.Categoria;
import dam.psp.emuladores.modelo.bin.CategoriaBin;
import dam.psp.emuladores.modelo.bin.SistemaBin;

import java.util.List;

public class CategoriaDAOBin implements CategoriaDAO {
    @Override
    public Categoria nuevaCategoria(String n) {
        GestorArchivoBin gab = GestorArchivoBin.getInstancia();
        List<CategoriaBin> lista = gab.getCategorias();
        CategoriaBin ultimo = lista.get(lista.size()-1);
        CategoriaBin c = new CategoriaBin(ultimo.getId()+1, n, gab.getVideojuegos());
        lista.add(c);
        return c;
    }

    @Override
    public List<CategoriaBin> getCategorias() {
        return GestorArchivoBin.getInstancia().getCategorias();
    }
}
