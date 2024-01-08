package dam.psp.emuladores.dao;

public interface EmuladorDAO {
    public nuevoEmulador(String nombre, String ruta, String lc, Sistema s);

    public List<Emulador> getEmuladores(Sistema s);
}
