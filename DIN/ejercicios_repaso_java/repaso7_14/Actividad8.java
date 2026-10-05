package repaso7_14;

import java.util.ArrayList;

public class Actividad8 {

    public static void mostrarTareas(ArrayList<String> Lista) {
        for (int i = 0; i < Lista.size(); i++) {
            System.out.println(Lista.get(i));
        }
        /*
         * for (String tarea : Lista){
         * System.out.println(tarea);
         * }
         */

    }

    public static void main(String[] args) {
        ArrayList<String> tareas = new ArrayList<>();

        tareas.add("deberes");
        tareas.add("limpiar");
        tareas.add("correr");
        tareas.add("medico");
        tareas.add("cocinar");

        mostrarTareas(tareas);
    }
}
