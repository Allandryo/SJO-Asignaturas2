import java.util.concurrent.Semaphore;

public class MainServicioSemaphore {
    public static void main(String[] args) {
        int totalArchivos = 10;
        int maxSimultaneas = 3;

        // Creamos un semáforo con un límite de 3 permisos simultáneos
        Semaphore semaforoDescargas = new Semaphore(maxSimultaneas);

        System.out.println("🔵 Iniciando gestor de descargas (Máximo " + maxSimultaneas + " a la vez)...\n");

        // Creamos y lanzamos los 10 hilos
        for (int i = 1; i <= totalArchivos; i++) {
            DescargaArchivoSemaphore hilo = new DescargaArchivoSemaphore(i, semaforoDescargas);
            hilo.start(); // El semáforo controla el ritmo automáticamente
        }
    }
}