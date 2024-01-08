package dam.psp.emuladores.modelo;

import java.util.List;

public interface Videojuego {
    public int getId();
    public String getNombre();
    public Sistema getSistema();
    public String getRuta();
    public String getRutaFoto();
    public <T extends Categoria> List<T> getCategorias();
}
