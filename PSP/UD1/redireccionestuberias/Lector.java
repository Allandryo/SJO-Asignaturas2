package redireccionestuberias;

import java.util.Scanner;

public class Lector {

    public static void main(String[] args) {
        System.err.println("Leiendo notas...");

        // System.in es el flujo de entrada estándar.
        Scanner scanner = new Scanner(System.in);
        int contadorAprobados = 0;

        // Lee línea por línea
        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();

            if (linea.contains("Aprobado")) {
                System.out.println(linea);
                contadorAprobados++;
            }

        }

        System.err.println("Notas aprobadas: " + contadorAprobados);

    }

}
