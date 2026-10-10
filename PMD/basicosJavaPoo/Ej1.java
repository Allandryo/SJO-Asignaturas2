public class Ej1 {
    public static void main(String[] args) {
        for (int i = 5; i <= 30; i++) {
            if (i == 15) {
                System.out.println("Es el " + i);
            } else if (i > 15) {
                System.out.println(i + " es mayor a 15");
            } else {
                System.out.println(i + " es menor a 15");
            }
        }
    }
}