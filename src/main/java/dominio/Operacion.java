package dominio;

import java.time.LocalDate;

public abstract class Operacion {
    private Prestamo prestamo;
    private LocalDate fecha;

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }
}
