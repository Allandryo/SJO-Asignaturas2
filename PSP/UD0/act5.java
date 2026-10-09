class Personaje {
    private String nombre;
    private int nivel;
    private int puntosVida;
    private Boolean vivo;

    public Personaje(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = 100;
        this.vivo = true;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public Boolean getVivo() {
        return vivo;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public void setVivo(Boolean vivo) {
        this.vivo = vivo;
    }

    public void recibirDanio(Double cantidad) {
        puntosVida -= cantidad;
        System.out.println(nombre);
        System.out.println("Daño recibido: " + cantidad + " | Vida restante: " + puntosVida);
    }
}

public class act5 {
    public static void main(String[] args) {
        Personaje p1 = new Personaje("alan", 0);

        while (p1.getVivo()) {
            p1.recibirDanio(Math.random() * 100);
            if (p1.getPuntosVida() <= 0) {
                p1.setVivo(false);
            }
        }

    }
}
