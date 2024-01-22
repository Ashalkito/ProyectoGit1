package dam.psp.emuladores.test;

import dam.psp.emuladores.dao.jpa.SistemaDAOJPA;
import dam.psp.emuladores.modelo.jpa.SistemaJPA;

public class ProgramaSistema {
    public static void main(String[] args) {

        //1
        SistemaDAOJPA sistema = new SistemaDAOJPA();
        /*sistema.nuevoSistema("game boy");
        sistema.nuevoSistema("megadrive");
        sistema.nuevoSistema("neo geo");*/
        //2
        for(SistemaJPA s: sistema.getSistema()){
            System.out.println(s.getNombre()+" "+s.getEmuladores()+" "+s.getJuegos());
        }
    }
}
