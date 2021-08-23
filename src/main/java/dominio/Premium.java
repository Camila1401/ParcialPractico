package dominio;

import java.util.TimerTask;

public class Premium extends TipoPrestamo{

    Premium(Prestamo prestamo_) {
        prestamo = prestamo_;
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
                    prestamo.agregarDiaMulta(4);
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
                    prestamo.restarDiaMulta(2);
                } else {
                    controladorPrestamos().eliminarPrestamo(prestamo);
                    prestamo.timer().cancel();
                }
            }
        };
    }
}
