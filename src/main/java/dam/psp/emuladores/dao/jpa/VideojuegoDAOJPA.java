package dam.psp.emuladores.dao.jpa;

import com.sun.tools.attach.VirtualMachineDescriptor;
import dam.psp.emuladores.dao.VideojuegoDAO;
import dam.psp.emuladores.modelo.Categoria;
import dam.psp.emuladores.modelo.Sistema;
import dam.psp.emuladores.modelo.Videojuego;
import dam.psp.emuladores.modelo.jpa.CategoriaJPA;
import dam.psp.emuladores.modelo.jpa.SistemaJPA;
import dam.psp.emuladores.modelo.jpa.VideojuegoJPA;

import java.util.List;


public class VideojuegoDAOJPA implements VideojuegoDAO {
    public VideojuegoDAOJPA() {
    }
    @Override
    public Videojuego nuevoVideojuego(String nombre, Sistema s, String rutaFoto, List<Categoria> c) {
        for(Categoria i:c ){
        if(s instanceof SistemaJPA && i instanceof CategoriaJPA) {
            return nuevoVideojuego(nombre, s, rutaFoto, c);
        }else{
            throw new IllegalArgumentException("error");
        }
    }

    @Override
    public List <VideojuegoJPA> getVideojuegos(String patron, Sistema s, Categoria c) {
        throw new UnsupportedOperationException("Método sin programar");
    }
}
