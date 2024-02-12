package dam.psp.emuladores.modelo.bin;

import dam.psp.emuladores.modelo.Sistema;
import dam.psp.emuladores.modelo.Videojuego;

import java.util.List;
import java.util.Objects;

public class SistemaBin implements Sistema {
    private int id;
    private String nombre;
    private List<VideojuegoBin> juegos;
    private List<EmuladorBin> emuladores;

    public SistemaBin(int id, String nombre, List<VideojuegoBin> juegos, List<EmuladorBin> emuladores) {
        this.id = id;
        this.nombre = nombre;
        this.juegos = juegos;
        this.emuladores = emuladores;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<VideojuegoBin> getJuegos() {
        return juegos;
    }

    public List<EmuladorBin> getEmuladores() {
        return emuladores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SistemaBin that = (SistemaBin) o;
        return id == that.id && Objects.equals(nombre, that.nombre) && Objects.equals(juegos, that.juegos) && Objects.equals(emuladores, that.emuladores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, juegos, emuladores);
    }
}
