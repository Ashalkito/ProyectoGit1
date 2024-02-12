package dam.psp.emuladores.gestores;

import dam.psp.emuladores.dao.VideojuegoDAO;
import dam.psp.emuladores.dao.bin.EmuladorDAOBin;
import dam.psp.emuladores.modelo.Sistema;
import dam.psp.emuladores.modelo.bin.CategoriaBin;
import dam.psp.emuladores.modelo.bin.EmuladorBin;
import dam.psp.emuladores.modelo.bin.SistemaBin;
import dam.psp.emuladores.modelo.bin.VideojuegoBin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorArchivoBin {
    private static GestorArchivoBin INSTANCIA;
    private List<CategoriaBin> categorias;
    private List<SistemaBin> sistemas;
    private List<EmuladorBin> emuladores;
    private List<VideojuegoBin> videojuegos;

    private GestorArchivoBin(){
        categorias= new ArrayList<>();
        sistemas= new ArrayList<>();
        emuladores= new ArrayList<>();
        videojuegos= new ArrayList<>();
    }

    public static GestorArchivoBin getInstancia(){
        GestorArchivoBin gbin;
        if(INSTANCIA == null){
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
        List<CategoriaBin> listacategorias= new ArrayList<>();
        for(CategoriaBin i:categorias){
            if(i.getId()==id){
                listacategorias.add(i);
            }
        }
        return listacategorias;
    }

    public List<SistemaBin> getSistemas(int id) {
        List<SistemaBin> listasistemas = new ArrayList<>();
        for(SistemaBin i:sistemas){
            if(i.getId()==id){
                listasistemas.add(i);
            }
        }
        return listasistemas;
    }

    public List<EmuladorBin> getEmuladores(int id) {
        List<EmuladorBin> listaemuladores= new ArrayList<>();
        for(EmuladorBin i: emuladores){
            if(i.getId()==id){
                listaemuladores.add(i);
            }
        }
        return listaemuladores;
    }

    public List<VideojuegoBin> getVideojuegos(int id) {
        List<VideojuegoBin> listavideojuegos= new ArrayList<>();
        for(VideojuegoBin i: videojuegos){
            if(i.getId()==id){
                listavideojuegos.add(i);
            }
        }
        return listavideojuegos;
    }

    public void guardar() throws IOException {
        throw new UnsupportedOperationException("sin programar");
    }
    public void cargar() throws IOException{
        throw new UnsupportedOperationException("sin programar");
    }

}
