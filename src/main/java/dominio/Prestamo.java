package dominio;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Prestamo {
    private Date fecha; //dsp vemos si queda date
    private List<Observer> observadores;
    private Usuario usuario;
    private final int dias;
    private int diasPrestado;
    private Prestable prestable;
    private Multa multa;
    private Timer timer; //dsp tengo q ver como funciona esto

    public Prestamo(List<Observer> observadoresPrestamo, Usuario usuarioPrestamo, Prestable prestablePrestamo){
        fecha = new Date();
        observadores = observadoresPrestamo;
        usuario = usuarioPrestamo;
        prestable = prestablePrestamo;
        dias = prestable.cantidadDias();
        diasPrestado = 0;
        multa = new Multa();
        timer = new Timer();

        TimerTask tarea = new TimerTask(){

            @Override
            public void run() {
                diasPrestado += 1;
                if(diasPrestado < dias){
                    if(dias - diasPrestado == 3){
                        notificarAvisoAnticipado();
                    }
                } else if(diasPrestado == dias){
                    notificarTiempoAgotado();
                } else {
                    multa.agregarDia();
                }
            }
        };

        timer.schedule(tarea, fecha, 86400000); //eso es un dia en milisegundos
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
}

