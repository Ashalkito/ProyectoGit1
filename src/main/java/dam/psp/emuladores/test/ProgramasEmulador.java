package dam.psp.emuladores.test;

import dam.psp.emuladores.dao.jpa.EmuladorDAOJPA;
import dam.psp.emuladores.modelo.Emulador;
import dam.psp.emuladores.modelo.jpa.EmuladorJPA;
import dam.psp.emuladores.modelo.jpa.SistemaJPA;

import java.util.List;

public class ProgramasEmulador {
    public static void main(String[] args) {
        ej2();
    }
    public static void ej1(){
        Emulador e1=new EmuladorDAOJPA()
                .nuevoEmulador("game boy","a","a",new SistemaJPA());
        Emulador e2=new EmuladorDAOJPA()
                .nuevoEmulador("megadrive","b","b", new SistemaJPA());
        Emulador e3=new EmuladorDAOJPA()
                .nuevoEmulador("neo geo","c","c", new SistemaJPA());
    }
    public static void ej2(){
        List<EmuladorJPA> lista=new EmuladorDAOJPA().getEmuladores(new EmuladorJPA().getSistema());
        for(EmuladorJPA i:lista){
            System.out.println(i.getId()+" "
                    +i.getNombre()+" "
                    +i.getRuta()+" "
                    +i.getLineaComandos()+" "
                    +i.getSistema().getId()
            );
        }
    }
}
