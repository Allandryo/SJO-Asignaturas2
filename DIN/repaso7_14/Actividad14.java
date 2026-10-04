package repaso7_14;

import java.util.ArrayList;

class Tarea14 {
    private String nombre;
    private Boolean completado;
    private Prioridad prioridad;

    public Tarea14(String nombre, Boolean completado, Prioridad prioridad) {
        this.nombre = nombre;
        this.completado = completado;
        this.prioridad = prioridad;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public Boolean getCompletado() {
        return completado;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    // Setters
    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return nombre + ": | Prioridad: " + prioridad;
    }
}

class Tareas14 {
    private String nombre;
    private ArrayList<Tarea14> tareasList;

    public Tareas14(String nombre, ArrayList<Tarea14> tareasList) {
        this.nombre = nombre;
        this.tareasList = tareasList;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    // Metodos

    public void getNumeroTareas() {
        System.out.println("Total de tareas: " + tareasList.size());
    }

    public void getNumeroCompletadas() {
        int count = 0;

        for (int i = 0; i < tareasList.size(); i++) {
            if (tareasList.get(i).getCompletado()) {
                count++;
            }
        }
        System.out.println("Total Completadas: " + count);
    }

    public void getNumeroPendientes() {
        int count = 0;

        for (int i = 0; i < tareasList.size(); i++) {
            if (!tareasList.get(i).getCompletado()) {
                count++;
            }
        }
        System.out.println("Total Pendientes: " + count);

    }

}

public class Actividad14 {
    public static void main(String[] args) {
        ArrayList<Tarea14> tareasList = new ArrayList<>();

        Tarea14 t1 = new Tarea14("Correr", false, Prioridad.BAJA);
        Tarea14 t2 = new Tarea14("Nadar", false, Prioridad.MEDIA);
        Tarea14 t3 = new Tarea14("Comer", false, Prioridad.ALTA);

        tareasList.add(t1);
        tareasList.add(t2);
        tareasList.add(t3);

        Tareas14 tl1 = new Tareas14("Proyecto DI", tareasList);

        tl1.getNumeroTareas();
        tl1.getNumeroCompletadas();
        tl1.getNumeroPendientes();

        System.out.println(t1.toString());
        System.out.println(t2.toString());
        System.out.println(t3.toString());
    }
}