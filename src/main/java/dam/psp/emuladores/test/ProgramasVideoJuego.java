package dam.psp.emuladores.test;

import dam.psp.emuladores.dao.jpa.VideojuegoDAOJPA;
import dam.psp.emuladores.gestores.GestorEntityManager;
import dam.psp.emuladores.modelo.Categoria;
import dam.psp.emuladores.modelo.Emulador;
import dam.psp.emuladores.modelo.Videojuego;
import dam.psp.emuladores.modelo.jpa.EmuladorJPA;
import dam.psp.emuladores.modelo.jpa.SistemaJPA;
import dam.psp.emuladores.modelo.jpa.VideojuegoJPA;

import java.util.List;
import java.util.Scanner;

public class ProgramasVideoJuego {
    public static void main(String[] args) {
        ejercicio1();
    }

    public static void ejercicio1() {


        /**Haz un programa de prueba que cree tres videojuegos, para los sistemas y
         emuladores añadidos a la base de datos en los tests de las clases
         SistemaDAOJPA y EmuladorDAOJPA. Asocialos a categorías añadidas en el test
         de la clase CategoriaDAOJPA*/

        /*String ruta = null;
        String rutafoto=null;
        List<Categoria> categorias = DAOFactory.getCategoriaDAO().getCategorias();
        Videojuego video1 = new VideojuegoDAOJPA().nuevoVideojuego("Los Sims",new SistemaJPA(),ruta,categorias);
        Videojuego video2 = new VideojuegoDAOJPA().nuevoVideojuego("Tetric",new SistemaJPA(),ruta,categorias);
        Videojuego video3= new VideojuegoDAOJPA().nuevoVideojuego("Packman",new SistemaJPA(),ruta,categorias);*/

    }

    public static void ejercicio2() {
        /**Haz un programa de prueba que recupere todos los videojuegos añadidos en el
         programa anterior y muestre por pantalla sus datos, comprobando que son
         correctos*/

        GestorEntityManager gm = GestorEntityManager.getINSTANCIA();

        List<VideojuegoJPA>listavideo =gm.getEntityManager().createQuery("Select c from VideojuegoJPA c",VideojuegoJPA.class ).getResultList();
        System.out.println(listavideo);
    }

    public static void ejercicio3() {
        /**Haz un programa de prueba que recupere todos los videojuegos asociados a una
         categoría y muestre por pantalla sus datos, comprobando que son correctos*/


        GestorEntityManager gm= GestorEntityManager.getINSTANCIA();
        List<VideojuegoJPA>videojuegosaso =gm.getEntityManager().createQuery("Select c from videojuegojpa c where c.id = (select a.juegos_id from categoriajpa_videojuegojpa a))",VideojuegoJPA.class ).getResultList();
        System.out.println(videojuegosaso);

    }

    public static void ejercicio4() {
        /**Haz un programa de prueba que recupere todos los videojuegos asociados a un
         sistema y muestre por pantalla sus datos, comprobando que son correctos*/
        GestorEntityManager gm= GestorEntityManager.getINSTANCIA();
        List<VideojuegoJPA>videosistema =gm.getEntityManager().createQuery("Select c from videojuegojpa c where c.id = (select a.juegos_id from sistemajpa a))",VideojuegoJPA.class ).getResultList();
        System.out.println(videosistema);

    }

    public static void ejercicio5() {
        /**Haz un programa de prueba que recupere todos los videojuegos cuyo nombre
         contiene una palabra introducida previamente por teclado, y muestre por pantalla
         sus datos, comprobando que son correctos*/

        System.out.println("Introduce un nombre");
        String nombreusuario= new Scanner(System.in).nextLine();

        GestorEntityManager gm= GestorEntityManager.getINSTANCIA();
        List <VideojuegoJPA> videousuario = gm.getEntityManager().createQuery("SELECT c from videojuegojpa c where c.nombre like '%nombreusuario%'",VideojuegoJPA.class).getResultList();
        System.out.println(videousuario);
    }

    public static void ejercicio6() {
        /**Haz un programa de prueba que recupere un videojuego que haya en la base de
         datos y lo lance, grabando en video la partida.*/

        GestorEntityManager gm= GestorEntityManager.getINSTANCIA();
        VideojuegoJPA videousuario = gm.getEntityManager().createQuery("SELECT c from videojuegojpa c limit 1",VideojuegoJPA.class).getSingleResult();
        Emulador emu = new EmuladorJPA();
        emu.abrir(videousuario,true);

    }
}
