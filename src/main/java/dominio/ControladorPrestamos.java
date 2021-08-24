package dominio;

import java.util.ArrayList;
import java.util.List;

public class ControladorPrestamos {
    private ControladorPrestables controladorPrestables;

    ControladorPrestamos(ControladorPrestables controladorPrestables_){
        controladorPrestables = controladorPrestables_;
    }

    public Prestamo crearPrestamo(Usuario usuario, List<Copia> copias) {
        if (usuario.tieneMulta()) {
            throw new UsuarioConMultaException();
        } else {
            Prestable prestable = controladorPrestables.generarPrestable(copias);

            List<Observador> observadores = new ArrayList<>();
            observadores.add(new Notificador());
            observadores.add(new ModificadorEstado());

            Prestamo prestamo = new Prestamo(observadores, usuario, prestable, this);

            if(usuario.esUsuarioPremium()){
                prestamo.elegirTipo(new Premium(prestamo));
            } else {
                prestamo.elegirTipo(new Basico(prestamo));
            }

            prestamo.arrancarTimer();
            usuario.agregarPrestamo(prestamo);
            return prestamo;
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
        prestamo.usuario().eliminarPrestamo(prestamo);
    }

}
