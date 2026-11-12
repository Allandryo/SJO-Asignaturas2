public class ServicioDescargasSync {

    private final int[] solicitudes; // Array con IDs de descargas
    private int indice = 0; // Descarga actual
    private int descargasActivas = 0;
    private final int MAX_DESCARGAS_SIMULTANEAS = 3;
    private boolean activo = true;

    public ServicioDescargasSync(int numSolicitudes) {
        solicitudes = new int[numSolicitudes];
        for (int i = 0; i < numSolicitudes; i++) {
            solicitudes[i] = i + 1; // Cargamos IDs de descargas
        }
    }

    // Inicia el servicio
    public void iniciar() {
        System.out.println("Servicio de descargas iniciado...");

        while (activo) {
            try {
                Thread.sleep(1000); // Simula llegada gradual de solicitudes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (this) {
                // Lanzar descargas nuevas si hay espacio disponible
                while (descargasActivas < MAX_DESCARGAS_SIMULTANEAS && indice < solicitudes.length) {
                    int id = solicitudes[indice];
                    DescargaArchivoSync hilo = new DescargaArchivoSync(id, this);
                    hilo.start(); // Lanza el hilo
                    descargasActivas++;
                    indice++;
                    System.out.println("🚀 Iniciando descarga #" + id + " (activas: " + descargasActivas + ")");
                }

                // Si todas las descargas ya fueron lanzadas y no quedan activas
                if (indice >= solicitudes.length && descargasActivas == 0) {
                    detener();
                }
            }
        }

        System.out.println("Servicio detenido (todas las descargas completadas).");
    }

    // Método sincronizado: lo llaman los hilos cuando terminan public synchronized
    public void descargaCompletada() {
        descargasActivas--;
        if (indice >= solicitudes.length && descargasActivas == 0) {
            detener();
        }
    }

    // Detiene el servicio
    public void detener() {
        activo = false;
    }
}
