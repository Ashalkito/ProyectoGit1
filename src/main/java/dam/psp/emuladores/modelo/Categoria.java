package dam.psp.emuladores.modelo;

import java.util.List;

public interface Categoria {
    public int getId();
    public String getNombre();
    public <T extends Videojuego> List<T> getJuegos();
}
