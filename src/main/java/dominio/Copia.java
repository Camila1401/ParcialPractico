package dominio;

public class Copia extends Libro {
    //private int id;
    private Estado estado;
    private int diasPrestables;

    Copia(int dias){
        diasPrestables = dias;
        estado = new EnBiblioteca();
    }

    public Boolean puedePrestarse(){
        return estado.validarPrestamo();
    }

    public int cantidadDias(){
        return diasPrestables;
    }

    public void modificarEstado(Estado estadoNuevo) {
        estado = estadoNuevo;
    }
}
