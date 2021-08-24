package dominio;

import java.time.LocalDate;

public class OpMorosidad extends Operacion{
    private int diasPrestado;

    OpMorosidad(int dias, Prestamo prestamo){
        diasPrestado = dias;
        setPrestamo(prestamo);
        setFecha(LocalDate.now());
    }
}
