public class EjecucionConcurrente {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();

        Thread[] hilos = new Thread[5];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new TareaHilo(i);
            hilos[i].start();
        }

        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long fin = System.currentTimeMillis();
        System.out.println("Tiempo total de ejecucion: " + (fin - inicio) + " ms");
    }
}
