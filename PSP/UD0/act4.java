class Coche {
    private String marca;
    private String modelo;
    private int año;

    public Coche(String marca, String modelo, int año) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }

    public String mostrarInfo() {
        return "Marca: " + marca + " |Modelo: " + modelo + " |Año: " + año;
    }
}

public class act4 {
    public static void main(String[] args) {
        Coche c1 = new Coche("BMW", "M5", 2024);
        Coche c2 = new Coche("Mercedez", "C4", 2024);

        System.out.println(c1.mostrarInfo());
        System.out.println(c2.mostrarInfo());
    }
}
