package dam.psp.emuladores.modelo.jpa;

public class EmuladorJPA implements Emulador{
    private int id;
    private String nombre;
    private String ruta;
    private String lineaComandos;
    private SistemaJPA sistema;
    public EmuladorJPA(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getLineaComandos() {
        return lineaComandos;
    }

    public void setLineaComandos(String lineaComandos) {
        this.lineaComandos = lineaComandos;
    }

    public SistemaJPA getSistema() {
        return sistema;
    }

    public void setSistema(SistemaJPA sistema) {
        this.sistema = sistema;
    }
}
