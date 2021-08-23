package dominio;

import java.time.LocalDate;

public abstract class Operacion {
    private int idPrestamo;
    private LocalDate fecha;

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
