package dominio;

import java.util.Date;
import java.util.List;
import java.util.Timer;

public class Prestamo {
    private Date fecha; //dsp vemos si queda date
    private List<Observer> observadores;
    private Usuario usuario;
    private final int dias;
    private Prestable prestable;
    private Multa multa;
    private Timer timer; //dsp tengo q ver como funciona esto

    public Prestamo(Date fechaDePrestamo, List<Observer> observadoresPrestamo, Usuario usuarioPrestamo, Prestable prestablePrestamo){
        fecha = fechaDePrestamo;
        observadores = observadoresPrestamo;
        usuario = usuarioPrestamo;
        prestable = prestablePrestamo;
        dias = prestable.cantidadDias();
        //falta el timer
    }

    public void notificarTiempoAgotado(){
        //algo del timer aca o en otro lado q llame a notificar
        observadores.forEach(observer -> observer.notificarTiempoAgotado(usuario, prestable));
    }

    public void notificarAvisoAnticipado(){
        observadores.forEach(observer -> observer.notificarAvisoAnticipado(usuario, prestable));
    }
}

