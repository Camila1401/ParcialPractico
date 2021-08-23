package dominio;

import java.util.Date;
import java.util.List;
import java.util.Timer;

public class Prestamo {
    private final List<Observador> observadores;
    private final Usuario usuario;
    private final int dias;
    private int diasPrestado;
    private final Prestable prestable;
    private int multa;
    private final Timer timer;
    private final TipoPrestamo tipoPrestamo;
    private final ControladorPrestamos controladorPrestamos;

    public Prestamo(List<Observador> observadoresPrestamo, Usuario usuarioPrestamo, Prestable prestablePrestamo, ControladorPrestamos controlador, TipoPrestamo tipo){
        observadores = observadoresPrestamo;
        usuario = usuarioPrestamo;
        prestable = prestablePrestamo;
        dias = prestable.cantidadDias();
        diasPrestado = 0;
        multa = 0;
        timer = new Timer();
        tipoPrestamo = tipo;

        timer.schedule(tipoPrestamo.prestamoCorriendo(), new Date(), 86400000); //eso es un dia en milisegundos
        controladorPrestamos = controlador;
    }

    public void notificarTiempoAgotado(){
        observadores.forEach(observador -> observador.notificarTiempoAgotado(usuario, prestable));
    }

    public void notificarAvisoAnticipado(){
        observadores.forEach(observador -> observador.notificarAvisoAnticipado(usuario, prestable));
    }

    public Prestable prestable(){
        return prestable;
    }

    public void agregarDiaMulta(int cantidad) {
        multa += cantidad;
    }

    public int dias() {
        return dias;
    }

    public int diasPrestado() {
        return diasPrestado;
    }

    public void sumarDiaPrestado(){
        diasPrestado += 1;
    }

    public Usuario usuario() {
        return usuario;
    }

    public int multa(){
        return multa;
    }

    public boolean hayMulta() {
        return multa != 0;
    }

    public void restarDiaMulta(int cantidad){
        multa -= cantidad;
    }

    public Timer timer() {
        return timer;
    }

    public void devueltoConMulta() {
        timer.cancel();
        timer.purge();
        timer.schedule(tipoPrestamo.prestamoDevuelto(), new Date(), 86400000);
    }
}


