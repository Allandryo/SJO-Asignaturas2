public class Empleado {
    private String nombre;
    private Double salarioBase;

    public Empleado(String nombre, Double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    // Getters

    public String getNombre() {
        return nombre;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    // Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    // Metodos
    public void calcularSalario() {
        System.out.println("Nombre: " + nombre + " | Salario: " + salarioBase);
    }

}
