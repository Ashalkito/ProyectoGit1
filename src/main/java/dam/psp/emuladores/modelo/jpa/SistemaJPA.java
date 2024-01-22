package dam.psp.emuladores.modelo.jpa;

import dam.psp.emuladores.modelo.Emulador;
import dam.psp.emuladores.modelo.Sistema;
import dam.psp.emuladores.modelo.Videojuego;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
public class SistemaJPA implements Sistema, Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "sistema")
    private List<VideojuegoJPA> juegos;
    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "sistema")
    private List<EmuladorJPA> emuladores;

    public SistemaJPA(){
        juegos=new ArrayList<>();
        emuladores=new ArrayList<>();
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
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

    public List<EmuladorJPA> getEmuladores() {
        return emuladores;
    }

    public void setEmuladores(List<EmuladorJPA> emuladores) {
        this.emuladores = emuladores;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
