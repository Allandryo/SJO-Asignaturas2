class Empleado {
    private String nombre;
    private Double salarioMensual;

    public Empleado() {
    }

    public Empleado(String nombre, Double salarioMensual) {
        this.nombre = nombre;
        this.salarioMensual = salarioMensual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSalarioMensual() {
        return salarioMensual;
    }

    public void setSalarioMensual(Double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    public void calcularSalarioAnual() {
        this.salarioMensual = this.salarioMensual * 12;
    }
}

public class Ej7 {
    public static void main(String[] args) {
        Empleado e1 = new Empleado();
        e1.setNombre("Laura");
        e1.setSalarioMensual(null);

        Empleado e2 = new Empleado();
        e2.setNombre("Marcos");
        e2.setSalarioMensual(2200.0);

        System.out.println("Empleado 1: " + e1.getNombre() + ", Salario mensual: " + e1.getSalarioMensual());
        System.out.println("Empleado 2: " + e2.getNombre() + ", Salario mensual: " + e2.getSalarioMensual());

        e1.setSalarioMensual(null);

        try {
            e1.calcularSalarioAnual();
            System.out.println("Salario anual de " + e1.getNombre() + ": " + e1.getSalarioMensual());
        } catch (Exception e) {
            System.out.println("Error al calcular el salario anual");
        }
    }
}
