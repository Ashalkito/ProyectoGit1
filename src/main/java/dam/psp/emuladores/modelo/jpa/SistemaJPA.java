package dam.psp.emuladores.modelo.jpa;

import dam.psp.emuladores.modelo.Emulador;
import dam.psp.emuladores.modelo.Sistema;
import dam.psp.emuladores.modelo.Videojuego;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
public class SistemaJPA implements Sistema, Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    @OneToMany
    private List<VideojuegoJPA> juegos;
    @OneToMany
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
}
