package dam.psp.emuladores.modelo.jpa;

import dam.psp.emuladores.modelo.Categoria;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CategoriaJPA implements Serializable{
    @Override
    public String toString() {
        return this.nombre;
    }
    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    @ManyToMany
    private List<VideojuegoJPA> juegos;

    public CategoriaJPA() {}

    public CategoriaJPA(int id, String nombre, List<VideojuegoJPA> juegos) {
        this.id = id;
        this.nombre = nombre;
        this.juegos = new ArrayList<>();
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

    public List<VideojuegoJPA> getJuegos() {
        return juegos;
    }

    public void setJuegos(List<VideojuegoJPA> juegos) {
        this.juegos = juegos;
    }
}
