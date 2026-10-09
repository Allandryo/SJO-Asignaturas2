class Vendedor extends Empleado {
    private double comision;

    public Vendedor(String nombre, Double salarioBase, double comision) {
        super(nombre, salarioBase);
        this.comision = comision;
    }

    // Getters
    public double getComision() {
        return comision;
    }

    // Setters
    public void setComision(double comision) {
        this.comision = comision;
    }

    @Override
    public void calcularSalario() {
        System.out.println("Nombre: " + getNombre() + " | Salario: " + (getSalarioBase() + comision));
    }
}

public class act6 {
    public static void main(String[] args) {
        Empleado e1 = new Empleado("Jose", 1000.0);
        Vendedor v1 = new Vendedor("Alan", 1500.0, 500.0);

        e1.calcularSalario();
        v1.calcularSalario();
    }
}
