public class Ej2 {
    public static void main(String[] args) {
        String texto = "hola mundo, bienvenidos a Java";

        if (texto.length() > 5) {
            System.out.println("texto largo");
        } else {
            System.out.println("texto corto");
        }

        if (texto.contains("hola")) {
            System.out.println("la subcadena hola aparece en la posición " + texto.indexOf("hola"));
        } else {
            System.out.println("mi texto no contiene la subcadena hola");
        }

        if (texto.contains("hola")) {
            String textoReemplazado = texto.replace("hola", "adiós");
            System.out.println(textoReemplazado);
        } else {
            System.out.println("mi texto no contiene la subcadena hola");
        }

        int contadorVocales = 0;
        for (int i = 0; i < texto.length(); i++) {
            char c = Character.toLowerCase(texto.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                contadorVocales++;
            }
        }
        System.out.println("la cadena tiene " + contadorVocales + " vocales");
    }
}
