package repaso7_14;

import java.util.ArrayList;

public class Actividad10 {
    public static void buscarTarea(ArrayList<String> Lista, String texto) {
        ArrayList<String> tareaList = new ArrayList<>();

        for (String t : Lista) {
            if (t.toLowerCase().contains(texto.toLowerCase())) {
                tareaList.add(t);
            }
        }
        System.out.println(tareaList);
    }

    public static void main(String[] args) {
        ArrayList<String> tareas = new ArrayList<>();

        tareas.add("Estudiar java");
        tareas.add("Practicar javaFX");
        tareas.add("Salir a correr");
        tareas.add("Ir al medico");
        tareas.add("Ir al mercadona");

        buscarTarea(tareas, "ir al");
    }
}