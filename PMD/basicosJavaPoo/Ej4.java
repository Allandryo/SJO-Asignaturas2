import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ej4 {

    public static boolean contieneString(List<String> lista, String texto) {
        return lista != null && lista.contains(texto);
    }

    public static String eliminarPorPosicion(List<?> lista, int posicion) {
        if (lista != null && posicion >= 0 && posicion < lista.size()) {
            lista.remove(posicion);
            return "elemento eliminado";
        } else {
            return "elemento no encontrado";
        }
    }

    public static List<Double> procesarDecimales(double n1, double n2, double n3, double n4, double n5, double n6) {
        List<Double> lista = new ArrayList<>(Arrays.asList(n1, n2, n3, n4, n5, n6));
        Collections.sort(lista);
        lista.remove(0);
        lista.remove(lista.size() - 1);
        return lista;
    }

    public static int sumarPositivos(List<Integer> numeros) {
        int suma = 0;
        if (numeros != null) {
            for (int i = 0; i < numeros.size(); i++) {
                int valor = numeros.get(i);
                if (valor > 0) {
                    suma += valor;
                }
            }
        }
        return suma;
    }

    public static List<String> eliminarDuplicados(List<String> lista) {
        List<String> resultado = new ArrayList<>();
        if (lista != null) {
            for (int i = 0; i < lista.size(); i++) {
                String elemento = lista.get(i);
                if (!resultado.contains(elemento)) {
                    resultado.add(elemento);
                }
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>(Arrays.asList("Ana", "Juan", "Pedro", "Lucía"));
        System.out.println("¿Contiene 'Juan'?: " + contieneString(nombres, "Juan"));
        System.out.println("");
        List<String> ciudades = new ArrayList<>(Arrays.asList("Madrid", "Barcelona", "Valencia", "Sevilla"));
        System.out.println("Lista inicial: " + ciudades);
        System.out.println("Elemento eliminado " + eliminarPorPosicion(ciudades, 1));
        System.out.println("Lista tras eliminar: " + ciudades);
        System.out.println("");

        List<Double> resultadoDecimales = procesarDecimales(9.5, 2.1, 7.8, 1.4, 5.0, 3.2);
        System.out.println("Resultado: " + resultadoDecimales);
        System.out.println("");
        List<Integer> listaNumeros = Arrays.asList(5, -3, 10, -2, 4, -8, 1);
        System.out.println("Suma positivos de " + listaNumeros + ": " + sumarPositivos(listaNumeros));
        System.out.println("");
        List<String> palabrasConDuplicados = Arrays.asList("sol", "luna", "sol", "estrella", "luna", "cielo");
        System.out.println("Original: " + palabrasConDuplicados);
        System.out.println("Sin duplicados: " + eliminarDuplicados(palabrasConDuplicados));
    }
}
