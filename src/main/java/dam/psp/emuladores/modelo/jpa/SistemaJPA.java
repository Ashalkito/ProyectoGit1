package dam.psp.emuladores.modelo.jpa;

import dam.psp.emuladores.gestores.GestorEntityManager;
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

    public SistemaJPA(){

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
        List<VideojuegoJPA> lista = new ArrayList<>();
        GestorEntityManager gm = GestorEntityManager.getINSTANCIA();
        lista  = gm.getEntityManager().createQuery("SELECT v FROM VideojuegoJPA v").getResultList();
        return lista;
    }

    public List<EmuladorJPA> getEmuladores() {
        List<EmuladorJPA> lista = new ArrayList<>();
        GestorEntityManager gm = GestorEntityManager.getINSTANCIA();
        lista  = gm.getEntityManager().createQuery("SELECT e FROM EmuladorJPA e").getResultList();
        return lista;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
