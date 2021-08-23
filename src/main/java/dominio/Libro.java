package dominio;

public class Libro {
    private String titulo;
    private Genero genero;

    public Genero genero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String titulo() {
        return titulo;
    }

    public boolean matchearGenero(Genero otroGenero){
        return genero.equals(otroGenero);
    }
}
