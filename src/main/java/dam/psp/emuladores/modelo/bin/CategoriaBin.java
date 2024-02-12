package dam.psp.emuladores.modelo.bin;

import dam.psp.emuladores.modelo.Categoria;

import java.util.List;
import java.util.Objects;

public class CategoriaBin  implements Categoria {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaBin that = (CategoriaBin) o;
        return id == that.id && Objects.equals(nombre, that.nombre) && Objects.equals(juegos, that.juegos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, juegos);
    }
}
