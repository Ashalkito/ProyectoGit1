package dam.psp.emuladores.gestores;

import dam.psp.emuladores.modelo.bin.CategoriaBin;
import dam.psp.emuladores.modelo.bin.EmuladorBin;
import dam.psp.emuladores.modelo.bin.SistemaBin;
import dam.psp.emuladores.modelo.bin.VideojuegoBin;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GestorArchivoBin {
    private static GestorArchivoBin INSTANCIA;
    private List<CategoriaBin> categorias;
    private List<SistemaBin> sistemas;
    private List<EmuladorBin> emuladores;
    private List<VideojuegoBin> videojuegos;

    private GestorArchivoBin(){}

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
        try(OutputStream out = new FileOutputStream("emuladores.bin",true);
            BufferedOutputStream b = new BufferedOutputStream(out);
            DataOutputStream d = new DataOutputStream(b);
            ObjectOutputStream oos = new ObjectOutputStream(b)){

            int numSistemas = sistemas.size();
            int numEmuladores = emuladores.size();
            int numVideojuegos = videojuegos.size();
            d.write(numSistemas);
            for(SistemaBin s : sistemas){
                String nombreSistema =  s.getNombre();
                d.writeUTF(nombreSistema);
            }
            d.write(numEmuladores);
            for(EmuladorBin e : emuladores){
                String nombreEmualdor = e.getNombre();
                String rutaEmuladores = e.getRuta();
                String lineaComandos = e.getLineaComandos();
                String idSistema =""+e.getId();
                d.writeUTF(nombreEmualdor);
                d.writeUTF(rutaEmuladores);
                d.writeUTF(lineaComandos);
                d.writeUTF(idSistema);
            }
            d.write(numVideojuegos);
            for(VideojuegoBin v : videojuegos){
                String nombreVideojuego =  v.getNombre();
                d.writeUTF(nombreVideojuego);
            }
            for(SistemaBin s : sistemas){
                int idSistemas = s.getId();
                d.write(idSistemas);
            }
            for(VideojuegoBin v : videojuegos){
                String ruta = v.getRuta();
                String rutaFoto = v.getRutaFoto();
                d.writeUTF(ruta);
                d.writeUTF(rutaFoto);
            }
            List<String> listaCategorias = new ArrayList<>();
            for(CategoriaBin l: categorias){
                listaCategorias.add(l.getNombre());
            }
            oos.writeObject(listaCategorias);


            Map<Integer,List<Integer>> mapSistemaJuego = new HashMap<>();
            Map<Integer,List<Integer>> mapSistemaEmulador = new HashMap<>();
            List<Integer>ids = new ArrayList<>();


            //Map Sistema-Juego
            for(int i =1; i<=sistemas.size(); i++){
                ids.clear();
                for(VideojuegoBin v : sistemas.get(i).getJuegos()){
                    ids.add(v.getId());
                }
                mapSistemaJuego.put(i,ids);
            }
            oos.writeObject(mapSistemaJuego);

            //Map Sistema-Emulador
            for(int i =1; i<=sistemas.size(); i++){
                ids.clear();
                for(EmuladorBin e : sistemas.get(i).getEmuladores()){
                    ids.add(e.getId());
                }
                mapSistemaEmulador.put(i,ids);
            }
            oos.writeObject(mapSistemaEmulador);
        }
    }
    public void cargar() throws IOException{
        throw new UnsupportedOperationException("sin programar");

    }

}
