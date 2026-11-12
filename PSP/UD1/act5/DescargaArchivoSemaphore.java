import java.util.concurrent.Semaphore;

// 1. Cada hilo representa una descarga individual
class DescargaArchivoSemaphore extends Thread {
    private final int id;
    private final Semaphore semaforo;

    public DescargaArchivoSemaphore(int id, Semaphore semaforo) {
        this.id = id;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        try {
            // El hilo intenta tomar una "ficha" del semáforo.
            // Si ya hay 3 descargas corriendo, se pausa aquí automáticamente.
            semaforo.acquire();

            System.out.println("Iniciando descarga #" + id + " en " + getName());

            // Simula el tiempo que tarda en bajar el archivo (entre 2 y 4 segundos)
            Thread.sleep(2000 + (int) (Math.random() * 2000));

            System.out.println("Descarga #" + id + " completada.");

        } catch (InterruptedException e) {
            System.err.println("La descarga #" + id + " fue interrumpida.");
            Thread.currentThread().interrupt();
        } finally {
            // IMPORTANTE: Siempre devolvemos la "ficha" al terminar (incluso si hubo error)
            semaforo.release();
        }
    }
}