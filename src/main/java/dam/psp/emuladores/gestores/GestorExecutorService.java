package dam.psp.emuladores.gestores;

import java.util.concurrent.ExecutorService;

public class GestorExecutorService {
    private static GestorExecutorService INSTANCIA;
    private ExecutorService executorService;
    private GestorExecutorService(){}
    public ExecutorService getExecutorService(){
        throw new UnsupportedOperationException("");
    }
    public static GestorExecutorService getINSTANCIA(){
        throw new UnsupportedOperationException("");
    }
}
