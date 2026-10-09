class Vehiculo {
    private String marca;
    private double peso;
    private double combustible;
    private double KmRecorridos;

    public Vehiculo(String marca, double peso, double combustible) {
        this.marca = marca;
        this.peso = peso;
        this.combustible = combustible;
        this.KmRecorridos = 0;
    }

    // Getters
    public String getMarca() {
        return marca;
    }

    public double getPeso() {
        return peso;
    }

    public double getCombustible() {
        return combustible;
    }

    public double getKmRecorridos() {
        return KmRecorridos;
    }

    // Setters
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setCombustible(double combustible) {
        this.combustible = combustible;
    }

    public void setKmRecorridos(double kmRecorridos) {
        KmRecorridos = kmRecorridos;
    }

    // Metodos
    public void mover() {
        if (combustible <= 0) {
            System.out.println(marca + " no tiene combustible para moverse.");
            return;
        }

        double distanciaTramo = peso * 0.05;
        double gastoCombustible = distanciaTramo * (peso * 0.001);

        if (combustible < gastoCombustible) {
            System.out.println(marca + " se ha quedado sin combustible a medio camino.");
            combustible = 0;
            return;
        }

        KmRecorridos += distanciaTramo;
        combustible -= gastoCombustible;

        System.out.println(marca + " | Combustible restante: " + combustible + " | Km recorridos: " + KmRecorridos);
    }
}

class Coche extends Vehiculo {
    private int numPuertas;

    public Coche(String marca, double peso, double combustible, int numPuertas) {
        super(marca, peso, combustible);
        this.numPuertas = numPuertas;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }
}

class Moto extends Vehiculo {
    private boolean sidecar;

    public Moto(String marca, double peso, double combustible, boolean sidecar) {
        super(marca, peso, combustible);
        this.sidecar = sidecar;
    }

    public boolean isSidecar() {
        return sidecar;
    }

    public void setSidecar(boolean sidecar) {
        this.sidecar = sidecar;
    }
}

class Carrera {
    private Coche coche;
    private Moto moto;
    private Double distanciaCarrera;

    public Carrera(Coche coche, Moto moto, double distanciaCarrera) {
        this.coche = coche;
        this.moto = moto;
        this.distanciaCarrera = distanciaCarrera;
    }

    public void iniciarCarrera() {
        System.out.println("--- ¡Comienza la carrera de " + distanciaCarrera + " km! ---");

        while (coche.getCombustible() > 0 && coche.getKmRecorridos() < distanciaCarrera
                && moto.getCombustible() > 0 && moto.getKmRecorridos() < distanciaCarrera) {

            coche.mover();
            moto.mover();
            System.out.println("----------------------------------------");
        }

        System.out.println("\n=== RESULTADO FINAL ===");
        if (coche.getKmRecorridos() >= distanciaCarrera && moto.getKmRecorridos() >= distanciaCarrera) {
            System.out.println("¡Ha habido un empate en la meta!");
        } else if (coche.getKmRecorridos() >= distanciaCarrera) {
            System.out.println("¡El coche (" + coche.getMarca() + ") ha ganado la carrera!");
        } else if (moto.getKmRecorridos() >= distanciaCarrera) {
            System.out.println("¡La moto (" + moto.getMarca() + ") ha ganado la carrera!");
        } else if (coche.getCombustible() <= 0 && moto.getCombustible() <= 0) {
            System.out.println("Ambos vehículos se quedaron sin combustible antes de llegar a la meta.");
        } else if (coche.getCombustible() <= 0) {
            System.out.println("El coche se quedó sin combustible. ¡Gana la moto (" + moto.getMarca() + ")!");
        } else {
            System.out.println("La moto se quedó sin combustible. ¡Gana el coche (" + coche.getMarca() + ")!");
        }
    }
}

public class act7 {
    public static void main(String[] args) {
        Coche c1 = new Coche("BMW", 1200, 500, 4);
        Moto m1 = new Moto("Honda", 200, 500, false);

        Carrera carrera1 = new Carrera(c1, m1, 1000000);
        carrera1.iniciarCarrera();
    }
}
