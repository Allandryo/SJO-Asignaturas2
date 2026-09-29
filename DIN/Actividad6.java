class Tarea {
    String titulo;
    String descripcion;
    boolean completado;

    public Tarea(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completado = false;
    }

    // GETERS
    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // SETERS
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public void MostrarInfo() {
        System.out.println(
                "Titulo: " + titulo + ", Descripcion: " + descripcion + ", completado: " + (completado ? "si" : "no"));
    }

}

public class Actividad6 {
    public static void main(String[] args) {
        Tarea t1 = new Tarea("correr", "salir a correr");
        Tarea t2 = new Tarea("Deberes", "Hacer los deberes");

        t1.MostrarInfo();
        t2.MostrarInfo();

    }
}
