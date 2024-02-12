package dam.psp.emuladores.modelo.bin;

import dam.psp.emuladores.modelo.Videojuego;

import java.util.List;
import java.util.Objects;

public class VideojuegoBin implements Videojuego {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideojuegoBin that = (VideojuegoBin) o;
        return id == that.id && Objects.equals(nombre, that.nombre) && Objects.equals(sistema, that.sistema) && Objects.equals(ruta, that.ruta) && Objects.equals(rutaFoto, that.rutaFoto) && Objects.equals(categorias, that.categorias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, sistema, ruta, rutaFoto, categorias);
    }
}
