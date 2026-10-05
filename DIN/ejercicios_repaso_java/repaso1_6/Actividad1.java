package repaso1_6;

import java.util.Scanner;

public class Actividad1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime tu nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Dime tu edad: ");
        int edad = sc.nextInt();

        System.out.println("Hola " + nombre + ", tienes " + edad);
        System.out.println("Dentro de 5 anios tendras " + (edad + 5));

        sc.close();
    }
}
