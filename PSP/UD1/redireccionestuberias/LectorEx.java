package redireccionestuberias;

import java.util.Scanner;

public class Lector {

    public static void main(String[] args) {
        System.out.println("Leiendo notas...");

        // System.in es el flujo de entrada estándar.
        Scanner scanner = new Scanner(System.in);
        int contadorAprobados = 0;

        // Lee línea por línea
        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine().split("[\\s]")[0];

            if (Integer.parseInt(linea) >= 9) {
                System.out.println(linea);
                contadorAprobados++;
            }

        }

        System.out.println("Notas aprobadas Excelente: " + contadorAprobados);

    }

}
