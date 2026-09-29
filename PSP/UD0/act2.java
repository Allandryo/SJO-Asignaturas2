public class act2 {
    public static void main(String[] args) {
        double nota = 6;

        if (nota > 0 && nota < 5) {
            System.out.println("Suspenso");
        } else if (nota >= 5 && nota < 7) {
            System.out.println("Aprobado");
        } else if (nota >= 7 && nota < 9) {
            System.out.println("Notable");
        } else if (nota >= 9 && nota <= 10) {
            System.out.println("Sobresaliente");
        } else {
            System.out.println("Nota invalida");
        }
    }
}
