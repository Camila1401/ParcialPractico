package dominio;

import java.time.LocalDate;

public class OpMorosidad extends Operacion{
    private int diasPrestado;

    OpMorosidad(int dias){
        diasPrestado = dias;
        setFecha(LocalDate.now());
    }
}
