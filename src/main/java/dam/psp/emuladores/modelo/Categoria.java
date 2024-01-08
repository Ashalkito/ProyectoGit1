package dam.psp.emuladores.modelo;

public interface Categoria {
    public int getId();
    public String getNombre();
    public <T> List<T extends Videojuego> getJuegos();
}
