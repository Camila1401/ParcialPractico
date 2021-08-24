package dominio;

import java.util.TimerTask;

public class Basico extends TipoPrestamo {

    Basico(Prestamo prestamo_, ControladorPrestamos controladorPrestamos){
        prestamo = prestamo_;
        setControladorPrestamos(controladorPrestamos);
    }

    @Override
    public TimerTask prestamoCorriendo() {
        return new TimerTask(){

            @Override
            public void run() {
                System.out.println("paso un dia");
                prestamo.sumarDiaPrestado();
                if(prestamo.diasPrestado() < prestamo.dias()){
                    if(prestamo.dias() - prestamo.diasPrestado() == 3){
                        prestamo.notificarAvisoAnticipado();
                    }
                } else if(prestamo.diasPrestado() == prestamo.dias()){
                    prestamo.notificarTiempoAgotado();
                } else {
                    prestamo.agregarDiaMulta(5);
                }
            }
        };
    }

    @Override
    public TimerTask prestamoDevuelto() {
        return new TimerTask() {
            @Override
            public void run() {
                if(prestamo.multa() != 0){
                    prestamo.restarDiaMulta(1);
                } else {
                    controladorPrestamos().eliminarPrestamo(prestamo);
                    prestamo.timer().cancel();
                }
            }
        };
    }
}

