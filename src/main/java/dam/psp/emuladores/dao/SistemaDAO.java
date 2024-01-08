package dam.psp.emuladores.dao;

public interface SistemaDAO {
    public Sistema nuevoSistema(String nombre);

    public List<Sistema> getSistema();
}
