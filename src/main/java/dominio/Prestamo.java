package dominio;

import java.util.Date;
import java.util.List;
import java.util.Timer;

public class Prestamo {
    private final Date fecha; //dsp vemos si queda date
    private final List<Observer> observadores;
    private final Usuario usuario;
    private final int dias;
    private int diasPrestado;
    private final Prestable prestable;
    private int multa;
    private Timer timer;
    private TimerPrestamo tareaTimer;
    private final ControladorPrestamos controladorPrestamos;

    public Prestamo(List<Observer> observadoresPrestamo, Usuario usuarioPrestamo, Prestable prestablePrestamo, ControladorPrestamos controlador){
        fecha = new Date();
        observadores = observadoresPrestamo;
        usuario = usuarioPrestamo;
        prestable = prestablePrestamo;
        dias = prestable.cantidadDias();
        diasPrestado = 0;
        multa = 0;
        timer = new Timer();
        tareaTimer = new TimerPrestamo();

        timer.schedule(tareaTimer.tarea(), fecha, 86400000); //eso es un dia en milisegundos
        controladorPrestamos = controlador;
    }

    public void notificarTiempoAgotado(){
        observadores.forEach(observer -> observer.notificarTiempoAgotado(usuario, prestable));
    }

    public void notificarAvisoAnticipado(){
        observadores.forEach(observer -> observer.notificarAvisoAnticipado(usuario, prestable));
    }

    public Prestable prestable(){
        return prestable;
    }

    public void agregarDiaMulta() {
        multa += 5;
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

    public void devueltoConMulta() {
        //implementar el timer yendo al reves para sacar la multa
    }
}


