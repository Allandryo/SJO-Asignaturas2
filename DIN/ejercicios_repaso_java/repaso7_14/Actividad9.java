package repaso7_14;

import java.util.ArrayList;

public class Actividad9 {
    public static void mostrarTarea(ArrayList<String> Lista) {
        for (int i = 0; i < Lista.size(); i++) {
            System.out.println(Lista.get(i));
        }
        /*
         * for (String tarea : Lista){
         * System.out.println(tarea);
         * }
         */

    }

    public static void eliminarTarea(ArrayList<String> Lista, int posicion) {
        posicion = posicion - 1;
        if (posicion < Lista.size()) {
            Lista.remove(posicion);
        } else {
            System.out.println("No existe una tarea en esa posicion");
        }

    }

    public static void main(String[] args) {
        ArrayList<String> tareas = new ArrayList<>();

        tareas.add("deberes");
        tareas.add("limpiar");
        tareas.add("correr");
        tareas.add("medico");
        tareas.add("cocinar");

        mostrarTarea(tareas);

        eliminarTarea(tareas, 7);

        mostrarTarea(tareas);
    }
}
