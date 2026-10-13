import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main19 {
    public static void procesarTarea(List<Tarea> tareasList, Consumer<Tarea> accion) {
        for (Tarea tarea : tareasList) {
            accion.accept(tarea);
        }
    }

    public static void crearTarea(List<Tarea> tareasList, String nombre, String descripcion, Boolean completado,
            String fechaLimite, Boolean prioridad) {
        Tarea nueva;
        if (!prioridad) {
            nueva = new Tarea(nombre, descripcion, completado, fechaLimite);
        } else {
            nueva = new TareaUrgente(nombre, descripcion, completado, fechaLimite);
        }
        tareasList.add(nueva);
        System.out.println("Tarea creada exitosamente");
    }

    public static void mostrarTareas(List<Tarea> tareasList) {
        for (int i = 0; i < tareasList.size(); i++) {
            if (tareasList.get(i) != null) {
                System.out.println(tareasList.get(i).toString());
            }
        }
    }

    public static void buscarTareas(List<Tarea> tareasList, String textoBuscar) {
        for (int i = 0; i < tareasList.size(); i++) {
            if (tareasList.get(i) != null) {
                if (tareasList.get(i).getTitulo().contains(textoBuscar)) {
                    System.out.println(tareasList.get(i).toString());
                }
                System.out.println("La tarea no existe");
            }
        }
    }

    public static void tareasPendientes(List<Tarea> tareasList) {
        for (int i = 0; i < tareasList.size(); i++) {
            if (tareasList.get(i) != null) {
                if (!tareasList.get(i).getCompletado()) {
                    System.out.println(tareasList.get(i).toString());
                }
            }
        }
    }

    public static void tareasCompletadas(List<Tarea> tareasList) {
        for (int i = 0; i < tareasList.size(); i++) {
            if (tareasList.get(i) != null) {
                if (tareasList.get(i).getCompletado()) {
                    System.out.println(tareasList.get(i).toString());
                }
            }
        }
    }

    public static void completarTarea(List<Tarea> tareasList, int index) {
        if (index >= 0 && index < tareasList.size() && tareasList.get(index) != null
                && tareasList.get(index).getCompletado() != true) {
            tareasList.get(index).setCompletado(true);
            System.out.println("Tarea completada");
        } else {
            System.out.println("Tarea ya completada");
        }
    }

    public static void eliminarTarea(List<Tarea> tareasList, int index) {
        if (index >= 0 && index < tareasList.size() && tareasList.get(index) != null) {
            tareasList.remove(index);
            System.out.println("Tarea eliminada");
        } else {
            System.out.println("Tarea no encontrada");
        }
    }

    public static void mostrarEstadisticas(List<Tarea> tareasList) {
        int completadas = 0;
        int pendientes = 0;
        for (int i = 0; i < tareasList.size(); i++) {
            if (tareasList.get(i) != null) {
                if (tareasList.get(i).getCompletado()) {
                    completadas++;
                } else {
                    pendientes++;
                }
            }
        }
        System.out.println("Tareas totales: " + tareasList.size());
        System.out.println("Tareas completadas: " + completadas);
        System.out.println("Tareas pendientes: " + pendientes);
    }

    public static void menu() {
        System.out.println("1. Crear tarea");
        System.out.println("2. Mostrar tareas");
        System.out.println("3. Buscar tareas");
        System.out.println("4. Mostrar tareas pendientes");
        System.out.println("5. Mostrar completadas");
        System.out.println("6. Comletar tarea");
        System.out.println("7. Eliminar tarea");
        System.out.println("8. Mostrar estadisticas");
        System.out.println("0. Salir");
    }

    public static void main(String[] args) {
        List<Tarea> tareasList = new ArrayList<Tarea>();

        while (true) {
            menu();
            Scanner sc = new Scanner(System.in);
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre de la tarea");
                    String nombre = sc.nextLine();
                    System.out.println("Ingrese la descripcion de la tarea");
                    String descripcion = sc.nextLine();
                    System.out.println("Ingrese la fecha limite de la tarea");
                    String fechaLimite = sc.nextLine();
                    System.out.println("Ingrese la prioridad de la tarea");
                    Boolean prioridad = sc.nextBoolean();
                    crearTarea(tareasList, nombre, descripcion, false, fechaLimite, prioridad);

                case 2:
                    mostrarTareas(tareasList);

                case 3:
                    System.out.println("Ingrese el texto a buscar");
                    String textoBuscar = sc.nextLine();
                    buscarTareas(tareasList, textoBuscar);
                case 4:
                    tareasPendientes(tareasList);

                case 5:
                    tareasCompletadas(tareasList);

                case 6:
                    System.out.println("Ingrese el indice de la tarea a completar");
                    int indexComplete = sc.nextInt();
                    completarTarea(tareasList, indexComplete);

                case 7:
                    System.out.println("Ingrese el indice de la tarea a eliminar");
                    int indexDelete = sc.nextInt();
                    eliminarTarea(tareasList, indexDelete);

                case 8:
                    mostrarEstadisticas(tareasList);

                case 0:
                    break;

                default:
                    System.out.println("Indique una de las opciones");
                    ;
            }
            sc.close();
        }
    }
}
