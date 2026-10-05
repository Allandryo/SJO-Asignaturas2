package repaso7_14;

class TareaList {
    String titulo;
    String descripcion;
    boolean completado;

    public TareaList(String titulo, String descripcion) {
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

    public void completar() {
        System.out.println("Realizando la tarea de: " + titulo);
        setCompletado(true);
        MostrarInfo();
    }
}

public class Actividad7 {
    public static void main(String[] args) {
        TareaList t1 = new TareaList("correr", "salir a correr");
        TareaList t2 = new TareaList("Deberes", "Hacer los deberes");

        t1.MostrarInfo();
        t2.MostrarInfo();

        t2.completar();

    }
}