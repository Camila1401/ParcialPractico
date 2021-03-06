package dominio;

import java.time.LocalDate;

public class OpCreacionPrestamo extends Operacion{
    private Prestable prestable;
    private String usuario;

    OpCreacionPrestamo(Prestable prestable_, String nombreUsuario, Prestamo prestamo){
        prestable = prestable_;
        usuario = nombreUsuario;
        setFecha(LocalDate.now());
        setPrestamo(prestamo);
    }
}
