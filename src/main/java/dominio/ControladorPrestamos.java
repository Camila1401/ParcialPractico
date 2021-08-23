package dominio;

import java.util.ArrayList;
import java.util.List;

public class ControladorPrestamos {
    private List<Prestamo> prestamos;
    private ControladorPrestables controladorPrestables;

    public Prestamo crearPrestamo(Usuario usuario, Prestable prestable){//List<Copia> copias) {
        if (usuario.tieneMulta()) {
            return null;
            //exepcion si tiene multa
        } else {
            //Prestable prestable = controladorPrestables.generarPrestable(copias);
            List<Observador> observadores = new ArrayList<>();
            observadores.add(new Notificador());
            observadores.add(new ModificadorEstado());

            //todo: aca usar polimorfismo
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
        prestamos.remove(prestamo);
        prestamo.usuario().eliminarPrestamo(prestamo);
    }

}
