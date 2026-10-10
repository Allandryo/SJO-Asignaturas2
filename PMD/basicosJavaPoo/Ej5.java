class Persona {
    String nombre;
    int edad;
    double altura;

    public Persona(String nombre, int edad, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    public void cumplirAnios() {
        this.edad++;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + this.nombre + ", Edad: " + this.edad + ", Altura: " + this.altura + " m");
    }

    public double convertirAlturaACentimetros() {
        return this.altura * 100;
    }
}

public class Ej5 {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Ana", 25, 1.65);
        Persona persona2 = new Persona("Carlos", 30, 1.80);

        persona1.mostrarInfo();
        persona1.cumplirAnios();
        System.out.println("Nueva edad: " + persona1.edad);
        System.out.println("Altura en cm: " + persona1.convertirAlturaACentimetros());

        System.out.println("");

        persona2.mostrarInfo();
        persona2.cumplirAnios();
        System.out.println("Nueva edad: " + persona2.edad);
        System.out.println("Altura en cm: " + persona2.convertirAlturaACentimetros());
    }
}
