package act3;

public class contadorSeguro extends Thread {

    public static int valor = 100000;

    private static final Object candado = new Object();

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (candado) {
                valor--;
            }
        }
    }

}
