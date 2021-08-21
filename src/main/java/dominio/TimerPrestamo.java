package dominio;

import java.util.TimerTask;

public class TimerPrestamo {

    private Prestamo prestamo;
    private TimerTask prestamoCorriendo;
    private TimerTask prestamoDevuelto;
    private ControladorPrestamos controladorPrestamos;

    TimerPrestamo(){
        prestamoCorriendo = new TimerTask(){

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

        prestamoDevuelto = new TimerTask() {
            @Override
            public void run() {
                if(prestamo.multa() != 0){
                    prestamo.restarDiaMulta();
                } else {
                    controladorPrestamos.eliminarPrestamo(prestamo);
                    prestamo.timer().cancel();
                }
            }
        };
    }

    public TimerTask prestamoCorriendo() {
        return prestamoCorriendo;
    }

    public TimerTask prestamoDevuelto() {
        return prestamoDevuelto;
    }
}
