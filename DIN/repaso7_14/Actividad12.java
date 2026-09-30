package repaso7_14;

import java.util.ArrayList;

class Proyecto {
    private String nombre;
    private ArrayList<String> listaTareas;

    public Proyecto(String nombre, ArrayList<String> tareaList) {
        this.nombre = nombre;
        this.listaTareas = tareaList;
    }

    // GETTERS
    public ArrayList<String> getListaTareas() {
        return listaTareas;
    }

    public String getNombre() {
        return nombre;
    }

    public void addTarea(String nameTarea) {
        this.listaTareas.add(nameTarea);
    }

    public void removeTarea(String nameTarea) {
        if (listaTareas.contains(nameTarea)) {
            System.out.println("La tarea " + nameTarea + " ha sido eliminada.");
            this.listaTareas.remove(nameTarea);
        } else {
            System.out.println("La tarea indicada no existe.");
        }
    }
}

public class Actividad12 {
    public static void main(String[] args) {
        ArrayList<String> tareasList = new ArrayList<>();

        tareasList.add("Estudiar java");
        tareasList.add("Practicar javaFX");
        tareasList.add("Salir a correr");
        tareasList.add("Ir al medico");
        tareasList.add("Ir al mercadona");

        Proyecto proyecto1 = new Proyecto("Proyecto DI", tareasList);

        proyecto1.addTarea("Ir a comer");

        System.out.println(proyecto1.getListaTareas());

        proyecto1.removeTarea("Salir a correr");

        System.out.println(proyecto1.getListaTareas());
    }
}
