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

            Prestamo prestamo;
            if(usuario.esUsuarioPremium()){         //esto tmb me da duda si hacerlo acá adentro aaaaaaaaaaaaaaaaaaaaa
                prestamo = new Prestamo(observadores, usuario, prestable, this, new Premium());
            } else {
                prestamo = new Prestamo(observadores, usuario, prestable, this, new Basico());
            }
            usuario.agregarPrestamo(prestamo);      //esto me da un poco de duda si corresponde que se haga aca adentro...
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
        prestamos.remove(prestamo);
        prestamo.usuario().eliminarPrestamo(prestamo);
    }

}
