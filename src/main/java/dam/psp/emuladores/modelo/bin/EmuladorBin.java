package dam.psp.emuladores.modelo.bin;

public class EmuladorBin {
    private int id;
    private String nombre;
    private String ruta;
    private String lineaComandos;
    private SistemaBin sistema;

    public EmuladorBin(int id, String nombre, String ruta, String lineaComandos, SistemaBin sistema) {
        this.id = id;
        this.nombre = nombre;
        this.ruta = ruta;
        this.lineaComandos = lineaComandos;
        this.sistema = sistema;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public String getLineaComandos() {
        return lineaComandos;
    }

    public SistemaBin getSistema() {
        return sistema;
    }
}
