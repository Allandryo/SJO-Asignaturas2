public class act3 {
    public static void tabla(int numero) {
        System.out.println("Tabla de multiplicar del " + numero);
        for (int i = 1; i < 11; i++) {
            System.out.println(i + " x " + numero + " = " + (i * numero));
        }
    }

    public static void pares() {
        int i = 1;
        int count = 0;
        while (i <= 20) {
            if (i % 2 == 0) {
                count = count + i;
            }
            i++;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        tabla(5);
        pares();
    }
}
