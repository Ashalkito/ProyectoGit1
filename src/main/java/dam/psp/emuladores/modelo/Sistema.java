package dam.psp.emuladores.modelo;

import java.util.List;

public interface Sistema {
    public int getId();
    public String getNombre();
    public <T extends Videojuego> List<T> getJuegos();
    public <T extends Emulador> List<T> getEmuladores();
}
