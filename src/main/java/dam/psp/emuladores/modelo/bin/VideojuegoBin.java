package dam.psp.emuladores.modelo.bin;

import java.util.List;

public class VideojuegoBin {
    private int id;
    private String nombre;
    private SistemaBin sistema;
    private String ruta;
    private String rutaFoto;
    private List<CategoriaBin> categorias;

    public VideojuegoBin(int id, String nombre, SistemaBin sistema, String ruta, String rutaFoto, List<CategoriaBin> categorias) {
        this.id = id;
        this.nombre = nombre;
        this.sistema = sistema;
        this.ruta = ruta;
        this.rutaFoto = rutaFoto;
        this.categorias = categorias;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public SistemaBin getSistema() {
        return sistema;
    }

    public String getRuta() {
        return ruta;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    public List<CategoriaBin> getCategorias() {
        return categorias;
    }
}
