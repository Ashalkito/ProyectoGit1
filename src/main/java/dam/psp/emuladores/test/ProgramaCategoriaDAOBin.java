package dam.psp.emuladores.test;

import dam.psp.emuladores.dao.bin.CategoriaDAOBin;
import dam.psp.emuladores.modelo.Categoria;

public class ProgramaCategoriaDAOBin {
    public static void main(String[] args) {
        CategoriaDAOBin c = new CategoriaDAOBin();
        c.nuevaCategoria("RPG");
        for(Categoria categoria : c.getCategorias()){
            System.out.println(categoria.getNombre());
        }
    }
}
