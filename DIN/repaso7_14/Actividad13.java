package repaso7_14;

import java.util.ArrayList;

class Tarea13 {
    private String nombre;
    private Boolean completado;

    public Tarea13(String nombre, Boolean completado) {
        this.nombre = nombre;
        this.completado = completado;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getCompletado() {
        return completado;
    }
}

class Tareas13 {
    private String nombre;
    private ArrayList<Tarea13> tareasList;

    public Tareas13(String nombre, ArrayList<Tarea13> tareasList) {
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

public class Actividad13 {
    public static void main(String[] args) {
        ArrayList<Tarea13> tareasList = new ArrayList<>();

        Tarea13 t1 = new Tarea13("Correr", true);
        Tarea13 t2 = new Tarea13("Nadar", true);
        Tarea13 t3 = new Tarea13("Comer", false);

        tareasList.add(t1);
        tareasList.add(t2);
        tareasList.add(t3);

        Tareas13 tl1 = new Tareas13("Proyecto DI", tareasList);

        tl1.getNumeroTareas();
        tl1.getNumeroCompletadas();
        tl1.getNumeroPendientes();
    }
}
