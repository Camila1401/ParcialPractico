package dominio;

import java.util.List;

public class ControladorPrestamos {
    private List<Prestamo> prestamos;

    public Prestamo crearPrestamo(List<Observer> observadores, Usuario usuario, Prestable prestable){
        return new Prestamo(observadores, usuario, prestable, this);
    }

    public void devolverPrestamo(Prestamo prestamo){
        prestamo.prestable().modificarEstado(new EnBiblioteca());
        if(prestamo.hayMulta()){
            prestamo.devueltoConMulta();
        } else {
            eliminarPrestamo(prestamo);
        }
    }

    public void eliminarPrestamo(Prestamo prestamo){
        prestamos.remove(prestamo);
        prestamo.usuario().eliminarPrestamo(prestamo);
    }

}
