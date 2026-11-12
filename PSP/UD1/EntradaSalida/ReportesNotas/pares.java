package ReportesNotas;

import java.util.Scanner;

public class pares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nota;
        while (sc.hasNextLine()) {
            nota = Integer.parseInt(sc.nextLine());
            if (nota % 2 == 0) {
                System.out.println(nota);
            }
        }
    }
}
