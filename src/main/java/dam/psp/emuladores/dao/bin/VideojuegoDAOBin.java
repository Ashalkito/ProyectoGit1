package dam.psp.emuladores.dao.bin;

import dam.psp.emuladores.dao.VideojuegoDAO;
import dam.psp.emuladores.gestores.GestorArchivoBin;
import dam.psp.emuladores.modelo.Categoria;
import dam.psp.emuladores.modelo.Sistema;
import dam.psp.emuladores.modelo.Videojuego;
import dam.psp.emuladores.modelo.bin.CategoriaBin;
import dam.psp.emuladores.modelo.bin.SistemaBin;
import dam.psp.emuladores.modelo.bin.VideojuegoBin;
import dam.psp.emuladores.modelo.jpa.CategoriaJPA;
import dam.psp.emuladores.modelo.jpa.SistemaJPA;

import java.util.ArrayList;
import java.util.List;

public class VideojuegoDAOBin implements VideojuegoDAO {
    @Override
    public Videojuego nuevoVideojuego(String nombre, Sistema s, String rutaJuego, String rutaFoto, List<Categoria> c) {
        VideojuegoBin v = null;
        for (Categoria i : c) {
            if (s instanceof SistemaBin sistema && i instanceof CategoriaBin categoria) {
                List<CategoriaBin> categorias = new ArrayList<>();
                categorias.add(categoria);

                GestorArchivoBin gab = GestorArchivoBin.getInstancia();
                List<VideojuegoBin> lista = gab.getVideojuegos();
                VideojuegoBin ultimo = lista.get(lista.size() - 1);
                v = new VideojuegoBin(ultimo.getId() + 1, nombre, sistema, rutaJuego, rutaFoto, categorias);
                lista.add(v);
            }
        }
        return v;
    }

    @Override
    public List<VideojuegoBin> getVideojuegos(String patron, Sistema s, Categoria c) {
        List<VideojuegoBin> listaFinal=new ArrayList<>();
        GestorArchivoBin gab = GestorArchivoBin.getInstancia();
        List<VideojuegoBin> listaJuegos = gab.getVideojuegos();
        if(patron!=null && s!=null && c!=null){
            for (VideojuegoBin i: listaJuegos){
                if (i.getNombre().contains(patron) && i.getSistema() == s && i.getCategorias() == c){
                    listaFinal.add(i);
                }
            }

        }
        return listaFinal;
    }
}
