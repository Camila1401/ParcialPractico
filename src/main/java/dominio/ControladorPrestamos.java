package dominio;

import java.util.List;

public class ControladorPrestamos {
    private List<Prestamo> prestamos;

    public Prestamo crearPrestamo(List<Observer> observadores, Usuario usuario, Prestable prestable){
        return new Prestamo(observadores, usuario, prestable);
    }

    public void devolverPrestamo(Prestamo prestamo){
        prestamos.remove(prestamo);
        prestamo.prestable().modificarEstado(new EnBiblioteca());
        //habria q guardar la multa en algun lado
    }


}
