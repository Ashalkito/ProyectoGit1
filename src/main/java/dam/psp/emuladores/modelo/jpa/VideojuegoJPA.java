package dam.psp.emuladores.modelo.jpa;

import dam.psp.emuladores.modelo.Videojuego;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class VideojuegoJPA implements Videojuego,Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    @ManyToOne
    private SistemaJPA sistema;
    private String ruta;
    private String rutaFoto;
    @ManyToMany
    private List<CategoriaJPA> categorias;
    public VideojuegoJPA(){}
    public VideojuegoJPA(int id, String nombre, SistemaJPA sistema, String ruta, String rutaFoto, List<CategoriaJPA> categorias) {
        this.id = id;
        this.nombre = nombre;
        this.sistema = sistema;
        this.ruta = ruta;
        this.rutaFoto = rutaFoto;
        this.categorias = new ArrayList<>();

    }

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

    public SistemaJPA getSistema() {
        return sistema;
    }

    public void setSistema(SistemaJPA sistema) {
        this.sistema = sistema;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

    public List<CategoriaJPA> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaJPA> categorias) {
        this.categorias = categorias;
    }
}
