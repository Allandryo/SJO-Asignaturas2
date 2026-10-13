import java.time.LocalDate;

public class Tarea {
    String titulo;
    String descripcion;
    Boolean completado;
    LocalDate fechaLimite;
    Boolean prioridad;

    public Tarea(String titulo, String descripcion, Boolean completado, String fechaLimite) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El titulo no puede estar vacio");
        }
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completado = completado;
        this.fechaLimite = LocalDate.parse(fechaLimite);
        this.prioridad = false;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Boolean getCompletado() {
        return completado;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public Boolean getPrioridad() {
        return prioridad;
    }

    // Setters
    public void settitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCompletado(Boolean completado) {
        this.completado = completado;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    // Metodos

    public String toString() {
        return "Tarea: " + titulo + " | Completado: " + (completado ? "Si" : "No") + " | Fecha limite: " + fechaLimite;
    }
}
