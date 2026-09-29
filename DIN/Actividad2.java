import java.util.Scanner;

public class Actividad2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el precio: ");
        double precio = sc.nextInt();

        System.out.println("Indica la cantidad: ");
        double cantidad = sc.nextInt();

        System.out.println("Indica el descuento");
        double descuento = sc.nextInt();

        int subtotal = (int) precio * (int) cantidad;

        System.out.println("Subtotal: " + subtotal + "€");
        System.out.println("Descuento:: " + (subtotal * (descuento / 100)) + "€");
        System.out.println("Total: " + (subtotal - (subtotal * (descuento / 100))) + "€");

        sc.close();
    }
}
