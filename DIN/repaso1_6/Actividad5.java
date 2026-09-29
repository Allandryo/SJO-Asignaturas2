package repaso1_6;

public class Actividad5 {
    public static String buscarTarea(String[] Lista, String texto) {
        for (int i = 0; i < Lista.length; i++) {
            if (texto.equalsIgnoreCase(Lista[i])) {
                return "Posicion de la tarea: " + (i + 1);

            }
        }
        return "No existe la tarea";
    }

    public static void main(String[] args) {
        String[] tareas = { "Estudiar java", "Preparar practica", "Revisar ejercicios", "subir proyecto" };

        System.out.println(buscarTarea(tareas, "SUBIR PROYECTO"));

    }

}