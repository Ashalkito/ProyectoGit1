package dam.psp.emuladores.test;



import dam.psp.emuladores.dao.bin.EmuladorDAOBin;
import dam.psp.emuladores.gestores.GestorArchivoBin;
import dam.psp.emuladores.modelo.Emulador;
import dam.psp.emuladores.modelo.bin.EmuladorBin;
import dam.psp.emuladores.modelo.bin.SistemaBin;

import java.util.List;

public class ProgramaEmuladorDAOBin {
    public static void main(String[] args) {
        ej1();
    }
    public static void ej1(){
        GestorArchivoBin gab = GestorArchivoBin.getInstancia();
        List<SistemaBin> s = gab.getSistemas();
        Emulador e1=new EmuladorDAOBin()
                .nuevoEmulador("game boy","a","a",s.get(0));
        Emulador e2=new EmuladorDAOBin()
                .nuevoEmulador("megadrive","b","b", s.get(0));
        Emulador e3=new EmuladorDAOBin()
                .nuevoEmulador("neo geo","c","c", s.get(0));
    }
    /*
    public static void ej2(){
        List<EmuladorBin> lista=new EmuladorDAOBin().getEmuladores(new EmuladorBin().getSistema());
        for(EmuladorBin i:lista){
            System.out.println(i.getId()+" "
                    +i.getNombre()+" "
                    +i.getRuta()+" "
                    +i.getLineaComandos()+" "
                    +i.getSistema().getId()
            );
        }
    }*/
}
