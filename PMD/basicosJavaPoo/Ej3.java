import java.util.Arrays;

public class Ej3 {

    public static void saludar(String nombre) {
        System.out.println("Hola " + nombre);
    }

    public static double calcularMedia(double num1, double num2, double num3) {
        double media = (num1 + num2 + num3) / 3.0;
        System.out.println("La media es: " + media);
        return media;
    }

    public static void imprimirElementos(String[] array) {
        String[] ordinales = { "primer", "segundo", "tercer", "cuarto", "quinto", "sexto", "séptimo", "octavo",
                "noveno", "décimo" };
        for (int i = 0; i < array.length; i++) {
            String orden = (i < ordinales.length) ? ordinales[i] : (i + 1) + "º";
            System.out.println("El " + orden + " elemento es: " + array[i]);
        }
    }

    public static String[] ordenarSeisCadenas(String s1, String s2, String s3, String s4, String s5, String s6) {
        String[] array = { s1, s2, s3, s4, s5, s6 };
        Arrays.sort(array);
        System.out.print("Array ordenado: [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        return array;
    }

    public static int encontrarMaximo(int[] numeros) {
        if (numeros == null || numeros.length == 0) {
            throw new IllegalArgumentException("El array no puede estar vacío");
        }
        int max = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > max) {
                max = numeros[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        saludar("Allandryo");

        double media1 = calcularMedia(5, 7, 9);

        String[] frutas = { "Manzana", "Plátano", "Fresa", "Naranja" };
        imprimirElementos(frutas);

        ordenarSeisCadenas("Zaragoza", "Madrid", "Barcelona", "Sevilla", "Bilbao", "Valencia");

        int[] notas = { 4, 9, 2, 8, 10, 6 };
        int maxNotas = encontrarMaximo(notas);
        System.out.println("El valor más alto de las notas es: " + maxNotas);
    }
}
