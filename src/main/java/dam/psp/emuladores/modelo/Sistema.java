package dam.psp.emuladores.modelo;

public interface Sistema {
    public int getId();
    public String getNombre();
    public <T> List<T extends Videojuego> getJuegos();
    public <T> List<T extends Emulador> getEmuladores();
}
