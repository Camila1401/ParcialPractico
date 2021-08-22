package dominio;

import java.util.TimerTask;

public abstract class TipoPrestamo {

    private Prestamo prestamo;
    private TimerTask prestamoCorriendo;
    private TimerTask prestamoDevuelto;
    private ControladorPrestamos controladorPrestamos;

    public abstract TimerTask prestamoCorriendo();

    public abstract TimerTask prestamoDevuelto();

    public Prestamo prestamo() {
        return prestamo;
    }

    public ControladorPrestamos controladorPrestamos() {
        return controladorPrestamos;
    }
}
