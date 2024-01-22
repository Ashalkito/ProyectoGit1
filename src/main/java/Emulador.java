public class Emulador {
    private String nombre;
    private String sistema;
    private String categoría;

    public Emulador(String nombre, String sistema, String categoría) {
        this.nombre = nombre;
        this.sistema = sistema;
        this.categoría = categoría;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public void setCategoría(String categoría) {
        this.categoría = categoría;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSistema() {
        return sistema;
    }

    public String getCategoría() {
        return categoría;
    }
}
