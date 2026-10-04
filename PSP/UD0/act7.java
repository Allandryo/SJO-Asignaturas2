class Vehiculo {
    private String marca;
    private double peso;
    private double combustible;
    private double KmRecorridos;

    public Vehiculo(String marca, double peso, double combustible, double KmRecorridos) {
        this.marca = marca;
        this.peso = peso;
        this.combustible = combustible;
        this.KmRecorridos = KmRecorridos;
    }

    // Getters
    public String getMarca() {
        return marca;
    }

    public double getPeso() {
        return peso;
    }

    public double getCombustible() {
        return combustible;
    }

    public double getKmRecorridos() {
        return KmRecorridos;
    }

    // Setters
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setCombustible(double combustible) {
        this.combustible = combustible;
    }

    public void setKmRecorridos(double kmRecorridos) {
        KmRecorridos = kmRecorridos;
    }

    // Metodos

    public void mover() {

    }
}

public class act7 {
    public static void main(String[] args) {

    }
}
