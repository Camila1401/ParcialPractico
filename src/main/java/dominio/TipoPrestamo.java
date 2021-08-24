package dominio;

import java.util.TimerTask;

public abstract class TipoPrestamo {

    public Prestamo prestamo;
    private ControladorPrestamos controladorPrestamos;

    public abstract TimerTask prestamoCorriendo();

    public abstract TimerTask prestamoDevuelto();

    public ControladorPrestamos controladorPrestamos() {
        return controladorPrestamos;
    }

    public void setControladorPrestamos(ControladorPrestamos controladorPrestamos) {
        this.controladorPrestamos = controladorPrestamos;
    }
}
