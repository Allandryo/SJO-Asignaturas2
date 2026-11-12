package ReportesNotas;

import java.util.Random;

public class GeneradorNotas {
    public static void main(String[] args) {
        Random random = new Random();
        int nota;

        for (int i = 1; i <= Integer.parseInt(args[0]); i++) {
            nota = random.nextInt(0, 11);
            System.out.println(nota);
        }
    }
}
