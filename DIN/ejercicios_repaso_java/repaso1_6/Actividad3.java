package repaso1_6;

import java.util.Scanner;

public class Actividad3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el numero de la prioridad: ");
        int number = sc.nextInt();

        switch (number) {
            case 1:
                System.out.println("Prioridad baja");
                break;
            case 2:
                System.out.println("Prioridad media");
                break;
            case 3:
                System.out.println("Prioridad alta");
                break;
            default:
                System.out.println("Prioridad invalida");
                ;
        }
        sc.close();
    }

}
