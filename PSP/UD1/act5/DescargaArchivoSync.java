// Clase que representa una descarga (cada hilo es una descarga)
public class DescargaArchivoSync extends Thread {
    private final int id;
    private final ServicioDescargasSync servicio;

    public DescargaArchivoSync(int id, ServicioDescargasSync servicio) {
        this.id = id;
        this.servicio = servicio;
    }

    @Override
    public void run() {
        System.out.println("Descargando archivo_" + id + ".zip en " + getName());
        try {
            Thread.sleep(2000 + (int) (Math.random() * 2000)); // Simula tiempo de descarga
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Descarga #" + id + " completada.");
        servicio.descargaCompletada(); // Notifica al servicio
    }
}