package dominio;

import java.util.ArrayList;
import java.util.List;

public class ControladorPrestamos {
    private List<Prestamo> prestamos;
    private ControladorPrestables controladorPrestables;

    public Prestamo crearPrestamo(Usuario usuario, List<Copia> copias) {
        if (usuario.tieneMulta()) {
            return null;
            //exepcion si tiene multa
        } else {
            Prestable prestable = controladorPrestables.generarPrestable(copias);
            List<Observador> observadores = new ArrayList<>();
            observadores.add(new Notificador());
            observadores.add(new ModificadorEstado());
            return new Prestamo(observadores, usuario, prestable, this);
        }
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
