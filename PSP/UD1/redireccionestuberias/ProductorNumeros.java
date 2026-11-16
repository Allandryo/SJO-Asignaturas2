package redireccionestuberias;

import java.util.Random;

public class ProductorNumeros {
    public static void main(String[] args) {
        Random random = new Random();

        System.err.println("Generando notas...");

        // Escribe en System.out
        for (int i = 1; i <= Integer.parseInt(args[0]); i++) {
            int numero = random.nextInt(1, 11);
            if (numero >= 5) {
                System.out.println(numero + " Aprobado");
            } else {
                System.out.println(numero + " Suspendido");
            }
        }

        System.err.println("Notas generadas correctamente.");
    }
}
