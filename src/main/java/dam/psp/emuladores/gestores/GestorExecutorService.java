package dam.psp.emuladores.gestores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GestorExecutorService {
    private static GestorExecutorService INSTANCIA;
    private ExecutorService executorService;
    private GestorExecutorService(){
        executorService= Executors.newCachedThreadPool();
    }
    public ExecutorService getExecutorService(){
        return executorService;
    }
    public static GestorExecutorService getINSTANCIA(){
        GestorExecutorService ges;
        if(INSTANCIA==null){
            ges=new GestorExecutorService();
        }else{
            ges=INSTANCIA;
        }
        INSTANCIA=ges;
        return INSTANCIA;
    }
}
