package act4;

public class contadorAsientos extends Thread {
    public static int asiento = 100;

    private static final Object candado = new Object();

    @Override
    public void run() {
        synchronized (candado) {
            if (asiento > 0) {
                asiento--;
                System.out.println("Agente " + getName() + " reservo. Quedan: " + asiento);

            }
        }
    }
}
