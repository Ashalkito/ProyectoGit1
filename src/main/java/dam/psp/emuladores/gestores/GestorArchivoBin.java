package dam.psp.emuladores.gestores;

import java.io.IOException;
import java.util.List;

public class GestorArchivoBin {
    private static GestorArchivoBin INSTANCIA;
    private List<CategoriaBin> categorias;
    private List<SistemaBin> sistemas;
    private List<EmuladorBin> emuladores;
    private List<VideojuegoBin> videojuegos;

    private GestorArchivoBin(){}

    public static GestorArchivoBin getInstancia(){
        GestorArchivoBin gbin;
        if(gbin == null){
            gbin = new GestorArchivoBin();
        }else{
            gbin = INSTANCIA;
        }
        INSTANCIA = gbin;
        return INSTANCIA;
    }

    public List<CategoriaBin> getCategorias() {
        return categorias;
    }

    public List<SistemaBin> getSistemas() {
        return sistemas;
    }

    public List<EmuladorBin> getEmuladores() {
        return emuladores;
    }

    public List<VideojuegoBin> getVideojuegos() {
        return videojuegos;
    }

    public List<CategoriaBin> getCategorias(int id) {
        throw new UnsupportedOperationException("sin programar");
    }

    public List<SistemaBin> getSistemas(int id) {
        throw new UnsupportedOperationException("sin programar");
    }

    public List<EmuladorBin> getEmuladores(int id) {
        throw new UnsupportedOperationException("sin programar");
    }

    public List<VideojuegoBin> getVideojuegos(int id) {
        throw new UnsupportedOperationException("sin programar");
    }

    public void guardar() throws IOException {
        throw new UnsupportedOperationException("sin programar");
    }
    public void cargar() throws IOException{
        throw new UnsupportedOperationException("sin programar");

    }

}
