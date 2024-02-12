package dam.psp.emuladores.modelo.bin;

import dam.psp.emuladores.modelo.Videojuego;

import java.util.List;

public class SistemaBin {
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
}
