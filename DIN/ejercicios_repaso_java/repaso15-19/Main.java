import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void procesarTarea(List<Tarea> tareasList, Consumer<Tarea> accion) {
        for (Tarea tarea : tareasList) {
            accion.accept(tarea);
        }
    }

    public static void main(String[] args) {
        Tarea t1 = null;
        TareaUrgente t2 = null;
        Tarea t3 = null;
        try {
            t1 = new Tarea("Comprar pan", "", false, "2026-12-02");
            t2 = new TareaUrgente("Abrir el PC", "", true, "2026-12-02");
            t3 = new Tarea("Hacer la compra", "", false, "2026-12-02");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        List<Tarea> tareasList = new ArrayList<Tarea>();
        tareasList.add(t1);
        tareasList.add(t2);
        tareasList.add(t3);

        System.out.println("Lista normal.");
        for (int i = 0; i < tareasList.size(); i++) {
            if (tareasList.get(i) != null) {
                System.out.println(tareasList.get(i).toString());
            }
        }
        System.out.println("");
        System.out.println("Lista ordenada alfabeticamente.");
        tareasList.sort(Comparator.comparing(Tarea::getTitulo));

        for (int i = 0; i < tareasList.size(); i++) {
            if (tareasList.get(i) != null) {
                System.out.println(tareasList.get(i).toString());
            }
        }
        System.out.println("");
        System.out.println("Lista ordenada por prioridad.");
        tareasList.sort(Comparator.comparing(Tarea::getPrioridad).reversed());
        for (int i = 0; i < tareasList.size(); i++) {
            if (tareasList.get(i) != null) {
                System.out.println(tareasList.get(i).toString());
            }
        }
        System.out.println("");
        System.out.println("Mostrando todas las tareas.");
        procesarTarea(tareasList, tarea -> {
            System.out.println(tarea.toString());
        });
        System.out.println("");
        System.out.println("Completando todas las tareas.");
        procesarTarea(tareasList, tarea -> tarea.setCompletado(true));
        procesarTarea(tareasList, tarea -> {
            System.out.println(tarea.toString());
        });
        System.out.println("");
        System.out.println("Mostrando el titulo de las tareas.");
        procesarTarea(tareasList, tarea -> {
            System.out.println(tarea.getTitulo());
        });
    }
}
