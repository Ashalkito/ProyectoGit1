package dam.psp.emuladores.test;

import dam.psp.emuladores.dao.bin.SistemaDAOBin;
import dam.psp.emuladores.dao.jpa.SistemaDAOJPA;
import dam.psp.emuladores.gestores.GestorArchivoBin;
import dam.psp.emuladores.modelo.bin.SistemaBin;
import dam.psp.emuladores.modelo.jpa.SistemaJPA;

public class ProgramaSistemaDAOBin {
    public static void main(String[] args) {
        //1
        SistemaDAOBin sistema = new SistemaDAOBin();
        sistema.nuevoSistema("game boy");
        sistema.nuevoSistema("megadrive");
        sistema.nuevoSistema("neo geo");
        //2
        for(SistemaBin s: GestorArchivoBin.getInstancia().getSistemas()){
            System.out.println(s.getNombre()+" "+s.getEmuladores()+" "+s.getJuegos());
        }
    }
}
