package dam.psp.emuladores.modelo.bin;

import java.util.List;

public class CategoriaBin {
    private int id;
    private String nombre;
    private List<VideojuegoBin> juegos;

    public CategoriaBin(int id, String nombre, List<VideojuegoBin> juegos) {
        this.id = id;
        this.nombre = nombre;
        this.juegos = juegos;
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
}
