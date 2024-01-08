package dam.psp.emuladores.modelo;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public interface Emulador {
    public int getId();
    public String getNombre();
    public String getRuta();
    public String getLineaComandos();
    public Sistema getSistema();
    public default boolean abrir(Videojuego v, boolean grabarVideo){
        String archivoSalida = v.getNombre()+ LocalDate.now()+ LocalTime.now()+".mp4";
        String comandoGrabar = "ffmpeg -s "+Toolkit.getDefaultToolkit().getScreenResolution()+"-framerate 25 -f x11grab -i :0.0 "+archivoSalida;

        try {
            Process proceso = new ProcessBuilder(comandoGrabar).start();
        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
