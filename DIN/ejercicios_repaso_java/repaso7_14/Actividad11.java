package repaso7_14;

import java.util.ArrayList;

public class Actividad11 {
    public static void tareasCompletadas(ArrayList<String> tareas, ArrayList<Boolean> completado) {
        ArrayList<String> hechas = new ArrayList<>();
        ArrayList<String> pendientes = new ArrayList<>();

        for (int i = 0; i < completado.size(); i++) {
            if (completado.get(i)) {
                hechas.add(tareas.get(i));
            } else {
                pendientes.add(tareas.get(i));
            }
        }
        System.out.println("Tareas completadas");
        for (String h : hechas) {
            System.out.println(h);
        }
        System.out.println("Tareas pendientes");
        for (String p : pendientes) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {

        ArrayList<String> tareas = new ArrayList<>();
        ArrayList<Boolean> completada = new ArrayList<>();

        tareas.add("Estudiar java");
        completada.add(true);

        tareas.add("Practicar javaFX");
        completada.add(true);

        tareas.add("Salir a correr");
        completada.add(false);

        tareas.add("Ir al medico");
        completada.add(true);

        tareas.add("Ir al mercadona");
        completada.add(false);

        tareasCompletadas(tareas, completada);
    }

}
