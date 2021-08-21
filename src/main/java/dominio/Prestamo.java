package dominio;

import java.util.Date;
import java.util.List;
import java.util.Timer;

public class Prestamo {
    private Date fecha; //dsp vemos si queda date
    private List<Observer> observadores;
    private Usuario usuario;
    private final int dias;
    private int diasPrestado;
    private Prestable prestable;
    private Multa multa;
    private Timer timer;
    private TimerPrestamo tareaTimer;

    public Prestamo(List<Observer> observadoresPrestamo, Usuario usuarioPrestamo, Prestable prestablePrestamo){
        fecha = new Date();
        observadores = observadoresPrestamo;
        usuario = usuarioPrestamo;
        prestable = prestablePrestamo;
        dias = prestable.cantidadDias();
        diasPrestado = 0;
        multa = new Multa();
        timer = new Timer();
        tareaTimer = new TimerPrestamo();

        timer.schedule(tareaTimer.tarea(), fecha, 86400000); //eso es un dia en milisegundos
    }

    public void notificarTiempoAgotado(){
        //algo del timer aca o en otro lado q llame a notificar
        observadores.forEach(observer -> observer.notificarTiempoAgotado(usuario, prestable));
    }

    public void notificarAvisoAnticipado(){
        observadores.forEach(observer -> observer.notificarAvisoAnticipado(usuario, prestable));
    }

    public Prestable prestable(){
        return prestable;
    }

    public void agregarDiaMulta() {
        multa.agregarDia();
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

}


