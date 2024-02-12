package dam.psp.emuladores.test;

import dam.psp.emuladores.dao.CategoriaDAO;
import dam.psp.emuladores.dao.jpa.CategoriaDAOJPA;
import dam.psp.emuladores.modelo.Categoria;
import dam.psp.emuladores.modelo.ConfiguracionLectura;
import dam.psp.emuladores.modelo.jpa.CategoriaJPA;

import java.util.List;
import java.util.Scanner;

public class ProgramasCategoria {
    public static void main(String[] args) {
        CategoriaDAO jd= ConfiguracionLectura.progEmDAOFac.getCategoriaDAO();
        jd.nuevaCategoria("Plataformas");
        jd.nuevaCategoria("Romance");
        jd.nuevaCategoria("Terror");
        System.out.println("Para cargar las categorias");
        String s=new Scanner(System.in).nextLine();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("El sleep");
        }
        List<Categoria> categorias=jd.getCategorias();
        for (Categoria i:categorias){
            System.out.println(i.getNombre());
        }
    }
}
