package act3;

public class mainContadorSeguro {
    public static void main(String[] args) throws InterruptedException {
        int cantidadHilos = 100;
        contadorSeguro[] hilos = new contadorSeguro[cantidadHilos];

        // 1. Creación e inicio de los hilos
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new contadorSeguro();
            hilos[i].start(); // Inicia el hilo independiente
        }

        // 2. Espera a que todos los hilos terminen
        for (contadorSeguro hilo : hilos) {
            hilo.join(); // El hilo main espera a que cada hilo finalice
        }

        // 3. Resultado final garantizado
        System.out.println("----------------------------------------");
        System.out.println("Deberia haber sido: " + 0);
        System.out.println("El marcador quedó en: " + contadorSeguro.valor);
        System.out.println("----------------------------------------");
    }
}
