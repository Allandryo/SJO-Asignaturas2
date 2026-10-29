public class TareaHilo extends Thread {

    private int numero;

    public TareaHilo(int numero) {
        this.numero = numero;
    }

    @Override
    public void run() {
        System.out.println("Tarea " + numero + " iniciada");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Tarea " + numero + " finalizada");
    }

}