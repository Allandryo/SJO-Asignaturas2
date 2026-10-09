import java.util.ArrayList;

class Contenido {
    String titulo;
    int duracionMinutos;
    String genero;

    public Contenido(String titulo, int duracionMinutos, String genero) {
        this.titulo = titulo;
        this.duracionMinutos = duracionMinutos;
        this.genero = genero;
    }

    public void reproducir() {
        System.out.println(
                "Reproduciendo: " + titulo + " | Duracion: " + duracionMinutos + " min.");
    }
}

class Pelicula extends Contenido {
    String director;

    public Pelicula(String titulo, int duracionMinutos, String genero, String director) {
        super(titulo, duracionMinutos, genero);
        this.director = director;
    }

    @Override
    public void reproducir() {
        System.out.println(
                "Titulo: " + titulo + " | Director: " + director + " | Duracion: " + duracionMinutos + " min.");
    }
}

class Serie extends Contenido {
    int numeroTemporadas;
    int capitulosTotales;

    public Serie(String titulo, int duracionMinutos, String genero, int numeroTemporadas, int capitulosTotales) {
        super(titulo, duracionMinutos, genero);
        this.numeroTemporadas = numeroTemporadas;
        this.capitulosTotales = capitulosTotales;
    }

    @Override
    public void reproducir() {
        System.out.println(
                "Titulo: " + titulo + " | Temporadas: " + numeroTemporadas + " | Episodios: " + capitulosTotales);
    }
}

public class plataformaStreaming {
    public static void main(String[] args) {
        final Double Cuota_Mensual_Base = 20.99;

        ArrayList<Contenido> Catalogo = new ArrayList<>();

        Pelicula p1 = new Pelicula("Titanic", 180, "Drama", "Allandryo");
        Serie s1 = new Serie("SUITS", 50, "Comedia", 13, 125);

        Catalogo.add(p1);
        Catalogo.add(s1);

        for (int i = 0; i < Catalogo.size(); i++) {
            Catalogo.get(i).reproducir();
        }

        Usuario u1 = new Usuario("Alan", 2);
        u1.verPerfil();
        u1.calculoGastado(Cuota_Mensual_Base);
    }
}
