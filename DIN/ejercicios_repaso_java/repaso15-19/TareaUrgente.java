public class TareaUrgente extends Tarea {

    public TareaUrgente(String nombre, String descripcion, Boolean completado, String fechaLimite) {
        super(nombre, descripcion, completado, fechaLimite);
        this.prioridad = true;
    }

    public void setPrioridad(Boolean prioridad) {
        this.prioridad = true;
    }

    @Override
    public String toString() {
        return "Tarea: " + titulo + " | Completado: " + (completado ? "Si" : "No") + " | Fecha limite: " + fechaLimite
                + " | Prioridad: " + prioridad;
    }
}
