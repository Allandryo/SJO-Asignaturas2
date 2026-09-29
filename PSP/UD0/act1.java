public class act1 {
    public static void main(String[] args) {
        double precio = 20;
        int cantidad = 10;
        double descuento = 0.10;

        double valorTotal = (precio * cantidad) - ((precio * cantidad) * descuento);

        System.out.println(valorTotal);

    }
}