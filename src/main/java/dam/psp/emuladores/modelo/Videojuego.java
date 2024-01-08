package dam.psp.emuladores.modelo;

public interface Videojuego {
    public int getId();
    public String getNombre();
    public Sistema getSistema();
    public String getRuta();
    public String getRutaFoto();
    public <T> List <T extends Categoria> getCategorias();
}
