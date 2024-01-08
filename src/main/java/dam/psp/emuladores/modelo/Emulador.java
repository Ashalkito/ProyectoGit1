package dam.psp.emuladores.modelo;

public interface Emulador {
    public int getId();
    public String getNombre();
    public String getRuta();
    public String getLineaComandos();
    public Sistema getSistema();
    public default boolean abrir(Videojuego v, boolean grabarVideo){
        throw new UnsupportedOperationException(("Sin programar"));
    }
}
