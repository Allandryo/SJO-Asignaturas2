package act4;

public class mainContadorAsientos {
    public static void main(String[] args) throws InterruptedException {
        int cantidadHilos = 200;
        contadorAsientos[] hilos = new contadorAsientos[cantidadHilos];

        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new contadorAsientos();
            hilos[i].setName("Agente " + (i + 1));
            hilos[i].start();
        }

        for (contadorAsientos hilo : hilos) {
            hilo.join();
        }
    }
}
