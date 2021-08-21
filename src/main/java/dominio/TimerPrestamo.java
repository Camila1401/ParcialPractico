package dominio;

import java.util.TimerTask;

public class TimerPrestamo {

    private Prestamo prestamo;
    private TimerTask tarea;

    TimerPrestamo(){
        tarea = new TimerTask(){

            @Override
            public void run() {
                prestamo.sumarDiaPrestado();
                if(prestamo.diasPrestado() < prestamo.dias()){
                    if(prestamo.dias() - prestamo.diasPrestado() == 3){
                        prestamo.notificarAvisoAnticipado();
                    }
                } else if(prestamo.diasPrestado() == prestamo.dias()){
                    prestamo.notificarTiempoAgotado();
                } else {
                    prestamo.agregarDiaMulta();
                }
            }
        };
    }

    public TimerTask tarea() {
        return tarea;
    }
}
